/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.be.PersonaBE;
import celepsa.rrcc.bd.ConexionBD;
import celepsa.rrcc.be.EstadoBE;
import celepsa.rrcc.be.NivelInfluenciaBE;
import celepsa.rrcc.be.TipoDocumentoIdentidadBE;
import celepsa.rrcc.be.ZonaBE;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class PersonaDA {
   public List<PersonaBE> listarPersona(Integer tdoc) throws Exception  {
        ConexionBD objConexion = null;
        try 
        {
            objConexion = new ConexionBD();
            List<PersonaBE> lstRetorno = new ArrayList<PersonaBE>();
            String sQuery="";
            if (tdoc==0){
               sQuery = "SELECT id, CONCAT(Nombre , ' ', Apellido) as nombre FROM tmStakePersona WHERE est=0" ;   
         
                }
            else
                {
                  //sQuery = " SELECT * FROM tmDocumento WHERE tmTipoDocumento_id=" + tdoc +" OR tmTipoDocumento_id=0 and eliminado='0'" ;   
                     sQuery="SELECT DISTINCT tmStakePersona.id, CONCAT(tmStakePersona.Nombre , ' ', tmStakePersona.Apellido) as nombre FROM " +
"tmStakePersona WHERE  tmStakePersona.id NOT IN (SELECT tmStakePersona.id  FROM " +
"tmStakePersona, PersonaDocumento where tmStakePersona.id=PersonaDocumento.tmStakePersona_id and " +
" PersonaDocumento.tmDocumento_id =" + tdoc +")";
                }
           
            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) 
            {
                while (objResult.next()) 
                {
                    lstRetorno.add(populatePersonaVarios(objResult));
                }
            } 
            return lstRetorno;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            throw e;
        } 
        finally 
        {
            objConexion.close();
        }
    } 
   
   private PersonaBE populatePersonaVarios(ResultSet resultado) throws SQLException {
        PersonaBE objPersonaBE = new PersonaBE();

        objPersonaBE.setId(resultado.getString("id"));
        
        objPersonaBE.setNombre(resultado.getString("nombre"));

        return objPersonaBE;
    }
   
   public PersonaBE obtenerPersona(PersonaBE objPersona) throws Exception  {
        ConexionBD objConexion = null;
        int cont = 1;
        try 
        {
            objConexion = new ConexionBD();
            PersonaBE objDocumentoResult = null;
            String sQuery = " SELECT  * FROM RRHH.tmStakePersona WHERE id = ? ";
            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            objConexion.agregarParametro(cont++, objPersona.getId());

            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) 
            {
                if (objResult.next()) 
                {
                    objDocumentoResult = this.populatePersona(objResult);
                }
            } 
            return objDocumentoResult;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            throw e;
        } 
        finally 
        {
            objConexion.close();
        }
    }
   
    private PersonaBE populatePersona(ResultSet resultado) throws SQLException {
        PersonaBE objPersonaBE = new PersonaBE();
        
        NivelInfluenciaBE objNivelInfluenciaBE = new NivelInfluenciaBE();
        TipoDocumentoIdentidadBE objTipoDocumentoIdentidadBE = new TipoDocumentoIdentidadBE();
        ZonaBE objZonaBE = new ZonaBE();
        EstadoBE objEstadoBE = new EstadoBE();
        
        
        objPersonaBE.setId(resultado.getString("id"));
        objPersonaBE.setFechaRegistro(resultado.getString("FechaRegistro")); 
        objPersonaBE.setNombre(resultado.getString("Nombre")); 
        objPersonaBE.setApellido(resultado.getString("Apellido")); 
        objPersonaBE.setAlias(resultado.getString("Alias")); 
        objPersonaBE.setIdentidad(resultado.getString("Identidad")); 
        objPersonaBE.setNroDocumento(resultado.getString("NroDocumento")); 
        objPersonaBE.setFotografia(resultado.getString("Fotografia"));
        
        objTipoDocumentoIdentidadBE.setId(resultado.getString("tmTDocumento_id"));
        objPersonaBE.setTDoumentoIdentidad(objTipoDocumentoIdentidadBE);;
        
        objNivelInfluenciaBE.setId(resultado.getString("tmNivelInfluencia_id"));
        objPersonaBE.setNInfluencia(objNivelInfluenciaBE);
        
        objZonaBE.setId(resultado.getString("tmZona_id"));
        objPersonaBE.setZona(objZonaBE);
        
        objEstadoBE.setId(resultado.getString("tmEstado_id"));
        objPersonaBE.setEstado(objEstadoBE);
        
        
        
        return objPersonaBE;
    }
    
   public int registrarPersona(PersonaBE objSistema) throws Exception {
           
        ConexionBD objConexion = null;
         String query ="";
        
            query ="INSERT INTO `RRHH`.`tmStakePersona` (`id`, `FechaRegistro`, `Nombre`, `Apellido`, `Alias`, `Identidad`, `NroDocumento`, `tmTDocumento_id`," +
                    "`tmNivelInfluencia_id`, `est`, `tmZona_id`, `tmEstado_id`) VALUES (?,?,?,?,?,?,?,?,?,0,?,?);";
        
      int cont = 1;
        try 
        {
            objConexion = new ConexionBD();
            objConexion.open();
            objConexion.prepararSentencia(query);
             objConexion.agregarParametro(cont++, CrearIDPersona());        
            objConexion.agregarParametro(cont++, objSistema.getFechaRegistro());
            objConexion.agregarParametro(cont++, objSistema.getNombre());
            objConexion.agregarParametro(cont++, objSistema.getApellido());
            objConexion.agregarParametro(cont++, objSistema.getAlias());
            objConexion.agregarParametro(cont++, objSistema.getIdentidad());
            objConexion.agregarParametro(cont++, objSistema.getNroDocumento());
            objConexion.agregarParametro(cont++, objSistema.getTDoumentoIdentidad().getId());
            objConexion.agregarParametro(cont++, objSistema.getNInfluencia().getId());
            objConexion.agregarParametro(cont++, objSistema.getZona().getId());
            objConexion.agregarParametro(cont++, objSistema.getEstado().getId());
            
            return objConexion.insertar();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            throw e;
        }
        finally
        {
            objConexion.close();
        }
    
        }     
   
   public boolean ActualizarPersona(PersonaBE objSistema) throws Exception {
           
        ConexionBD objConexion = null;
         String query ="";
       
             query ="UPDATE `RRHH`.`tmStakePersona` SET `FechaRegistro`=?, " +
                    "`Nombre`=?, `Apellido`=?, " +
                    "`Alias`=?, `Identidad`=?, "+
                    "`NroDocumento`=?, `tmTDocumento_id`=?, " +
                     "`tmNivelInfluencia_id`=?, `tmZona_id`=?, `tmEstado_id`=? " +
                    " WHERE `id`='"+ objSistema.getId() +"'";        
 
        
        
      int cont = 1;
        
        try 
        {
            objConexion = new ConexionBD();
            objConexion.open();
            objConexion.prepararSentencia(query);
        
            objConexion.agregarParametro(cont++, objSistema.getFechaRegistro());
            objConexion.agregarParametro(cont++, objSistema.getNombre());
            objConexion.agregarParametro(cont++, objSistema.getApellido());
            objConexion.agregarParametro(cont++, objSistema.getAlias());
            objConexion.agregarParametro(cont++, objSistema.getIdentidad());
            objConexion.agregarParametro(cont++, objSistema.getNroDocumento());
            objConexion.agregarParametro(cont++, Integer.parseInt(objSistema.getTDoumentoIdentidad().getId()));
            objConexion.agregarParametro(cont++, Integer.parseInt(objSistema.getNInfluencia().getId()));
            objConexion.agregarParametro(cont++, Integer.parseInt(objSistema.getZona().getId()));
            objConexion.agregarParametro(cont++, Integer.parseInt(objSistema.getEstado().getId()));    
      
            
             objConexion.ejecutar();
            return true;
            //return objConexion.insertar();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            throw e;
        }
        finally
        {
            objConexion.close();
        }
    
        }
   
   private Integer CrearIDPersona() throws Exception  {
          Integer idnew=0;
           ConexionBD objConexion2 = null;
          // DocumentoBE objDocumentoBE = new DocumentoBE();
        try 
        {
            objConexion2 = new ConexionBD();
            
            //List<DocumentoBE> lstRetorno = new ArrayList<DocumentoBE>();
            String sQuery = "SELECT  * FROM RRHH.tmStakePersona ORDER BY id DESC LIMIT 1" ;
            objConexion2.open();
            objConexion2.prepararSentencia(sQuery);   
            ResultSet objResult = objConexion2.ejecutarQuery();
                   if (objResult != null) 
                    {
                        objResult.next();
                        
                        if (objResult.getRow() ==0)
                                {
                                    idnew=0;
                                }
                         else
                        {
                            idnew = Integer.parseInt(populatePersona(objResult).getId());
                        }
                        
                    } 
                   else
                   { 
                       idnew=0;
                   }
            
        //objDocumentoBE.setId(resultado.getString("id"));
            //objDocumentoBE.setId(objResult.getString("id"));
            
            
            if (idnew == 0) 
            {
                idnew=1;
            } 
            else
            {
                idnew=idnew+1;
            }
            return idnew;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            throw e;
        } 
        finally 
        {
            objConexion2.close();
        }

            
    }
   public boolean eliminarPersona(PersonaBE objDocumento) throws Exception {
        ConexionBD objConexion = null;
        int cont = 1;
        String query = " UPDATE tmStakePersona SET est = ? WHERE id = ? ";
        
        try {
            objConexion = new ConexionBD();
            objConexion.open();
            objConexion.prepararSentencia(query);
            objConexion.agregarParametro(cont++, objDocumento.getEst());
            objConexion.agregarParametro(cont++, objDocumento.getId());
            objConexion.ejecutar();
            return true;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            throw e;
        }
        finally
        {
            objConexion.close();
        }
    }
   public List<PersonaBE> buscarPersonasVarios(String AsuntoBuscado) throws Exception  {
               ConexionBD objConexion = null;
        try 
        {
            objConexion = new ConexionBD();
            List<PersonaBE> lstRetorno = new ArrayList<PersonaBE>();
            String sQuery = "SELECT id, CONCAT(Nombre , ' ', Apellido) as nombre FROM " +
                    "tmStakePersona WHERE est=0 and tmStakePersona.Nombre like '%"+ AsuntoBuscado +"%' or tmStakePersona.Apellido like '%"+ AsuntoBuscado +"%'  ";
            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) 
            {
                while (objResult.next()) 
                {
                    lstRetorno.add(populatePersonasVarios(objResult));
                }
            } 
            return lstRetorno;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            throw e;
        } 
        finally 
        {
            objConexion.close();
        }
  
    }
   private PersonaBE populatePersonasVarios(ResultSet resultado) throws SQLException {
        PersonaBE objPersonaBE = new PersonaBE();
        
        
        objPersonaBE.setId(resultado.getString("id"));
        objPersonaBE.setNombre(resultado.getString("nombre"));
        
       
        return objPersonaBE;
    }
    
   
}

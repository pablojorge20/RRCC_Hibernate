/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.be.AdjuntoBE;
import celepsa.rrcc.be.CriticidadBE;
import celepsa.rrcc.be.PersonaBE;
import celepsa.rrcc.be.DocumentoBE;
import celepsa.rrcc.be.IngrsoSalidaBE;
import celepsa.rrcc.be.StakeholderBE;
import celepsa.rrcc.be.TipoDocumentoBE;
import celepsa.rrcc.bd.ConexionBD;
import celepsa.rrcc.be.EstadoBE;
import celepsa.rrcc.eh.HibernateUtil;
import celepsa.rrcc.eh.TmDocumento;
import celepsa.rrcc.eh.TmStakePersona;
import celepsa.rrcc.eh.TmTdocumentoIdentidad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class DocumentoDA {
  
    
    Session session = null;

    public DocumentoDA() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
        
    public int registrarDocumento(DocumentoBE objSistema) throws Exception {
        /*
         ConexionBD objConexion = null;
         String query ="";
        
                   
         query ="INSERT INTO `tmDocumento`(`id`,`FechaRegistro`,`FechaRecepcion`,`FechaCaducidad`,`Asunto`,`Observaciones`,`IngresoSalida`," +
         "`tmStakePersona_id`,`tmTipoDocumento_id`,`RefConvenio`,`RefPrograma`,`RefProyecto`,`RefDocumento`, `Criticidad_id`,`eliminado`, `tmEstado_id`)" +
         "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,'0',?)";
         */
        //   int cont = 1;
        TmDocumento documento = new TmDocumento();
        try {
            // objConexion = new ConexionBD();
            // objConexion.open();
            //  objConexion.prepararSentencia(query);
            documento.setId(CrearIDDoc());
            documento.setFechaRegistro(objSistema.getFechaRegistro());
            documento.setFechaRecepcion(objSistema.getFechaRecepcion());
            documento.setFechaCaducidad(objSistema.getFechaCaducidad());
            documento.setAsunto(objSistema.getAsunto());
            documento.setObservaciones(objSistema.getObservaciones());
            //habia que castearlo de string a integer
            documento.setIngresoSalida(Integer.parseInt(objSistema.getIngreso().getId()));
            //faltaba castear ede string a integer
            documento.setTmStakePersonaId(Integer.parseInt(objSistema.getStakeholder().getId()));
            documento.setTmTipoDocumentoId(Integer.parseInt(objSistema.getTipoDocumento().getId()));

            if (objSistema.getConvenio() != null
                    && objSistema.getConvenio().getId() != null
                    && !objSistema.getConvenio().getId().isEmpty()) {
                documento.setRefConvenio(Integer.parseInt(objSistema.getConvenio().getId()));
            } else {
                documento.setRefConvenio(java.sql.Types.NULL);
            }

            if (objSistema.getPrograma() != null
                    && objSistema.getPrograma().getId() != null
                    && !objSistema.getPrograma().getId().isEmpty()) {
                documento.setRefPrograma(Integer.parseInt(objSistema.getPrograma().getId()));
            } else {
                documento.setRefPrograma(java.sql.Types.NULL);
            }

            if (objSistema.getProyecto() != null
                    && objSistema.getProyecto().getId() != null
                    && !objSistema.getProyecto().getId().isEmpty()) {
                documento.setRefProyecto(Integer.parseInt(objSistema.getProyecto().getId()));
            } else {
                documento.setRefProyecto(java.sql.Types.NULL);
            }

            if (objSistema.getDocumento() != null
                    && objSistema.getDocumento().getId() != null
                    && !objSistema.getDocumento().getId().isEmpty()) {
                documento.setRefDocumento(Integer.parseInt(objSistema.getDocumento().getId()));
            } else {
                documento.setRefDocumento(java.sql.Types.NULL);
            }
            documento.setCriticidadId(Integer.parseInt(objSistema.getCriticidad().getId()));
            documento.setEliminado('0');
            documento.setTmEstadoId(Integer.parseInt(objSistema.getEstado().getId()));
            System.out.println("antes del insert con hibernate");
            org.hibernate.Transaction tx = session.beginTransaction();
            session.save(documento);
            System.out.println("luego del commit ");
            tx.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;// no inserto nada 
        }

    }
        
    public boolean ActualizarDocumento(DocumentoBE objSistema) throws Exception {

        TmDocumento documento = new TmDocumento();
        try {
            documento.setId(Integer.parseInt(objSistema.getId()));
            documento.setFechaRegistro(objSistema.getFechaRegistro());
            documento.setFechaRecepcion(objSistema.getFechaRecepcion());
            documento.setFechaCaducidad(objSistema.getFechaCaducidad());
            documento.setAsunto(objSistema.getAsunto());
            documento.setObservaciones(objSistema.getObservaciones());
            //habia que castearlo de string a integer
            documento.setIngresoSalida(Integer.parseInt(objSistema.getIngreso().getId()));
            //faltaba castear ede string a integer
            documento.setTmStakePersonaId(Integer.parseInt(objSistema.getStakeholder().getId()));
            documento.setTmTipoDocumentoId(Integer.parseInt(objSistema.getTipoDocumento().getId()));

            if (objSistema.getConvenio() != null
                    && objSistema.getConvenio().getId() != null
                    && !objSistema.getConvenio().getId().isEmpty()) {
                documento.setRefConvenio(Integer.parseInt(objSistema.getConvenio().getId()));
            } else {
                documento.setRefConvenio(java.sql.Types.NULL);
            }

            if (objSistema.getPrograma() != null
                    && objSistema.getPrograma().getId() != null
                    && !objSistema.getPrograma().getId().isEmpty()) {
                documento.setRefPrograma(Integer.parseInt(objSistema.getPrograma().getId()));
            } else {
                documento.setRefPrograma(java.sql.Types.NULL);
            }

            if (objSistema.getProyecto() != null
                    && objSistema.getProyecto().getId() != null
                    && !objSistema.getProyecto().getId().isEmpty()) {
                documento.setRefProyecto(Integer.parseInt(objSistema.getProyecto().getId()));
            } else {
                documento.setRefProyecto(java.sql.Types.NULL);
            }

            if (objSistema.getDocumento() != null
                    && objSistema.getDocumento().getId() != null
                    && !objSistema.getDocumento().getId().isEmpty()) {
                documento.setRefDocumento(Integer.parseInt(objSistema.getDocumento().getId()));
            } else {
                documento.setRefDocumento(java.sql.Types.NULL);
            }
            documento.setCriticidadId(Integer.parseInt(objSistema.getCriticidad().getId()));
            documento.setTmEstadoId(Integer.parseInt(objSistema.getEstado().getId()));

            org.hibernate.Transaction tx = session.beginTransaction();
            //el merge  hace el update ,  solo debes setearle el ID para que
            //arme bien el query y ponga en el update where id=xxx
            session.merge(documento);
            tx.commit();
            return true;
        } catch (NumberFormatException | HibernateException e) {
            System.out.println( e.getMessage() );
            return false;// no actualizo nada 
        }

    }
     
    public List<DocumentoBE> listarDocumentos(Integer tdoc) throws Exception {
        try {
         
            String sQuery = "";
            if (tdoc == 0) {
                sQuery = " from TmDocumento where  eliminado='0'";
            } else { 
                sQuery =  "from TmDocumento where tmTipoDocumentoId=" +tdoc+ " OR tmTipoDocumentoId=0  eliminado='0' " ;
            } 
            Query query  = session.createQuery( sQuery );
            return query.list();
             
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        } 
    }

          public List<DocumentoBE> listarDocumentosVarios() throws Exception  {
         try 
        {
         /*    String sQuery = "SELECT tmDocumento.id, tmDocumento.Asunto, "
                    + "tmStakePersona.id,tmStakePersona.Nombre, tmStakePersona.Apellido," +
            "Criticidad.id, Criticidad.Descripcion from tmDocumento, tmStakePersona, Criticidad where " +
            "tmDocumento.tmStakePersona_id=tmStakePersona.id and"
                    + " tmDocumento.Criticidad_id=Criticidad.id and eliminado='0'";
         */
            // NECEISTO RECREAR LAS ENTIDADES Y NO TENGO EL SCRIPT PARA QUE CARGUE TODAS LAS CLASES
            //ASOCIADAS DE GOLPE
            Query query  = session.createQuery("from TmDocumento where  eliminado='0' ");
            return query.list();
        } 
        catch (HibernateException e) 
        {
            System.out.println(e.getMessage());
            throw e;
        } 
  
    }

      public List<DocumentoBE> buscarDocumentosVarios(String AsuntoBuscado) throws Exception  {
        try{
         /* String sQuery = "SELECT tmDocumento.id, tmDocumento.Asunto, tmStakePersona.id,tmStakePersona.Nombre, tmStakePersona.Apellido," +
            "Criticidad.id, Criticidad.Descripcion"
                  + " from tmDocumento, tmStakePersona, Criticidad "
                  + "where tmDocumento.tmStakePersona_id=tmStakePersona.id"
                  + " and tmDocumento.Criticidad_id=Criticidad.id"
                  + " and eliminado='0'"
                  + " and tmDocumento.Asunto like '%"+ AsuntoBuscado +"%' ";*/
           Query query  = session.createQuery("from TmDocumento where  eliminado='0' and asunto like :asunto ");
           query.setString("asunto", "%"+AsuntoBuscado+"%");
            return query.list();
        } 
        catch (HibernateException e) 
        {
            System.out.println(e.getMessage());
            throw e;
        } 
    }
/*
   private DocumentoBE populateDocumentoVarios(ResultSet resultado) throws SQLException {
        DocumentoBE objDocumentoBE = new DocumentoBE();
        PersonaBE objPersonaBE = new PersonaBE();
        CriticidadBE objCriticidadBE = new CriticidadBE();
        EstadoBE objEstadoBE = new EstadoBE();
        objDocumentoBE.setId(resultado.getString("tmDocumento.id"));
        objDocumentoBE.setAsunto(resultado.getString("tmDocumento.Asunto"));
        objPersonaBE.setId("tmStakePersona.id");
        objPersonaBE.setNombre("tmStakePersona.Nombre");
        objPersonaBE.setApellido("tmStakePersona.Apellido");
        objDocumentoBE.setStakeholder(objPersonaBE);
        objCriticidadBE.setId("Criticidad.id");
        objCriticidadBE.setDescripcion("Criticidad.Descripcion");
       objDocumentoBE.setCriticidad(objCriticidadBE);
       
          
        return objDocumentoBE;
    }
       */
    private DocumentoBE populateDocumento(ResultSet resultado) throws SQLException {
        DocumentoBE objDocumentoBE = new DocumentoBE();
        DocumentoBE objConvenioBE = new DocumentoBE();
        DocumentoBE objProgramaBE = new DocumentoBE();
        DocumentoBE objProyectoBE = new DocumentoBE();
        DocumentoBE objOtroDocsBE = new DocumentoBE();
        TipoDocumentoBE objTipoDocumentoBE = new TipoDocumentoBE();
        StakeholderBE objStakeholderBE = new StakeholderBE();
        IngrsoSalidaBE objIngreoSalidaBE = new IngrsoSalidaBE();
        CriticidadBE objCriticidadBE = new CriticidadBE();
        EstadoBE objEstadoBE = new EstadoBE();
        
        
        objDocumentoBE.setId(resultado.getString("id"));
        
        objDocumentoBE.setFechaRegistro(resultado.getString("FechaRegistro")); 
        objDocumentoBE.setFechaRecepcion(resultado.getString("FechaRecepcion"));
        
        objTipoDocumentoBE.setId(resultado.getString("tmTipoDocumento_id"));
        objDocumentoBE.setTipoDocumento(objTipoDocumentoBE);
        
        objStakeholderBE.setId(resultado.getString("tmStakePersona_id"));
        objDocumentoBE.setStakeholder(objStakeholderBE);
        
        
        objDocumentoBE.setObservaciones(resultado.getString("Observaciones"));
        objDocumentoBE.setAsunto(resultado.getString("Asunto"));
        
        objIngreoSalidaBE.setId(resultado.getString("IngresoSalida"));
        objDocumentoBE.setIngreso(objIngreoSalidaBE);
        
        objCriticidadBE.setId(resultado.getString("Criticidad_id"));
        objDocumentoBE.setCriticidad(objCriticidadBE);
        objDocumentoBE.setFechaCaducidad(resultado.getString("FechaCaducidad"));
        
        objConvenioBE.setId(resultado.getString("RefConvenio")); 
        objDocumentoBE.setConvenio(objConvenioBE);
        
        objProgramaBE.setId(resultado.getString("RefPrograma"));
        objDocumentoBE.setPrograma(objProgramaBE);
        
        objProyectoBE.setId(resultado.getString("RefProyecto"));
        objDocumentoBE.setProyecto(objProyectoBE);
        
        objOtroDocsBE.setId(resultado.getString("RefDocumento"));
        objDocumentoBE.setDocumento(objOtroDocsBE);
        
        objEstadoBE.setId(resultado.getString("tmEstado_id"));
        objDocumentoBE.setEstado(objEstadoBE);
        
        return objDocumentoBE;
    }
    
    private AdjuntoBE populateAdjunto(ResultSet resultado) throws SQLException {
        AdjuntoBE objAdjuntoBE = new AdjuntoBE();
         DocumentoBE objDocumentoBE = new DocumentoBE();
          
        objAdjuntoBE.setId(resultado.getString("id"));
           
        objDocumentoBE.setId(resultado.getString("tmDocumento_id"));
        objAdjuntoBE.setDocumento(objDocumentoBE);
        
        objAdjuntoBE.setNombre(resultado.getString("Nombre"));
        objAdjuntoBE.setEliminado(resultado.getString("eliminado"));
        objAdjuntoBE.setScodigo(resultado.getString("scodigo"));
    
        return objAdjuntoBE;
    }
    
    private Integer CrearIDDoc() throws Exception  {
          Integer idnew=0;
           ConexionBD objConexion2 = null;
          // DocumentoBE objDocumentoBE = new DocumentoBE();
        try 
        {
            objConexion2 = new ConexionBD();
            
            //List<DocumentoBE> lstRetorno = new ArrayList<DocumentoBE>();
            String sQuery = "SELECT  * FROM RRHH.tmDocumento ORDER BY id DESC LIMIT 1" ;
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
                            idnew = Integer.parseInt(populateDocumento(objResult).getId());
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
    public TmDocumento obtenerDocumento(TmDocumento objDocumento) throws Exception  {
        try 
        {    
          Query query  = session.createQuery("from TmDocumento where id = :id ");
           query.setInteger("id", objDocumento.getId()  );
            return (TmDocumento) query.list().get(0); 
        } 
        catch (NumberFormatException | HibernateException e) 
        {
            System.out.println(e.getMessage());
            throw e;
        }  
    }
    public boolean eliminarDocumento(DocumentoBE objDocumento) throws Exception {
        ConexionBD objConexion = null;
        int cont = 1;
        String query = " UPDATE tmDocumento SET eliminado = ? WHERE id = ? ";
        
        try {
            objConexion = new ConexionBD();
            objConexion.open();
            objConexion.prepararSentencia(query);
            objConexion.agregarParametro(cont++, objDocumento.getEliminado());
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
  
     public int registrarAdjunto(AdjuntoBE objSistema, DocumentoBE objDocumento) throws Exception {
           
        ConexionBD objConexion = null;
         String query ="";
        
                   
         query ="INSERT INTO `tmAdjunto`(`id`,`tmDocumento_id`,`Nombre`,`eliminado`, `scodigo`)" +
"VALUES (?,?,?,'0',?)";
        
      int cont = 1;
        try 
        {
            objConexion = new ConexionBD();
            objConexion.open();
            objConexion.prepararSentencia(query);
             objConexion.agregarParametro(cont++, CrearIDAdjunto());        
            objConexion.agregarParametro(cont++, objDocumento.getId());
            objConexion.agregarParametro(cont++, objSistema.getNombre());    
            objConexion.agregarParametro(cont++, objSistema.getScodigo()); 
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
   
     private Integer CrearIDAdjunto() throws Exception  {
          Integer idnew=0;
           ConexionBD objConexion2 = null;
          // DocumentoBE objDocumentoBE = new DocumentoBE();
        try 
        {
            objConexion2 = new ConexionBD();
            
            //List<DocumentoBE> lstRetorno = new ArrayList<DocumentoBE>();
            String sQuery = "SELECT  * FROM tmAdjunto ORDER BY id DESC LIMIT 1" ;
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
                            idnew = Integer.parseInt(populateAdjunto(objResult).getId());
                        }
                        
                    } 
                   else
                   { 
                       idnew=0;
                   }

            
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
     
     public List<AdjuntoBE> listarAdjuntos(Integer tdoc) throws Exception  {
        ConexionBD objConexion = null;
        try 
        {
            objConexion = new ConexionBD();
            List<AdjuntoBE> lstRetorno = new ArrayList<AdjuntoBE>();
            String sQuery="";
            if (tdoc==0){
               sQuery = "SELECT id, tmDocumento_id, Nombre, eliminado, scodigo  FROM " + 
                       "tmAdjunto where tmDocumento_id =" + tdoc +"" ;   
         
                }
            else
                {
                  sQuery = "SELECT id, tmDocumento_id, Nombre, eliminado, scodigo  FROM " + 
                       "tmAdjunto where tmDocumento_id =" + tdoc +"" ; 
                 
                }
           
            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) 
            {
                while (objResult.next()) 
                {
                    lstRetorno.add(populateAdjunto(objResult));
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
     
       public boolean eliminarDocumentoAdjunto(AdjuntoBE objAdjunto, DocumentoBE objDocumento) throws Exception {
        ConexionBD objConexion = null;
        int cont = 1;
        //String query = " UPDATE tmDocumento SET eliminado = ? WHERE id = ? ";
        String query ="DELETE FROM `RRHH`.`tmAdjunto` WHERE `id`=? and`tmDocumento_id`=?";
        try {
            objConexion = new ConexionBD();
            objConexion.open();
            objConexion.prepararSentencia(query);
           // objConexion.agregarParametro(cont++, objStakeholder.getEliminado());
            objConexion.agregarParametro(cont++, objAdjunto.getId());
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
  }


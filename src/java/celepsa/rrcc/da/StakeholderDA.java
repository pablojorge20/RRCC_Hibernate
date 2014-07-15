/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.be.DocumentoBE;
import celepsa.rrcc.be.StakeholderBE;
import celepsa.rrcc.bd.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class StakeholderDA {
    public List<StakeholderBE> listarStakeholder(Integer tdoc) throws Exception  {
        ConexionBD objConexion = null;
        try 
        {
            objConexion = new ConexionBD();
            List<StakeholderBE> lstRetorno = new ArrayList<StakeholderBE>();
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
                    lstRetorno.add(populateStakeholder(objResult));
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
    public List<StakeholderBE> listarStakeholderDoc(String tdoc) throws Exception  {
        ConexionBD objConexion = null;
        try 
        {
            objConexion = new ConexionBD();
            List<StakeholderBE> lstRetorno = new ArrayList<StakeholderBE>();
            String sQuery="";
         
                sQuery = "SELECT tmStakePersona.id, CONCAT(tmStakePersona.Nombre , ' ', tmStakePersona.Apellido) as Nombre " + 
                       " FROM tmStakePersona, PersonaDocumento where PersonaDocumento.tmStakePersona_id=tmStakePersona.id " +
                      "and PersonaDocumento.tmDocumento_id='"+ tdoc +"'" ;   
         
             
             
           
            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) 
            {
                while (objResult.next()) 
                {
                    lstRetorno.add(populateStakeholder(objResult));
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
     private StakeholderBE populateStakeholder(ResultSet resultado) throws SQLException {
        StakeholderBE objStakeholderBE = new StakeholderBE();

        objStakeholderBE.setId(resultado.getString("id"));
        
        objStakeholderBE.setNombre(resultado.getString("nombre"));

        return objStakeholderBE;
    }
        public int registrarStakeholderDocumento(StakeholderBE objSistema1, DocumentoBE objSistema2) throws Exception {
           
        ConexionBD objConexion = null;
         String query ="";
        
                   
         query ="INSERT INTO `RRHH`.`PersonaDocumento` (`tmDocumento_id`, `tmStakePersona_id`) VALUES (?, ?);";
        
      int cont = 1;
        try 
        {
            objConexion = new ConexionBD();
            objConexion.open();
            objConexion.prepararSentencia(query);
            //falta completar los parametros que se guardaran.
             objConexion.agregarParametro(cont++, objSistema2.getId());        
            objConexion.agregarParametro(cont++, objSistema1.getId());
      
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
        
       public boolean eliminarDocumento(StakeholderBE objStakeholder) throws Exception {
        ConexionBD objConexion = null;
        int cont = 1;
        String query = " UPDATE tmDocumento SET eliminado = ? WHERE id = ? ";
        
        try {
            objConexion = new ConexionBD();
            objConexion.open();
            objConexion.prepararSentencia(query);
           // objConexion.agregarParametro(cont++, objStakeholder.getEliminado());
            objConexion.agregarParametro(cont++, objStakeholder.getId());
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
         public boolean eliminarDocumentoStakeholder(StakeholderBE objStakeholder, DocumentoBE objDocumento) throws Exception {
        ConexionBD objConexion = null;
        int cont = 1;
        //String query = " UPDATE tmDocumento SET eliminado = ? WHERE id = ? ";
        String query ="DELETE FROM `RRHH`.`PersonaDocumento` WHERE `tmDocumento_id`=? and`tmStakePersona_id`=?";
        try {
            objConexion = new ConexionBD();
            objConexion.open();
            objConexion.prepararSentencia(query);
           // objConexion.agregarParametro(cont++, objStakeholder.getEliminado());
            objConexion.agregarParametro(cont++, objDocumento.getId());
            objConexion.agregarParametro(cont++, objStakeholder.getId());
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
        public StakeholderBE obtenerDocumento(StakeholderBE objStakeholder) throws Exception  {
        ConexionBD objConexion = null;
        int cont = 1;
        try 
        {
            objConexion = new ConexionBD();
            StakeholderBE objStakeholderResult = null;
            String sQuery = " SELECT  * FROM RRHH.tmDocumento WHERE id = ? ";
            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            objConexion.agregarParametro(cont++, objStakeholder.getId());

            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) 
            {
                if (objResult.next()) 
                {
                    objStakeholderResult = this.populateStakeholder(objResult);
                }
            } 
            return objStakeholderResult;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;


import celepsa.rrcc.be.DocumentoBE;
import celepsa.rrcc.be.StakeholderBE;
import celepsa.rrcc.da.StakeholderDA;
import celepsa.rrcc.eh.Tmstakepersona;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class StakeholderBL {
public List<Tmstakepersona> listarStakeholder(Integer pAg) throws Exception 
    {
           
        StakeholderDA objSistemaDA = new StakeholderDA();
        return objSistemaDA.listarStakeholder(pAg);
    }  

public List<Tmstakepersona> listarStakeholderDoc(String pAg) throws Exception 
    {
           
        StakeholderDA objSistemaDA = new StakeholderDA();
        return objSistemaDA.listarStakeholderDoc(pAg);
    } 

      public void registrarStakeholderDocumento(Tmstakepersona objSistema1, DocumentoBE objSistema2) throws Exception 
    {
        StakeholderDA objSistemaDA = new StakeholderDA();
        objSistemaDA.registrarStakeholderDocumento(objSistema1, objSistema2);
    }  
 public void eliminarStakeholder(Tmstakepersona objStakeholder) throws Exception
    {
        //public void eliminarMsgCorreo(MsgCorreoBE objMsgCorreo, UsuarioBE objUsuario) throws Exception
     //   PoliticasBL objPoliticasBL = new PoliticasBL();
        
        // Verificar el mensaje de correo está siendo usado
      //  int iCont = objPoliticasBL.contarMsgCorreo(objMsgCorreo);
        //if (iCont > 0)
        //{
          //  throw new Exception("*No se puede eliminar porque el mensaje de correo está asociado en la políticas.");
        //}
        
      //  MsgCorreoDA objMsgCorreoDA = new MsgCorreoDA();
        StakeholderDA objStakeholderDA = new StakeholderDA();
        // Obtener datos del mensaje del correo
       // objMsgCorreo = objMsgCorreoDA.obtenerMsgCorreo(objMsgCorreo);
        objStakeholder =objStakeholderDA.obtenerDocumento(objStakeholder);
        // Eliminación depende 
       // objStakeholder.setEliminado("1");
            objStakeholderDA.eliminarDocumento(objStakeholder)
                    ;
                
    //    objMsgCorreo.setEliminado("1");
      //  objMsgCorreoDA.eliminarMsgCorreo(objMsgCorreo);
        
       
        
    }  
 
 public void eliminarStakeholderDocumento(Tmstakepersona objStakeholder, DocumentoBE objDocumento) throws Exception
    {
        StakeholderDA objStakeholderDA = new StakeholderDA();
            objStakeholderDA.eliminarDocumentoStakeholder(objStakeholder, objDocumento) ;
        
    }  
 
}

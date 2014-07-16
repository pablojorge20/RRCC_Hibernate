/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;

import celepsa.rrcc.be.AdjuntoBE;
import celepsa.rrcc.be.DocumentoBE;
import celepsa.rrcc.da.DocumentoDA;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 *
 * @author pmedina
 */
public class DocumentoBL {
      public void registrarDocumento(DocumentoBE objSistema) throws Exception 
    {
        DocumentoDA objSistemaDA = new DocumentoDA();
        objSistemaDA.registrarDocumento(objSistema);
    }  
      
      public void actualizarDocumento (DocumentoBE objSistema) throws Exception 
    {
        SimpleDateFormat fT = new SimpleDateFormat("dd/MM/yyyy");
        if (fT.parse(objSistema.getFechaCaducidad()).before
           (fT.parse(objSistema.getFechaRecepcion()))){
                DocumentoDA objSistemaDA = new DocumentoDA();
                
                objSistemaDA.ActualizarDocumento(objSistema);
        }
        else{
            throw new Exception("*La fecha no de Caducidad no debe ser menor o igual a la fecha de recepción");   
            
        }
            
        
     
    }
      
            public List<DocumentoBE> listarDocumento(Integer tdoc) throws Exception 
    {
           
        DocumentoDA objSistemaDA = new DocumentoDA();
        return objSistemaDA.listarDocumentos(tdoc);
    }  
            
public List<DocumentoBE> listarDocumentos() throws Exception
    {
        DocumentoDA objSistemaDA = new DocumentoDA();
        return objSistemaDA.listarDocumentosVarios();
     
    }

public List<DocumentoBE> buscarDocumentos(String AsuntoBuscado) throws Exception
    {
        DocumentoDA objSistemaDA = new DocumentoDA();
        return objSistemaDA.buscarDocumentosVarios(AsuntoBuscado);
     
    }
 public void eliminarDocumento(DocumentoBE objDocumento) throws Exception
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
        DocumentoDA objDocumentoDA = new DocumentoDA();
        // Obtener datos del mensaje del correo
        
       // objMsgCorreo = objMsgCorreoDA.obtenerMsgCorreo(objMsgCorreo);
        objDocumento =objDocumentoDA.obtenerDocumento(objDocumento);
        // Eliminación
        objDocumento.setEliminado("1");
            objDocumentoDA.eliminarDocumento(objDocumento);
                
    //    objMsgCorreo.setEliminado("1");
      //  objMsgCorreoDA.eliminarMsgCorreo(objMsgCorreo);
        
       
        
    }    
    public DocumentoBE obtenerDocumento(DocumentoBE objDocumento) throws Exception
    {
        DocumentoDA objDocumentoDA = new DocumentoDA();
        return objDocumentoDA.obtenerDocumento(objDocumento);
    }  
    
    public void registrarAdjunto(AdjuntoBE objSistema, DocumentoBE objDocumento) throws Exception 
    {
        DocumentoDA objSistemaDA = new DocumentoDA();
     objSistemaDA.registrarAdjunto(objSistema, objDocumento);
    }  

    
    public List<AdjuntoBE> listarAdjuntos(Integer pAg) throws Exception 
    {
           
         DocumentoDA objSistemaDA = new DocumentoDA();
        return objSistemaDA.listarAdjuntos(pAg);
    }  

    public void eliminarAdjuntoDocumento(AdjuntoBE objAdunto, DocumentoBE objDocumento) throws Exception
    {
   
        DocumentoDA objDocumentoDA = new DocumentoDA();
  
            objDocumentoDA.eliminarDocumentoAdjunto(objAdunto, objDocumento) ;
 
        
    }  

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;

import celepsa.rrcc.be.AdjuntoBE;
import celepsa.rrcc.be.DocumentoBE;
import celepsa.rrcc.da.ConsultasVariasDA;
import celepsa.rrcc.da.DocumentoDA;
import celepsa.rrcc.eh.TmDocumento;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 *
 * @author pmedina
 */
public class DocumentoBL {
      public void registrarDocumento(DocumentoBE objSistema) throws Exception 
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        //Date fRegistro =
        DocumentoDA objSistemaDA = new DocumentoDA();
        objSistemaDA.registrarDocumento(objSistema);
    }  
      
      public void actualizarDocumento (DocumentoBE objSistema) throws Exception 
    {
       
                DocumentoDA objSistemaDA = new DocumentoDA();           
                objSistemaDA.ActualizarDocumento(objSistema);
     
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
 public boolean eliminarDocumento(TmDocumento objDocumento) throws Exception{
        boolean a,b=false;
        ConsultasVariasDA objconsulta = new ConsultasVariasDA();
        DocumentoDA objDocumentoDA = new DocumentoDA();
       
        objDocumento =objDocumentoDA.obtenerDocumento(objDocumento);
        
         a =objconsulta.BuscarPersonaDocumento( objDocumento.getId()+"" );
        if (a == true ){
            b=true;//No se puede eliminar por que tiene transaccion
        }
        else{
            objDocumento.setEliminado('1');
            DocumentoBE obj = new DocumentoBE();
            obj.setEliminado( objDocumento.getEliminado()+"" );
            obj.setId( objDocumento.getId()+"" );
            objDocumentoDA.eliminarDocumento(obj); 
            b=false;
        }
          return b;
        
    }    
    public TmDocumento obtenerDocumento(DocumentoBE objDocumento) throws Exception
    {
        DocumentoDA objDocumentoDA = new DocumentoDA();
        TmDocumento obj = new TmDocumento();
        obj.setId(Integer.parseInt(objDocumento.getId()));
        return objDocumentoDA.obtenerDocumento( obj );
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

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
import celepsa.rrcc.eh.Tmdocumento;
import java.util.List;


/**
 *
 * @author pmedina
 */
public class DocumentoBL {
      public int registrarDocumento(Tmdocumento documento) throws Exception 
    { 
        
           if ( documento.getRefConvenio() == null ) {
                documento.setRefConvenio(java.sql.Types.NULL);
            }
            if (documento.getRefPrograma() == null ) {
               documento.setRefPrograma(java.sql.Types.NULL);
            } 
            if (documento.getRefProyecto() != null ) {
                documento.setRefProyecto(java.sql.Types.NULL);
            } 
            if (documento.getRefDocumento() != null ) {
                 documento.setRefDocumento(java.sql.Types.NULL);
            } 
             documento.setEliminado('0');
             
        DocumentoDA objSistemaDA = new DocumentoDA();
        return objSistemaDA.registrarDocumento(documento);
    }  
      
      public void actualizarDocumento (Tmdocumento documento) throws Exception 
    {
       
            if ( documento.getRefConvenio() == null ) {
                documento.setRefConvenio(java.sql.Types.NULL);
            }
            if (documento.getRefPrograma() == null ) {
               documento.setRefPrograma(java.sql.Types.NULL);
            } 
            if (documento.getRefProyecto() != null ) {
                documento.setRefProyecto(java.sql.Types.NULL);
            } 
            if (documento.getRefDocumento() != null ) {
                 documento.setRefDocumento(java.sql.Types.NULL);
            } 
                DocumentoDA objSistemaDA = new DocumentoDA();           
                objSistemaDA.ActualizarDocumento(documento);
     
    }
      
    public List<Tmdocumento> listarDocumento(Integer tdoc) throws Exception 
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
 public boolean eliminarDocumento(Tmdocumento objDocumento) throws Exception{
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
    public Tmdocumento obtenerDocumento(Tmdocumento objDocumento) throws Exception
    {
        DocumentoDA objDocumentoDA = new DocumentoDA();
        return objDocumentoDA.obtenerDocumento( objDocumento );
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

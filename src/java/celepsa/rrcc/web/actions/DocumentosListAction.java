/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.web.actions;

import celepsa.rrcc.be.CriticidadBE;
import celepsa.rrcc.be.DocumentoBE;
import celepsa.rrcc.bl.DocumentoBL;
import celepsa.rrcc.web.util.Messenger;
import com.opensymphony.xwork2.Preparable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class DocumentosListAction extends BaseAction implements Preparable{

   private DocumentoBE documento;
    private List<DocumentoBE> documentos;
    private String textobuscado;
    private List<CriticidadBE> LCriticidad;

    
    @Override
    public void prepare() throws Exception {
        super.prepare();
   
        
    }
     public String listarDocumentos() 
    {
        try 
        {
            this.prepararMensaje();
            DocumentoBL objDocumentoBL= new DocumentoBL();
            setDocumentos(objDocumentoBL.listarDocumentos());
            
      
            return INPUT;
        } 
        catch (Exception e) 
        {
            addActionError(e.getMessage());;
            return INPUT;
        }
    }
    
      public String buscarDocumentos() 
    {
        try 
        {
            this.prepararMensaje();
            DocumentoBL objDocumentoBL= new DocumentoBL();
            setDocumentos(objDocumentoBL.buscarDocumentos(getTextobuscado()));
            
      
            return INPUT;
        } 
        catch (Exception e) 
        {
            addActionError(e.getMessage());;
            return INPUT;
        }
    }
    
     
    public String eliminarDocumento() {
              try 
        {
            //CorreoBL objMsgCorreoBL = new CorreoBL();
            DocumentoBL objDocumentoBL = new DocumentoBL();
            objDocumentoBL.eliminarDocumento(documento);
            //objMsgCorreoBL.eliminarMsgCorreo(msgCorreo, this.getUsuarioSession());
            addActionMessage("El Documento se elimino correctamente");
            
            this.listarDocumentos();
            
            return INPUT;
        } 
        catch (Exception e) 
        {
            if (e.getMessage().startsWith("*"))
            {
                addActionError(e.getMessage().substring(1));
                this.listarDocumentos();
            }
            else
            {
                addActionError(e.getMessage());
            }
            return INPUT;
        }
       
    }

    /*********************** Métodos Privados *********************************/

    private void prepararMensaje() {
       
    }

    /**
     * @return the documento
     */
    public DocumentoBE getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(DocumentoBE documento) {
        this.documento = documento;
    }

    /**
     * @return the documentos
     */
    public List<DocumentoBE> getDocumentos() {
        return documentos;
    }

    /**
     * @param documentos the documentos to set
     */
    public void setDocumentos(List<DocumentoBE> documentos) {
        this.documentos = documentos;
    }

    /**
     * @return the textobuscado
     */
    public String getTextobuscado() {
        return textobuscado;
    }

    /**
     * @param textobuscado the textobuscado to set
     */
    public void setTextobuscado(String textobuscado) {
        this.textobuscado = textobuscado;
    }

    /**
     * @return the LCriticidad
     */
    public List<CriticidadBE> getLCriticidad() {
        return LCriticidad;
    }

    /**
     * @param LCriticidad the LCriticidad to set
     */
    public void setLCriticidad(List<CriticidadBE> LCriticidad) {
        this.LCriticidad = LCriticidad;
    }
    
}

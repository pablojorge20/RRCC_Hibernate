/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.web.actions;

import celepsa.rrcc.eh.Criticidad;
import celepsa.rrcc.bl.DocumentoBL;
import celepsa.rrcc.eh.Tmdocumento;
import com.opensymphony.xwork2.Preparable;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author pmedina
 */
public class DocumentosListAction extends BaseAction implements Preparable {

    private static final Logger logger = Logger.getLogger(DocumentosListAction.class);
     
    private Tmdocumento documento;
    private List<Tmdocumento> documentos;
    private String textobuscado;
    private List<Criticidad> LCriticidad;

    @Override
    public void prepare() throws Exception {
        super.prepare();

    }

    public String listarDocumentos() {
         logger.debug("listarDocumentos");
        try {
            this.prepararMensaje();
            DocumentoBL objDocumentoBL = new DocumentoBL();
            setDocumentos(objDocumentoBL.listarDocumentos());

            return INPUT;
        } catch (Exception e) {
            addActionError(e.getMessage());;
            return INPUT;
        }
    }

    public String buscarDocumentos() {
        logger.debug("buscarDocumentos");
        try {
            this.prepararMensaje();
            DocumentoBL objDocumentoBL = new DocumentoBL();
            setDocumentos(objDocumentoBL.buscarDocumentos(getTextobuscado()));

            return INPUT;
        } catch (Exception e) {
            addActionError(e.getMessage());;
            return INPUT;
        }
    }

    public String eliminarDocumento() {
        logger.debug("eliminarDocumento");
        try {
            boolean a = false;
            //CorreoBL objMsgCorreoBL = new CorreoBL();
            DocumentoBL objDocumentoBL = new DocumentoBL();
            a = objDocumentoBL.eliminarDocumento(documento);
            //objMsgCorreoBL.eliminarMsgCorreo(msgCorreo, this.getUsuarioSession());
            if (a == true) {
                addActionMessage("No se puede eliminar por que tiene transacciones, puede cambiar el estado del documento");
            } else {
                addActionMessage("El Documento se anulo correctamente");
            }

            this.listarDocumentos();

            return INPUT;
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().startsWith("*")) {
                addActionError(e.getMessage().substring(1));
                this.listarDocumentos();
            } else {
                addActionError(e.getMessage());
            }
            return INPUT;
        }

    }

    /**
     * ********************* Métodos Privados ********************************
     */
    private void prepararMensaje() {

    }

    /**
     * @return the documento
     */
    public Tmdocumento getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(Tmdocumento documento) {
        this.documento = documento;
    }

    /**
     * @return the documentos
     */
    public List<Tmdocumento> getDocumentos() {
        return documentos;
    }

    /**
     * @param documentos the documentos to set
     */
    public void setDocumentos(List<Tmdocumento> documentos) {
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
    public List<Criticidad> getLCriticidad() {
        return LCriticidad;
    }

    /**
     * @param LCriticidad the LCriticidad to set
     */
    public void setLCriticidad(List<Criticidad> LCriticidad) {
        this.LCriticidad = LCriticidad;
    }

}

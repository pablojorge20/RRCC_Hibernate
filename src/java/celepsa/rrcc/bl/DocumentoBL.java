/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.bl;

import celepsa.rrcc.da.ConsultasVariasDA;
import celepsa.rrcc.da.DocumentoDA;
import celepsa.rrcc.eh.Tmadjunto;
import celepsa.rrcc.eh.Tmdocumento;
import celepsa.rrcc.web.actions.DocumentosListAction;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author pmedina
 */
public class DocumentoBL {
   private static final Logger logger = Logger.getLogger(DocumentoBL.class);
    public int registrarDocumento(Tmdocumento documento) throws Exception {

        if (documento.getRefConvenio() == null) {
            documento.setRefConvenio(java.sql.Types.NULL);
        }
        if (documento.getRefPrograma() == null) {
            documento.setRefPrograma(java.sql.Types.NULL);
        }
        if (documento.getRefProyecto() != null) {
            documento.setRefProyecto(java.sql.Types.NULL);
        }
        if (documento.getRefDocumento() != null) {
            documento.setRefDocumento(java.sql.Types.NULL);
        }
        documento.setEliminado('0');

        DocumentoDA objSistemaDA = new DocumentoDA();
        return objSistemaDA.registrarDocumento(documento);
    }

    public void actualizarDocumento(Tmdocumento documento) throws Exception {

        if (documento.getRefConvenio() == null) {
            documento.setRefConvenio(java.sql.Types.NULL);
        }
        if (documento.getRefPrograma() == null) {
            documento.setRefPrograma(java.sql.Types.NULL);
        }
        if (documento.getRefProyecto() != null) {
            documento.setRefProyecto(java.sql.Types.NULL);
        }
        if (documento.getRefDocumento() != null) {
            documento.setRefDocumento(java.sql.Types.NULL);
        }
        DocumentoDA objSistemaDA = new DocumentoDA();
        objSistemaDA.ActualizarDocumento(documento);

    }

    public List<Tmdocumento> listarDocumento(Integer tdoc) throws Exception {
        DocumentoDA objSistemaDA = new DocumentoDA();
        return objSistemaDA.listarDocumentos(tdoc);
    }

    public List<Tmdocumento> listarDocumentos() throws Exception {
        DocumentoDA objSistemaDA = new DocumentoDA();
        return objSistemaDA.listarDocumentosVarios();

    }

    public List<Tmdocumento> buscarDocumentos(String AsuntoBuscado) throws Exception {
        DocumentoDA objSistemaDA = new DocumentoDA();
        return objSistemaDA.buscarDocumentosVarios(AsuntoBuscado);

    }

    public boolean eliminarDocumento(Tmdocumento objDocumento) throws Exception {
         logger.debug("eliminarDocumento ");
         boolean a, b = false;
        ConsultasVariasDA objconsulta = new ConsultasVariasDA();
        DocumentoDA objDocumentoDA = new DocumentoDA(); 
        
        a = objconsulta.BuscarPersonaDocumento(objDocumento.getId() + "");
        
        if (a == true) {
            b = true;//No se puede eliminar por que tiene transaccion
        } else {
            objDocumento.setEliminado('1');
            objDocumentoDA.eliminarDocumento(objDocumento);
            b = false;
        }
        return b;

    }

    public Tmdocumento obtenerDocumento(Tmdocumento objDocumento) throws Exception {
        DocumentoDA objDocumentoDA = new DocumentoDA();
        return objDocumentoDA.obtenerDocumento(objDocumento);
    }

    public void registrarAdjunto(Tmadjunto objSistema, Tmdocumento objDocumento) throws Exception {
        DocumentoDA objSistemaDA = new DocumentoDA();
        objSistemaDA.registrarAdjunto(objSistema, objDocumento);
    }

    public List<Tmadjunto> listarAdjuntos(Integer pAg) throws Exception {

        DocumentoDA objSistemaDA = new DocumentoDA();
        return objSistemaDA.listarAdjuntos(pAg);
    }

    public void eliminarAdjuntoDocumento(Tmadjunto objAdunto, Tmdocumento objDocumento) throws Exception {

        DocumentoDA objDocumentoDA = new DocumentoDA();

        objDocumentoDA.eliminarDocumentoAdjunto(objAdunto, objDocumento);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.web.actions;

import celepsa.rrcc.eh.Tmadjunto;
import celepsa.rrcc.eh.Tmdocumento;
import celepsa.rrcc.bl.DocumentoBL;
import celepsa.rrcc.web.util.Funciones;
import static com.opensymphony.xwork2.Action.INPUT;
import com.opensymphony.xwork2.Preparable;
import java.io.File;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author pmedina
 */
public class DocumentosAdjuntosAction extends BaseAction implements Preparable {

    private Tmdocumento Documento;
    private Tmadjunto adjunto;
    private List<Tmadjunto> adjuntos;
    private File upload;
    private String uploadContentType; //The content type of the file
    private String uploadFileName; //The uploaded file name

    @Override
    public void prepare() throws Exception {
        super.prepare();

        DocumentoBL objAdjuntoBL = new DocumentoBL();

        if (getDocumento() != null && getDocumento().getId() == null) {
            setAdjuntos(objAdjuntoBL.listarAdjuntos(0));
        } else {
            setAdjuntos(objAdjuntoBL.listarAdjuntos(getDocumento().getId()));
        }

    }

    public String listarAdjuntos() {
        try {
            this.prepararMensaje();
          // StakeholderBL objStakeholderBL= new StakeholderBL();
            // setStakeholders(objStakeholderBL.listarStakeholderDoc(getDocumento().getId()));
            DocumentoBL objDocumentoBL = new DocumentoBL();
            setAdjuntos(objDocumentoBL.listarAdjuntos(getDocumento().getId()));

            return INPUT;
        } catch (Exception e) {
            addActionError(e.getMessage());
            return INPUT;
        }
    }

    public String grabar() {
        try {
       //     StakeholderBL objSistemaBL = new StakeholderBL();
            //   StakeholderBL objRemitenteBL =  new StakeholderBL() ;

        //   if (Documento.getId().isEmpty() &&
            //    !stakeholder.getId().isEmpty())
            //  {
            addActionMessage("Seleccione  correctamente");
          //  }
            // else
            //  {
            //       objSistemaBL.registrarStakeholderDocumento(stakeholder,Documento );

           //     addActionMessage("El Documento se grabo correctamente");
            //    setLRemitente(objRemitenteBL.listarStakeholder(Integer.parseInt(getDocumento().getId())));
            //this.listarStakeholder();
            // }
        } catch (Exception e) {
            procesarError(e);
        }

        return INPUT;

    }

    public String eliminarAdjuntoDocumento() {
        try {
            DocumentoBL objDocumentoBL = new DocumentoBL();

            objDocumentoBL.eliminarAdjuntoDocumento(getAdjunto(), getDocumento());

           // StakeholderBL objStakeholderBL = new StakeholderBL();
            // StakeholderBL objRemitenteBL =  new StakeholderBL() ;
            // objStakeholderBL.eliminarStakeholderDocumento(getStakeholder(), getDocumento()); 
            addActionMessage("El adjunto se elimino correctamente");

            // setLRemitente(objRemitenteBL.listarStakeholder(Integer.parseInt(getDocumento().getId())));
            this.listarAdjuntos();
            return INPUT;
        } catch (Exception e) {
            if (e.getMessage().startsWith("*")) {
                addActionError(e.getMessage().substring(1));
                //   this.listarStakeholder();
            } else {
                addActionError(e.getMessage());
            }
            return INPUT;
        }

    }

    public String subirArchivo() {
        try {
            if (getUploadFileName() != null) {
                String filePath = request.getRealPath("/") + "uploads/";
                String [] arr = getUploadFileName().split("\\.");
                String sExtension = arr[arr.length -1];
                if (!sExtension.toUpperCase().equals("PDF")){
                    
                    addActionMessage("Solo se puede cargar PDF");
                     return INPUT;
                    }
                
                String sFecha = Funciones.formatearFecha_yyyyMMdd(new Date());
                String sCodigo = sFecha + getUploadFileName();

                File fileToCreate = new File(filePath, sCodigo);
                FileUtils.copyFile(getUpload(), fileToCreate);

                // adjunto
                Tmadjunto objAdjunto = new Tmadjunto();
                objAdjunto.setNombre(getUploadFileName());
                objAdjunto.setScodigo(sCodigo);

                DocumentoBL objAdjuntoBL = new DocumentoBL();
                objAdjuntoBL.registrarAdjunto(objAdjunto, Documento);
                //int iIdArchivo = objAdjuntoBL.registrarAdjunto(objAdjunto, Documento);
                this.listarAdjuntos();
            //  adjunto = new AdjuntoBE();
                // adjunto.setId(String.valueOf(iIdArchivo));
                addActionMessage("El adjunto se cargo correctamente");
                msgAction = "";
            } else {
                msgAction = "Seleccione el archivo";
            }
        } catch (Exception e) {
            procesarError(e);
        }
        return INPUT;
    }

    private void prepararMensaje() {

    }

    /**
     * @return the Documento
     */
    public Tmdocumento getDocumento() {
        return Documento;
    }

    /**
     * @param Documento the Documento to set
     */
    public void setDocumento(Tmdocumento Documento) {
        this.Documento = Documento;
    }

    /**
     * @return the adjunto
     */
    public Tmadjunto getAdjunto() {
        return adjunto;
    }

    /**
     * @param adjunto the adjunto to set
     */
    public void setAdjunto(Tmadjunto adjunto) {
        this.adjunto = adjunto;
    }

    /**
     * @return the adjuntos
     */
    public List<Tmadjunto> getAdjuntos() {
        return adjuntos;
    }

    /**
     * @param adjuntos the adjuntos to set
     */
    public void setAdjuntos(List<Tmadjunto> adjuntos) {
        this.adjuntos = adjuntos;
    }

    /**
     * @return the upload
     */
    public File getUpload() {
        return upload;
    }

    /**
     * @param upload the upload to set
     */
    public void setUpload(File upload) {
        this.upload = upload;
    }

    /**
     * @return the uploadContentType
     */
    public String getUploadContentType() {
        return uploadContentType;
    }

    /**
     * @param uploadContentType the uploadContentType to set
     */
    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    /**
     * @return the uploadFileName
     */
    public String getUploadFileName() {
        return uploadFileName;
    }

    /**
     * @param uploadFileName the uploadFileName to set
     */
    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

}

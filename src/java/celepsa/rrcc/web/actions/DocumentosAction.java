/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.web.actions;
import celepsa.rrcc.be.CriticidadBE;
import celepsa.rrcc.be.DocumentoBE;
import celepsa.rrcc.be.IngrsoSalidaBE;
import celepsa.rrcc.be.StakeholderBE;
import celepsa.rrcc.bl.DocumentoBL;
import celepsa.rrcc.bl.EstadoBL;
import celepsa.rrcc.bl.StakeholderBL;
import celepsa.rrcc.bl.TipoDocumentoBL;
import celepsa.rrcc.eh.TmEstado;
import celepsa.rrcc.eh.TmTipoDocumento;
import com.opensymphony.xwork2.Preparable;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author pmedina
 */



public class DocumentosAction extends BaseAction implements Preparable {
    private DocumentoBE Documento;
    private List<TmTipoDocumento> LTipo;
    private List<StakeholderBE> LRemitente;
    private List<CriticidadBE> LCriticidad;
    private List<DocumentoBE> LConvenio;
    private List<DocumentoBE> LPrograma;
    private List<DocumentoBE> LDocumento;
    private List<DocumentoBE> LProyecto;
    private List<IngrsoSalidaBE> LIngreso;
    private List<TmEstado> LEstado;
    @Override
    public void prepare() throws Exception {
        super.prepare();
        
        TipoDocumentoBL objTipoDocumentoBL = new TipoDocumentoBL();
        //setLTipo(objTipoDocumentoBL.ListarTipoDocumento());
        setLTipo(objTipoDocumentoBL.ListarTipoDocumento());
        
       DocumentoBL objDocumentoBL = new DocumentoBL();
        setLConvenio(objDocumentoBL.listarDocumento(4));
        setLPrograma(objDocumentoBL.listarDocumento(5));
        setLDocumento(objDocumentoBL.listarDocumento(0));
        setLProyecto(objDocumentoBL.listarDocumento(6));
        
        
        
        StakeholderBL objRemitenteBL =  new StakeholderBL() ;
        setLRemitente(objRemitenteBL.listarStakeholder(0));
        
         EstadoBL objEstadoBL = new EstadoBL();
        setLEstado(objEstadoBL.ListarEstado());
        
         CriticidadBE Criticidad1= new CriticidadBE();
      Criticidad1.setId("3");
      Criticidad1.setDescripcion("Alto");
        CriticidadBE Criticidad2= new CriticidadBE();
       Criticidad2.setId("2");
     Criticidad2.setDescripcion("Medio");
        CriticidadBE Criticidad3= new CriticidadBE();
       Criticidad3.setId("1");
      Criticidad3.setDescripcion("Bajo");
        setLCriticidad(new ArrayList<CriticidadBE>());
        setLCriticidad(new ArrayList<CriticidadBE>());
        getLCriticidad().add(Criticidad1);
        getLCriticidad().add(Criticidad2);
        getLCriticidad().add(Criticidad3);
        
         IngrsoSalidaBE Ingres1= new IngrsoSalidaBE();
      Ingres1.setId("1");
      Ingres1.setDescripcion("Ingreso");
        IngrsoSalidaBE Ingrse2= new IngrsoSalidaBE();
       Ingrse2.setId("2");
      Ingrse2.setDescripcion("Salida");
        setLIngreso(new ArrayList<IngrsoSalidaBE>());
        getLIngreso().add(Ingres1);
        getLIngreso().add(Ingrse2);
        
    }
   
    @SkipValidation
    public String obtenerDocumentos() {
       
                  try 
        {
            if (getDocumento() == null || getDocumento().getId().isEmpty() )
            {
                setDocumento(new DocumentoBE());
            }
            else
            {
                DocumentoBL objDocumentoBL = new DocumentoBL(); 
                setDocumento(objDocumentoBL.obtenerDocumento(getDocumento()));
                
            }
            return INPUT;
        }
        catch(Exception e)
        {
            addActionError(e.getMessage());
            return INPUT;
        }
   
    }
    
    private void obtenerDetalleParametros() throws Exception
    {
  
        
    }

    public String grabar()
    {
 
        try
        {
            if (!Documento.getAsunto().isEmpty() &&
                !Documento.getObservaciones().isEmpty()){
                DocumentoBL objSistemaBL = new DocumentoBL();
          
                if (getDocumento().getId() != null &&
                    !Documento.getId().isEmpty()){
                    objSistemaBL.actualizarDocumento(getDocumento());
                    addActionMessage("El Documento se actualizo correctamente");
                }
                else{
                    objSistemaBL.registrarDocumento(getDocumento()); 
                    addActionMessage("El Documento se grabo correctamente");
                }
            }
            else{
                addActionMessage("Por favor llene Asunto y Observaciones");
            }
            
        }
        catch(Exception e)        
        {
            procesarError(e);
        }
      
        
        return INPUT;
     
    }
    
    public String cancelar()
    {
        return CANCEL;
    }

    /**
     * @return the Documento
     */
    public DocumentoBE getDocumento() {
        return Documento;
    }

    /**
     * @param Documento the Documento to set
     */
    public void setDocumento(DocumentoBE Documento) {
        this.Documento = Documento;
    }



    /**
     * @return the LRemitente
     */
    public List<StakeholderBE> getLRemitente() {
        return LRemitente;
    }

    /**
     * @param LRemitente the LRemitente to set
     */
    public void setLRemitente(List<StakeholderBE> LRemitente) {
        this.LRemitente = LRemitente;
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

    /**
     * @return the LConvenio
     */
    public List<DocumentoBE> getLConvenio() {
        return LConvenio;
    }

    /**
     * @param LConvenio the LConvenio to set
     */
    public void setLConvenio(List<DocumentoBE> LConvenio) {
        this.LConvenio = LConvenio;
    }

    /**
     * @return the LPrograma
     */
    public List<DocumentoBE> getLPrograma() {
        return LPrograma;
    }

    /**
     * @param LPrograma the LPrograma to set
     */
    public void setLPrograma(List<DocumentoBE> LPrograma) {
        this.LPrograma = LPrograma;
    }

    /**
     * @return the LDocumento
     */
    public List<DocumentoBE> getLDocumento() {
        return LDocumento;
    }

    /**
     * @param LDocumento the LDocumento to set
     */
    public void setLDocumento(List<DocumentoBE> LDocumento) {
        this.LDocumento = LDocumento;
    }

    /**
     * @return the LProyecto
     */
    public List<DocumentoBE> getLProyecto() {
        return LProyecto;
    }

    /**
     * @param LProyecto the LProyecto to set
     */
    public void setLProyecto(List<DocumentoBE> LProyecto) {
        this.LProyecto = LProyecto;
    }

    /**
     * @return the LIngreso
     */
    public List<IngrsoSalidaBE> getLIngreso() {
        return LIngreso;
    }

    /**
     * @param LIngreso the LIngreso to set
     */
    public void setLIngreso(List<IngrsoSalidaBE> LIngreso) {
        this.LIngreso = LIngreso;
    }



    /**
     * @return the LTipo
     */
    public List<TmTipoDocumento> getLTipo() {
        return LTipo;
    }

    /**
     * @param LTipo the LTipo to set
     */
    public void setLTipo(List<TmTipoDocumento> LTipo) {
        this.LTipo = LTipo;
    }

    /**
     * @return the LEstado
     */
    public List<TmEstado> getLEstado() {
        return LEstado;
    }

    /**
     * @param LEstado the LEstado to set
     */
    public void setLEstado(List<TmEstado> LEstado) {
        this.LEstado = LEstado;
    }
    



}
    
    
    
    


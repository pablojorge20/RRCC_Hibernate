/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.web.actions;
import celepsa.rrcc.be.CriticidadBE;
import celepsa.rrcc.be.IngrsoSalidaBE;
import celepsa.rrcc.bl.DocumentoBL;
import celepsa.rrcc.bl.EstadoBL;
import celepsa.rrcc.bl.StakeholderBL;
import celepsa.rrcc.bl.TipoDocumentoBL;
import celepsa.rrcc.eh.Tmdocumento;
import celepsa.rrcc.eh.Tmestado;
import celepsa.rrcc.eh.Tmstakepersona;
import celepsa.rrcc.eh.Tmtipodocumento;
import com.opensymphony.xwork2.Preparable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author pmedina
 */



public class DocumentosAction extends BaseAction implements Preparable {
    private Tmdocumento Documento;
    private List<Tmtipodocumento> LTipo;
    private List<Tmstakepersona> LRemitente;
    private List<CriticidadBE> LCriticidad;
    private List<Tmdocumento> LConvenio;
    private List<Tmdocumento> LPrograma;
    private List<Tmdocumento> LDocumento;
    private List<Tmdocumento> LProyecto;
    private List<IngrsoSalidaBE> LIngreso;
    private List<Tmestado> LEstado;
    
    @Override
    public void prepare() throws Exception {
        super.prepare();
        
        TipoDocumentoBL objTipoDocumentoBL = new TipoDocumentoBL();
        //setLTipo(objTipoDocumentoBL.ListarTipoDocumento());
        setLTipo(objTipoDocumentoBL.ListarTipoDocumento());
        //pmedina-agrgado
       Date date = new Date();
       DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
       Tmdocumento fdocumento= new Tmdocumento();
       fdocumento.setFechaCaducidad(fecha.format(date));
       fdocumento.setFechaRegistro(fecha.format(date));
       fdocumento.setFechaRecepcion(fecha.format(date));
       setDocumento(fdocumento);
       //pmedina-agrgado
       
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
       
       try{
            if (getDocumento() == null || getDocumento().getId() == null)
            {
                setDocumento(new Tmdocumento());
            }
            else
            {
                DocumentoBL objDocumentoBL = new DocumentoBL(); 
                setDocumento( objDocumentoBL.obtenerDocumento( getDocumento() ) );
                
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

    public String grabar(){
        DocumentoBL objSistemaBL = new DocumentoBL();
 
        try
        {
            if (!Documento.getAsunto().isEmpty() &&
                !Documento.getObservaciones().isEmpty()){
               Documento.setFechaRecepcion(this.formatFecha(Documento.getFechaRecepcion().substring(0, 10)));
                Documento.setFechaCaducidad(this.formatFecha(Documento.getFechaCaducidad().substring(0, 10)));
                //Date reportDate =fT.parse(Recepcion2);
                //String Recepcion=fT.format(reportDate);
               // Tmdfileconflictividad.tmfileconflictividad
               // Tmfileconflictividad
                        
                if (getDocumento().getId() != null &&  Documento.getId()!=null ){
                    objSistemaBL.actualizarDocumento( getDocumento());
                    addActionMessage("El Documento se actualizo correctamente");
                }
                else{
                    int i = objSistemaBL.registrarDocumento( getDocumento() ); 
                    if( i > 0 )
                        addActionMessage("El Documento se grabo correctamente");
                    else
                        addActionMessage("No se pudo grabar el documento");
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
    private String formatFecha(String fecha){
         
          //SimpleDateFormat fT = new SimpleDateFormat("dd/MM/yyyy");
               
               fecha = fecha.substring(8, 10) + "/" + fecha.substring(5, 7)+ "/" + fecha.substring(0, 4);
      return fecha;  
    } 
    
    public String cancelar()
    {
        return CANCEL;
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
     * @return the LRemitente
     */
    public List<Tmstakepersona> getLRemitente() {
        return LRemitente;
    }

    /**
     * @param LRemitente the LRemitente to set
     */
    public void setLRemitente(List<Tmstakepersona> LRemitente) {
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
    public List<Tmdocumento> getLConvenio() {
        return LConvenio;
    }

    /**
     * @param LConvenio the LConvenio to set
     */
    public void setLConvenio(List<Tmdocumento> LConvenio) {
        this.LConvenio = LConvenio;
    }

    /**
     * @return the LPrograma
     */
    public List<Tmdocumento> getLPrograma() {
        return LPrograma;
    }

    /**
     * @param LPrograma the LPrograma to set
     */
    public void setLPrograma(List<Tmdocumento> LPrograma) {
        this.LPrograma = LPrograma;
    }

    /**
     * @return the LDocumento
     */
    public List<Tmdocumento> getLDocumento() {
        return LDocumento;
    }

    /**
     * @param LDocumento the LDocumento to set
     */
    public void setLDocumento(List<Tmdocumento> LDocumento) {
        this.LDocumento = LDocumento;
    }

    /**
     * @return the LProyecto
     */
    public List<Tmdocumento> getLProyecto() {
        return LProyecto;
    }

    /**
     * @param LProyecto the LProyecto to set
     */
    public void setLProyecto(List<Tmdocumento> LProyecto) {
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
    public List<Tmtipodocumento> getLTipo() {
        return LTipo;
    }

    /**
     * @param LTipo the LTipo to set
     */
    public void setLTipo(List<Tmtipodocumento> LTipo) {
        this.LTipo = LTipo;
    }

    /**
     * @return the LEstado
     */
    public List<Tmestado> getLEstado() {
        return LEstado;
    }

    /**
     * @param LEstado the LEstado to set
     */
    public void setLEstado(List<Tmestado> LEstado) {
        this.LEstado = LEstado;
    }
    



}
    
    
    
    


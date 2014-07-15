/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.be;
import java.util.Date;
import java.util.List;
/**
 *
 * @author pmedina
 */
public class DocumentoBE {
    private String id;
    private String fechaRegistro;
    private String fechaRecepcion;
    private String fechaCaducidad;
    private String asunto;
    private String observaciones;
    private IngrsoSalidaBE ingreso;
    private CriticidadBE criticidad;
    private TipoDocumentoBE tipoDocumento;
    private StakeholderBE stakeholder;
    private List<StakeholderBE> Lstakeholder;
    private DocumentoBE convenio;
    private DocumentoBE programa;
    private DocumentoBE proyecto;
    private DocumentoBE documento;
    private String eliminado;
    private EstadoBE Estado;


    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the fechaRegistro
     */
    public String getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the fechaRecepcion
     */
    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * @param fechaRecepcion the fechaRecepcion to set
     */
    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * @return the fechaCaducidad
     */
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * @param fechaCaducidad the fechaCaducidad to set
     */
    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * @return the tipoDocumento
     */
    public TipoDocumentoBE getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(TipoDocumentoBE tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the stakeholder
     */
    public StakeholderBE getStakeholder() {
        return stakeholder;
    }

    /**
     * @param stakeholder the stakeholder to set
     */
    public void setStakeholder(StakeholderBE stakeholder) {
        this.stakeholder = stakeholder;
    }

    /**
     * @return the Lstakeholder
     */
    public List<StakeholderBE> getLstakeholder() {
        return Lstakeholder;
    }

    /**
     * @param Lstakeholder the Lstakeholder to set
     */
    public void setLstakeholder(List<StakeholderBE> Lstakeholder) {
        this.Lstakeholder = Lstakeholder;
    }

    /**
     * @return the convenio
     */
    public DocumentoBE getConvenio() {
        return convenio;
    }

    /**
     * @param convenio the convenio to set
     */
    public void setConvenio(DocumentoBE convenio) {
        this.convenio = convenio;
    }

    /**
     * @return the programa
     */
    public DocumentoBE getPrograma() {
        return programa;
    }

    /**
     * @param programa the programa to set
     */
    public void setPrograma(DocumentoBE programa) {
        this.programa = programa;
    }

    /**
     * @return the proyecto
     */
    public DocumentoBE getProyecto() {
        return proyecto;
    }

    /**
     * @param proyecto the proyecto to set
     */
    public void setProyecto(DocumentoBE proyecto) {
        this.proyecto = proyecto;
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
     * @param ingreso the ingreso to set
     */
    public void setIngreso(IngrsoSalidaBE ingreso) {
        this.ingreso = ingreso;
    }

    /**
     * @param criticidad the criticidad to set
     */
    public void setCriticidad(CriticidadBE criticidad) {
        this.criticidad = criticidad;
    }

    /**
     * @return the ingreso
     */
    public IngrsoSalidaBE getIngreso() {
        return ingreso;
    }

    /**
     * @return the criticidad
     */
    public CriticidadBE getCriticidad() {
        return criticidad;
    }

    /**
     * @return the eliminado
     */
    public String getEliminado() {
        return eliminado;
    }

    /**
     * @param eliminado the eliminado to set
     */
    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * @return the Estado
     */
    public EstadoBE getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(EstadoBE Estado) {
        this.Estado = Estado;
    }
  
    
}

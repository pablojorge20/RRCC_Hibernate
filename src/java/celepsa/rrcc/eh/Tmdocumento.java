/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.eh;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Elvis
 */
@Entity
@Table(name = "tmdocumento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmdocumento.findAll", query = "SELECT t FROM Tmdocumento t"),
    @NamedQuery(name = "Tmdocumento.findById", query = "SELECT t FROM Tmdocumento t WHERE t.id = :id"),
    @NamedQuery(name = "Tmdocumento.findByFechaRegistro", query = "SELECT t FROM Tmdocumento t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Tmdocumento.findByFechaRecepcion", query = "SELECT t FROM Tmdocumento t WHERE t.fechaRecepcion = :fechaRecepcion"),
    @NamedQuery(name = "Tmdocumento.findByFechaCaducidad", query = "SELECT t FROM Tmdocumento t WHERE t.fechaCaducidad = :fechaCaducidad"),
    @NamedQuery(name = "Tmdocumento.findByAsunto", query = "SELECT t FROM Tmdocumento t WHERE t.asunto = :asunto"),
    @NamedQuery(name = "Tmdocumento.findByObservaciones", query = "SELECT t FROM Tmdocumento t WHERE t.observaciones = :observaciones"),
    @NamedQuery(name = "Tmdocumento.findByIngresoSalida", query = "SELECT t FROM Tmdocumento t WHERE t.ingresoSalida = :ingresoSalida"),
    @NamedQuery(name = "Tmdocumento.findByRefConvenio", query = "SELECT t FROM Tmdocumento t WHERE t.refConvenio = :refConvenio"),
    @NamedQuery(name = "Tmdocumento.findByRefPrograma", query = "SELECT t FROM Tmdocumento t WHERE t.refPrograma = :refPrograma"),
    @NamedQuery(name = "Tmdocumento.findByRefProyecto", query = "SELECT t FROM Tmdocumento t WHERE t.refProyecto = :refProyecto"),
    @NamedQuery(name = "Tmdocumento.findByRefDocumento", query = "SELECT t FROM Tmdocumento t WHERE t.refDocumento = :refDocumento"),
    @NamedQuery(name = "Tmdocumento.findByEliminado", query = "SELECT t FROM Tmdocumento t WHERE t.eliminado = :eliminado")})
public class Tmdocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Transient
    private String id2;
    @Size(max = 10)
    @Column(name = "FechaRegistro")
    private String fechaRegistro;
    @Size(max = 10)
    @Column(name = "FechaRecepcion")
    private String fechaRecepcion;
    @Size(max = 10)
    @Column(name = "FechaCaducidad")
    private String fechaCaducidad;
    @Size(max = 100)
    @Column(name = "Asunto")
    private String asunto;
    @Size(max = 100)
    @Column(name = "Observaciones")
    private String observaciones;
    @Column(name = "IngresoSalida")
    private Integer ingresoSalida;
    @Column(name = "RefConvenio")
    private Integer refConvenio;
    @Column(name = "RefPrograma")
    private Integer refPrograma;
    @Column(name = "RefProyecto")
    private Integer refProyecto;
    @Column(name = "RefDocumento")
    private Integer refDocumento;
    @Column(name = "eliminado")
    private Character eliminado;
    @ManyToMany(mappedBy = "tmdocumentoCollection")
    private Collection<Tmstakeagrupacion> tmstakeagrupacionCollection;
    @JoinColumn(name = "tmEstado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tmestado tmEstadoid;
    @JoinColumn(name = "Criticidad_id", referencedColumnName = "id")
    @ManyToOne
    private Criticidad criticidadid;
    @JoinColumn(name = "tmTipoDocumento_id", referencedColumnName = "id")
    @ManyToOne
    private Tmtipodocumento tmTipoDocumentoid;
    @JoinColumn(name = "tmStakePersona_id", referencedColumnName = "id")
    @ManyToOne
    private Tmstakepersona tmStakePersonaid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tmdocumento")
    private Collection<Personadocumento> personadocumentoCollection;
    @OneToMany(mappedBy = "tmDocumentoid")
    private Collection<Tminterpretacion> tminterpretacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tmdocumento")
    private Collection<Tmadjunto> tmadjuntoCollection;

    public Tmdocumento() {
    }

    public Tmdocumento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getIngresoSalida() {
        return ingresoSalida;
    }

    public void setIngresoSalida(Integer ingresoSalida) {
        this.ingresoSalida = ingresoSalida;
    }

    public Integer getRefConvenio() {
        return refConvenio;
    }

    public void setRefConvenio(Integer refConvenio) {
        this.refConvenio = refConvenio;
    }

    public Integer getRefPrograma() {
        return refPrograma;
    }

    public void setRefPrograma(Integer refPrograma) {
        this.refPrograma = refPrograma;
    }

    public Integer getRefProyecto() {
        return refProyecto;
    }

    public void setRefProyecto(Integer refProyecto) {
        this.refProyecto = refProyecto;
    }

    public Integer getRefDocumento() {
        return refDocumento;
    }

    public void setRefDocumento(Integer refDocumento) {
        this.refDocumento = refDocumento;
    }

    public Character getEliminado() {
        return eliminado;
    }

    public void setEliminado(Character eliminado) {
        this.eliminado = eliminado;
    }

    @XmlTransient
    public Collection<Tmstakeagrupacion> getTmstakeagrupacionCollection() {
        return tmstakeagrupacionCollection;
    }

    public void setTmstakeagrupacionCollection(Collection<Tmstakeagrupacion> tmstakeagrupacionCollection) {
        this.tmstakeagrupacionCollection = tmstakeagrupacionCollection;
    }

    public Tmestado getTmEstadoid() {
        return tmEstadoid;
    }

    public void setTmEstadoid(Tmestado tmEstadoid) {
        this.tmEstadoid = tmEstadoid;
    }

    public Criticidad getCriticidadid() {
        return criticidadid;
    }

    public void setCriticidadid(Criticidad criticidadid) {
        this.criticidadid = criticidadid;
    }

    public Tmtipodocumento getTmTipoDocumentoid() {
        return tmTipoDocumentoid;
    }

    public void setTmTipoDocumentoid(Tmtipodocumento tmTipoDocumentoid) {
        this.tmTipoDocumentoid = tmTipoDocumentoid;
    }

    public Tmstakepersona getTmStakePersonaid() {
        return tmStakePersonaid;
    }

    public void setTmStakePersonaid(Tmstakepersona tmStakePersonaid) {
        this.tmStakePersonaid = tmStakePersonaid;
    }

    @XmlTransient
    public Collection<Personadocumento> getPersonadocumentoCollection() {
        return personadocumentoCollection;
    }

    public void setPersonadocumentoCollection(Collection<Personadocumento> personadocumentoCollection) {
        this.personadocumentoCollection = personadocumentoCollection;
    }

    @XmlTransient
    public Collection<Tminterpretacion> getTminterpretacionCollection() {
        return tminterpretacionCollection;
    }

    public void setTminterpretacionCollection(Collection<Tminterpretacion> tminterpretacionCollection) {
        this.tminterpretacionCollection = tminterpretacionCollection;
    }

    @XmlTransient
    public Collection<Tmadjunto> getTmadjuntoCollection() {
        return tmadjuntoCollection;
    }

    public void setTmadjuntoCollection(Collection<Tmadjunto> tmadjuntoCollection) {
        this.tmadjuntoCollection = tmadjuntoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tmdocumento)) {
            return false;
        }
        Tmdocumento other = (Tmdocumento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.eh.Tmdocumento[ id=" + id + " ]";
    }

    /**
     * @return the id2
     */
    public String getId2() {
        return id2;
    }

    /**
     * @param id2 the id2 to set
     */
    public void setId2(String id2) {
        this.id2 = id2;
    }
    
}

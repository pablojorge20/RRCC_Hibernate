/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
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
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 10)
    @Column(name = "FechaRegistro", length = 10)
    private String fechaRegistro;
    @Size(max = 10)
    @Column(name = "FechaRecepcion", length = 10)
    private String fechaRecepcion;
    @Size(max = 10)
    @Column(name = "FechaCaducidad", length = 10)
    private String fechaCaducidad;
    @Size(max = 100)
    @Column(name = "Asunto", length = 100)
    private String asunto;
    @Size(max = 100)
    @Column(name = "Observaciones", length = 100)
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
    @JoinTable(name = "agrupaciondocumento", joinColumns = {
        @JoinColumn(name = "tmDocumento_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "tmStakeAgrupacion_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Collection<Tmstakeagrupacion> tmstakeagrupacionCollection;
    @JoinTable(name = "personadocumento", joinColumns = {
        @JoinColumn(name = "tmDocumento_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "tmStakePersona_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Collection<Tmstakepersona> tmstakepersonaCollection;
    @OneToMany(mappedBy = "tmDocumentoid")
    private Collection<Tminterpretacion> tminterpretacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tmdocumento")
    private Collection<Tmadjunto> tmadjuntoCollection;
    @JoinColumn(name = "Criticidad_id", referencedColumnName = "id")
    @ManyToOne
    private Criticidad criticidadid;
    @JoinColumn(name = "tmEstado_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Tmestado tmEstadoid;
    @JoinColumn(name = "tmStakePersona_id", referencedColumnName = "id")
    @ManyToOne
    private Tmstakepersona tmStakePersonaid;
    @JoinColumn(name = "tmTipoDocumento_id", referencedColumnName = "id")
    @ManyToOne
    private Tmtipodocumento tmTipoDocumentoid;

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

    @XmlTransient
    public Collection<Tmstakepersona> getTmstakepersonaCollection() {
        return tmstakepersonaCollection;
    }

    public void setTmstakepersonaCollection(Collection<Tmstakepersona> tmstakepersonaCollection) {
        this.tmstakepersonaCollection = tmstakepersonaCollection;
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

    public Criticidad getCriticidadid() {
        return criticidadid;
    }

    public void setCriticidadid(Criticidad criticidadid) {
        this.criticidadid = criticidadid;
    }

    public Tmestado getTmEstadoid() {
        return tmEstadoid;
    }

    public void setTmEstadoid(Tmestado tmEstadoid) {
        this.tmEstadoid = tmEstadoid;
    }

    public Tmstakepersona getTmStakePersonaid() {
        return tmStakePersonaid;
    }

    public void setTmStakePersonaid(Tmstakepersona tmStakePersonaid) {
        this.tmStakePersonaid = tmStakePersonaid;
    }

    public Tmtipodocumento getTmTipoDocumentoid() {
        return tmTipoDocumentoid;
    }

    public void setTmTipoDocumentoid(Tmtipodocumento tmTipoDocumentoid) {
        this.tmTipoDocumentoid = tmTipoDocumentoid;
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
        return "celepsa.rrcc.db.Tmdocumento[ id=" + id + " ]";
    }
    
}

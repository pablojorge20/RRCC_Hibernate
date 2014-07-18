/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "tmproyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmproyecto.findAll", query = "SELECT t FROM Tmproyecto t"),
    @NamedQuery(name = "Tmproyecto.findById", query = "SELECT t FROM Tmproyecto t WHERE t.id = :id"),
    @NamedQuery(name = "Tmproyecto.findByFechaRegistro", query = "SELECT t FROM Tmproyecto t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Tmproyecto.findByFechaCaducidad", query = "SELECT t FROM Tmproyecto t WHERE t.fechaCaducidad = :fechaCaducidad"),
    @NamedQuery(name = "Tmproyecto.findByNombre", query = "SELECT t FROM Tmproyecto t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tmproyecto.findByAlcance", query = "SELECT t FROM Tmproyecto t WHERE t.alcance = :alcance"),
    @NamedQuery(name = "Tmproyecto.findByFInicio", query = "SELECT t FROM Tmproyecto t WHERE t.fInicio = :fInicio"),
    @NamedQuery(name = "Tmproyecto.findByFFin", query = "SELECT t FROM Tmproyecto t WHERE t.fFin = :fFin"),
    @NamedQuery(name = "Tmproyecto.findByUbicacion", query = "SELECT t FROM Tmproyecto t WHERE t.ubicacion = :ubicacion"),
    @NamedQuery(name = "Tmproyecto.findByAReal", query = "SELECT t FROM Tmproyecto t WHERE t.aReal = :aReal"),
    @NamedQuery(name = "Tmproyecto.findByAEstimado", query = "SELECT t FROM Tmproyecto t WHERE t.aEstimado = :aEstimado"),
    @NamedQuery(name = "Tmproyecto.findByEst", query = "SELECT t FROM Tmproyecto t WHERE t.est = :est")})
public class Tmproyecto implements Serializable {
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
    @Column(name = "FechaCaducidad", length = 10)
    private String fechaCaducidad;
    @Size(max = 100)
    @Column(name = "Nombre", length = 100)
    private String nombre;
    @Size(max = 250)
    @Column(name = "Alcance", length = 250)
    private String alcance;
    @Size(max = 10)
    @Column(name = "FInicio", length = 10)
    private String fInicio;
    @Size(max = 10)
    @Column(name = "FFin", length = 10)
    private String fFin;
    @Size(max = 250)
    @Column(name = "Ubicacion", length = 250)
    private String ubicacion;
    @Size(max = 10)
    @Column(name = "AReal", length = 10)
    private String aReal;
    @Size(max = 10)
    @Column(name = "AEstimado", length = 10)
    private String aEstimado;
    @Column(name = "Est")
    private Integer est;
    @JoinColumn(name = "Criticidad_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Criticidad criticidadid;
    @JoinColumn(name = "tmEstado_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Tmestado tmEstadoid;
    @JoinColumn(name = "tmZona_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Tmzona tmZonaid;

    public Tmproyecto() {
    }

    public Tmproyecto(Integer id) {
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

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public String getFInicio() {
        return fInicio;
    }

    public void setFInicio(String fInicio) {
        this.fInicio = fInicio;
    }

    public String getFFin() {
        return fFin;
    }

    public void setFFin(String fFin) {
        this.fFin = fFin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getAReal() {
        return aReal;
    }

    public void setAReal(String aReal) {
        this.aReal = aReal;
    }

    public String getAEstimado() {
        return aEstimado;
    }

    public void setAEstimado(String aEstimado) {
        this.aEstimado = aEstimado;
    }

    public Integer getEst() {
        return est;
    }

    public void setEst(Integer est) {
        this.est = est;
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

    public Tmzona getTmZonaid() {
        return tmZonaid;
    }

    public void setTmZonaid(Tmzona tmZonaid) {
        this.tmZonaid = tmZonaid;
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
        if (!(object instanceof Tmproyecto)) {
            return false;
        }
        Tmproyecto other = (Tmproyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.db.Tmproyecto[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "tmstakeagrupacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmstakeagrupacion.findAll", query = "SELECT t FROM Tmstakeagrupacion t"),
    @NamedQuery(name = "Tmstakeagrupacion.findById", query = "SELECT t FROM Tmstakeagrupacion t WHERE t.id = :id"),
    @NamedQuery(name = "Tmstakeagrupacion.findByFechaRegistro", query = "SELECT t FROM Tmstakeagrupacion t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Tmstakeagrupacion.findByNombre", query = "SELECT t FROM Tmstakeagrupacion t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tmstakeagrupacion.findByIdentidad", query = "SELECT t FROM Tmstakeagrupacion t WHERE t.identidad = :identidad"),
    @NamedQuery(name = "Tmstakeagrupacion.findByUbicacion", query = "SELECT t FROM Tmstakeagrupacion t WHERE t.ubicacion = :ubicacion"),
    @NamedQuery(name = "Tmstakeagrupacion.findByFotografia", query = "SELECT t FROM Tmstakeagrupacion t WHERE t.fotografia = :fotografia"),
    @NamedQuery(name = "Tmstakeagrupacion.findByEst", query = "SELECT t FROM Tmstakeagrupacion t WHERE t.est = :est")})
public class Tmstakeagrupacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 10)
    @Column(name = "FechaRegistro", length = 10)
    private String fechaRegistro;
    @Size(max = 100)
    @Column(name = "Nombre", length = 100)
    private String nombre;
    @Size(max = 250)
    @Column(name = "Identidad", length = 250)
    private String identidad;
    @Size(max = 250)
    @Column(name = "Ubicacion", length = 250)
    private String ubicacion;
    @Size(max = 100)
    @Column(name = "Fotografia", length = 100)
    private String fotografia;
    @Column(name = "est")
    private Integer est;
    @ManyToMany(mappedBy = "tmstakeagrupacionCollection")
    private Collection<Tmdocumento> tmdocumentoCollection;
    @JoinColumn(name = "tmEstado_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Tmestado tmEstadoid;
    @JoinColumn(name = "tmNivelInfluencia_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Tmnivelinfluencia tmNivelInfluenciaid;
    @JoinColumn(name = "tmZona_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Tmzona tmZonaid;

    public Tmstakeagrupacion() {
    }

    public Tmstakeagrupacion(Integer id) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public Integer getEst() {
        return est;
    }

    public void setEst(Integer est) {
        this.est = est;
    }

    @XmlTransient
    public Collection<Tmdocumento> getTmdocumentoCollection() {
        return tmdocumentoCollection;
    }

    public void setTmdocumentoCollection(Collection<Tmdocumento> tmdocumentoCollection) {
        this.tmdocumentoCollection = tmdocumentoCollection;
    }

    public Tmestado getTmEstadoid() {
        return tmEstadoid;
    }

    public void setTmEstadoid(Tmestado tmEstadoid) {
        this.tmEstadoid = tmEstadoid;
    }

    public Tmnivelinfluencia getTmNivelInfluenciaid() {
        return tmNivelInfluenciaid;
    }

    public void setTmNivelInfluenciaid(Tmnivelinfluencia tmNivelInfluenciaid) {
        this.tmNivelInfluenciaid = tmNivelInfluenciaid;
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
        if (!(object instanceof Tmstakeagrupacion)) {
            return false;
        }
        Tmstakeagrupacion other = (Tmstakeagrupacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.db.Tmstakeagrupacion[ id=" + id + " ]";
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.eh;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
 * @author Elvis
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
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "FechaRegistro")
    private String fechaRegistro;
    @Size(max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "Identidad")
    private String identidad;
    @Size(max = 250)
    @Column(name = "Ubicacion")
    private String ubicacion;
    @Size(max = 100)
    @Column(name = "Fotografia")
    private String fotografia;
    @Column(name = "est")
    private Integer est;
    @JoinTable(name = "agrupaciondocumento", joinColumns = {
        @JoinColumn(name = "tmStakeAgrupacion_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "tmDocumento_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Tmdocumento> tmdocumentoCollection;
    @JoinColumn(name = "tmEstado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tmestado tmEstadoid;
    @JoinColumn(name = "tmZona_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tmzona tmZonaid;
    @JoinColumn(name = "tmNivelInfluencia_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tmnivelinfluencia tmNivelInfluenciaid;

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

    public Tmzona getTmZonaid() {
        return tmZonaid;
    }

    public void setTmZonaid(Tmzona tmZonaid) {
        this.tmZonaid = tmZonaid;
    }

    public Tmnivelinfluencia getTmNivelInfluenciaid() {
        return tmNivelInfluenciaid;
    }

    public void setTmNivelInfluenciaid(Tmnivelinfluencia tmNivelInfluenciaid) {
        this.tmNivelInfluenciaid = tmNivelInfluenciaid;
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
        return "celepsa.rrcc.eh.Tmstakeagrupacion[ id=" + id + " ]";
    }
    
}

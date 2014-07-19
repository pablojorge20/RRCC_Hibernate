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
 * @author Elvis
 */
@Entity
@Table(name = "tmfileconflictividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmfileconflictividad.findAll", query = "SELECT t FROM Tmfileconflictividad t"),
    @NamedQuery(name = "Tmfileconflictividad.findById", query = "SELECT t FROM Tmfileconflictividad t WHERE t.id = :id"),
    @NamedQuery(name = "Tmfileconflictividad.findByFechaRegistro", query = "SELECT t FROM Tmfileconflictividad t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Tmfileconflictividad.findByNombreFile", query = "SELECT t FROM Tmfileconflictividad t WHERE t.nombreFile = :nombreFile")})
public class Tmfileconflictividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "FechaRegistro")
    private String fechaRegistro;
    @Size(max = 50)
    @Column(name = "NombreFile")
    private String nombreFile;
    @JoinColumn(name = "tmZona_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tmzona tmZonaid;
    @JoinColumn(name = "tmUsuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tmusuario tmUsuarioid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tmfileconflictividad")
    private Collection<Tmdfileconflictividad> tmdfileconflictividadCollection;

    public Tmfileconflictividad() {
    }

    public Tmfileconflictividad(Integer id) {
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

    public String getNombreFile() {
        return nombreFile;
    }

    public void setNombreFile(String nombreFile) {
        this.nombreFile = nombreFile;
    }

    public Tmzona getTmZonaid() {
        return tmZonaid;
    }

    public void setTmZonaid(Tmzona tmZonaid) {
        this.tmZonaid = tmZonaid;
    }

    public Tmusuario getTmUsuarioid() {
        return tmUsuarioid;
    }

    public void setTmUsuarioid(Tmusuario tmUsuarioid) {
        this.tmUsuarioid = tmUsuarioid;
    }

    @XmlTransient
    public Collection<Tmdfileconflictividad> getTmdfileconflictividadCollection() {
        return tmdfileconflictividadCollection;
    }

    public void setTmdfileconflictividadCollection(Collection<Tmdfileconflictividad> tmdfileconflictividadCollection) {
        this.tmdfileconflictividadCollection = tmdfileconflictividadCollection;
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
        if (!(object instanceof Tmfileconflictividad)) {
            return false;
        }
        Tmfileconflictividad other = (Tmfileconflictividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.eh.Tmfileconflictividad[ id=" + id + " ]";
    }
    
}

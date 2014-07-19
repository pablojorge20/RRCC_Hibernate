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
@Table(name = "tmzona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmzona.findAll", query = "SELECT t FROM Tmzona t"),
    @NamedQuery(name = "Tmzona.findById", query = "SELECT t FROM Tmzona t WHERE t.id = :id"),
    @NamedQuery(name = "Tmzona.findByDescripcion", query = "SELECT t FROM Tmzona t WHERE t.descripcion = :descripcion")})
public class Tmzona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tmzona")
    private Collection<Tmclima> tmclimaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tmZonaid")
    private Collection<Tmevento> tmeventoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tmZonaid")
    private Collection<Tmproyecto> tmproyectoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tmZonaid")
    private Collection<Tmstakepersona> tmstakepersonaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tmZonaid")
    private Collection<Tmfileconflictividad> tmfileconflictividadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tmZonaid")
    private Collection<Tmstakeagrupacion> tmstakeagrupacionCollection;

    public Tmzona() {
    }

    public Tmzona(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Tmclima> getTmclimaCollection() {
        return tmclimaCollection;
    }

    public void setTmclimaCollection(Collection<Tmclima> tmclimaCollection) {
        this.tmclimaCollection = tmclimaCollection;
    }

    @XmlTransient
    public Collection<Tmevento> getTmeventoCollection() {
        return tmeventoCollection;
    }

    public void setTmeventoCollection(Collection<Tmevento> tmeventoCollection) {
        this.tmeventoCollection = tmeventoCollection;
    }

    @XmlTransient
    public Collection<Tmproyecto> getTmproyectoCollection() {
        return tmproyectoCollection;
    }

    public void setTmproyectoCollection(Collection<Tmproyecto> tmproyectoCollection) {
        this.tmproyectoCollection = tmproyectoCollection;
    }

    @XmlTransient
    public Collection<Tmstakepersona> getTmstakepersonaCollection() {
        return tmstakepersonaCollection;
    }

    public void setTmstakepersonaCollection(Collection<Tmstakepersona> tmstakepersonaCollection) {
        this.tmstakepersonaCollection = tmstakepersonaCollection;
    }

    @XmlTransient
    public Collection<Tmfileconflictividad> getTmfileconflictividadCollection() {
        return tmfileconflictividadCollection;
    }

    public void setTmfileconflictividadCollection(Collection<Tmfileconflictividad> tmfileconflictividadCollection) {
        this.tmfileconflictividadCollection = tmfileconflictividadCollection;
    }

    @XmlTransient
    public Collection<Tmstakeagrupacion> getTmstakeagrupacionCollection() {
        return tmstakeagrupacionCollection;
    }

    public void setTmstakeagrupacionCollection(Collection<Tmstakeagrupacion> tmstakeagrupacionCollection) {
        this.tmstakeagrupacionCollection = tmstakeagrupacionCollection;
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
        if (!(object instanceof Tmzona)) {
            return false;
        }
        Tmzona other = (Tmzona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.eh.Tmzona[ id=" + id + " ]";
    }
    
}

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
@Table(name = "criticidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Criticidad.findAll", query = "SELECT c FROM Criticidad c"),
    @NamedQuery(name = "Criticidad.findById", query = "SELECT c FROM Criticidad c WHERE c.id = :id"),
    @NamedQuery(name = "Criticidad.findByDescripcion", query = "SELECT c FROM Criticidad c WHERE c.descripcion = :descripcion")})
public class Criticidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 50)
    @Column(name = "Descripcion", length = 50)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criticidadid")
    private Collection<Tmproyecto> tmproyectoCollection;
    @OneToMany(mappedBy = "criticidadid")
    private Collection<Tmdocumento> tmdocumentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criticidadid")
    private Collection<Tmevento> tmeventoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criticidadid")
    private Collection<Tmtipodocumento> tmtipodocumentoCollection;

    public Criticidad() {
    }

    public Criticidad(Integer id) {
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
    public Collection<Tmproyecto> getTmproyectoCollection() {
        return tmproyectoCollection;
    }

    public void setTmproyectoCollection(Collection<Tmproyecto> tmproyectoCollection) {
        this.tmproyectoCollection = tmproyectoCollection;
    }

    @XmlTransient
    public Collection<Tmdocumento> getTmdocumentoCollection() {
        return tmdocumentoCollection;
    }

    public void setTmdocumentoCollection(Collection<Tmdocumento> tmdocumentoCollection) {
        this.tmdocumentoCollection = tmdocumentoCollection;
    }

    @XmlTransient
    public Collection<Tmevento> getTmeventoCollection() {
        return tmeventoCollection;
    }

    public void setTmeventoCollection(Collection<Tmevento> tmeventoCollection) {
        this.tmeventoCollection = tmeventoCollection;
    }

    @XmlTransient
    public Collection<Tmtipodocumento> getTmtipodocumentoCollection() {
        return tmtipodocumentoCollection;
    }

    public void setTmtipodocumentoCollection(Collection<Tmtipodocumento> tmtipodocumentoCollection) {
        this.tmtipodocumentoCollection = tmtipodocumentoCollection;
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
        if (!(object instanceof Criticidad)) {
            return false;
        }
        Criticidad other = (Criticidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.db.Criticidad[ id=" + id + " ]";
    }
    
}

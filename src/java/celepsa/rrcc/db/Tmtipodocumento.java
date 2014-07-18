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
@Table(name = "tmtipodocumento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmtipodocumento.findAll", query = "SELECT t FROM Tmtipodocumento t"),
    @NamedQuery(name = "Tmtipodocumento.findById", query = "SELECT t FROM Tmtipodocumento t WHERE t.id = :id"),
    @NamedQuery(name = "Tmtipodocumento.findByDescripcion", query = "SELECT t FROM Tmtipodocumento t WHERE t.descripcion = :descripcion")})
public class Tmtipodocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 45)
    @Column(name = "Descripcion", length = 45)
    private String descripcion;
    @OneToMany(mappedBy = "tmTipoDocumentoid")
    private Collection<Tmdocumento> tmdocumentoCollection;
    @JoinColumn(name = "Criticidad_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Criticidad criticidadid;

    public Tmtipodocumento() {
    }

    public Tmtipodocumento(Integer id) {
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
    public Collection<Tmdocumento> getTmdocumentoCollection() {
        return tmdocumentoCollection;
    }

    public void setTmdocumentoCollection(Collection<Tmdocumento> tmdocumentoCollection) {
        this.tmdocumentoCollection = tmdocumentoCollection;
    }

    public Criticidad getCriticidadid() {
        return criticidadid;
    }

    public void setCriticidadid(Criticidad criticidadid) {
        this.criticidadid = criticidadid;
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
        if (!(object instanceof Tmtipodocumento)) {
            return false;
        }
        Tmtipodocumento other = (Tmtipodocumento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.db.Tmtipodocumento[ id=" + id + " ]";
    }
    
}

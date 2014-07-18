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
@Table(name = "tmtdocumentoidentidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmtdocumentoidentidad.findAll", query = "SELECT t FROM Tmtdocumentoidentidad t"),
    @NamedQuery(name = "Tmtdocumentoidentidad.findById", query = "SELECT t FROM Tmtdocumentoidentidad t WHERE t.id = :id"),
    @NamedQuery(name = "Tmtdocumentoidentidad.findByDescripcion", query = "SELECT t FROM Tmtdocumentoidentidad t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tmtdocumentoidentidad.findByEst", query = "SELECT t FROM Tmtdocumentoidentidad t WHERE t.est = :est")})
public class Tmtdocumentoidentidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 45)
    @Column(name = "Descripcion", length = 45)
    private String descripcion;
    @Column(name = "est")
    private Integer est;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tmTDocumentoid")
    private Collection<Tmstakepersona> tmstakepersonaCollection;

    public Tmtdocumentoidentidad() {
    }

    public Tmtdocumentoidentidad(Integer id) {
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

    public Integer getEst() {
        return est;
    }

    public void setEst(Integer est) {
        this.est = est;
    }

    @XmlTransient
    public Collection<Tmstakepersona> getTmstakepersonaCollection() {
        return tmstakepersonaCollection;
    }

    public void setTmstakepersonaCollection(Collection<Tmstakepersona> tmstakepersonaCollection) {
        this.tmstakepersonaCollection = tmstakepersonaCollection;
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
        if (!(object instanceof Tmtdocumentoidentidad)) {
            return false;
        }
        Tmtdocumentoidentidad other = (Tmtdocumentoidentidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.db.Tmtdocumentoidentidad[ id=" + id + " ]";
    }
    
}

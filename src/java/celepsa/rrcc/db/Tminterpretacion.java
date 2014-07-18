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
import javax.persistence.Lob;
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
@Table(name = "tminterpretacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tminterpretacion.findAll", query = "SELECT t FROM Tminterpretacion t"),
    @NamedQuery(name = "Tminterpretacion.findById", query = "SELECT t FROM Tminterpretacion t WHERE t.id = :id"),
    @NamedQuery(name = "Tminterpretacion.findByFechaRegistro", query = "SELECT t FROM Tminterpretacion t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Tminterpretacion.findByStatus", query = "SELECT t FROM Tminterpretacion t WHERE t.status = :status"),
    @NamedQuery(name = "Tminterpretacion.findByEst", query = "SELECT t FROM Tminterpretacion t WHERE t.est = :est")})
public class Tminterpretacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 10)
    @Column(name = "FechaRegistro", length = 10)
    private String fechaRegistro;
    @Size(max = 45)
    @Column(name = "Status", length = 45)
    private String status;
    @Lob
    @Size(max = 16777215)
    @Column(name = "Interpretacion", length = 16777215)
    private String interpretacion;
    @Column(name = "Est")
    private Integer est;
    @JoinColumn(name = "tmDocumento_id", referencedColumnName = "id")
    @ManyToOne
    private Tmdocumento tmDocumentoid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tminterpretacion")
    private Collection<Intercomentario> intercomentarioCollection;

    public Tminterpretacion() {
    }

    public Tminterpretacion(Integer id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInterpretacion() {
        return interpretacion;
    }

    public void setInterpretacion(String interpretacion) {
        this.interpretacion = interpretacion;
    }

    public Integer getEst() {
        return est;
    }

    public void setEst(Integer est) {
        this.est = est;
    }

    public Tmdocumento getTmDocumentoid() {
        return tmDocumentoid;
    }

    public void setTmDocumentoid(Tmdocumento tmDocumentoid) {
        this.tmDocumentoid = tmDocumentoid;
    }

    @XmlTransient
    public Collection<Intercomentario> getIntercomentarioCollection() {
        return intercomentarioCollection;
    }

    public void setIntercomentarioCollection(Collection<Intercomentario> intercomentarioCollection) {
        this.intercomentarioCollection = intercomentarioCollection;
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
        if (!(object instanceof Tminterpretacion)) {
            return false;
        }
        Tminterpretacion other = (Tminterpretacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.db.Tminterpretacion[ id=" + id + " ]";
    }
    
}

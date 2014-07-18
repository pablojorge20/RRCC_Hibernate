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
@Table(name = "tmnotificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmnotificacion.findAll", query = "SELECT t FROM Tmnotificacion t"),
    @NamedQuery(name = "Tmnotificacion.findById", query = "SELECT t FROM Tmnotificacion t WHERE t.id = :id"),
    @NamedQuery(name = "Tmnotificacion.findByDescripcion", query = "SELECT t FROM Tmnotificacion t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tmnotificacion.findByFechaRegistro", query = "SELECT t FROM Tmnotificacion t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Tmnotificacion.findByEst", query = "SELECT t FROM Tmnotificacion t WHERE t.est = :est")})
public class Tmnotificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 100)
    @Column(name = "Descripcion", length = 100)
    private String descripcion;
    @Size(max = 10)
    @Column(name = "FechaRegistro", length = 10)
    private String fechaRegistro;
    @Column(name = "Est")
    private Integer est;

    public Tmnotificacion() {
    }

    public Tmnotificacion(Integer id) {
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

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getEst() {
        return est;
    }

    public void setEst(Integer est) {
        this.est = est;
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
        if (!(object instanceof Tmnotificacion)) {
            return false;
        }
        Tmnotificacion other = (Tmnotificacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.db.Tmnotificacion[ id=" + id + " ]";
    }
    
}

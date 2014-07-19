/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.eh;

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
 * @author Elvis
 */
@Entity
@Table(name = "tmevento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmevento.findAll", query = "SELECT t FROM Tmevento t"),
    @NamedQuery(name = "Tmevento.findById", query = "SELECT t FROM Tmevento t WHERE t.id = :id"),
    @NamedQuery(name = "Tmevento.findByFechaRegistro", query = "SELECT t FROM Tmevento t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Tmevento.findByFechaEvento", query = "SELECT t FROM Tmevento t WHERE t.fechaEvento = :fechaEvento"),
    @NamedQuery(name = "Tmevento.findByDescripcion", query = "SELECT t FROM Tmevento t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tmevento.findByEst", query = "SELECT t FROM Tmevento t WHERE t.est = :est")})
public class Tmevento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "FechaRegistro")
    private String fechaRegistro;
    @Size(max = 10)
    @Column(name = "FechaEvento")
    private String fechaEvento;
    @Size(max = 250)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Est")
    private Integer est;
    @JoinColumn(name = "tmZona_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tmzona tmZonaid;
    @JoinColumn(name = "Criticidad_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Criticidad criticidadid;

    public Tmevento() {
    }

    public Tmevento(Integer id) {
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

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
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

    public Tmzona getTmZonaid() {
        return tmZonaid;
    }

    public void setTmZonaid(Tmzona tmZonaid) {
        this.tmZonaid = tmZonaid;
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
        if (!(object instanceof Tmevento)) {
            return false;
        }
        Tmevento other = (Tmevento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.eh.Tmevento[ id=" + id + " ]";
    }
    
}

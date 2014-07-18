/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "intercomentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intercomentario.findAll", query = "SELECT i FROM Intercomentario i"),
    @NamedQuery(name = "Intercomentario.findByFechaComentario", query = "SELECT i FROM Intercomentario i WHERE i.intercomentarioPK.fechaComentario = :fechaComentario"),
    @NamedQuery(name = "Intercomentario.findByTmUsuarioid", query = "SELECT i FROM Intercomentario i WHERE i.intercomentarioPK.tmUsuarioid = :tmUsuarioid"),
    @NamedQuery(name = "Intercomentario.findByTmInterpretacionid", query = "SELECT i FROM Intercomentario i WHERE i.intercomentarioPK.tmInterpretacionid = :tmInterpretacionid"),
    @NamedQuery(name = "Intercomentario.findByComentario", query = "SELECT i FROM Intercomentario i WHERE i.comentario = :comentario"),
    @NamedQuery(name = "Intercomentario.findByEst", query = "SELECT i FROM Intercomentario i WHERE i.est = :est")})
public class Intercomentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IntercomentarioPK intercomentarioPK;
    @Size(max = 100)
    @Column(name = "Comentario", length = 100)
    private String comentario;
    @Column(name = "Est")
    private Integer est;
    @JoinColumn(name = "tmInterpretacion_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tminterpretacion tminterpretacion;
    @JoinColumn(name = "tmUsuario_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tmusuario tmusuario;

    public Intercomentario() {
    }

    public Intercomentario(IntercomentarioPK intercomentarioPK) {
        this.intercomentarioPK = intercomentarioPK;
    }

    public Intercomentario(int fechaComentario, int tmUsuarioid, int tmInterpretacionid) {
        this.intercomentarioPK = new IntercomentarioPK(fechaComentario, tmUsuarioid, tmInterpretacionid);
    }

    public IntercomentarioPK getIntercomentarioPK() {
        return intercomentarioPK;
    }

    public void setIntercomentarioPK(IntercomentarioPK intercomentarioPK) {
        this.intercomentarioPK = intercomentarioPK;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getEst() {
        return est;
    }

    public void setEst(Integer est) {
        this.est = est;
    }

    public Tminterpretacion getTminterpretacion() {
        return tminterpretacion;
    }

    public void setTminterpretacion(Tminterpretacion tminterpretacion) {
        this.tminterpretacion = tminterpretacion;
    }

    public Tmusuario getTmusuario() {
        return tmusuario;
    }

    public void setTmusuario(Tmusuario tmusuario) {
        this.tmusuario = tmusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (intercomentarioPK != null ? intercomentarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intercomentario)) {
            return false;
        }
        Intercomentario other = (Intercomentario) object;
        if ((this.intercomentarioPK == null && other.intercomentarioPK != null) || (this.intercomentarioPK != null && !this.intercomentarioPK.equals(other.intercomentarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.db.Intercomentario[ intercomentarioPK=" + intercomentarioPK + " ]";
    }
    
}

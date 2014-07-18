/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrador
 */
@Embeddable
public class IntercomentarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaComentario", nullable = false)
    private int fechaComentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tmUsuario_id", nullable = false)
    private int tmUsuarioid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tmInterpretacion_id", nullable = false)
    private int tmInterpretacionid;

    public IntercomentarioPK() {
    }

    public IntercomentarioPK(int fechaComentario, int tmUsuarioid, int tmInterpretacionid) {
        this.fechaComentario = fechaComentario;
        this.tmUsuarioid = tmUsuarioid;
        this.tmInterpretacionid = tmInterpretacionid;
    }

    public int getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(int fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public int getTmUsuarioid() {
        return tmUsuarioid;
    }

    public void setTmUsuarioid(int tmUsuarioid) {
        this.tmUsuarioid = tmUsuarioid;
    }

    public int getTmInterpretacionid() {
        return tmInterpretacionid;
    }

    public void setTmInterpretacionid(int tmInterpretacionid) {
        this.tmInterpretacionid = tmInterpretacionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fechaComentario;
        hash += (int) tmUsuarioid;
        hash += (int) tmInterpretacionid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntercomentarioPK)) {
            return false;
        }
        IntercomentarioPK other = (IntercomentarioPK) object;
        if (this.fechaComentario != other.fechaComentario) {
            return false;
        }
        if (this.tmUsuarioid != other.tmUsuarioid) {
            return false;
        }
        if (this.tmInterpretacionid != other.tmInterpretacionid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.db.IntercomentarioPK[ fechaComentario=" + fechaComentario + ", tmUsuarioid=" + tmUsuarioid + ", tmInterpretacionid=" + tmInterpretacionid + " ]";
    }
    
}

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
public class TmdfileconflictividadPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaGeneracion", nullable = false)
    private int fechaGeneracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tmFileConflictividad_id", nullable = false)
    private int tmFileConflictividadid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private int id;

    public TmdfileconflictividadPK() {
    }

    public TmdfileconflictividadPK(int fechaGeneracion, int tmFileConflictividadid, int id) {
        this.fechaGeneracion = fechaGeneracion;
        this.tmFileConflictividadid = tmFileConflictividadid;
        this.id = id;
    }

    public int getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(int fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public int getTmFileConflictividadid() {
        return tmFileConflictividadid;
    }

    public void setTmFileConflictividadid(int tmFileConflictividadid) {
        this.tmFileConflictividadid = tmFileConflictividadid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fechaGeneracion;
        hash += (int) tmFileConflictividadid;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmdfileconflictividadPK)) {
            return false;
        }
        TmdfileconflictividadPK other = (TmdfileconflictividadPK) object;
        if (this.fechaGeneracion != other.fechaGeneracion) {
            return false;
        }
        if (this.tmFileConflictividadid != other.tmFileConflictividadid) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.db.TmdfileconflictividadPK[ fechaGeneracion=" + fechaGeneracion + ", tmFileConflictividadid=" + tmFileConflictividadid + ", id=" + id + " ]";
    }
    
}

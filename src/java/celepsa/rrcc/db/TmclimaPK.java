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
import javax.validation.constraints.Size;

/**
 *
 * @author Administrador
 */
@Embeddable
public class TmclimaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "tmZona_id", nullable = false)
    private int tmZonaid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FechaGeneracion", nullable = false, length = 10)
    private String fechaGeneracion;

    public TmclimaPK() {
    }

    public TmclimaPK(int tmZonaid, String fechaGeneracion) {
        this.tmZonaid = tmZonaid;
        this.fechaGeneracion = fechaGeneracion;
    }

    public int getTmZonaid() {
        return tmZonaid;
    }

    public void setTmZonaid(int tmZonaid) {
        this.tmZonaid = tmZonaid;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tmZonaid;
        hash += (fechaGeneracion != null ? fechaGeneracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmclimaPK)) {
            return false;
        }
        TmclimaPK other = (TmclimaPK) object;
        if (this.tmZonaid != other.tmZonaid) {
            return false;
        }
        if ((this.fechaGeneracion == null && other.fechaGeneracion != null) || (this.fechaGeneracion != null && !this.fechaGeneracion.equals(other.fechaGeneracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.db.TmclimaPK[ tmZonaid=" + tmZonaid + ", fechaGeneracion=" + fechaGeneracion + " ]";
    }
    
}

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
@Table(name = "tmdfileconflictividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmdfileconflictividad.findAll", query = "SELECT t FROM Tmdfileconflictividad t"),
    @NamedQuery(name = "Tmdfileconflictividad.findByFechaGeneracion", query = "SELECT t FROM Tmdfileconflictividad t WHERE t.tmdfileconflictividadPK.fechaGeneracion = :fechaGeneracion"),
    @NamedQuery(name = "Tmdfileconflictividad.findByTmFileConflictividadid", query = "SELECT t FROM Tmdfileconflictividad t WHERE t.tmdfileconflictividadPK.tmFileConflictividadid = :tmFileConflictividadid"),
    @NamedQuery(name = "Tmdfileconflictividad.findById", query = "SELECT t FROM Tmdfileconflictividad t WHERE t.tmdfileconflictividadPK.id = :id"),
    @NamedQuery(name = "Tmdfileconflictividad.findByTabla", query = "SELECT t FROM Tmdfileconflictividad t WHERE t.tabla = :tabla"),
    @NamedQuery(name = "Tmdfileconflictividad.findByIdTabla", query = "SELECT t FROM Tmdfileconflictividad t WHERE t.idTabla = :idTabla"),
    @NamedQuery(name = "Tmdfileconflictividad.findByEst", query = "SELECT t FROM Tmdfileconflictividad t WHERE t.est = :est")})
public class Tmdfileconflictividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TmdfileconflictividadPK tmdfileconflictividadPK;
    @Size(max = 50)
    @Column(name = "Tabla", length = 50)
    private String tabla;
    @Column(name = "idTabla")
    private Integer idTabla;
    @Column(name = "Est")
    private Integer est;
    @JoinColumn(name = "tmFileConflictividad_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tmfileconflictividad tmfileconflictividad;

    public Tmdfileconflictividad() {
    }

    public Tmdfileconflictividad(TmdfileconflictividadPK tmdfileconflictividadPK) {
        this.tmdfileconflictividadPK = tmdfileconflictividadPK;
    }

    public Tmdfileconflictividad(int fechaGeneracion, int tmFileConflictividadid, int id) {
        this.tmdfileconflictividadPK = new TmdfileconflictividadPK(fechaGeneracion, tmFileConflictividadid, id);
    }

    public TmdfileconflictividadPK getTmdfileconflictividadPK() {
        return tmdfileconflictividadPK;
    }

    public void setTmdfileconflictividadPK(TmdfileconflictividadPK tmdfileconflictividadPK) {
        this.tmdfileconflictividadPK = tmdfileconflictividadPK;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public Integer getIdTabla() {
        return idTabla;
    }

    public void setIdTabla(Integer idTabla) {
        this.idTabla = idTabla;
    }

    public Integer getEst() {
        return est;
    }

    public void setEst(Integer est) {
        this.est = est;
    }

    public Tmfileconflictividad getTmfileconflictividad() {
        return tmfileconflictividad;
    }

    public void setTmfileconflictividad(Tmfileconflictividad tmfileconflictividad) {
        this.tmfileconflictividad = tmfileconflictividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tmdfileconflictividadPK != null ? tmdfileconflictividadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tmdfileconflictividad)) {
            return false;
        }
        Tmdfileconflictividad other = (Tmdfileconflictividad) object;
        if ((this.tmdfileconflictividadPK == null && other.tmdfileconflictividadPK != null) || (this.tmdfileconflictividadPK != null && !this.tmdfileconflictividadPK.equals(other.tmdfileconflictividadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.db.Tmdfileconflictividad[ tmdfileconflictividadPK=" + tmdfileconflictividadPK + " ]";
    }
    
}

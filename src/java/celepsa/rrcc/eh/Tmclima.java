/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.eh;

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
 * @author Elvis
 */
@Entity
@Table(name = "tmclima")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmclima.findAll", query = "SELECT t FROM Tmclima t"),
    @NamedQuery(name = "Tmclima.findByTmZonaid", query = "SELECT t FROM Tmclima t WHERE t.tmclimaPK.tmZonaid = :tmZonaid"),
    @NamedQuery(name = "Tmclima.findByFechaGeneracion", query = "SELECT t FROM Tmclima t WHERE t.tmclimaPK.fechaGeneracion = :fechaGeneracion"),
    @NamedQuery(name = "Tmclima.findByClima", query = "SELECT t FROM Tmclima t WHERE t.clima = :clima")})
public class Tmclima implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TmclimaPK tmclimaPK;
    @Size(max = 10)
    @Column(name = "Clima")
    private String clima;
    @JoinColumn(name = "tmZona_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tmzona tmzona;

    public Tmclima() {
    }

    public Tmclima(TmclimaPK tmclimaPK) {
        this.tmclimaPK = tmclimaPK;
    }

    public Tmclima(int tmZonaid, String fechaGeneracion) {
        this.tmclimaPK = new TmclimaPK(tmZonaid, fechaGeneracion);
    }

    public TmclimaPK getTmclimaPK() {
        return tmclimaPK;
    }

    public void setTmclimaPK(TmclimaPK tmclimaPK) {
        this.tmclimaPK = tmclimaPK;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public Tmzona getTmzona() {
        return tmzona;
    }

    public void setTmzona(Tmzona tmzona) {
        this.tmzona = tmzona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tmclimaPK != null ? tmclimaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tmclima)) {
            return false;
        }
        Tmclima other = (Tmclima) object;
        if ((this.tmclimaPK == null && other.tmclimaPK != null) || (this.tmclimaPK != null && !this.tmclimaPK.equals(other.tmclimaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.eh.Tmclima[ tmclimaPK=" + tmclimaPK + " ]";
    }
    
}

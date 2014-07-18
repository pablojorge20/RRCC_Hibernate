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
@Table(name = "tmadjunto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmadjunto.findAll", query = "SELECT t FROM Tmadjunto t"),
    @NamedQuery(name = "Tmadjunto.findById", query = "SELECT t FROM Tmadjunto t WHERE t.tmadjuntoPK.id = :id"),
    @NamedQuery(name = "Tmadjunto.findByTmDocumentoid", query = "SELECT t FROM Tmadjunto t WHERE t.tmadjuntoPK.tmDocumentoid = :tmDocumentoid"),
    @NamedQuery(name = "Tmadjunto.findByNombre", query = "SELECT t FROM Tmadjunto t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tmadjunto.findByEliminado", query = "SELECT t FROM Tmadjunto t WHERE t.eliminado = :eliminado"),
    @NamedQuery(name = "Tmadjunto.findByScodigo", query = "SELECT t FROM Tmadjunto t WHERE t.scodigo = :scodigo")})
public class Tmadjunto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TmadjuntoPK tmadjuntoPK;
    @Size(max = 250)
    @Column(name = "Nombre", length = 250)
    private String nombre;
    @Column(name = "eliminado")
    private Character eliminado;
    @Size(max = 100)
    @Column(name = "scodigo", length = 100)
    private String scodigo;
    @JoinColumn(name = "tmDocumento_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tmdocumento tmdocumento;

    public Tmadjunto() {
    }

    public Tmadjunto(TmadjuntoPK tmadjuntoPK) {
        this.tmadjuntoPK = tmadjuntoPK;
    }

    public Tmadjunto(int id, int tmDocumentoid) {
        this.tmadjuntoPK = new TmadjuntoPK(id, tmDocumentoid);
    }

    public TmadjuntoPK getTmadjuntoPK() {
        return tmadjuntoPK;
    }

    public void setTmadjuntoPK(TmadjuntoPK tmadjuntoPK) {
        this.tmadjuntoPK = tmadjuntoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getEliminado() {
        return eliminado;
    }

    public void setEliminado(Character eliminado) {
        this.eliminado = eliminado;
    }

    public String getScodigo() {
        return scodigo;
    }

    public void setScodigo(String scodigo) {
        this.scodigo = scodigo;
    }

    public Tmdocumento getTmdocumento() {
        return tmdocumento;
    }

    public void setTmdocumento(Tmdocumento tmdocumento) {
        this.tmdocumento = tmdocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tmadjuntoPK != null ? tmadjuntoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tmadjunto)) {
            return false;
        }
        Tmadjunto other = (Tmadjunto) object;
        if ((this.tmadjuntoPK == null && other.tmadjuntoPK != null) || (this.tmadjuntoPK != null && !this.tmadjuntoPK.equals(other.tmadjuntoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.db.Tmadjunto[ tmadjuntoPK=" + tmadjuntoPK + " ]";
    }
    
}

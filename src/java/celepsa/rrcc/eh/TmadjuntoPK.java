/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.eh;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Elvis
 */
@Embeddable
public class TmadjuntoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tmDocumento_id")
    private int tmDocumentoid;

    public TmadjuntoPK() {
    }

    public TmadjuntoPK(int id, int tmDocumentoid) {
        this.id = id;
        this.tmDocumentoid = tmDocumentoid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTmDocumentoid() {
        return tmDocumentoid;
    }

    public void setTmDocumentoid(int tmDocumentoid) {
        this.tmDocumentoid = tmDocumentoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) tmDocumentoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmadjuntoPK)) {
            return false;
        }
        TmadjuntoPK other = (TmadjuntoPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.tmDocumentoid != other.tmDocumentoid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.eh.TmadjuntoPK[ id=" + id + ", tmDocumentoid=" + tmDocumentoid + " ]";
    }
    
}

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
public class PersonadocumentoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "tmDocumento_id")
    private int tmDocumentoid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tmStakePersona_id")
    private int tmStakePersonaid;

    public PersonadocumentoPK() {
    }

    public PersonadocumentoPK(int tmDocumentoid, int tmStakePersonaid) {
        this.tmDocumentoid = tmDocumentoid;
        this.tmStakePersonaid = tmStakePersonaid;
    }

    public int getTmDocumentoid() {
        return tmDocumentoid;
    }

    public void setTmDocumentoid(int tmDocumentoid) {
        this.tmDocumentoid = tmDocumentoid;
    }

    public int getTmStakePersonaid() {
        return tmStakePersonaid;
    }

    public void setTmStakePersonaid(int tmStakePersonaid) {
        this.tmStakePersonaid = tmStakePersonaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tmDocumentoid;
        hash += (int) tmStakePersonaid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonadocumentoPK)) {
            return false;
        }
        PersonadocumentoPK other = (PersonadocumentoPK) object;
        if (this.tmDocumentoid != other.tmDocumentoid) {
            return false;
        }
        if (this.tmStakePersonaid != other.tmStakePersonaid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.eh.PersonadocumentoPK[ tmDocumentoid=" + tmDocumentoid + ", tmStakePersonaid=" + tmStakePersonaid + " ]";
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.eh;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elvis
 */
@Entity
@Table(name = "personadocumento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personadocumento.findAll", query = "SELECT p FROM Personadocumento p"),
    @NamedQuery(name = "Personadocumento.findByTmDocumentoid", query = "SELECT p FROM Personadocumento p WHERE p.personadocumentoPK.tmDocumentoid = :tmDocumentoid"),
    @NamedQuery(name = "Personadocumento.findByTmStakePersonaid", query = "SELECT p FROM Personadocumento p WHERE p.personadocumentoPK.tmStakePersonaid = :tmStakePersonaid"),
    @NamedQuery(name = "Personadocumento.findByEst", query = "SELECT p FROM Personadocumento p WHERE p.est = :est")})
public class Personadocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonadocumentoPK personadocumentoPK;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "est")
    private int est;
    
    @JoinColumn(name = "tmDocumento_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tmdocumento tmdocumento;
    
    @JoinColumn(name = "tmStakePersona_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tmstakepersona tmstakepersona;

    public Personadocumento() {
    }

    public Personadocumento(PersonadocumentoPK personadocumentoPK) {
        this.personadocumentoPK = personadocumentoPK;
    }

    public Personadocumento(PersonadocumentoPK personadocumentoPK, int est) {
        this.personadocumentoPK = personadocumentoPK;
        this.est = est;
    }

    public Personadocumento(int tmDocumentoid, int tmStakePersonaid) {
        this.personadocumentoPK = new PersonadocumentoPK(tmDocumentoid, tmStakePersonaid);
    }

    public PersonadocumentoPK getPersonadocumentoPK() {
        return personadocumentoPK;
    }

    public void setPersonadocumentoPK(PersonadocumentoPK personadocumentoPK) {
        this.personadocumentoPK = personadocumentoPK;
    }

    public int getEst() {
        return est;
    }

    public void setEst(int est) {
        this.est = est;
    }

    public Tmdocumento getTmdocumento() {
        return tmdocumento;
    }

    public void setTmdocumento(Tmdocumento tmdocumento) {
        this.tmdocumento = tmdocumento;
    }

    public Tmstakepersona getTmstakepersona() {
        return tmstakepersona;
    }

    public void setTmstakepersona(Tmstakepersona tmstakepersona) {
        this.tmstakepersona = tmstakepersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personadocumentoPK != null ? personadocumentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personadocumento)) {
            return false;
        }
        Personadocumento other = (Personadocumento) object;
        if ((this.personadocumentoPK == null && other.personadocumentoPK != null) || (this.personadocumentoPK != null && !this.personadocumentoPK.equals(other.personadocumentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.eh.Personadocumento[ personadocumentoPK=" + personadocumentoPK + " ]";
    }
    
}

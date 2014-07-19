/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.eh;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Elvis
 */
@Entity
@Table(name = "tmusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmusuario.findAll", query = "SELECT t FROM Tmusuario t"),
    @NamedQuery(name = "Tmusuario.findById", query = "SELECT t FROM Tmusuario t WHERE t.id = :id"),
    @NamedQuery(name = "Tmusuario.findByNombre", query = "SELECT t FROM Tmusuario t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tmusuario.findByApellido", query = "SELECT t FROM Tmusuario t WHERE t.apellido = :apellido"),
    @NamedQuery(name = "Tmusuario.findByUsuario", query = "SELECT t FROM Tmusuario t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "Tmusuario.findByContrase\u00f1a", query = "SELECT t FROM Tmusuario t WHERE t.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "Tmusuario.findByFechaRegistro", query = "SELECT t FROM Tmusuario t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Tmusuario.findByEst", query = "SELECT t FROM Tmusuario t WHERE t.est = :est")})
public class Tmusuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "Apellido")
    private String apellido;
    @Size(max = 20)
    @Column(name = "Usuario")
    private String usuario;
    @Size(max = 20)
    @Column(name = "Contrase\u00f1a")
    private String contraseña;
    @Size(max = 10)
    @Column(name = "FechaRegistro")
    private String fechaRegistro;
    @Column(name = "Est")
    private Integer est;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tmUsuarioid")
    private Collection<Tmfileconflictividad> tmfileconflictividadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tmusuario")
    private Collection<Intercomentario> intercomentarioCollection;

    public Tmusuario() {
    }

    public Tmusuario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getEst() {
        return est;
    }

    public void setEst(Integer est) {
        this.est = est;
    }

    @XmlTransient
    public Collection<Tmfileconflictividad> getTmfileconflictividadCollection() {
        return tmfileconflictividadCollection;
    }

    public void setTmfileconflictividadCollection(Collection<Tmfileconflictividad> tmfileconflictividadCollection) {
        this.tmfileconflictividadCollection = tmfileconflictividadCollection;
    }

    @XmlTransient
    public Collection<Intercomentario> getIntercomentarioCollection() {
        return intercomentarioCollection;
    }

    public void setIntercomentarioCollection(Collection<Intercomentario> intercomentarioCollection) {
        this.intercomentarioCollection = intercomentarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tmusuario)) {
            return false;
        }
        Tmusuario other = (Tmusuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celepsa.rrcc.eh.Tmusuario[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.be;

/**
 *
 * @author pmedina
 */
public class StakeholderBE {
     private String id;
    private String FechaRegistro;
    private String Nombre;
    private NivelInfluenciaBE NInfluencia;  
    private String Identidad;
    private String Fotografia;
    private String est;
    private ZonaBE Zona;
    private EstadoBE Estado;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the FechaRegistro
     */
    public String getFechaRegistro() {
        return FechaRegistro;
    }

    /**
     * @param FechaRegistro the FechaRegistro to set
     */
    public void setFechaRegistro(String FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Identidad
     */
    public String getIdentidad() {
        return Identidad;
    }

    /**
     * @param Identidad the Identidad to set
     */
    public void setIdentidad(String Identidad) {
        this.Identidad = Identidad;
    }

    /**
     * @return the Fotografia
     */
    public String getFotografia() {
        return Fotografia;
    }

    /**
     * @param Fotografia the Fotografia to set
     */
    public void setFotografia(String Fotografia) {
        this.Fotografia = Fotografia;
    }

    /**
     * @return the NInfluencia
     */
    public NivelInfluenciaBE getNInfluencia() {
        return NInfluencia;
    }

    /**
     * @param NInfluencia the NInfluencia to set
     */
    public void setNInfluencia(NivelInfluenciaBE NInfluencia) {
        this.NInfluencia = NInfluencia;
    }

    /**
     * @return the est
     */
    public String getEst() {
        return est;
    }

    /**
     * @param est the est to set
     */
    public void setEst(String est) {
        this.est = est;
    }

    /**
     * @return the Zona
     */
    public ZonaBE getZona() {
        return Zona;
    }

    /**
     * @param Zona the Zona to set
     */
    public void setZona(ZonaBE Zona) {
        this.Zona = Zona;
    }

    /**
     * @return the Estado
     */
    public EstadoBE getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(EstadoBE Estado) {
        this.Estado = Estado;
    }
    

}

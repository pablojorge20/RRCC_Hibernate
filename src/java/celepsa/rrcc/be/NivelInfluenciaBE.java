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
public class NivelInfluenciaBE {
    private String id;
    private String Descripcion;
    private String est;  

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
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
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
}

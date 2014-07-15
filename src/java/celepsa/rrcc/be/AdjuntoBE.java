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
public class AdjuntoBE {
    private String id;
    private DocumentoBE documento;
    private String Nombre; 
    private String eliminado; 
    private String scodigo;

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
     * @return the documento
     */
    public DocumentoBE getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(DocumentoBE documento) {
        this.documento = documento;
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
     * @return the eliminado
     */
    public String getEliminado() {
        return eliminado;
    }

    /**
     * @param eliminado the eliminado to set
     */
    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * @return the scodigo
     */
    public String getScodigo() {
        return scodigo;
    }

    /**
     * @param scodigo the scodigo to set
     */
    public void setScodigo(String scodigo) {
        this.scodigo = scodigo;
    }
    
}

package celepsa.rrcc.eh;
// Generated 17/07/2014 10:17:45 PM by Hibernate Tools 3.6.0



/**
 * TmTipoDocumento generated by hbm2java
 */
public class TmTipoDocumento  implements java.io.Serializable {


     private int id;
     private String descripcion;
     private int criticidadId;

    public TmTipoDocumento() {
    }

	
    public TmTipoDocumento(int id, int criticidadId) {
        this.id = id;
        this.criticidadId = criticidadId;
    }
    public TmTipoDocumento(int id, String descripcion, int criticidadId) {
       this.id = id;
       this.descripcion = descripcion;
       this.criticidadId = criticidadId;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getCriticidadId() {
        return this.criticidadId;
    }
    
    public void setCriticidadId(int criticidadId) {
        this.criticidadId = criticidadId;
    }




}



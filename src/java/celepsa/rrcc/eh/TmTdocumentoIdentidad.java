package celepsa.rrcc.eh;
// Generated 15-jul-2014 15:31:34 by Hibernate Tools 3.6.0



/**
 * TmTdocumentoIdentidad generated by hbm2java
 */
public class TmTdocumentoIdentidad  implements java.io.Serializable {


     private int id;
     private String descripcion;
     private Integer est;

    public TmTdocumentoIdentidad() {
    }

	
    public TmTdocumentoIdentidad(int id) {
        this.id = id;
    }
    public TmTdocumentoIdentidad(int id, String descripcion, Integer est) {
       this.id = id;
       this.descripcion = descripcion;
       this.est = est;
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
    public Integer getEst() {
        return this.est;
    }
    
    public void setEst(Integer est) {
        this.est = est;
    }




}



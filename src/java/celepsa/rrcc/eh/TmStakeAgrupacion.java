package celepsa.rrcc.eh;
// Generated 17/07/2014 10:17:45 PM by Hibernate Tools 3.6.0



/**
 * TmStakeAgrupacion generated by hbm2java
 */
public class TmStakeAgrupacion  implements java.io.Serializable {


     private int id;
     private String fechaRegistro;
     private String nombre;
     private String identidad;
     private String ubicacion;
     private String fotografia;
     private int tmNivelInfluenciaId;
     private Integer est;
     private int tmZonaId;
     private int tmEstadoId;

    public TmStakeAgrupacion() {
    }

	
    public TmStakeAgrupacion(int id, int tmNivelInfluenciaId, int tmZonaId, int tmEstadoId) {
        this.id = id;
        this.tmNivelInfluenciaId = tmNivelInfluenciaId;
        this.tmZonaId = tmZonaId;
        this.tmEstadoId = tmEstadoId;
    }
    public TmStakeAgrupacion(int id, String fechaRegistro, String nombre, String identidad, String ubicacion, String fotografia, int tmNivelInfluenciaId, Integer est, int tmZonaId, int tmEstadoId) {
       this.id = id;
       this.fechaRegistro = fechaRegistro;
       this.nombre = nombre;
       this.identidad = identidad;
       this.ubicacion = ubicacion;
       this.fotografia = fotografia;
       this.tmNivelInfluenciaId = tmNivelInfluenciaId;
       this.est = est;
       this.tmZonaId = tmZonaId;
       this.tmEstadoId = tmEstadoId;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdentidad() {
        return this.identidad;
    }
    
    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }
    public String getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getFotografia() {
        return this.fotografia;
    }
    
    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }
    public int getTmNivelInfluenciaId() {
        return this.tmNivelInfluenciaId;
    }
    
    public void setTmNivelInfluenciaId(int tmNivelInfluenciaId) {
        this.tmNivelInfluenciaId = tmNivelInfluenciaId;
    }
    public Integer getEst() {
        return this.est;
    }
    
    public void setEst(Integer est) {
        this.est = est;
    }
    public int getTmZonaId() {
        return this.tmZonaId;
    }
    
    public void setTmZonaId(int tmZonaId) {
        this.tmZonaId = tmZonaId;
    }
    public int getTmEstadoId() {
        return this.tmEstadoId;
    }
    
    public void setTmEstadoId(int tmEstadoId) {
        this.tmEstadoId = tmEstadoId;
    }




}



package celepsa.rrcc.eh;
// Generated 15-jul-2014 15:31:34 by Hibernate Tools 3.6.0



/**
 * TmClima generated by hbm2java
 */
public class TmClima  implements java.io.Serializable {


     private TmClimaId id;
     private String clima;

    public TmClima() {
    }

	
    public TmClima(TmClimaId id) {
        this.id = id;
    }
    public TmClima(TmClimaId id, String clima) {
       this.id = id;
       this.clima = clima;
    }
   
    public TmClimaId getId() {
        return this.id;
    }
    
    public void setId(TmClimaId id) {
        this.id = id;
    }
    public String getClima() {
        return this.clima;
    }
    
    public void setClima(String clima) {
        this.clima = clima;
    }




}



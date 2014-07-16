/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;



import celepsa.rrcc.be.ClimaBE;
import celepsa.rrcc.be.ZonaBE;
import celepsa.rrcc.da.ClimaDA;
import celepsa.rrcc.eh.TmClima;
import celepsa.rrcc.eh.TmClimaId;
import celepsa.rrcc.eh.TmZona;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import java.util.List;

/**
 *
 * @author pmedina
 */
public class ClimaBL {
    private List<TmClima> LCLima;
    private Integer SumCri;
    private Integer SumInf;
    private Integer SumInfxDoc;
    private Integer IDZona;
    public List<TmClima> GenerarClima(List<TmZona> LZona)  throws Exception
    {
        
         ClimaDA objClimaDA = new ClimaDA();
         ClimaDA objClimaDA1 = new ClimaDA();
         ClimaDA objClimaDA2 = new ClimaDA();
         setLCLima(new ArrayList<TmClima>());
        
            for(TmZona objZona : LZona)
            {
                 TmClima Clima= new TmClima();
                 TmClimaId id_zona = new TmClimaId();
                 TmClimaId fechaGeneracion = new TmClimaId();
           id_zona.setTmZonaId(objZona.getId());
        Clima.setId(id_zona);
      
      Date date = new Date();
      DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
      fechaGeneracion.setFechaGeneracion(fecha.format(date));
      //Clima. (fecha.format(date));
            setSumCri((Integer) objClimaDA.CriticidadZona(objZona));
            setSumInf((Integer) objClimaDA1.InfluenciaPersonas(objZona));
            setSumInfxDoc((Integer) objClimaDA2.InfluenciaPersonasDocumento(objZona));
      //Clima.setClima(objClimaDA.CriticidadZona(objZona));
    //  Clima.setClima(objClimaDA1.InfluenciaPersonas(objZona));
      
      
       Clima.setClima(Integer.toString(getSumCri()+getSumInf()+getSumInfxDoc()));
       
           
       if ( id_zona.getTmZonaId()>0)
       {
       getLCLima().add(Clima);
       }
      
      
    
            }
        return getLCLima();
        
        
          
    }  


    /**
     * @return the SumCri
     */
    public Integer getSumCri() {
        return SumCri;
    }

    /**
     * @param SumCri the SumCri to set
     */
    public void setSumCri(Integer SumCri) {
        this.SumCri = SumCri;
    }

    /**
     * @return the SumInf
     */
    public Integer getSumInf() {
        return SumInf;
    }

    /**
     * @param SumInf the SumInf to set
     */
    public void setSumInf(Integer SumInf) {
        this.SumInf = SumInf;
    }

    /**
     * @return the SumInfxDoc
     */
    public Integer getSumInfxDoc() {
        return SumInfxDoc;
    }

    /**
     * @param SumInfxDoc the SumInfxDoc to set
     */
    public void setSumInfxDoc(Integer SumInfxDoc) {
        this.SumInfxDoc = SumInfxDoc;
    }

    /**
     * @return the IDZona
     */
    public Integer getIDZona() {
        return IDZona;
    }

    /**
     * @param IDZona the IDZona to set
     */
    public void setIDZona(Integer IDZona) {
        this.IDZona = IDZona;
    }

    /**
     * @return the LCLima
     */
    public List<TmClima> getLCLima() {
        return LCLima;
    }

    /**
     * @param LCLima the LCLima to set
     */
    public void setLCLima(List<TmClima> LCLima) {
        this.LCLima = LCLima;
    }

   
}

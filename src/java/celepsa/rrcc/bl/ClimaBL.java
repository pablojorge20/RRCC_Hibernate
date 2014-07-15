/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;



import celepsa.rrcc.be.ClimaBE;
import celepsa.rrcc.be.ZonaBE;
import celepsa.rrcc.da.ClimaDA;
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
    private List<ClimaBE> LCLima;
    private Integer SumCri;
    private Integer SumInf;
    private Integer SumInfxDoc;
    private Integer IDZona;
    public List<ClimaBE> GenerarClima(List<ZonaBE> LZona)  throws Exception
    {
        
         ClimaDA objClimaDA = new ClimaDA();
         ClimaDA objClimaDA1 = new ClimaDA();
         ClimaDA objClimaDA2 = new ClimaDA();
         setLCLima(new ArrayList<ClimaBE>());
        
            for(ZonaBE objZona : LZona)
            {
                 ClimaBE Clima= new ClimaBE();
      Clima.setZona_id(objZona);
      Date date = new Date();
      DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
      Clima.setFechaGeneracion(fecha.format(date));
            setSumCri((Integer) objClimaDA.CriticidadZona(objZona));
            setSumInf((Integer) objClimaDA1.InfluenciaPersonas(objZona));
            setSumInfxDoc((Integer) objClimaDA2.InfluenciaPersonasDocumento(objZona));
      //Clima.setClima(objClimaDA.CriticidadZona(objZona));
    //  Clima.setClima(objClimaDA1.InfluenciaPersonas(objZona));
      if (  getSumCri()+getSumInf()+getSumInfxDoc()>20)
        {
         Clima.setColor("#FE2E2E");
         Clima.setCFont("#FFFFFF");
        }
      else
        {
         if (  getSumCri()+getSumInf()+getSumInfxDoc()>10)
        {
             Clima.setColor("#FE9A2E");
            Clima.setCFont("#FFFFFF");
        } 
         else
         {
           Clima.setColor("70FFB3");
            Clima.setCFont("001C81");  
         }
        }
      
       Clima.setClima(getSumCri()+getSumInf()+getSumInfxDoc());
       IDZona=Integer.parseInt(objZona.getId());
       if (IDZona>0)
       {
       getLCLima().add(Clima);
       }
      
      
    
            }
        return getLCLima();
        
        
          
    }  

    /**
     * @return the LCLima
     */
    public List<ClimaBE> getLCLima() {
        return LCLima;
    }

    /**
     * @param LCLima the LCLima to set
     */
    public void setLCLima(List<ClimaBE> LCLima) {
        this.LCLima = LCLima;
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
}

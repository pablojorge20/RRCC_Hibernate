/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;



import celepsa.rrcc.da.ClimaDA;
import celepsa.rrcc.eh.Tmclima;
import celepsa.rrcc.eh.TmclimaPK;
import celepsa.rrcc.eh.Tmzona;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pmedina
 */
public class ClimaBL {
  private List<Tmclima> LCLima;
    
  
    public List<Tmclima> GenerarClima(List<Tmzona> LZona) 
    {
         
         setLCLima(new ArrayList<Tmclima>());
         Integer SumCri;
         Integer SumInf;
         Integer SumInfxDoc;
         ClimaDA objClimaDA = new ClimaDA();
         ClimaDA objClimaDA1 = new ClimaDA();
         ClimaDA objClimaDA2 = new ClimaDA();
         
        
            for(Tmzona objZona : LZona)
            {
             try {
                 Tmclima Clima= new Tmclima();
               //  TmclimaPK id_zona = new TmclimaPK();
                 Clima.setTmzona(objZona);
                 
               //  id_zona.setTmZonaid(objZona.getId());
                 //Clima.setTmclimaPK(id_zona);
                 
                 Date date = new Date();
                 DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
              //   id_zona.setFechaGeneracion(fecha.format(date));
              
                 
                 SumCri =((Integer) objClimaDA.CriticidadZona( objZona));
                 SumInf= ((Integer) objClimaDA1.InfluenciaPersonas(objZona));
                 SumInfxDoc=((Integer) objClimaDA2.InfluenciaPersonasDocumento(objZona));
              
                 
                 Clima.setClima(Integer.toString(SumCri + SumInf + SumInfxDoc));
             //    Clima.setTmclimaPK(id_zona);
                 
                 if (objZona.getId()>0)
                 {
                     LCLima.add(Clima);
                     
                 }     } catch (Exception ex) {
                 Logger.getLogger(ClimaBL.class.getName()).log(Level.SEVERE, null, ex);
             }
      
      
    
            }
        return LCLima;
        
        
          
    }  

    private void LCLima(ArrayList<Tmclima> arrayList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the LCLima
     */
    public List<Tmclima> getLCLima() {
        return LCLima;
    }

    /**
     * @param LCLima the LCLima to set
     */
    public void setLCLima(List<Tmclima> LCLima) {
        this.LCLima = LCLima;
    }



}

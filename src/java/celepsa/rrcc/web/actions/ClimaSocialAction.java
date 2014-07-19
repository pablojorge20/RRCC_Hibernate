/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.web.actions;


import celepsa.rrcc.bl.ClimaBL;
import celepsa.rrcc.bl.ZonaBL;
import celepsa.rrcc.eh.Tmclima;
import celepsa.rrcc.eh.Tmzona;
import com.opensymphony.xwork2.Preparable;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author pmedina
 */
public class ClimaSocialAction extends BaseAction implements Preparable{
    
    private List<Tmzona> LZona;
    private Tmclima Clima;
    private List<Tmclima> LClima;
    
 @Override
    public void prepare() throws Exception {
        super.prepare();
          ZonaBL objZonaBL = new ZonaBL();
        setLZona(objZonaBL.ListarZona());
    }
   
    @SkipValidation
  
    private void obtenerDetalleParametros() throws Exception{
  
        
    }
  public String GenerarClima(){         
     try 
        {
                ClimaBL objClimaBL = new ClimaBL(); 
                setLClima( objClimaBL.GenerarClima( getLZona() ));
            return INPUT;
        }
        catch(Exception e)
        {
            addActionError(e.getMessage());
            return INPUT;
        }
    }
    
  
    public String cancelar()
    {
        return CANCEL;
    }

    /**
     * @return the LZona
     */
    public List<Tmzona> getLZona() {
        return LZona;
    }

    /**
     * @param LZona the LZona to set
     */
    public void setLZona(List<Tmzona> LZona) {
        this.LZona = LZona;
    }

    /**
     * @return the Clima
     */
    public Tmclima getClima() {
        return Clima;
    }

    /**
     * @param Clima the Clima to set
     */
    public void setClima(Tmclima Clima) {
        this.Clima = Clima;
    }

    /**
     * @return the LClima
     */
    public List<Tmclima> getLClima() {
        return LClima;
    }

    /**
     * @param LClima the LClima to set
     */
    public void setLClima(List<Tmclima> LClima) {
        this.LClima = LClima;
    }

  
   
}

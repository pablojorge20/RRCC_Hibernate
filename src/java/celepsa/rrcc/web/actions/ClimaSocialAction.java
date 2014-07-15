/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.web.actions;


import celepsa.rrcc.be.ClimaBE;
import celepsa.rrcc.be.ZonaBE;
import celepsa.rrcc.bl.ClimaBL;
import celepsa.rrcc.bl.ZonaBL;
import com.opensymphony.xwork2.Preparable;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author pmedina
 */
public class ClimaSocialAction extends BaseAction implements Preparable{
    
    private List<ZonaBE> LZona;
    private ClimaBE Clima;
    private List<ClimaBE> LClima;
    
 @Override
    public void prepare() throws Exception {
        super.prepare();
        
 
          ZonaBL objZonaBL = new ZonaBL();
        setLZona(objZonaBL.ListarZona());
        
    }
   
    @SkipValidation
  
    private void obtenerDetalleParametros() throws Exception
    {
  
        
    }
  public String GenerarClima()
    {         
     try 
        {
                ClimaBL objClimaBL = new ClimaBL(); 
                setLClima(objClimaBL.GenerarClima(LZona));
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
    public List<ZonaBE> getLZona() {
        return LZona;
    }

    /**
     * @param LZona the LZona to set
     */
    public void setLZona(List<ZonaBE> LZona) {
        this.LZona = LZona;
    }

    /**
     * @return the Clima
     */
    public ClimaBE getClima() {
        return Clima;
    }

    /**
     * @param Clima the Clima to set
     */
    public void setClima(ClimaBE Clima) {
        this.Clima = Clima;
    }

    /**
     * @return the LClima
     */
    public List<ClimaBE> getLClima() {
        return LClima;
    }

    /**
     * @param LClima the LClima to set
     */
    public void setLClima(List<ClimaBE> LClima) {
        this.LClima = LClima;
    }

}

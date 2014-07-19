/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.web.actions;

import celepsa.rrcc.be.AgrupacionBE;
import celepsa.rrcc.bl.NivelInfluenciaBL;
import celepsa.rrcc.bl.AgrupacionBL;
import celepsa.rrcc.bl.EstadoBL;
import celepsa.rrcc.bl.ZonaBL;
import celepsa.rrcc.eh.Tmestado;
import celepsa.rrcc.eh.Tmnivelinfluencia;
import celepsa.rrcc.eh.Tmzona;
import com.opensymphony.xwork2.Preparable;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author pmedina
 */
public class StakeAgrupacionAction extends BaseAction implements Preparable{
    private AgrupacionBE Agrupacion;
  
    private List<Tmnivelinfluencia> LNinfluencia;
       private List<Tmzona> LZona;
    private List<Tmestado> LEstado;
 @Override
    public void prepare() throws Exception {
        super.prepare();
     
    
          NivelInfluenciaBL objNivelInfluenciaBL = new NivelInfluenciaBL();
          setLNinfluencia(objNivelInfluenciaBL.ListarNivelInfluencia());
       
                ZonaBL objZonaBL = new ZonaBL();
        setLZona(objZonaBL.ListarZona());
        
          EstadoBL objEstadoBL = new EstadoBL();
        setLEstado(objEstadoBL.ListarEstado());
        
    }
   
    @SkipValidation
    public String obtenerStakeAgrupacion() {
       
                  try 
        {
            if (getAgrupacion() == null || getAgrupacion().getId().isEmpty() )
            {
                setAgrupacion(new AgrupacionBE());
            }
            else
            {
                AgrupacionBL objAgrupacionBL = new AgrupacionBL(); 
                setAgrupacion(objAgrupacionBL.obtenerAgrupacion(getAgrupacion()));
                
            }
            return INPUT;
        }
        catch(Exception e)
        {
            addActionError(e.getMessage());
            return INPUT;
        }
   
    }
    
    private void obtenerDetalleParametros() throws Exception
    {
  
        
    }
  public String grabar()
    {         
        try
        {
            AgrupacionBL objSistemaBL = new AgrupacionBL();
           // Documento = objSistemaBL.obtenerDocumento(Documento);
            if (getAgrupacion().getId() != null &&
                !Agrupacion.getId().isEmpty())
            {
                objSistemaBL.actualizarAgrupacion(getAgrupacion());
                addActionMessage("El Documento se actualizo correctamente");
            }
            else
            {
                objSistemaBL.registrarAgrupacion(getAgrupacion());
                addActionMessage("El Documento se grabo correctamente");
            }
        }
        catch(Exception e)        
        {
            procesarError(e);
        }
      
        
        return INPUT;
     
    }
    
  
    public String cancelar()
    {
        return CANCEL;
    }

    /**
     * @return the Agrupacion
     */
    public AgrupacionBE getAgrupacion() {
        return Agrupacion;
    }

    /**
     * @param Agrupacion the Agrupacion to set
     */
    public void setAgrupacion(AgrupacionBE Agrupacion) {
        this.Agrupacion = Agrupacion;
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
     * @return the LNinfluencia
     */
    public List<Tmnivelinfluencia> getLNinfluencia() {
        return LNinfluencia;
    }

    /**
     * @param LNinfluencia the LNinfluencia to set
     */
    public void setLNinfluencia(List<Tmnivelinfluencia> LNinfluencia) {
        this.LNinfluencia = LNinfluencia;
    }

    /**
     * @return the LEstado
     */
    public List<Tmestado> getLEstado() {
        return LEstado;
    }

    /**
     * @param LEstado the LEstado to set
     */
    public void setLEstado(List<Tmestado> LEstado) {
        this.LEstado = LEstado;
    }

   
}

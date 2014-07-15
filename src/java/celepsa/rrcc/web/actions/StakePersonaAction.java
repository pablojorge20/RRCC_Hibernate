/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.web.actions;

import celepsa.rrcc.be.EstadoBE;
import celepsa.rrcc.be.NivelInfluenciaBE;
import celepsa.rrcc.be.PersonaBE;
import celepsa.rrcc.be.TipoDocumentoIdentidadBE;
import celepsa.rrcc.be.ZonaBE;
import celepsa.rrcc.bl.EstadoBL;
import celepsa.rrcc.bl.NivelInfluenciaBL;
import celepsa.rrcc.bl.PersonaBL;
import celepsa.rrcc.bl.TipoDocumentoIdentidadBL;
import celepsa.rrcc.bl.ZonaBL;
import com.opensymphony.xwork2.Preparable;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author pmedina
 */
public class StakePersonaAction extends BaseAction implements Preparable{
    private PersonaBE Persona;
    private List<TipoDocumentoIdentidadBE> LTipo;
    private List<NivelInfluenciaBE> LNinfluencia;
    private List<ZonaBE> LZona;
    private List<EstadoBE> LEstado;
    
 @Override
    public void prepare() throws Exception {
        super.prepare();
        
        TipoDocumentoIdentidadBL objTipoDocumentoBL = new TipoDocumentoIdentidadBL();
        setLTipo(objTipoDocumentoBL.ListarTipoDocumento());
        
    
          NivelInfluenciaBL objNivelInfluenciaBL = new NivelInfluenciaBL();
        setLNinfluencia(objNivelInfluenciaBL.ListarNivelInfluencia());
        
          ZonaBL objZonaBL = new ZonaBL();
        setLZona(objZonaBL.ListarZona());
        
          EstadoBL objEstadoBL = new EstadoBL();
        setLEstado(objEstadoBL.ListarEstado());
        
    }
   
    @SkipValidation
    public String obtenerStakePersona() {
       
                  try 
        {
            if (getPersona() == null || getPersona().getId().isEmpty() )
            {
                setPersona(new PersonaBE());
            }
            else
            {
                PersonaBL objPersonaBL = new PersonaBL(); 
                setPersona(objPersonaBL.obtenerPersona(getPersona()));
                
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
            PersonaBL objSistemaBL = new PersonaBL();
           // Documento = objSistemaBL.obtenerDocumento(Documento);
            if (getPersona().getId() != null &&
                !Persona.getId().isEmpty())
            {
                objSistemaBL.actualizarPersona(getPersona());
                addActionMessage("El Documento se actualizo correctamente");
            }
            else
            {
                objSistemaBL.registrarPersona(getPersona());
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
     * @return the Persona
     */
    public PersonaBE getPersona() {
        return Persona;
    }

    /**
     * @param Persona the Persona to set
     */
    public void setPersona(PersonaBE Persona) {
        this.Persona = Persona;
    }

    /**
     * @return the LTipo
     */
    public List<TipoDocumentoIdentidadBE> getLTipo() {
        return LTipo;
    }

    /**
     * @param LTipo the LTipo to set
     */
    public void setLTipo(List<TipoDocumentoIdentidadBE> LTipo) {
        this.LTipo = LTipo;
    }

    /**
     * @return the LNinfluencia
     */
    public List<NivelInfluenciaBE> getLNinfluencia() {
        return LNinfluencia;
    }

    /**
     * @param LNinfluencia the LNinfluencia to set
     */
    public void setLNinfluencia(List<NivelInfluenciaBE> LNinfluencia) {
        this.LNinfluencia = LNinfluencia;
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
     * @return the LEstado
     */
    public List<EstadoBE> getLEstado() {
        return LEstado;
    }

    /**
     * @param LEstado the LEstado to set
     */
    public void setLEstado(List<EstadoBE> LEstado) {
        this.LEstado = LEstado;
    }

   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.web.actions;

import celepsa.rrcc.be.PersonaBE;
import celepsa.rrcc.bl.EstadoBL;
import celepsa.rrcc.bl.NivelInfluenciaBL;
import celepsa.rrcc.bl.PersonaBL;
import celepsa.rrcc.bl.TipoDocumentoIdentidadBL;
import celepsa.rrcc.bl.ZonaBL;
import celepsa.rrcc.eh.Tmestado;
import celepsa.rrcc.eh.Tmnivelinfluencia;
import celepsa.rrcc.eh.Tmstakepersona;
import celepsa.rrcc.eh.Tmtdocumentoidentidad;
import celepsa.rrcc.eh.Tmzona;
import com.opensymphony.xwork2.Preparable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author pmedina
 */
public class StakePersonaAction extends BaseAction implements Preparable{
    private Tmstakepersona Persona;
    private List<Tmtdocumentoidentidad> LTipo;
    private List<Tmnivelinfluencia> LNinfluencia;
    private List<Tmzona> LZona;
    private List<Tmestado> LEstado;
    
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
        
            //pmedina-agrgado
       Date date = new Date();
       DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
       Tmstakepersona FRegPersona= new Tmstakepersona();
       FRegPersona.setFechaRegistro(fecha.format(date));
       setPersona(FRegPersona);
       //pmedina-agrgado
        
    }
   
    @SkipValidation
    public String obtenerStakePersona() {
       
                  try 
        {
            if (getPersona() == null || getPersona().getId() == null )
            {
                setPersona(new Tmstakepersona());
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
                Persona.getId() != null)
            {
                objSistemaBL.actualizarPersona(getPersona());
                addActionMessage("El Documento se actualizo correctamente");
            }
            else
            {
               boolean a =objSistemaBL.registrarPersona(getPersona());
               if (a==false ){
                    addActionMessage("El Numero de DNI ya se ha registrado");
               }
               else{
                    addActionMessage("El Documento se grabo correctamente");
               }
                   
               
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
    public Tmstakepersona getPersona() {
        return Persona;
    }

    /**
     * @param Persona the Persona to set
     */
    public void setPersona(Tmstakepersona Persona) {
        this.Persona = Persona;
    }

    /**
     * @return the LTipo
     */
    public List<Tmtdocumentoidentidad> getLTipo() {
        return LTipo;
    }

    /**
     * @param LTipo the LTipo to set
     */
    public void setLTipo(List<Tmtdocumentoidentidad> LTipo) {
        this.LTipo = LTipo;
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

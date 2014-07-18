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
import celepsa.rrcc.eh.TmEstado;
import celepsa.rrcc.eh.TmNivelInfluencia;
import celepsa.rrcc.eh.TmTdocumentoIdentidad;
import celepsa.rrcc.eh.TmZona;
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
    private PersonaBE Persona;
    private List<TmTdocumentoIdentidad> LTipo;
    private List<TmNivelInfluencia> LNinfluencia;
    private List<TmZona> LZona;
    private List<TmEstado> LEstado;
    
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
       PersonaBE FRegPersona= new PersonaBE();
       FRegPersona.setFechaRegistro(fecha.format(date));
       setPersona(FRegPersona);
       //pmedina-agrgado
        
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
               boolean a =objSistemaBL.registrarPersona(getPersona());
               if (a=false ){
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
    public List<TmTdocumentoIdentidad> getLTipo() {
        return LTipo;
    }

    /**
     * @param LTipo the LTipo to set
     */
    public void setLTipo(List<TmTdocumentoIdentidad> LTipo) {
        this.LTipo = LTipo;
    }



    /**
     * @return the LZona
     */
    public List<TmZona> getLZona() {
        return LZona;
    }

    /**
     * @param LZona the LZona to set
     */
    public void setLZona(List<TmZona> LZona) {
        this.LZona = LZona;
    }


    /**
     * @return the LNinfluencia
     */
    public List<TmNivelInfluencia> getLNinfluencia() {
        return LNinfluencia;
    }

    /**
     * @param LNinfluencia the LNinfluencia to set
     */
    public void setLNinfluencia(List<TmNivelInfluencia> LNinfluencia) {
        this.LNinfluencia = LNinfluencia;
    }

    /**
     * @return the LEstado
     */
    public List<TmEstado> getLEstado() {
        return LEstado;
    }

    /**
     * @param LEstado the LEstado to set
     */
    public void setLEstado(List<TmEstado> LEstado) {
        this.LEstado = LEstado;
    }


}

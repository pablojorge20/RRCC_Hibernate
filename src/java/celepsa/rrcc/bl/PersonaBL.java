/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.bl;

import celepsa.rrcc.eh.Tmstakepersona;
import celepsa.rrcc.da.PersonaDA;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class PersonaBL {

    public List<Tmstakepersona> listarPersona(Integer pAg) throws Exception {

        PersonaDA objSistemaDA = new PersonaDA();
        return objSistemaDA.listarPersona(pAg);
    }

    public Tmstakepersona obtenerPersona(Tmstakepersona objPersona) throws Exception {
        PersonaDA objPersonaDA = new PersonaDA();
        return objPersonaDA.obtenerPersona(objPersona);
    }

      public boolean obtenerPersonaNroDocumento(Tmstakepersona objPersona) throws Exception {
        PersonaDA objPersonaDA = new PersonaDA();
        return objPersonaDA.obtenerPersonaNDOC(objPersona);
    }    
    
    public boolean registrarPersona(Tmstakepersona objSistema) throws Exception {
        if(this.obtenerPersonaNroDocumento(objSistema) == false){
            return false;  
            }
        else{
            PersonaDA objSistemaDA = new PersonaDA();
        objSistemaDA.registrarPersona(objSistema);
            return true;
            }
    
        

    }

    public void actualizarPersona(Tmstakepersona objSistema) throws Exception {
        PersonaDA objSistemaDA = new PersonaDA();
        objSistemaDA.ActualizarPersona(objSistema);
    }

    public void eliminarPersona(Tmstakepersona objPersona) throws Exception {
        PersonaDA objSistemaDA = new PersonaDA();

        objPersona.setEst(1);
        //elimimado =1
        objSistemaDA.eliminarPersona(objPersona);

    }

    public List<Tmstakepersona> buscarPersonas(String AsuntoBuscado) throws Exception {
        PersonaDA objSistemaDA = new PersonaDA();
        return objSistemaDA.buscarPersonasVarios(AsuntoBuscado);

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;

import celepsa.rrcc.be.PersonaBE;
import celepsa.rrcc.da.PersonaDA;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class PersonaBL {
 public List<PersonaBE> listarPersona(Integer pAg) throws Exception 
    {
           
        PersonaDA objSistemaDA = new PersonaDA();
        return objSistemaDA.listarPersona(pAg);
    }    
     public PersonaBE obtenerPersona(PersonaBE objPersona) throws Exception
    {
        PersonaDA objPersonaDA = new PersonaDA();
        return objPersonaDA.obtenerPersona(objPersona);
    }  
     
      public boolean registrarPersona(PersonaBE objSistema) throws Exception 
    {
        PersonaBE PerRegistrada = new PersonaBE();
        
        //PerRegistrada(this.obtenerPersona(objSistema).getNroDocumento());
        
        //if (!PerRegistrada.equals(objSistema)){
            PersonaDA objSistemaDA = new PersonaDA();
            objSistemaDA.registrarPersona(objSistema);
        //}
       // else{
         //     return false;
        //}
     
        return true;
        
        
    }  
      
      public void actualizarPersona (PersonaBE objSistema) throws Exception 
    {
     PersonaDA objSistemaDA = new PersonaDA();
        objSistemaDA.ActualizarPersona(objSistema);
    }
       public void eliminarPersona(PersonaBE objPersona) throws Exception
    {
        PersonaDA objSistemaDA = new PersonaDA();
        
        objPersona.setEst("1");
        //elimimado =1
            objSistemaDA.eliminarPersona(objPersona) ;
        
    }
       public List<PersonaBE> buscarPersonas(String AsuntoBuscado) throws Exception
    {
        PersonaDA objSistemaDA = new PersonaDA();
        return objSistemaDA.buscarPersonasVarios(AsuntoBuscado);
     
    }
}

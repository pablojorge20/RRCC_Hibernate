/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;

import celepsa.rrcc.be.AgrupacionBE;
import celepsa.rrcc.da.AgrupacionDA;
import celepsa.rrcc.eh.Tmstakeagrupacion;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class AgrupacionBL {
public List<AgrupacionBE> listarAgrupacion(Integer pAg) throws Exception {
           
        AgrupacionDA objSistemaDA = new AgrupacionDA();
        return objSistemaDA.listarAgrupacion(pAg);
    }    
public Tmstakeagrupacion obtenerAgrupacion(Tmstakeagrupacion objAgrupacion) throws Exception{
        AgrupacionDA objAgrupacionDA = new AgrupacionDA();
        return objAgrupacionDA.obtenerAgrupacion(objAgrupacion);
    }  
     
      public void registrarAgrupacion(Tmstakeagrupacion objSistema) throws Exception 
    {
        AgrupacionDA objSistemaDA = new AgrupacionDA();
        objSistemaDA.registrarAgrupacion(objSistema);
    }  
      
      public void actualizarAgrupacion (Tmstakeagrupacion objSistema) throws Exception 
    {
     AgrupacionDA objSistemaDA = new AgrupacionDA();
        objSistemaDA.ActualizarAgrupacion(objSistema);
    }
       public void eliminarAgrupacion(AgrupacionBE objAgrupacion) throws Exception
    {
        AgrupacionDA objSistemaDA = new AgrupacionDA();
        
        objAgrupacion.setEst("1");
        //elimimado =1
            objSistemaDA.eliminarAgrupacion(objAgrupacion) ;
        
    }  
  public List<AgrupacionBE> buscarAgrupacion(String AsuntoBuscado) throws Exception
    {
        AgrupacionDA objSistemaDA = new AgrupacionDA();
        return objSistemaDA.buscarAgrupacionVarios(AsuntoBuscado);
     
    }
}

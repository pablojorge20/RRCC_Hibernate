/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;



import celepsa.rrcc.be.ZonaBE;
import celepsa.rrcc.da.ZonaDA;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class ZonaBL {
    public List<ZonaBE> ListarZona()  throws Exception
    {
        ZonaDA objSistemaDA = new ZonaDA();
        return objSistemaDA.listarZona();
    }  
}

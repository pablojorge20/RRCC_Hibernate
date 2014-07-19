/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;


import celepsa.rrcc.da.EstadoDA;
import celepsa.rrcc.eh.Tmestado;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class EstadoBL {
    public List<Tmestado> ListarEstado()  throws Exception
    {
        EstadoDA objSistemaDA = new EstadoDA();
        return objSistemaDA.listarEstado();
    }  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;



import celepsa.rrcc.be.EstadoBE;
import celepsa.rrcc.da.EstadoDA;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class EstadoBL {
    public List<EstadoBE> ListarEstado()  throws Exception
    {
        EstadoDA objSistemaDA = new EstadoDA();
        return objSistemaDA.listarEstado();
    }  
}

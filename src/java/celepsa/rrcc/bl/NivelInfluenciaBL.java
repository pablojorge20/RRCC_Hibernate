/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;

import celepsa.rrcc.be.NivelInfluenciaBE;
import celepsa.rrcc.da.NivelInfluenciaDA;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class NivelInfluenciaBL {
    public List<NivelInfluenciaBE> ListarNivelInfluencia()  throws Exception
    {
        NivelInfluenciaDA objSistemaDA = new NivelInfluenciaDA();
        return objSistemaDA.listarNivelInfluencia();
    }  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;


import celepsa.rrcc.da.TipoDocumentoIdentidadDA;

import celepsa.rrcc.eh.Tmtdocumentoidentidad;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class TipoDocumentoIdentidadBL {
    public List<Tmtdocumentoidentidad> ListarTipoDocumento()  throws Exception{
        TipoDocumentoIdentidadDA objSistemaDA = new TipoDocumentoIdentidadDA();
        return objSistemaDA.ListarTipoDocumento();
    }  
}

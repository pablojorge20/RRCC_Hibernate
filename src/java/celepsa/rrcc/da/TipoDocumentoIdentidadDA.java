/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.bd.ConexionBD;
import celepsa.rrcc.be.TipoDocumentoIdentidadBE;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class TipoDocumentoIdentidadDA {
        public List<TipoDocumentoIdentidadBE> listarTipoDocumento() throws Exception  {
        ConexionBD objConexion = null;
        try 
        {
            objConexion = new ConexionBD();
            List<TipoDocumentoIdentidadBE> lstRetorno = new ArrayList<TipoDocumentoIdentidadBE>();
            String sQuery = " SELECT * FROM tmTDocumentoIdentidad " ;
            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) 
            {
                while (objResult.next()) 
                {
                    lstRetorno.add(populateTipoDocumento(objResult));
                }
            } 
            return lstRetorno;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            throw e;
        } 
        finally 
        {
            objConexion.close();
        }
    }

    private TipoDocumentoIdentidadBE populateTipoDocumento(ResultSet resultado) throws SQLException {
        TipoDocumentoIdentidadBE objTipoDocumentoBE = new TipoDocumentoIdentidadBE();
        objTipoDocumentoBE.setId(resultado.getString("id"));
        objTipoDocumentoBE.setDescripcion(resultado.getString("Descripcion"));
        return objTipoDocumentoBE;
    }    
}

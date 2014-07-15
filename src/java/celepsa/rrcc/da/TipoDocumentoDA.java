/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.bd.ConexionBD;
import celepsa.rrcc.be.TipoDocumentoBE;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class TipoDocumentoDA {
        public List<TipoDocumentoBE> listarTipoDocumento() throws Exception  {
        ConexionBD objConexion = null;
        try 
        {
            objConexion = new ConexionBD();
            List<TipoDocumentoBE> lstRetorno = new ArrayList<TipoDocumentoBE>();
            String sQuery = " SELECT * FROM tmTipoDocumento " ;
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

    private TipoDocumentoBE populateTipoDocumento(ResultSet resultado) throws SQLException {
        TipoDocumentoBE objTipoDocumentoBE = new TipoDocumentoBE();
        objTipoDocumentoBE.setId(resultado.getString("id"));
        objTipoDocumentoBE.setDescripcion(resultado.getString("Descripcion"));
        return objTipoDocumentoBE;
    }
}
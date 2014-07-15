/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.bd.ConexionBD;
import celepsa.rrcc.be.ZonaBE;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class ZonaDA {
            public List<ZonaBE> listarZona() throws Exception  {
        ConexionBD objConexion = null;
        try 
        {
            objConexion = new ConexionBD();
            List<ZonaBE> lstRetorno = new ArrayList<ZonaBE>();
            String sQuery = " SELECT * FROM tmZona" ;
            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) 
            {
                while (objResult.next()) 
                {
                    lstRetorno.add(populateZona(objResult));
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

    private ZonaBE populateZona(ResultSet resultado) throws SQLException {
        ZonaBE objZonaBE = new ZonaBE();
        objZonaBE.setId(resultado.getString("id"));
        objZonaBE.setDescripcion(resultado.getString("Descripcion"));
        return objZonaBE;
    } 
}

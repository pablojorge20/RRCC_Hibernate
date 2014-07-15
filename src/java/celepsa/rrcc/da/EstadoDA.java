/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.bd.ConexionBD;
import celepsa.rrcc.be.EstadoBE;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class EstadoDA {
            public List<EstadoBE> listarEstado() throws Exception  {
        ConexionBD objConexion = null;
        try 
        {
            objConexion = new ConexionBD();
            List<EstadoBE> lstRetorno = new ArrayList<EstadoBE>();
            String sQuery = " SELECT * FROM tmEstado" ;
            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) 
            {
                while (objResult.next()) 
                {
                    lstRetorno.add(populateEstado(objResult));
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

    private EstadoBE populateEstado(ResultSet resultado) throws SQLException {
        EstadoBE objEstadoBE = new EstadoBE();
        objEstadoBE.setId(resultado.getString("id"));
        objEstadoBE.setDescripcion(resultado.getString("Descripcion"));
        return objEstadoBE;
    } 
}

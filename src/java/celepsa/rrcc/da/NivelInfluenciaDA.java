/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.bd.ConexionBD;
import celepsa.rrcc.be.NivelInfluenciaBE;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class NivelInfluenciaDA {
            public List<NivelInfluenciaBE> listarNivelInfluencia() throws Exception  {
        ConexionBD objConexion = null;
        try 
        {
            objConexion = new ConexionBD();
            List<NivelInfluenciaBE> lstRetorno = new ArrayList<NivelInfluenciaBE>();
            String sQuery = " SELECT * FROM tmNivelInfluencia" ;
            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) 
            {
                while (objResult.next()) 
                {
                    lstRetorno.add(populateNivelInfluencia(objResult));
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

    private NivelInfluenciaBE populateNivelInfluencia(ResultSet resultado) throws SQLException {
        NivelInfluenciaBE objNivelInfluenciaBE = new NivelInfluenciaBE();
        objNivelInfluenciaBE.setId(resultado.getString("id"));
        objNivelInfluenciaBE.setDescripcion(resultado.getString("Descripcion"));
        return objNivelInfluenciaBE;
    } 
}

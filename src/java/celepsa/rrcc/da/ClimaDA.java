/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.da;
import celepsa.rrcc.bd.ConexionBD;
import celepsa.rrcc.eh.Tmzona;
import java.sql.ResultSet;

/**
 *
 * @author pmedina
 */
public class ClimaDA {

    private Integer SumCri;
    private Integer SumInf;
    private Integer SumInfxDoc;
    private Integer SumPerDoc;

    public int CriticidadZona(Tmzona objSistema) throws Exception {

        ConexionBD objConexion = null;
        try {
            objConexion = new ConexionBD();

            String sQuery = " SELECT tmZona.id as zona_id, tmZona.Descripcion,"
                    + " SUm( tmTipoDocumento.Criticidad_id) as sumCri "
                    + "FROM tmDocumento, tmTipoDocumento, tmStakePersona, tmZona "
                    + "where "
                    + "tmDocumento.eliminado = 0 and tmDocumento.tmEstado_id = 1 and tmDocumento.tmTipoDocumento_id <>0 "
                    + "and tmDocumento.tmTipoDocumento_id = tmTipoDocumento.id "
                    + "and tmDocumento.tmStakePersona_id = tmStakePersona.id "
                    + "and tmStakePersona.tmZona_id =tmZona.id "
                    + "and tmZona.id='" + objSistema.getId() + "'";
            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) {
                while (objResult.next()) {

                    if (objResult.getString("sumCri") != null) {
                        setSumCri((Integer) Integer.parseInt(objResult.getString("sumCri")));
                    } else {
                        setSumCri((Integer) 0);
                    }
                }
            }
            return getSumCri();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion.close();
        }
    }

    public int InfluenciaPersonas(Tmzona objSistema) throws Exception {

        ConexionBD objConexion = null;
        try {
            objConexion = new ConexionBD();
            String sQuery = "select tmStakePersona.tmZona_id, SUM(tmStakePersona.tmNivelInfluencia_id) as SumNin "
                    + "from tmStakePersona,tmNivelInfluencia "
                    + "where tmStakePersona.tmZona_id='" + objSistema.getId() + "' and "
                    + "tmStakePersona.tmNivelInfluencia_id=tmNivelInfluencia.id ";

            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) {
                while (objResult.next()) {

                    if (objResult.getString("SumNin") != null) {
                        setSumInf((Integer) Integer.parseInt(objResult.getString("SumNin")));
                    } else {
                        setSumInf((Integer) 0);
                    }
                }
            }
            return getSumInf();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion.close();
        }
    }

    public int InfluenciaPersonasDocumento(Tmzona objSistema) throws Exception {

        ConexionBD objConexion = null;
        try {
            objConexion = new ConexionBD();
            String sQuery = "Select tmDocumento.id as DocID "
                    + "from tmDocumento, tmStakePersona "
                    + "where "
                    + "tmDocumento.tmStakePersona_id=tmStakePersona.id and "
                    + "tmStakePersona.tmZona_id='" + objSistema.getId() + "'";

            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            SumInfxDoc = 0;
            if (objResult != null) {
                while (objResult.next()) {

                    if (objResult.getString("DocID") != null) {
                        SumInfxDoc = SumInfxDoc + this.PersonasDocumento(objResult.getString("DocID"));

                    }

                }
            }
            return getSumInfxDoc();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion.close();
        }
    }

    public int PersonasDocumento(String IdDOC) throws Exception {

        ConexionBD objConexion = null;
        try {
            objConexion = new ConexionBD();
            String sQuery = "Select "
                    + " Sum(tmStakePersona.tmNivelInfluencia_id) as Ninf,  tmDocumento.id as nrodoc "
                    + "from PersonaDocumento, tmStakePersona, tmDocumento "
                    + "where "
                    + "PersonaDocumento.tmStakePersona_id=tmStakePersona.id and "
                    + "PersonaDocumento.tmDocumento_id=tmDocumento.id and "
                    + "PersonaDocumento.tmDocumento_id='" + IdDOC + "'";

            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            setSumPerDoc((Integer) 0);
            if (objResult != null) {
                while (objResult.next()) {

                    if (objResult.getString("Ninf") != null) {
                        SumPerDoc = SumPerDoc + ((Integer) Integer.parseInt(objResult.getString("Ninf")));
                    }

                }
            }
            return getSumPerDoc();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion.close();
        }
    }

    /**
     * @return the SumCri
     */
    public Integer getSumCri() {
        return SumCri;
    }

    /**
     * @param SumCri the SumCri to set
     */
    public void setSumCri(Integer SumCri) {
        this.SumCri = SumCri;
    }

    /**
     * @return the SumInf
     */
    public Integer getSumInf() {
        return SumInf;
    }

    /**
     * @param SumInf the SumInf to set
     */
    public void setSumInf(Integer SumInf) {
        this.SumInf = SumInf;
    }

    /**
     * @return the SumInfxDoc
     */
    public Integer getSumInfxDoc() {
        return SumInfxDoc;
    }

    /**
     * @param SumInfxDoc the SumInfxDoc to set
     */
    public void setSumInfxDoc(Integer SumInfxDoc) {
        this.SumInfxDoc = SumInfxDoc;
    }

    /**
     * @return the SumPerDoc
     */
    public Integer getSumPerDoc() {
        return SumPerDoc;
    }

    /**
     * @param SumPerDoc the SumPerDoc to set
     */
    public void setSumPerDoc(Integer SumPerDoc) {
        this.SumPerDoc = SumPerDoc;
    }
}

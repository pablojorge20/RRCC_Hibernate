/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.da;

import celepsa.rrcc.be.AgrupacionBE;
import celepsa.rrcc.bd.ConexionBD;
import celepsa.rrcc.be.EstadoBE;
import celepsa.rrcc.be.NivelInfluenciaBE;
import celepsa.rrcc.be.TipoDocumentoIdentidadBE;
import celepsa.rrcc.be.ZonaBE;
import celepsa.rrcc.eh.HibernateUtil;
import celepsa.rrcc.eh.TmEstado;
import celepsa.rrcc.eh.TmStakeAgrupacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class AgrupacionDA {

      Session session = null;

    public AgrupacionDA() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    public List<AgrupacionBE> listarAgrupacion(Integer tdoc) throws Exception {
        ConexionBD objConexion = null;
        try {
            objConexion = new ConexionBD();
            List<AgrupacionBE> lstRetorno = new ArrayList<AgrupacionBE>();
            String sQuery = "";
            if (tdoc == 0) {
                sQuery = "SELECT id, Nombre FROM tmStakeAgrupacion WHERE est=0";

            } else {
                //sQuery = " SELECT * FROM tmDocumento WHERE tmTipoDocumento_id=" + tdoc +" OR tmTipoDocumento_id=0 and eliminado='0'" ;   
                sQuery = "SELECT DISTINCT tmStakeAgrupacion.id, CONCAT(tmStakeAgrupacion.Nombre , ' ', tmStakeAgrupacion.Apellido) as nombre FROM "
                        + "tmStakeAgrupacion WHERE  tmStakeAgrupacion.id NOT IN (SELECT tmStakeAgrupacion.id  FROM "
                        + "tmStakeAgrupacion, AgrupacionDocumento where tmStakeAgrupacion.id=AgrupacionDocumento.tmStakeAgrupacion_id and "
                        + " AgrupacionDocumento.tmDocumento_id =" + tdoc + ")";
            }

            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) {
                while (objResult.next()) {
                    lstRetorno.add(populateAgrupacionVarios(objResult));
                }
            }
            return lstRetorno;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion.close();
        }
    }

    private AgrupacionBE populateAgrupacionVarios(ResultSet resultado) throws SQLException {
        AgrupacionBE objAgrupacionBE = new AgrupacionBE();

        objAgrupacionBE.setId(resultado.getString("id"));

        objAgrupacionBE.setNombre(resultado.getString("nombre"));

        return objAgrupacionBE;
    }

    public AgrupacionBE obtenerAgrupacion(AgrupacionBE objAgrupacion) throws Exception {
        ConexionBD objConexion = null;
        int cont = 1;
        try {
            objConexion = new ConexionBD();
            AgrupacionBE objDocumentoResult = null;
            String sQuery = " SELECT  * FROM RRHH.tmStakeAgrupacion WHERE id = ? ";
            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            objConexion.agregarParametro(cont++, objAgrupacion.getId());

            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) {
                if (objResult.next()) {
                    objDocumentoResult = this.populateAgrupacion(objResult);
                }
            }
            return objDocumentoResult;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion.close();
        }
    }

    private AgrupacionBE populateAgrupacion(ResultSet resultado) throws SQLException {
        AgrupacionBE objAgrupacionBE = new AgrupacionBE();

        NivelInfluenciaBE objNivelInfluenciaBE = new NivelInfluenciaBE();
        TipoDocumentoIdentidadBE objTipoDocumentoIdentidadBE = new TipoDocumentoIdentidadBE();
        ZonaBE objZonaBE = new ZonaBE();
        EstadoBE objEstadoBE = new EstadoBE();
        objAgrupacionBE.setId(resultado.getString("id"));
        objAgrupacionBE.setFechaRegistro(resultado.getString("FechaRegistro"));
        objAgrupacionBE.setNombre(resultado.getString("Nombre"));
        objAgrupacionBE.setIdentidad(resultado.getString("Identidad"));
        objAgrupacionBE.setUbicacion(resultado.getString("Ubicacion"));
        objAgrupacionBE.setFotografia(resultado.getString("Fotografia"));

        objNivelInfluenciaBE.setId(resultado.getString("tmNivelInfluencia_id"));
        objAgrupacionBE.setNInfluencia(objNivelInfluenciaBE);;

        objZonaBE.setId(resultado.getString("tmZona_id"));
        objAgrupacionBE.setZona(objZonaBE);

        objEstadoBE.setId(resultado.getString("tmEstado_id"));
        objAgrupacionBE.setEstado(objEstadoBE);

        return objAgrupacionBE;
    }

    public int registrarAgrupacion(AgrupacionBE objSistema) throws Exception {

      /*  ConexionBD objConexion = null;
        String query = "";

        query = "INSERT INTO `RRHH`.`tmStakeAgrupacion` (`id`, `FechaRegistro`, `Nombre`, `Identidad`, `Ubicacion`, `Fotografia`,"
                + "`tmNivelInfluencia_id`, `est`, `tmZona_id`, `tmEstado_id`) VALUES (?,?,?,?,?,?,?,0,?,?);";

        int cont = 1;*/
        try {
            TmStakeAgrupacion ad = new TmStakeAgrupacion();
            /*objConexion = new ConexionBD();
             objConexion.open();
             objConexion.prepararSentencia(query);*/
            ad.setId(CrearIDAgrupacion());
            ad.setFechaRegistro(objSistema.getFechaRegistro());
            ad.setNombre(objSistema.getNombre());
            ad.setIdentidad(objSistema.getIdentidad());
            ad.setUbicacion(objSistema.getUbicacion());
            ad.setFotografia(objSistema.getFotografia());
            ad.setTmNivelInfluenciaId(Integer.parseInt(objSistema.getNInfluencia().getId()));
            ad.setTmZonaId(Integer.parseInt(objSistema.getZona().getId()));
            ad.setTmEstadoId(Integer.parseInt(objSistema.getEstado().getId()));
            org.hibernate.Transaction tx = session.beginTransaction();
            session.save(ad);
            tx.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;// no inserto nada 
        }

    }

    public boolean ActualizarAgrupacion(AgrupacionBE objSistema) throws Exception {

        ConexionBD objConexion = null;
        String query = "";

        query = "UPDATE `RRHH`.`tmStakeAgrupacion` SET `FechaRegistro`=?, "
                + "`Nombre`=?, "
                + "`Identidad`=?, "
                + "`Ubicacion`=?, `Fotografia`=?, `tmNivelInfluencia_id`=?, "
                + "`tmZona_id`=?, `tmEstado_id`=?"
                + " WHERE `id`='" + objSistema.getId() + "'";

        int cont = 1;

        try {
            objConexion = new ConexionBD();
            objConexion.open();
            objConexion.prepararSentencia(query);

            objConexion.agregarParametro(cont++, objSistema.getFechaRegistro());
            objConexion.agregarParametro(cont++, objSistema.getNombre());
            objConexion.agregarParametro(cont++, objSistema.getIdentidad());
            objConexion.agregarParametro(cont++, objSistema.getUbicacion());
            objConexion.agregarParametro(cont++, objSistema.getFotografia());
            objConexion.agregarParametro(cont++, Integer.parseInt(objSistema.getNInfluencia().getId()));
            objConexion.agregarParametro(cont++, Integer.parseInt(objSistema.getZona().getId()));
            objConexion.agregarParametro(cont++, Integer.parseInt(objSistema.getEstado().getId()));

            objConexion.ejecutar();
            return true;
            //return objConexion.insertar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion.close();
        }

    }

    private Integer CrearIDAgrupacion() throws Exception {
        Integer idnew = 0;
        ConexionBD objConexion2 = null;
        // DocumentoBE objDocumentoBE = new DocumentoBE();
        try {
             /* org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("From RRHH.tmStakeAgrupacion ORDER BY id DESC LIMIT 1");
            ResultSet objResult = (int) q.list().size();
           */
            objConexion2 = new ConexionBD();
            //List<DocumentoBE> lstRetorno = new ArrayList<DocumentoBE>();
            String sQuery = "SELECT  * FROM RRHH.tmStakeAgrupacion ORDER BY id DESC LIMIT 1";
            objConexion2.open();
            objConexion2.prepararSentencia(sQuery);
            ResultSet objResult = objConexion2.ejecutarQuery();
            if (objResult != null) {
                objResult.next();

                if (objResult.getRow() == 0) {
                    idnew = 0;
                } else {
                    idnew = Integer.parseInt(populateAgrupacion(objResult).getId());
                }

            } else {
                idnew = 0;
            }

        //objDocumentoBE.setId(resultado.getString("id"));
            //objDocumentoBE.setId(objResult.getString("id"));
            if (idnew == 0) {
                idnew = 1;
            } else {
                idnew = idnew + 1;
            }
            return idnew;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion2.close();
        }

    }

    public boolean eliminarAgrupacion(AgrupacionBE objDocumento) throws Exception {
        ConexionBD objConexion = null;
        int cont = 1;
        String query = " UPDATE tmStakeAgrupacion SET est = ? WHERE id = ? ";

        try {
            objConexion = new ConexionBD();
            objConexion.open();
            objConexion.prepararSentencia(query);
            objConexion.agregarParametro(cont++, objDocumento.getEst());
            objConexion.agregarParametro(cont++, objDocumento.getId());
            objConexion.ejecutar();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion.close();
        }
    }

    public List<AgrupacionBE> buscarAgrupacionVarios(String AsuntoBuscado) throws Exception {
        ConexionBD objConexion = null;
        try {
            objConexion = new ConexionBD();
            List<AgrupacionBE> lstRetorno = new ArrayList<AgrupacionBE>();
            String sQuery = "SELECT id, Nombre FROM "
                    + "tmStakeAgrupacion WHERE est=0 and tmStakeAgrupacion.Nombre like '%" + AsuntoBuscado + "%' ";
            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) {
                while (objResult.next()) {
                    lstRetorno.add(populateAgrupacionVarios(objResult));
                }
            }
            return lstRetorno;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion.close();
        }

    }

}

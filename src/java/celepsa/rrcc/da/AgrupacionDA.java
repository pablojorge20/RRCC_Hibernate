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
import celepsa.rrcc.web.util.HibernateUtil;
import celepsa.rrcc.eh.Tmestado;
import celepsa.rrcc.eh.Tmnivelinfluencia;
import celepsa.rrcc.eh.Tmstakeagrupacion;
import celepsa.rrcc.eh.Tmzona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class AgrupacionDA {

    private static final Logger logger = Logger.getLogger(AgrupacionDA.class);
    Session session = null;

    public AgrupacionDA() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<AgrupacionBE> listarAgrupacion(Integer tdoc) throws Exception {

        logger.debug("listarAgrupacion");

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
        logger.debug("populateAgrupacionVarios");
        objAgrupacionBE.setId(resultado.getString("id"));

        objAgrupacionBE.setNombre(resultado.getString("nombre"));

        return objAgrupacionBE;
    }

    public Tmstakeagrupacion obtenerAgrupacion(Tmstakeagrupacion objAgrupacion) throws Exception {

        logger.debug("obtenerAgrupacion hib");
        try {
            Query query = session.createQuery("from Tmstakeagrupacion where id = :id ");
            query.setInteger("id", objAgrupacion.getId());
            return (Tmstakeagrupacion) query.list().get(0);

        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private AgrupacionBE populateAgrupacion(ResultSet resultado) throws SQLException {
        AgrupacionBE objAgrupacionBE = new AgrupacionBE();
        logger.debug("populateAgrupacion");
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

    public void registrarAgrupacion(Tmstakeagrupacion objSistema) throws Exception {
        logger.debug("registrarAgrupacion:1");
        try {
            Tmstakeagrupacion ad = new Tmstakeagrupacion();
            ad.setId(CrearIDAgrupacion());
            ad.setFechaRegistro(objSistema.getFechaRegistro());
            ad.setNombre(objSistema.getNombre());
            ad.setIdentidad(objSistema.getIdentidad());
            ad.setUbicacion(objSistema.getUbicacion());
            ad.setEst(0);
            ad.setFotografia(objSistema.getFotografia());
            logger.debug("registrarAgrupacion:2");
            ad.setTmNivelInfluenciaid(new Tmnivelinfluencia(objSistema.getTmNivelInfluenciaid().getId()));            
            logger.debug("registrarAgrupacion:2.1");
            ad.setTmZonaid(new Tmzona(objSistema.getTmZonaid().getId()));
            ad.setTmEstadoid(new Tmestado(objSistema.getTmEstadoid().getId()));
            org.hibernate.Transaction tx = session.beginTransaction();
            session.save(ad);
            logger.debug("registrarAgrupacion:3");            
            tx.commit();
            
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void ActualizarAgrupacion(Tmstakeagrupacion objSistema) throws Exception {
        logger.debug("ActualizarAgrupacion");
        try {
            logger.debug("update");
            org.hibernate.Transaction tx = session.beginTransaction();

            session.merge(objSistema);
            tx.commit();
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private Integer CrearIDAgrupacion() throws Exception {
        Integer idnew = 0;
        try {
            SQLQuery query = session.createSQLQuery("select max(id) from Tmstakeagrupacion ORDER BY id DESC");
            idnew = (Integer) query.uniqueResult();
            if (idnew != null) {
                if (idnew == 0) {
                    idnew = 1;
                } else {
                    idnew = idnew + 1;
                }
            } else {
                idnew = 1;
            }
            logger.debug("CrearIDAgrupacion: " + idnew);
            return idnew;
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public boolean eliminarAgrupacion(AgrupacionBE objDocumento) throws Exception {
        logger.debug("eliminarAgrupacion id=" + objDocumento.getId());
        String squery = " update Tmstakeagrupacion set est='2' WHERE id = :id ";

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(squery);
            query.setInteger("id", Integer.parseInt(objDocumento.getId()));
            query.executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<AgrupacionBE> buscarAgrupacionVarios(String AsuntoBuscado) throws Exception {

        try {
            logger.debug("buscarAgrupacionVarios");
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(" from Tmstakeagrupacion WHERE est=0 and nombre like :nombre ");
            query.setString("nombre", "%" + AsuntoBuscado + "%");
            return query.list();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

}

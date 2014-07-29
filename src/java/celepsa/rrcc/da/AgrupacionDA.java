/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.da;
import celepsa.rrcc.web.util.HibernateUtil;
import celepsa.rrcc.eh.Tmestado;
import celepsa.rrcc.eh.Tmnivelinfluencia;
import celepsa.rrcc.eh.Tmstakeagrupacion;
import celepsa.rrcc.eh.Tmzona;
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

    public List<Tmstakeagrupacion> listarAgrupacion(Integer tdoc) throws Exception {

        logger.debug("listarAgrupacion");
        try {
            String sQuery = "";
            if (tdoc == 0) {
                sQuery = "FROM Tmstakeagrupacion WHERE est=0";

            } else {
                sQuery = "SELECT DISTINCT tmStakeAgrupacion.id, CONCAT(tmStakeAgrupacion.Nombre , ' ', tmStakeAgrupacion.Apellido) as nombre FROM "
                        + "tmStakeAgrupacion WHERE  tmStakeAgrupacion.id NOT IN (SELECT tmStakeAgrupacion.id  FROM "
                        + "tmStakeAgrupacion, AgrupacionDocumento where tmStakeAgrupacion.id=AgrupacionDocumento.tmStakeAgrupacion_id and "
                        + " AgrupacionDocumento.tmDocumento_id =:documentoId)";
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(sQuery);
            if (tdoc != 0) {
                query.setInteger("documentoId", tdoc);
            }

            return query.list();

        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

//    private AgrupacionBE populateAgrupacionVarios(ResultSet resultado) throws SQLException {
//        AgrupacionBE objAgrupacionBE = new AgrupacionBE();
//        logger.debug("populateAgrupacionVarios");
//        objAgrupacionBE.setId(resultado.getString("id"));
//
//        objAgrupacionBE.setNombre(resultado.getString("nombre"));
//
//        return objAgrupacionBE;
//    }
    public Tmstakeagrupacion obtenerAgrupacion(Tmstakeagrupacion objAgrupacion) throws Exception {

        logger.debug("obtenerAgrupacion hib");
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Tmstakeagrupacion where id = :id ");
            query.setInteger("id", objAgrupacion.getId());
            return (Tmstakeagrupacion) query.list().get(0);

        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

//    private AgrupacionBE populateAgrupacion(ResultSet resultado) throws SQLException {
//        AgrupacionBE objAgrupacionBE = new AgrupacionBE();
//        logger.debug("populateAgrupacion");
//        NivelInfluenciaBE objNivelInfluenciaBE = new NivelInfluenciaBE();
//        TipoDocumentoIdentidadBE objTipoDocumentoIdentidadBE = new TipoDocumentoIdentidadBE();
//        ZonaBE objZonaBE = new ZonaBE();
//        EstadoBE objEstadoBE = new EstadoBE();
//        objAgrupacionBE.setId(resultado.getString("id"));
//        objAgrupacionBE.setFechaRegistro(resultado.getString("FechaRegistro"));
//        objAgrupacionBE.setNombre(resultado.getString("Nombre"));
//        objAgrupacionBE.setIdentidad(resultado.getString("Identidad"));
//        objAgrupacionBE.setUbicacion(resultado.getString("Ubicacion"));
//        objAgrupacionBE.setFotografia(resultado.getString("Fotografia"));
//
//        objNivelInfluenciaBE.setId(resultado.getString("tmNivelInfluencia_id"));
//        objAgrupacionBE.setNInfluencia(objNivelInfluenciaBE);;
//
//        objZonaBE.setId(resultado.getString("tmZona_id"));
//        objAgrupacionBE.setZona(objZonaBE);
//
//        objEstadoBE.setId(resultado.getString("tmEstado_id"));
//        objAgrupacionBE.setEstado(objEstadoBE);
//
//        return objAgrupacionBE;
//    }
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
            logger.debug("id: " + objSistema.getId());
            logger.debug("estado: " + objSistema.getTmEstadoid().getId());
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

    public void eliminarAgrupacion(Tmstakeagrupacion objAgrupacion) throws Exception {
        logger.debug("eliminarAgrupacion id=" + objAgrupacion.getId());
        String squery = " update Tmstakeagrupacion set est='2' WHERE id = :id ";

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(squery);
            query.setInteger("id", objAgrupacion.getId());
            query.executeUpdate();
            tx.commit();
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public List<Tmstakeagrupacion> buscarAgrupacionVarios(String AsuntoBuscado) throws Exception {

        try {
            logger.debug("buscarAgrupacionVarios");
            Query query = session.createQuery(" from Tmstakeagrupacion WHERE est=0 and nombre like :nombre ");
            query.setString("nombre", "%" + AsuntoBuscado + "%");
            return query.list();
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

}

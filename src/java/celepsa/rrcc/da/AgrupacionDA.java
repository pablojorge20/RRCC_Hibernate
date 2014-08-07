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
            String sQuery = "FROM Tmstakeagrupacion WHERE est=0";
            if (tdoc != 0) {
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
            logger.error( e.getMessage() );
            throw e;
        }
    }

    public Tmstakeagrupacion obtenerAgrupacion(Tmstakeagrupacion objAgrupacion) throws Exception {

        logger.debug("obtenerAgrupacion hib");
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Tmstakeagrupacion where id = :id ");
            query.setInteger("id", objAgrupacion.getId());
            return (Tmstakeagrupacion) query.list().get(0);

        } catch (NumberFormatException | HibernateException e) {
            logger.error( e.getMessage() );
            throw e;
        }
    }

    public void registrarAgrupacion(Tmstakeagrupacion objSistema) throws Exception {
        logger.debug("registrarAgrupacion:1");
        try {
            // Tmstakeagrupacion ad = new Tmstakeagrupacion();
            objSistema.setId(CrearIDAgrupacion());
            objSistema.setEst(0);

            org.hibernate.Transaction tx = session.beginTransaction();
            session.save(objSistema);
            logger.debug("registrarAgrupacion:3");
            tx.commit();

        } catch (NumberFormatException | HibernateException e) {
            logger.error( e.getMessage() );
            throw e;
        }
    }

    public void ActualizarAgrupacion(Tmstakeagrupacion objSistema) throws Exception {
        logger.debug("ActualizarAgrupacion");
        try {
            objSistema.setEst(0);
            logger.debug("id: " + objSistema.getId());             
            logger.debug("estado: " + objSistema.getTmEstadoid().getId());
            org.hibernate.Transaction tx = session.beginTransaction();

            session.merge(objSistema);
            tx.commit();
        } catch (NumberFormatException | HibernateException e) {
            logger.error( e.getMessage() );
            throw e;
        }
    }

    private Integer CrearIDAgrupacion() throws Exception {
        Integer idnew = 0;
        try {
            SQLQuery query = session.createSQLQuery("select max(id) from Tmstakeagrupacion");
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
            logger.error( e.getMessage() );
            throw e;
        }
    }

    public void eliminarAgrupacion(Tmstakeagrupacion objAgrupacion) throws Exception {
        logger.debug("eliminarAgrupacion id=" + objAgrupacion.getId());
        String squery = " update Tmstakeagrupacion set est=2 WHERE id = :id ";

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(squery);
            query.setInteger("id", objAgrupacion.getId());
            query.executeUpdate();
            tx.commit();
        } catch (NumberFormatException | HibernateException e) {
            logger.error( e.getMessage() );
            throw e;
        }
    }

    public List<Tmstakeagrupacion> buscarAgrupacionVarios(String AsuntoBuscado) throws Exception {

        try {
            logger.debug("buscarAgrupacionVarios");
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(" from Tmstakeagrupacion WHERE est=0 and nombre like :nombre ");
            query.setString("nombre", "%" + AsuntoBuscado + "%");
            return query.list();
        } catch (NumberFormatException | HibernateException e) {
            logger.error( e.getMessage() );
            throw e;
        }
    }

}

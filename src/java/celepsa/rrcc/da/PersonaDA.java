/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.da;

import celepsa.rrcc.web.util.HibernateUtil;
import celepsa.rrcc.eh.Tmestado;
import celepsa.rrcc.eh.Tmnivelinfluencia;
import celepsa.rrcc.eh.Tmstakepersona;
import celepsa.rrcc.eh.Tmtdocumentoidentidad;
import celepsa.rrcc.eh.Tmzona;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.apache.log4j.Logger;

/**
 *
 * @author pmedina
 */
public class PersonaDA {

    private static final Logger logger = Logger.getLogger(DocumentoDA.class);
    Session session = null;

    public PersonaDA() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Tmstakepersona> listarPersona(Integer tdoc) throws Exception {
        try {
            String sQuery = "FROM Tmstakepersona WHERE est=0";
            if (tdoc != 0) {
                sQuery = "SELECT DISTINCT Tmstakepersona.id, CONCAT(Tmstakepersona.Nombre , ' ', Tmstakepersona.Apellido) as nombre FROM "
                        + "Tmstakepersona WHERE Tmstakepersona.est=0 and  Tmstakepersona.id NOT IN (SELECT Tmstakepersona.id  FROM "
                        + "Tmstakepersona, PersonaDocumento where Tmstakepersona.id=PersonaDocumento.Tmstakepersona_id and "
                        + " PersonaDocumento.tmDocumento_id = :documentoId)";
            }
            logger.debug("listarPersona: " + sQuery);
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(sQuery);
            if (tdoc != 0) {
                query.setInteger("documentoId", tdoc);
            }
            return query.list();
        } catch (HibernateException e) {
            logger.error( e.getMessage() );
            throw e;
        }
    }

    public Tmstakepersona obtenerPersona(Tmstakepersona objPersona) throws Exception {
        try {
            String sQuery = "FROM Tmstakepersona WHERE id = :id ";
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(sQuery);
            query.setInteger("id", objPersona.getId());
            return (Tmstakepersona) query.list().get(0);
        } catch (HibernateException e) {
            logger.error( e.getMessage() );
            throw e;
        }
    }

    public boolean obtenerPersonaNDOC(Tmstakepersona objPersona) throws Exception {
        try {
            boolean a = false;
            String sQuery = "FROM Tmstakepersona WHERE nroDocumento = :NDocumento ";
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(sQuery);
            query.setString("NDocumento", objPersona.getNroDocumento());
            List<Object[]> res = query.list();
            res = query.list();
            if (res.isEmpty()) {
                a = true;
            }
            return a;
        } catch (HibernateException e) {
            logger.error( e.getMessage() );
            throw e;
        }
    }

    public int registrarPersona(Tmstakepersona objSistema) throws Exception {
        Tmstakepersona persona = new Tmstakepersona();
        try {
            persona.setId(CrearIDPersona());
            persona.setFechaRegistro(objSistema.getFechaRegistro());
            persona.setNombre(objSistema.getNombre());
            persona.setApellido(objSistema.getApellido());
            persona.setAlias(objSistema.getAlias());
            persona.setIdentidad(objSistema.getIdentidad());
            persona.setNroDocumento(objSistema.getNroDocumento());
            if (objSistema != null && objSistema.getTmTDocumentoid() != null) {
                persona.setTmTDocumentoid(new Tmtdocumentoidentidad(objSistema.getTmTDocumentoid().getId()));
            } else {
                persona.setTmTDocumentoid(new Tmtdocumentoidentidad(1));
            }
            if (objSistema != null && objSistema.getTmNivelInfluenciaid() != null) {
                persona.setTmNivelInfluenciaid(new Tmnivelinfluencia(objSistema.getTmNivelInfluenciaid().getId()));
            } else {
                persona.setTmNivelInfluenciaid(new Tmnivelinfluencia(1));
            }
            persona.setEst(0);
            if (objSistema != null && objSistema.getTmZonaid() != null) {
                persona.setTmZonaid(new Tmzona(objSistema.getTmZonaid().getId()));
            } else {
                persona.setTmZonaid(new Tmzona(1));
            }
            if (objSistema != null && objSistema.getTmEstadoid() != null) {
                persona.setTmEstadoid(new Tmestado(objSistema.getTmEstadoid().getId()));
            } else {
                persona.setTmEstadoid(new Tmestado(1));
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            session.save(persona);
            tx.commit();
            return 1;
        } catch (Exception e) {
            logger.error( e.getMessage() );
            throw e;
        }

    }

    public boolean ActualizarPersona(Tmstakepersona objSistema) throws Exception {

        try {
            logger.debug("update");
            org.hibernate.Transaction tx = session.beginTransaction();
            session.merge(objSistema);
            tx.commit();
            return true;
        } catch (NumberFormatException | HibernateException e) {
            logger.error( e.getMessage() );
<<<<<<< HEAD
             throw e;
=======
            return false;
>>>>>>> origin/master
        }

    }

    private Integer CrearIDPersona() throws Exception {
        Integer idnew = 0;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("select max(id) from Tmstakepersona");
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
            logger.debug("CrearIDPersona: " + idnew);
            return idnew;
        } catch (NumberFormatException | HibernateException e) {
            logger.error( e.getMessage() );
            throw e;
        }
    }

    public boolean eliminarPersona(Tmstakepersona objDocumento) throws Exception {
        try {
            logger.debug("eliminarPersona(id): " + objDocumento.getId());
            logger.debug("eliminarPersona(est): " + objDocumento.getEst());
            org.hibernate.Transaction tx = session.beginTransaction();
            String sQuery = " update Tmstakepersona set est = 1 WHERE id = :id ";
            logger.debug("eliminarPersona(query): " + sQuery);
            Query query = session.createQuery(sQuery);
            //query.setInteger("est", objDocumento.getEst());
            query.setInteger("id", objDocumento.getId());
            query.executeUpdate();
            tx.commit();
            return true;
        } catch (NumberFormatException | HibernateException e) {
<<<<<<< HEAD
           logger.error( e.getMessage() );
=======
            logger.error( e.getMessage() );
>>>>>>> origin/master
            throw e;
        }

    }

    public List<Tmstakepersona> buscarPersonasVarios(String nombreBuscado) throws Exception {
        String sQuery = "from Tmstakepersona WHERE est=0 and ( nombre like :nombreBuscado or apellido like :nombreBuscado ) ";
        try {
            logger.debug("buscarPersonasVarios");
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(sQuery);
            query.setString("nombreBuscado", "%" + nombreBuscado + "%");
            return query.list();
        } catch (NumberFormatException | HibernateException e) {
            logger.error( e.getMessage() );
            throw e;
        }
    }

}

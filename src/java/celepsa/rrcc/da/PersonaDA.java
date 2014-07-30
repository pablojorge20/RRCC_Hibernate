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
            String sQuery = "SELECT id, CONCAT(Nombre , ' ', Apellido) as nombre FROM tmStakePersona WHERE est=0";
            if (tdoc != 0) {
                sQuery = "SELECT DISTINCT tmStakePersona.id, CONCAT(tmStakePersona.Nombre , ' ', tmStakePersona.Apellido) as nombre FROM "
                        + "tmStakePersona WHERE  tmStakePersona.id NOT IN (SELECT tmStakePersona.id  FROM "
                        + "tmStakePersona, PersonaDocumento where tmStakePersona.id=PersonaDocumento.tmStakePersona_id and "
                        + " PersonaDocumento.tmDocumento_id = :documentoId)";
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(sQuery);
            if (tdoc != 0) {
                query.setInteger("documentoId", tdoc);
            }
            return query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            persona.setTmTDocumentoid(new Tmtdocumentoidentidad(objSistema.getTmTDocumentoid().getId()));
            persona.setTmNivelInfluenciaid(new Tmnivelinfluencia(objSistema.getTmNivelInfluenciaid().getId()));
            persona.setEst(0);
            persona.setTmZonaid(new Tmzona(objSistema.getTmZonaid().getId()));
            persona.setTmEstadoid(new Tmestado(objSistema.getTmEstadoid().getId()));

            org.hibernate.Transaction tx = session.beginTransaction();
            session.save(persona);
            tx.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;// no inserto nada 
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
            System.out.println(e.getMessage());
            return false;
        }
       
    }

    private Integer CrearIDPersona() throws Exception {
        Integer idnew = 0;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("select max(id) from tmStakePersona");
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
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public boolean eliminarPersona(Tmstakepersona objDocumento) throws Exception {
       
         try {
            Query query = session.createQuery("  UPDATE tmStakePersona SET est = :est WHERE id = :id ");
            query.setInteger("est", objDocumento.getEst() );
            query.setInteger("id", objDocumento.getId());
            return query.executeUpdate() > 0;
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
            
    }

    public List<Tmstakepersona> buscarPersonasVarios(String nombreBuscado) throws Exception {
        String sQuery = "SELECT id, CONCAT(Nombre , ' ', Apellido) as nombre FROM "
                + "Tmstakepersona WHERE est=0 and Tmstakepersona.Nombre like :nombreBuscado or Tmstakepersona.Apellido like :nombreBuscado ";
        try {
            logger.debug("buscarPersonasVarios");
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(sQuery);
            query.setString("nombreBuscado", "%" + nombreBuscado + "%");
            return query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

}

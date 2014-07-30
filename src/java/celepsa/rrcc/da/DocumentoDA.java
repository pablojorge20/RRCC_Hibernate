/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.da;

import celepsa.rrcc.web.util.HibernateUtil;
import celepsa.rrcc.eh.Tmdocumento;
import celepsa.rrcc.eh.Tmadjunto;
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
public class DocumentoDA {

    private static final Logger logger = Logger.getLogger(DocumentoDA.class);
    Session session = null;

    public DocumentoDA() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Integer registrarDocumento(Tmdocumento documento) throws Exception {
        try {
            documento.setId(CrearIDDoc());
            logger.debug("antes del insert con hibernate");
            org.hibernate.Transaction tx = session.beginTransaction();
            session.save(documento);
            logger.debug("luego del commit ");
            tx.commit();            
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());            
        }
        return documento.getId();
    }

    public void ActualizarDocumento(Tmdocumento documento) throws Exception {

        try {
            logger.debug("update");
            org.hibernate.Transaction tx = session.beginTransaction();
            session.merge(documento);
            tx.commit();
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Tmdocumento> listarDocumentos(Integer tdoc) throws Exception {
        try {
            logger.debug("listarDocumentos");
            String sQuery = "from Tmdocumento where  eliminado='0'";
            if (tdoc != 0) {
                sQuery = "from Tmdocumento where tmTipoDocumentoid.id=:documentoId OR tmTipoDocumentoid.id=0  and eliminado='0' ";
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(sQuery);
            query.setInteger("documentoId", tdoc);
            return query.list();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public List<Tmdocumento> listarDocumentosVarios() throws Exception {
        try {
            logger.debug("listarDocumentosVarios");

            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Tmdocumento where eliminado='0' ");
            return query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public List<Tmdocumento> buscarDocumentosVarios(String AsuntoBuscado) throws Exception {
        try {
            logger.debug("buscarDocumentosVarios");
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Tmdocumento where  eliminado='0' and asunto like :asunto ");
            query.setString("asunto", "%" + AsuntoBuscado + "%");
            return query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private Integer CrearIDDoc() throws Exception {
        Integer idnew = 0;
        try {
            SQLQuery query = session.createSQLQuery("select max(id) from Tmdocumento");
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
            logger.debug("CrearIDDocumento: " + idnew);
            return idnew;
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public Tmdocumento obtenerDocumento(Tmdocumento objDocumento) throws Exception {
        try {
            Query query = session.createQuery("from Tmdocumento where id = :id ");
            query.setInteger("id", objDocumento.getId());
            return (Tmdocumento) query.list().get(0);
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public boolean eliminarDocumento(Tmdocumento objDocumento) throws Exception {
        // eliminar con hibernate 
        try {
            Query query = session.createQuery(" update Tmdocumento set eliminado= :eliminado where id = :id ");
            query.setInteger("eliminado", objDocumento.getEliminado());
            query.setInteger("id", objDocumento.getId());
            return query.executeUpdate() > 0;
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public int registrarAdjunto(Tmadjunto objSistema, Tmdocumento objDocumento) throws Exception {

        String squery = "INSERT INTO `tmAdjunto`(`id`,`tmDocumento_id`,`Nombre`,`eliminado`, `scodigo`)"
                + "VALUES (:id,:doc, :nom, '0', :scod)";
        logger.debug("registrarStakeholderDocumento");
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(squery);
            query.setInteger("id", CrearIDAdjunto());
            query.setInteger("doc", objDocumento.getId());
            query.setString("nom", objSistema.getNombre());
            query.setString("scod", objSistema.getScodigo());
            
            int res = query.executeUpdate();
            tx.commit();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private Integer CrearIDAdjunto() throws Exception {
        Integer idnew = 0;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("select max(id) from Tmadjunto");
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
            logger.debug("CrearIDAdjunto: " + idnew);
            return idnew;
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public List<Tmadjunto> listarAdjuntos(Integer tdoc) throws Exception {
        try {
            String sQuery = "SELECT id, tmDocumento_id, Nombre, eliminado, scodigo  FROM "
                    + "tmAdjunto where tmDocumento_id = :documentoId";
            logger.debug("listarAdjuntosPorDocumento");
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(sQuery);
            query.setInteger("documentoId", tdoc);
            return query.list();
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public boolean eliminarDocumentoAdjunto(Tmadjunto objAdjunto, Tmdocumento objDocumento) throws Exception {
        String sQuery = "DELETE FROM RRHH.Tmadjunto WHERE id=:id and tmDocumento_id=:documentoId";        
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(sQuery);            
            query.setInteger("id", objAdjunto.getTmadjuntoPK().getId());
            query.setInteger("documentoId", objDocumento.getId());
            return query.executeUpdate() > 0;
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}

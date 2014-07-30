/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.da;

import celepsa.rrcc.be.DocumentoBE;
import celepsa.rrcc.eh.Tmstakepersona;
import celepsa.rrcc.web.util.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class StakeholderDA {

    Session session = null;
    private static final Logger logger = Logger.getLogger(StakeholderDA.class);

    public StakeholderDA() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Tmstakepersona> listarStakeholder(Integer tdoc) throws Exception {

        try {
            logger.debug("listarStakeholder");
            String sQuery = "";
            if (tdoc == 0) {
                sQuery = " FROM Tmstakepersona WHERE est=0";
            } else {
                /*  sQuery="SELECT DISTINCT tmStakePersona.id, "
                 + " CONCAT(tmStakePersona.Nombre , ' ', tmStakePersona.Apellido) as nombre FROM " +
                 "tmStakePersona  WHERE  tmStakePersona.id NOT IN (SELECT tmStakePersona.id  FROM " +
                 "tmStakePersona, PersonaDocumento where tmStakePersona.id=PersonaDocumento.tmStakePersona_id and " +
                 " PersonaDocumento.tmDocumento_id =" + tdoc +")";*/
                sQuery = " from Tmstakepersona where id not in ( select t.tmStakePersonaid.id from Tmdocumento t where t.id='" + tdoc + "' )";
            }
            logger.debug(sQuery);
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(sQuery);
            return query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public List<Tmstakepersona> listarStakeholderDoc(String tdoc) throws Exception {

        try {
            logger.debug("listarStakeholderDoc");
            String sQuery = "";
            /* sQuery = "SELECT tmStakePersona.id, CONCAT(tmStakePersona.Nombre , ' ', tmStakePersona.Apellido) as Nombre " + 
             " FROM tmStakePersona, PersonaDocumento where PersonaDocumento.tmStakePersona_id=tmStakePersona.id " +
             "and PersonaDocumento.tmDocumento_id='"+ tdoc +"'" ;  */

            // sQuery = "Select t.tmStakePersonaid from Tmdocumento t where t.id='"+tdoc+"' " ;
            sQuery = "Select p.tmstakepersona from Personadocumento p where p.tmdocumento.id='" + tdoc + "' ";
            logger.debug(sQuery);
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(sQuery);
            return query.list();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int registrarStakeholderDocumento(Tmstakepersona objSistema1, DocumentoBE objSistema2) throws Exception {

        String squery = "INSERT INTO `RRHH`.`PersonaDocumento` (`tmDocumento_id`, `tmStakePersona_id`, est) VALUES (:doc, :per, 1);";
        logger.debug("registrarStakeholderDocumento");
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(squery);
            query.setInteger("doc", Integer.parseInt(objSistema2.getId()));
            query.setInteger("per", (objSistema1.getId()));
            int res = query.executeUpdate();
            tx.commit();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    public boolean eliminarDocumento(Tmstakepersona objStakeholder) throws Exception {
        logger.debug("eliminarDocumento");
        String squery = " UPDATE tmDocumento SET  eliminado = 2 WHERE id = :id ";

        try {

            org.hibernate.Transaction tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(squery);
            query.setInteger("id", (objStakeholder.getId()));
            query.executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarDocumentoStakeholder(Tmstakepersona objStakeholder, DocumentoBE objDocumento) throws Exception {
        logger.debug("eliminarDocumentoStakeholder");
        String squery = "DELETE FROM `RRHH`.`PersonaDocumento` WHERE `tmDocumento_id`=:doc and`tmStakePersona_id`=:per";
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(squery);
            query.setInteger("doc", Integer.parseInt(objDocumento.getId()));
            query.setInteger("per", (objStakeholder.getId()));
            query.executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Tmstakepersona obtenerDocumento(Tmstakepersona objStakeholder) throws Exception {
        logger.debug("obtenerDocumento");
        try {
            String sQuery = " from Tmstakepersona WHERE id = :id ";

            SQLQuery query = session.createSQLQuery(sQuery);
            query.setInteger("id", (objStakeholder.getId()));
            return (Tmstakepersona) query.list().get(0);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

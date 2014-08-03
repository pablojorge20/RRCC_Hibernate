/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.eh.Tmdocumento;
import celepsa.rrcc.web.util.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class ConsultasVariasDA {
    
     private static final Logger logger = Logger.getLogger(ConsultasVariasDA.class);
     
    Session session= null;
      public ConsultasVariasDA() {
            this.session =HibernateUtil.getSessionFactory().getCurrentSession();
      }
       
    public boolean BuscarPersonaDocumento(String idDocPer) {
       logger.debug("BuscarPersonaDocumento " +idDocPer);
        boolean a=false;
        try{
                org.hibernate.Transaction tx = session.beginTransaction();
                 //Personadocumento tmdocumento
                Query query =session.createQuery("select p.tmdocumento  FROM Personadocumento p WHERE p.tmdocumento.id = :pdid");
                query.setParameter("pdid", Integer.parseInt(idDocPer) );
                List<Tmdocumento> li = query.list() ;
              
                System.out.println(" lista " + li);
                a = li != null && li.size()>0;
            } catch (HibernateException e){
                e.printStackTrace();
            }
        return a;
    } 
}

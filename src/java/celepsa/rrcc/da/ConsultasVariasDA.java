/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.eh.Tmdocumento;
import celepsa.rrcc.web.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class ConsultasVariasDA {
    Session session= null;
      public ConsultasVariasDA() {
            this.session =HibernateUtil.getSessionFactory().getCurrentSession();
      }
       
    public boolean BuscarPersonaDocumento(String idDocPer) {
       
        boolean a=false;
        try{
                Query query =session.createQuery("FROM Tmdocumento d WHERE d.id = :pdid");
                query.setParameter("pdid",idDocPer);
                List<Tmdocumento> li = query.list() ;
              
                System.out.println(" lista " + li);
                  a = li != null && li.size()>0;
            } catch (Exception e){
                e.printStackTrace();
            }
        return a;
    } 
}

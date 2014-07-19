/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.web.util.HibernateUtil;
import celepsa.rrcc.eh.Tmzona;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class ZonaDA {
      Session session= null;
      public ZonaDA() {
            this.session =HibernateUtil.getSessionFactory().getCurrentSession();
      }
        
    public List<Tmzona> listarZona() throws Exception{
        List<Tmzona> TZona = null;
        try
            {
                org.hibernate.Transaction  tx =session.beginTransaction();
                Query q =session.createQuery("From Tmzona as tzona");
                TZona=(List<Tmzona>) q.list();           
            } catch (Exception e){
                e.printStackTrace();
            }
        return TZona;
    } 
}

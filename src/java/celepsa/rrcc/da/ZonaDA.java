/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.bd.ConexionBD;
import celepsa.rrcc.be.ZonaBE;
import celepsa.rrcc.eh.HibernateUtil;
import celepsa.rrcc.eh.TmZona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        
    public List<TmZona> listarZona() throws Exception{
        List<TmZona> TZona = null;
        try
            {
                org.hibernate.Transaction  tx =session.beginTransaction();
                Query q =session.createQuery("From TmZona as tzona");
                TZona=(List<TmZona>) q.list();           
            } catch (Exception e){
                e.printStackTrace();
            }
        return TZona;
    } 
}

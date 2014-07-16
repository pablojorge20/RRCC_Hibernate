/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;


import celepsa.rrcc.eh.HibernateUtil;
import celepsa.rrcc.eh.TmNivelInfluencia;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class NivelInfluenciaDA {
   Session session= null;
      public NivelInfluenciaDA() {
            this.session =HibernateUtil.getSessionFactory().getCurrentSession();
      }
        
    public List<TmNivelInfluencia> listarNivelInfluencia() throws Exception{
        List<TmNivelInfluencia> TInfluencia = null;
        try
            {
                org.hibernate.Transaction  tx =session.beginTransaction();
                Query q =session.createQuery("From TmNivelInfluencia as TInfluencia");
                TInfluencia=(List<TmNivelInfluencia>) q.list();           
            } catch (Exception e){
                e.printStackTrace();
            }
        return TInfluencia;
    }
}

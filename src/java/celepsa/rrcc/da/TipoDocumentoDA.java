/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.web.util.HibernateUtil;
import celepsa.rrcc.eh.Tmtipodocumento;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class TipoDocumentoDA {
       Session session= null;
        public TipoDocumentoDA() 
    {
            this.session =HibernateUtil.getSessionFactory().getCurrentSession();
      
    }
        
public List<Tmtipodocumento> ListarTipoDocumento() throws HibernateException
{
    List<Tmtipodocumento> TDocumento = null;
    try
        {
                org.hibernate.Transaction  tx =session.beginTransaction();
                Query q =session.createQuery("From Tmtipodocumento as tipoDocumento");
                
                TDocumento=(List<Tmtipodocumento>) q.list();
                
                
        } catch (HibernateException e){
        }
        return TDocumento;
}

}
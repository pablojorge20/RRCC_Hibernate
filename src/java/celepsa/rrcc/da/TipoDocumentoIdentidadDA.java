/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.web.util.HibernateUtil;
import celepsa.rrcc.eh.Tmtdocumentoidentidad;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class TipoDocumentoIdentidadDA {
     Session session= null;
        public TipoDocumentoIdentidadDA() 
    {
            this.session =HibernateUtil.getSessionFactory().getCurrentSession();
    }
        
public List<Tmtdocumentoidentidad> ListarTipoDocumento() throws Exception{
    List<Tmtdocumentoidentidad> TDocumento = null;
    try
        {
                org.hibernate.Transaction  tx =session.beginTransaction();
                Query q =session.createQuery("From Tmtdocumentoidentidad as tipoDocumento");
                
                TDocumento=(List<Tmtdocumentoidentidad>) q.list();
                
                
        } catch (Exception e){
                e.printStackTrace();
        }
        return TDocumento;
}  
}

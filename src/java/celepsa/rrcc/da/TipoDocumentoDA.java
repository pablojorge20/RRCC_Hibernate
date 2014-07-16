/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.bd.ConexionBD;
import celepsa.rrcc.be.TipoDocumentoBE;
import celepsa.rrcc.eh.HibernateUtil;
import celepsa.rrcc.eh.TmTipoDocumento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        
public List<TmTipoDocumento> ListarTipoDocumento() throws HibernateException
{
    List<TmTipoDocumento> TDocumento = null;
    try
        {
                org.hibernate.Transaction  tx =session.beginTransaction();
                Query q =session.createQuery("From TmTipoDocumento as tipoDocumento");
                
                TDocumento=(List<TmTipoDocumento>) q.list();
                
                
        } catch (HibernateException e){
        }
        return TDocumento;
}

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;


import celepsa.rrcc.eh.HibernateUtil;
import celepsa.rrcc.eh.TmTdocumentoIdentidad;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class TipoDocumentoIdentidadBL {
    Session session= null;
        public TipoDocumentoIdentidadBL() 
    {
            this.session =HibernateUtil.getSessionFactory().getCurrentSession();
    }
        
public List<TmTdocumentoIdentidad> ListarTipoDocumento() throws Exception
{
    List<TmTdocumentoIdentidad> TDocumento = null;
    try
        {
                org.hibernate.Transaction  tx =session.beginTransaction();
                Query q =session.createQuery("From TmTdocumentoIdentidad as tipoDocumento");
                
                TDocumento=(List<TmTdocumentoIdentidad>) q.list();
                
                
        } catch (Exception e){
                e.printStackTrace();
        }
        return TDocumento;
}
}

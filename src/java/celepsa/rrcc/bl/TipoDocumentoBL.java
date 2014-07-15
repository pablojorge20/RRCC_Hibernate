/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.bl;

import celepsa.rrcc.be.TipoDocumentoBE;
import celepsa.rrcc.da.TipoDocumentoDA;
import celepsa.rrcc.eh.HibernateUtil;
import celepsa.rrcc.eh.TmTipoDocumento;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class TipoDocumentoBL {
    Session session= null;
        public TipoDocumentoBL() 
    {
            this.session =HibernateUtil.getSessionFactory().getCurrentSession();
        //TipoDocumentoDA objSistemaDA = new TipoDocumentoDA();
        //return objSistemaDA.listarTipoDocumento();
    }
        
public List<TmTipoDocumento> ListarTipoDocumento() throws Exception
{
    List<TmTipoDocumento> TDocumento = null;
    try
        {
                org.hibernate.Transaction  tx =session.beginTransaction();
                Query q =session.createQuery("From TmTipoDocumento as tipoDocumento");
                
                TDocumento=(List<TmTipoDocumento>) q.list();
                
                
        } catch (Exception e){
                e.printStackTrace();
        }
        return TDocumento;
}

}

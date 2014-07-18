/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.da;

import celepsa.rrcc.eh.HibernateUtil;
import celepsa.rrcc.eh.PersonaDocumentoId;
import celepsa.rrcc.eh.TmStakePersona;
import celepsa.rrcc.eh.TmZona;
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
        List<PersonaDocumentoId> PDocumento = null;
        boolean a=false;
        try
            {
                org.hibernate.Transaction  tx =session.beginTransaction();
                Query query =session.createQuery("FROM PersonaDocumentoId as PD WHERE PD.tmDocumentoId = :pdid");
                query.setParameter("pdid",idDocPer);
                PDocumento=query.list();
                PDocumento = (List<PersonaDocumentoId>) query.list();   
                if (!PDocumento.isEmpty()){
                    a= true;
                }
                
            } catch (Exception e){
                e.printStackTrace();
            }
        return a;
        
        
    } 
}

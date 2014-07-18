/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.da;

import celepsa.rrcc.eh.HibernateUtil;
import celepsa.rrcc.eh.TmEstado;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class EstadoDA {

    Session session = null;

    public EstadoDA() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<TmEstado> listarEstado() throws Exception {
        List<TmEstado> Testado = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("From TmEstado as Tmestado");
            Testado = (List<TmEstado>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Testado;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.da;

import celepsa.rrcc.web.util.HibernateUtil;
import celepsa.rrcc.eh.Tmestado;
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

    public List<Tmestado> listarEstado() throws Exception {
        List<Tmestado> Testado = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("From Tmestado as Tmestado");
            Testado = (List<Tmestado>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Testado;
    }
}

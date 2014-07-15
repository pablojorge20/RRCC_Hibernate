/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.web.util;

import celepsa.rrcc.be.UsuarioBE;
import com.opensymphony.xwork2.ActionContext;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.apache.log4j.Logger;

/**
 *
 * @author durbina
 */
public class SessionController implements HttpSessionListener
{
    private static Logger logger = Logger.getLogger(SessionController.class);
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //System.out.println("sessionCreated - add one session into counter");
        //System.out.println("sessionCreated - timeout " + se.getSession().getMaxInactiveInterval());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        Object objUser = se.getSession().getAttribute("usuario");
        if (objUser != null)
        {
            se.getSession().getServletContext().removeAttribute(((UsuarioBE)objUser).getCuenta());
            logger.info("sessionDestroyed - remove " + ((UsuarioBE)objUser).getCuenta());
            
            /*Enumeration enumer = se.getSession().getServletContext().getAttributeNames();
            while (enumer.hasMoreElements()) 
            {
                String sVariable = (String)enumer.nextElement();
                if(se.getSession().getServletContext().getAttribute(sVariable) instanceof UsuarioBE)
                {
                }
            }*/        
        }
        else
        {
            logger.info("sessionDestroyed - usuario = null");
        }        
    }
    
}

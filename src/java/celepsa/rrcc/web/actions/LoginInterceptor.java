package celepsa.rrcc.web.actions;


import celepsa.rrcc.be.UsuarioBE;
import celepsa.rrcc.bl.UsuarioBL;
import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.StrutsStatics;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics, ServletRequestAware {
    private static Logger logger = Logger.getLogger(LoginInterceptor.class);
    private static final String LOGIN_ATTEMPT = "login";

    protected HttpServletRequest request;
    
    @Override
    public void init () {}

    @Override
    public void destroy () {}

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }    
    
    @Override
    public String intercept (ActionInvocation invocation) throws Exception 
    {
        return invocation.invoke();
    }

    private boolean validarLogin (HttpServletRequest request, Map session) throws Exception 
    {
        
        UsuarioBL gestorUsuarios = new UsuarioBL();

        UsuarioBE user = new UsuarioBE();
        user.setCuenta(request.getParameter("usuario"));
        user.setClave(request.getParameter("clave"));

        user = gestorUsuarios.validarLogin(user, session, request.getRemoteAddr(), request.getRemoteHost());
        if (user != null) 
        {
            return true;
        }
        else
        {
            return false;
        }

    }

}

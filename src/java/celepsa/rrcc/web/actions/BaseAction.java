package celepsa.rrcc.web.actions;

import celepsa.rrcc.be.UsuarioBE;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class BaseAction extends ActionSupport implements ServletRequestAware,Preparable,SessionAware{
    //protected MyLogger logger = new MyLogger(MyLogger.class);
    protected HttpServletRequest request;
    protected boolean login;
    protected Map session;
    protected Map sessionAware;
    protected static String FORM = "form";
    protected static String ADD = "add";
    protected static String CANCEL = "cancel";
    protected static String SEARCH = "search";
    protected static String BACK = "back";
    protected String mensaje;
    
    protected boolean aceptar = false;
    protected boolean eliminar = false;
    protected boolean listo = false;
    //protected boolean grabar = false;
    protected boolean cancelar = false;
    protected boolean buscar = false;
    protected boolean agregar = false;
    protected String msgAction;

    @Override
    public void prepare() throws Exception {
        if ( (UsuarioBE)getSession().get("usuario") == null )
        {
            login= false;
        }
        else
        {
            login= true;
        }
        session = ActionContext.getContext().getSession();
    }

    public HttpServletRequest getServletRequest() {
        return request;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    protected Map getSession(){
        session = ActionContext.getContext().getSession();
        session.put("request", request);
        return session;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setError(Exception e) {
        System.out.println(e.getMessage());
        //this.mensaje = "Message: "+e.getMessage();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        this.mensaje = sw.toString();

    }

    @Override
    public void setSession(Map session) {
        sessionAware = session;
    }

    public UsuarioBE getUsuarioSession(){
        return (UsuarioBE)session.get("usuario");
    }
    
    
//    public void setGrabar(boolean grabar) {
//        this.grabar = true;
//    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = true;
    }

    public void setListo(boolean listo) {
        this.listo = true;
    }

    public void setCancelar(boolean cancelar) {
        this.cancelar = true;
    }
    
    public void setEliminar(boolean eliminar) {
        this.eliminar = true;
    }    

    public void setBuscar(boolean buscar) {
        this.buscar = true;
    }

    public void setAgregar(boolean agregarAction) {
        this.agregar = true;
    }

    public List<String> filtrarCheckList(List<String> lista){
        List<String> ret = new ArrayList<String>();
        for (String cadena : lista )
        {
            if ( cadena!=null && !cadena.equals("false")) 
            {
                ret.add(cadena);
            }
        }
        return ret;
    }
    
    
    protected void procesarError(Exception e)
    {
        if (e.getMessage() == null)
        {
            msgAction = "Error al procesar la operación";
        }
        else if (e.getMessage().startsWith("*"))
        {
            msgAction = e.getMessage().substring(1);
        }
        else
        {
            msgAction = e.getMessage();
        }        
    }
    
    protected String obtenerError(Exception e)
    {
        if (e.getMessage() == null)
        {
            return "Error al procesar la operación";
        }
        else if (e.getMessage().startsWith("*"))
        {
            return e.getMessage().substring(1);
        }
        else
        {
            return e.getMessage();
        }        
    }
    

}
package celepsa.rrcc.web.actions;

import celepsa.rrcc.be.UsuarioBE;
import celepsa.rrcc.bl.UsuarioBL;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

public class LoginAction extends BaseAction implements Preparable{
    private static Logger logger = Logger.getLogger(LoginAction.class);
    private UsuarioBE usuario;
    private String url;
    private String accion;
    
    
    
    @Override
    public void prepare() throws Exception {
        super.prepare();
        Map<String, Object> mapa = ActionContext.getContext().getApplication();
        if (mapa == null)
        {
            mapa = new HashMap<String, Object>();
            ActionContext.getContext().setApplication(mapa);
           
        }
    }

    public String login() {
        usuario = (UsuarioBE)session.get("usuario");
        if ( usuario!= null )
        {
            accion = "welcome.action";
            return SUCCESS;
        }
        
        
        return INPUT;
    }
    
    public String check() throws Exception {
        boolean bLogin = false;
        UsuarioBL gestorUsuarios = new UsuarioBL();
        

        try 
        {            
            UsuarioBE objUsuarioSession = this.getUsuarioSession();
            
            if (usuario == null || 
                usuario.getCuenta().trim().length() == 0 ||
                usuario.getClave().trim().length() == 0)
            {
                addActionError("Ingrese usuario y clave");
                return INPUT;
            }
            else
            {                
                UsuarioBE user = gestorUsuarios.validarLogin(usuario, session, request.getRemoteAddr(), request.getRemoteHost());
                if (user != null) 
                {
                    bLogin = true;
                    
                    // crear variable en la sesión
                    Map<String, Object> mapa = ActionContext.getContext().getApplication();
                    mapa.put(user.getCuenta(), user);
                    ActionContext.getContext().setApplication(mapa);
                    
                    logger.info("Ingreso al sistema (usuario="+user.getCuenta()+")");
                    
                    accion = "welcome";
                    return SUCCESS;
                } 
                else 
                {                    
                    // mostrar error
                    addActionError("error");
                    return INPUT;
                }                
            }   
        } 
        catch (Exception e) 
        {
            if (e.getMessage().startsWith("*"))
            {
                addActionError(e.getMessage().substring(1));
            }
            else
            {
                addActionError(e.getMessage());
            }
            return INPUT;
        }
        finally
        {
            if (usuario == null)
            {
                usuario = new UsuarioBE();
            }
        }
    }

    public String logout() throws Exception {
        try 
        {
            String sUsuario = this.getUsuarioSession().getCuenta();
            session.remove("usuario");
            
            Map<String, Object> mapa = ActionContext.getContext().getApplication();
            mapa.remove(sUsuario);
            ActionContext.getContext().setApplication(mapa);
            
            logger.info("Salida del sistema (usuario="+sUsuario+")");
            return SUCCESS;
        } 
        catch (Exception e) 
        {
            logger.error(e.getMessage());
            addActionError(e.getMessage());
            return INPUT;
        }
    }
    
    public UsuarioBE getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBE usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }


    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

}

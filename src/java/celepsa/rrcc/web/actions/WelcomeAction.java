package celepsa.rrcc.web.actions;

import celepsa.rrcc.be.UsuarioBE;
import celepsa.rrcc.bl.UsuarioBL;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pmedina
 */
public class WelcomeAction extends BaseAction implements Preparable{
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
   public String welcome() {
   
        return INPUT;
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




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.web.actions;

import celepsa.rrcc.be.AgrupacionBE;
import celepsa.rrcc.bl.AgrupacionBL;

import com.opensymphony.xwork2.Preparable;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class StakeAgrupacionListAction extends BaseAction implements Preparable {
    private AgrupacionBE agrupacion;
    private List<AgrupacionBE> agrupacions;
    private String textobuscado;
        @Override
    public void prepare() throws Exception {
        super.prepare();
   
        
    }
    
       public String listarStakeAgrupacion() 
    {
        try 
        {
            this.prepararMensaje();
            AgrupacionBL objAgrupacionBL= new AgrupacionBL();
          setAgrupacions(objAgrupacionBL.listarAgrupacion(0));
            
      
            return INPUT;
        } 
        catch (Exception e) 
        {
            addActionError(e.getMessage());;
            return INPUT;
        }
    }
            public String buscarAgrupacions() 
    {
        try 
        {
            this.prepararMensaje();
            AgrupacionBL objAgrupacionBL= new AgrupacionBL();   
            setAgrupacions(objAgrupacionBL.buscarAgrupacion(getTextobuscado()));
            
      
            return INPUT;
        } 
        catch (Exception e) 
        {
            addActionError(e.getMessage());;
            return INPUT;
        }
    }
            
   public String eliminarAgrupacion() {
              try 
        {
           
            AgrupacionBL objAgrupacionBL = new AgrupacionBL();
            objAgrupacionBL.eliminarAgrupacion(getAgrupacion());
           
            addActionMessage("La agrupacion se elimino correctamente");
            
            this.listarStakeAgrupacion();
            
            return INPUT;
        } 
        catch (Exception e) 
        {
            if (e.getMessage().startsWith("*"))
            {
                addActionError(e.getMessage().substring(1));
                this.listarStakeAgrupacion();
            }
            else
            {
                addActionError(e.getMessage());
            }
            return INPUT;
        }
       
    }
           private void prepararMensaje() {
       
    }

    /**
     * @return the agrupacion
     */
    public AgrupacionBE getAgrupacion() {
        return agrupacion;
    }

    /**
     * @param agrupacion the agrupacion to set
     */
    public void setAgrupacion(AgrupacionBE agrupacion) {
        this.agrupacion = agrupacion;
    }

    /**
     * @return the agrupacions
     */
    public List<AgrupacionBE> getAgrupacions() {
        return agrupacions;
    }

    /**
     * @param agrupacions the agrupacions to set
     */
    public void setAgrupacions(List<AgrupacionBE> agrupacions) {
        this.agrupacions = agrupacions;
    }

    /**
     * @return the textobuscado
     */
    public String getTextobuscado() {
        return textobuscado;
    }

    /**
     * @param textobuscado the textobuscado to set
     */
    public void setTextobuscado(String textobuscado) {
        this.textobuscado = textobuscado;
    }

}

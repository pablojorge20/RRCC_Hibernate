/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.web.actions;

import celepsa.rrcc.be.DocumentoBE;
import celepsa.rrcc.be.StakeholderBE;
import celepsa.rrcc.bl.DocumentoBL;
import celepsa.rrcc.bl.StakeholderBL;
import celepsa.rrcc.eh.Tmstakepersona;
import static com.opensymphony.xwork2.Action.INPUT;
import com.opensymphony.xwork2.Preparable;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class DocumentoStakeholder extends BaseAction implements Preparable{
    
     private Tmstakepersona stakeholder;
    private List<Tmstakepersona> stakeholders;
    private DocumentoBE Documento;
    private List<Tmstakepersona> LRemitente;
     @Override
    public void prepare() throws Exception {
        super.prepare();
        
        StakeholderBL objRemitenteBL =  new StakeholderBL() ;
        
           if (getDocumento().getId()== null)
         {
             setLRemitente(objRemitenteBL.listarStakeholder(0));
         }
         else
         {
             setLRemitente(objRemitenteBL.listarStakeholder(Integer.parseInt(getDocumento().getId())));
         }
        
        
    }
     public String listarStakeholder() 
    {
        try 
        {
            this.prepararMensaje();
            StakeholderBL objStakeholderBL= new StakeholderBL();
            setStakeholders(objStakeholderBL.listarStakeholderDoc(getDocumento().getId()));
            
      
            return INPUT;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            addActionError(e.getMessage());
            return INPUT;
        }
    }
     public String eliminarStakeholder() {
              try 
        {
            //CorreoBL objMsgCorreoBL = new CorreoBL();
            StakeholderBL objStakeholderBL = new StakeholderBL();
            StakeholderBL objRemitenteBL =  new StakeholderBL() ;
            objStakeholderBL.eliminarStakeholder(getStakeholder());
            //objMsgCorreoBL.eliminarMsgCorreo(msgCorreo, this.getUsuarioSession());
            addActionMessage("El Documento se elimino correctamente");
            
            setLRemitente(objRemitenteBL.listarStakeholder(Integer.parseInt(getDocumento().getId())));
            this.listarStakeholder();
            
            return INPUT;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            if (e.getMessage().startsWith("*"))
            {
                addActionError(e.getMessage().substring(1));
                this.listarStakeholder();
            }
            else
            {
                addActionError(e.getMessage());
            }
            return INPUT;
        }
       
    }
     public String eliminarStakeholderDocumento() {
              try 
        {
            //CorreoBL objMsgCorreoBL = new CorreoBL();
            StakeholderBL objStakeholderBL = new StakeholderBL();
            StakeholderBL objRemitenteBL =  new StakeholderBL() ;
            objStakeholderBL.eliminarStakeholderDocumento(getStakeholder(), getDocumento()); 
            //objMsgCorreoBL.eliminarMsgCorreo(msgCorreo, this.getUsuarioSession());
            addActionMessage("El Stakeholder se elimino correctamente");
            
           setLRemitente(objRemitenteBL.listarStakeholder(Integer.parseInt(getDocumento().getId())));
            this.listarStakeholder();
            return INPUT;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            if (e.getMessage().startsWith("*"))
            {
                addActionError(e.getMessage().substring(1));
                this.listarStakeholder();
            }
            else
            {
                addActionError(e.getMessage());
            }
            return INPUT;
        }
       
    }
      
      public String grabar()
    {        
        try
        {
            StakeholderBL objSistemaBL = new StakeholderBL();
            StakeholderBL objRemitenteBL =  new StakeholderBL() ;
           // Documento = objSistemaBL.obtenerDocumento(Documento);
            if (Documento.getId().isEmpty() &&    stakeholder.getId() != null )
            {
           addActionMessage("Seleccione  correctamente");
            }
            else
            {
                 objSistemaBL.registrarStakeholderDocumento(stakeholder,Documento );
                 
                addActionMessage("El Documento se grabo correctamente");
                setLRemitente(objRemitenteBL.listarStakeholder(Integer.parseInt(getDocumento().getId())));
            this.listarStakeholder();
               
            }
        }
        catch(Exception e)        
        {
            e.printStackTrace();
            procesarError(e);
        }
      
        
        return INPUT;
     
    }
    private void prepararMensaje() {
       
    } 

    /**
     * @return the stakeholder
     */
    public Tmstakepersona getStakeholder() {
        return stakeholder;
    }

    /**
     * @param stakeholder the stakeholder to set
     */
    public void setStakeholder(Tmstakepersona stakeholder) {
        this.stakeholder = stakeholder;
    }

    /**
     * @return the stakeholders
     */
    public List<Tmstakepersona> getStakeholders() {
        return stakeholders;
    }

    /**
     * @param stakeholders the stakeholders to set
     */
    public void setStakeholders(List<Tmstakepersona> stakeholders) {
        this.stakeholders = stakeholders;
    }

    /**
     * @return the Documento
     */
    public DocumentoBE getDocumento() {
        return Documento;
    }

    /**
     * @param Documento the Documento to set
     */
    public void setDocumento(DocumentoBE Documento) {
        this.Documento = Documento;
    }

    /**
     * @return the LRemitente
     */
    public List<Tmstakepersona> getLRemitente() {
        return LRemitente;
    }

    /**
     * @param LRemitente the LRemitente to set
     */
    public void setLRemitente(List<Tmstakepersona> LRemitente) {
        this.LRemitente = LRemitente;
    }
}

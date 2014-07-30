/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.web.actions;

import celepsa.rrcc.bl.PersonaBL;
import celepsa.rrcc.eh.Tmstakepersona;

import com.opensymphony.xwork2.Preparable;
import java.util.List;

/**
 *
 * @author pmedina
 */
public class StakePersonaListAction extends BaseAction implements Preparable {

    private Tmstakepersona persona;
    private List<Tmstakepersona> personas;
    private String textobuscado;

    @Override
    public void prepare() throws Exception {
        super.prepare();

    }

    public String listarStakePersona() {
        try {
            this.prepararMensaje();
            PersonaBL objPersonaBL = new PersonaBL();
            setPersonas(objPersonaBL.listarPersona(0));

            return INPUT;
        } catch (Exception e) {
            addActionError(e.getMessage());;
            return INPUT;
        }
    }

    public String buscarPersonas() {
        try {
            this.prepararMensaje();
            PersonaBL objPersonaBL = new PersonaBL();
            setPersonas(objPersonaBL.buscarPersonas(getTextobuscado()));

            return INPUT;
        } catch (Exception e) {
            addActionError(e.getMessage());;
            return INPUT;
        }
    }

    public String eliminarPersona() {
        try {

            PersonaBL objPersonaBL = new PersonaBL();
            objPersonaBL.eliminarPersona(persona);

            addActionMessage("La persona se elimino correctamente");

            this.listarStakePersona();

            return INPUT;
        } catch (Exception e) {
            if (e.getMessage().startsWith("*")) {
                addActionError(e.getMessage().substring(1));
                this.listarStakePersona();
            } else {
                addActionError(e.getMessage());
            }
            return INPUT;
        }

    }

    private void prepararMensaje() {

    }

    /**
     * @return the persona
     */
    public Tmstakepersona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Tmstakepersona persona) {
        this.persona = persona;
    }

    /**
     * @return the personas
     */
    public List<Tmstakepersona> getPersonas() {
        return personas;
    }

    /**
     * @param personas the personas to set
     */
    public void setPersonas(List<Tmstakepersona> personas) {
        this.personas = personas;
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

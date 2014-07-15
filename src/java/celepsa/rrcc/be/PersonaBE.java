/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.be;

/**
 *
 * @author pmedina
 */
public class PersonaBE extends StakeholderBE {

    private String Apellido;
    private String Alias;
    private String NroDocumento;
    private TipoDocumentoIdentidadBE TDoumentoIdentidad;
    
    
    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the Alias
     */
    public String getAlias() {
        return Alias;
    }

    /**
     * @param Alias the Alias to set
     */
    public void setAlias(String Alias) {
        this.Alias = Alias;
    }

    /**
     * @return the NroDocumento
     */
    public String getNroDocumento() {
        return NroDocumento;
    }

    /**
     * @param NroDocumento the NroDocumento to set
     */
    public void setNroDocumento(String NroDocumento) {
        this.NroDocumento = NroDocumento;
    }



    /**
     * @return the TDoumentoIdentidad
     */
    public TipoDocumentoIdentidadBE getTDoumentoIdentidad() {
        return TDoumentoIdentidad;
    }

    /**
     * @param TDoumentoIdentidad the TDoumentoIdentidad to set
     */
    public void setTDoumentoIdentidad(TipoDocumentoIdentidadBE TDoumentoIdentidad) {
        this.TDoumentoIdentidad = TDoumentoIdentidad;
    }



}

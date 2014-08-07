package celepsa.rrcc.be;

import java.util.Date;


public class UsuarioBE {
    private String id;
    private String nombres;
    private String apellidos;
    private String cuenta;
    private String clave;
    private String correo;
    private String anexo;
    private String anexoTexto;
    private String telefono;
    private String hostname;
    private String direccionIP;
    private String docIdentidad;
    private byte[] imagen;
    private String imagenBase64;
    private String imagen64;
    
    private Date dateLogin;
    private String fechaLogin;
    private boolean activo;
    private String birthday;
    private String sexo;
    private String empresa;
    private String cargo;
    private String area;
    private String usuarioJabber;
    private String contactoJabber;

    public UsuarioBE(){
        this.nombres = "";
        this.apellidos = "";
        this.cuenta = "";
        this.clave ="";
    }

    public UsuarioBE(String id){
        this.nombres = "";
        this.apellidos = "";
        this.cuenta = "";
        this.clave = "";
    }


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }


    /**
     * @return the anexo
     */
    public String getAnexo() {
        return anexo;
    }

    /**
     * @param anexo the anexo to set
     */
    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @param hostname the hostname to set
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * @return the direccionIP
     */
    public String getDireccionIP() {
        return direccionIP;
    }

    /**
     * @param direccionIP the direccionIP to set
     */
    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    /**
     * @return the docIdentidad
     */
    public String getDocIdentidad() {
        return docIdentidad;
    }

    /**
     * @param docIdentidad the docIdentidad to set
     */
    public void setDocIdentidad(String docIdentidad) {
        this.docIdentidad = docIdentidad;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the imagen
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the imagenBase64
     */
    public String getImagenBase64() {
        return imagenBase64;
    }

    /**
     * @param imagenBase64 the imagenBase64 to set
     */
    public void setImagenBase64(String imagenBase64) {
        this.imagenBase64 = imagenBase64;
    }

    /**
     * @return the dateLogin
     */
    public Date getDateLogin() {
        return dateLogin;
    }

    /**
     * @param dateLogin the dateLogin to set
     */
    public void setDateLogin(Date dateLogin) {
        this.dateLogin = dateLogin;
    }

    /**
     * @return the fechaLogin
     */
    public String getFechaLogin() {
        return fechaLogin;
    }

    /**
     * @param fechaLogin the fechaLogin to set
     */
    public void setFechaLogin(String fechaLogin) {
        this.fechaLogin = fechaLogin;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

        /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the anexoTexto
     */
    public String getAnexoTexto() {
        return anexoTexto;
    }

    /**
     * @param anexoTexto the anexoTexto to set
     */
    public void setAnexoTexto(String anexoTexto) {
        this.anexoTexto = anexoTexto;
    }

    /**
     * @return the usuarioJabber
     */
    public String getUsuarioJabber() {
        return usuarioJabber;
    }

    /**
     * @param usuarioJabber the usuarioJabber to set
     */
    public void setUsuarioJabber(String usuarioJabber) {
        this.usuarioJabber = usuarioJabber;
    }

    /**
     * @return the contactoJabber
     */
    public String getContactoJabber() {
        return contactoJabber;
    }

    /**
     * @param contactoJabber the contactoJabber to set
     */
    public void setContactoJabber(String contactoJabber) {
        this.contactoJabber = contactoJabber;
    }

    /**
     * @return the imagen64
     */
    public String getImagen64() {
        return imagen64;
    }

    /**
     * @param imagen64 the imagen64 to set
     */
    public void setImagen64(String imagen64) {
        this.imagen64 = imagen64;
    }


}

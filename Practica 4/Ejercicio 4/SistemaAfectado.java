public class SistemaAfectado {
    private String mensajeError;
    private Sistema sistema;    //Relacion con Sistema: sirve para indicar cual de los sistemas de la empresa fue el afectado


    public SistemaAfectado(String mensajeError, Sistema sistema) {
        this.mensajeError = mensajeError;
        this.sistema = sistema;
    }


    public String getMensajeError() { return mensajeError; }
    public void setMensajeError(String mensajeError) { this.mensajeError = mensajeError; }

    
    public Sistema getSistema() { return sistema; }
    public void setSistema(Sistema sistema) { this.sistema = sistema; }


    



}

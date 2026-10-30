public class Sistema {

    private int numero; //El enunciado dice que los sistemas fueron relevados generandose una lista codificada en forma numerica de los mismos
    private String nombreAplicacion;
    private boolean desarrolloPropio;   //true = desarrollo propio

    public Sistema(int numero, String nombreAplicacion, boolean desarrolloPropio) {
        this.desarrolloPropio = desarrolloPropio;
        this.nombreAplicacion = nombreAplicacion;
        this.numero = numero;
    }


    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getNombreAplicacion() { return nombreAplicacion; }


    public void setNombreAplicacion(String nombreAplicacion) { this.nombreAplicacion = nombreAplicacion; }
    public boolean isDesarrolloPropio() { return desarrolloPropio; }
    public void setDesarrolloPropio(boolean desarrolloPropio) { this.desarrolloPropio = desarrolloPropio; }


    


}

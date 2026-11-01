public class Oferta {
    private String nombre;
    private String apellido;
    private double montoOfrecido;


    public Oferta(String nombre, String apellido, double montoOfrecido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.montoOfrecido = montoOfrecido;
    }


    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public double getMontoOfrecido() { return montoOfrecido; }


    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setMontoOfrecido(double montoOfrecido) { this.montoOfrecido = montoOfrecido; }

    
    
    
    
    
}

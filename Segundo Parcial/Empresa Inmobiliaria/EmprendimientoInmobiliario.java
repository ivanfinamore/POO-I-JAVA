public class EmprendimientoInmobiliario {
    private String nombre;
    private String ubicacion;
    private double hectareas;


    public EmprendimientoInmobiliario(String nombre, String ubicacion, double hectareas) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.hectareas = hectareas;
    }

    

    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public double getHectareas() { return hectareas; }



    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public void setHectareas(double hectareas) { this.hectareas = hectareas; }


    

    
}

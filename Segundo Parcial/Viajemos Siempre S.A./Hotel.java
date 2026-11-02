public class Hotel {
    private String nombre;
    private String ubicacion;
    private double costoPorDia;



    public Hotel(String nombre, String ubicacion, double costoPorDia) {
        this.costoPorDia = costoPorDia;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }



    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public double getCostoPorDia() { return costoPorDia; }



    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public void setCostoPorDia(double costoPorDia) { this.costoPorDia = costoPorDia; }


    


    


    

}
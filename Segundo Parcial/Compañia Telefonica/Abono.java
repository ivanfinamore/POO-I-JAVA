public class Abono {
    private String nombre;
    private double costoMensual;
    private double gbIncluidos;
    private double precioGbExcedente;


    public Abono(String nombre, double costoMensual, double gbIncluidos, double precioGbExcedente) {
        this.nombre = nombre;
        this.costoMensual = costoMensual;
        this.gbIncluidos = gbIncluidos;
        this.precioGbExcedente = precioGbExcedente;
    }



    
    public String getNombre() { return nombre; }
    public double getCostoMensual() { return costoMensual; }
    public double getGbIncluidos() { return gbIncluidos; }
    public double getPrecioGbExcedente() { return precioGbExcedente; }




    public void setNombre(String nombre) { this.nombre = nombre;}
    public void setCostoMensual(double costoMensual) { this.costoMensual = costoMensual; }
    public void setGbIncluidos(double gbIncluidos) { this.gbIncluidos = gbIncluidos; }
    public void setPrecioGbExcedente(double precioGbExcedente) { this.precioGbExcedente = precioGbExcedente; }



    

    


    
}
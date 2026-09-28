public class Zapatilla{
    protected int codigo;
    protected String marca;
    protected double talle;
    protected double costoFabricacion;
    protected double costoMateriales;

    public Zapatilla(int codigo, String marca, double talle, double costoFabricacion, double costoMateriales){
        this.codigo = codigo;
        this.marca = marca;
        this.talle = talle;
        this.costoFabricacion = costoFabricacion;
        this.costoMateriales = costoMateriales;
    }



    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }



    public double getTalle(){
        return talle;
    }

    public void setTalle(double talle){
        this.talle = talle;
    }



    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public double getCostoMateriales(){
        return costoMateriales;
    }

    public void setCostoMateriales(double costoMateriales){
        this.costoMateriales = costoMateriales;
    }




    public double calcularCostoTotal(){
        return (costoFabricacion + costoMateriales);
    }

    public double calcularPrecioVenta(double valorFijo){
        return (calcularCostoTotal() + valorFijo);
    }

}
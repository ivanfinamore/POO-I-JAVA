public class Urbana extends Zapatilla{
    private String estilo;
    private static double descuentoLiquidacion;

    public Urbana(int codigo, String marca, double talle, double costoFabricacion, double costoMateriales, 
                  String estilo){
        
        super(codigo, marca, talle, costoFabricacion, costoMateriales);
        this.estilo = estilo;
    }

    public static void setDescuentoLiquidacion(double descuentoLiquidacion){
        Urbana.descuentoLiquidacion = descuentoLiquidacion;
    }

    public String getEstilo(){
        return estilo;
    }

    public void setEstilo(String estilo){
        this.estilo = estilo;
    }

    @Override
    public double calcularCostoTotal(){
        return (super.calcularCostoTotal() - descuentoLiquidacion);
    }

}
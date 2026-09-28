public class Terrestre extends Pasaje{
    private String empresa;
    private static double descuentoTemporadaBaja;

    public Terrestre(int codigo, String destino, String fechaSalida, double tarifaBase, double costoBase, String empresa){
        super(codigo,destino,fechaSalida,tarifaBase,costoBase);
        this.empresa = empresa;
    }

    public static void setDescuentoTemporadaBaja(double descuentoTemporadaBaja){
        Terrestre.descuentoTemporadaBaja = descuentoTemporadaBaja;
    }

    public static double getDescuentoTemporadaBaja() {
        return descuentoTemporadaBaja;
    }

    public String getEmpresa(){
        return empresa;
    }

    public void setEmpresa(String empresa){
        this.empresa = empresa;
    }

    @Override
    public double calcularCostoTotal(){
        return (super.calcularCostoTotal() - descuentoTemporadaBaja);
    }


}
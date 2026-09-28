public class Escolar extends Remera{
    private String nombreInstituto;
    private double descuentoPromocional;

    public Escolar(int codigo, String nombreModelo, String temporada, int costoManoObra, int costoMateriaPrima, String nombreInstituto){
        
        super(codigo,nombreModelo,temporada,costoManoObra,costoMateriaPrima);
        this.nombreInstituto = nombreInstituto;
        this.descuentoPromocional = descuentoPromocional;

    }

    public void setDescuentoPromocional(double descuento){
        descuentoPromocional = descuento;
    }

    @Override
    public double calcularCostoTotal(){
        return super.calcularCostoTotal() - descuentoPromocional;
    }
}
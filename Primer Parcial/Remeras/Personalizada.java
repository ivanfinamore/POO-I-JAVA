public class Personalizada extends Remera{
    private boolean conFoto;
    private int cantidadSolicitada;
    private double porcDescuentoVolumen;

    public Personalizada (int codigo, String nombreModelo, String temporada, double costoManoObra, 
           double costoMateriaPrima, boolean conFoto, int cantidadSolicitada, double porcDescuentoVolumen){

        super(codigo,nombreModelo,temporada,costoManoObra,costoMateriaPrima);
        this.conFoto = conFoto;
        this.cantidadSolicitada = cantidadSolicitada;
        this.porcDescuentoVolumen = porcDescuentoVolumen;

    }

    @Override
    public double calcularCostoTotal(){
        if(cantidadSolicitada > 12){
            return (super.costoManoObra * (1 - (porcDescuentoVolumen / 100)) + super.costoMateriaPrima);
        }
        return super.costoManoObra + super.costoMateriaPrima;
    }
}
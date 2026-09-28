public class DeportivaConDryFit extends Deportiva{
    private double porcAdicionalDryFit;

    public DeportivaConDryFit(int codigo, String nombreModelo, String temporada, 
                              double costoManoObra, double costoMateriaPrima, String nombreClub, 
                              double porcAdicionalDryFit){
        super(codigo, nombreModelo, temporada, costoManoObra, costoMateriaPrima, nombreClub);
        this.porcAdicionalDryFit = porcAdicionalDryFit;
    }   

    @Override
    public double calcularCostoTotal(){
        return (super.calcularCostoTotal()*(1+(porcAdicionalDryFit/100)));
    }
}
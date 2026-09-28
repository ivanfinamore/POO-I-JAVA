public class AereoPrimeraClase extends Aereo{
    private double porcAdicionalPrimera;

    public AereoPrimeraClase(int codigo, String destino, String fechaSalida, double tarifaBase, 
                             double costoBase, String aerolinea, double porcAdicionalPrimera){

        super(codigo, destino, fechaSalida, tarifaBase, costoBase, aerolinea);
        this.porcAdicionalPrimera = porcAdicionalPrimera;

    }

    public double getPorcAdicionalPrimera(){
        return porcAdicionalPrimera;
    }

    public void setPorcAdicionalPrimera(double porcAdicionalPrimera){
        this.porcAdicionalPrimera = porcAdicionalPrimera;
    }

    @Override
    public double calcularCostoTotal(){
        return (super.calcularCostoTotal() * (1 + (porcAdicionalPrimera / 100)));
    }

}
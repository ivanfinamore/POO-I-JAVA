public class PorEncargo extends Zapatilla{
    private boolean conGrabado;
    private int paresSolicitados;
    private double porcDescuentoMayorista;

    public PorEncargo(int codigo, String marca, double talle, double costoFabricacion, double costoMateriales, 
                      boolean conGrabado, int paresSolicitados, double porcDescuentoMayorista){
        
        super(codigo, marca, talle, costoFabricacion, costoMateriales);
        this.conGrabado = conGrabado;
        this.paresSolicitados = paresSolicitados;
        this.porcDescuentoMayorista = porcDescuentoMayorista;

    }

    public boolean getConGrabado(){
        return conGrabado;
    }

    public void setConGrabado(boolean conGrabado){
        this.conGrabado = conGrabado;
    }

    @Override
    public double calcularCostoTotal(){

        if(paresSolicitados > 20){

            return(super.costoFabricacion * (1 - (porcDescuentoMayorista / 100)) + super.costoMateriales);
        }

        return super.calcularCostoTotal();
    }
}
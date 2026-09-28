public class RunningConAmortiguacion extends Running{
    private double porcAdicionalAmortiguacion;

    public RunningConAmortiguacion(int codigo, String marca, double talle, double costoFabricacion, 
                   double costoMateriales, String tipoPisada, double porcAdicionalAmortiguacion){

        super(codigo,marca,talle,costoFabricacion,costoMateriales,tipoPisada);
        this.porcAdicionalAmortiguacion = porcAdicionalAmortiguacion;

    }

    public double getPorcAdicionalAmortiguacion(){
        return porcAdicionalAmortiguacion;
    }

    public void setPorcAdicionalAmortiguacion(double porcAdicionalAmortiguacion){
        this.porcAdicionalAmortiguacion = porcAdicionalAmortiguacion;
    }

    @Override
    public double calcularCostoTotal(){

        return (super.calcularCostoTotal() * (1 + porcAdicionalAmortiguacion / 100));
    
    }

}
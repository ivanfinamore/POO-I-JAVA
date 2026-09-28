public class Running extends Zapatilla{
    protected String tipoPisada;

    public Running(int codigo, String marca, double talle, double costoFabricacion, 
                   double costoMateriales, String tipoPisada){

        super(codigo, marca, talle, costoFabricacion, costoMateriales);
        this.tipoPisada = tipoPisada;

    }

    public String getTipoPisada(){
        return tipoPisada;
    }

    public void setTipoPisada(String tipoPisada){
        this.tipoPisada = tipoPisada;
    }

}
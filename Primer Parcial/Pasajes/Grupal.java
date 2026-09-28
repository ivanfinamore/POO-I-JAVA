public class Grupal extends Pasaje{
    private boolean conSeguro;
    private int cantidadPasajeros;
    private double porcDescuentoGrupo;

    public Grupal(int codigo, String destino, String fechaSalida, double tarifaBase, double costoBase, 
                  boolean conSeguro, int cantidadPasajeros, double porcDescuentoGrupo){
        
        super(codigo, destino, fechaSalida, tarifaBase, costoBase);
        this.conSeguro = conSeguro;
        this.cantidadPasajeros = cantidadPasajeros;
        this.porcDescuentoGrupo = porcDescuentoGrupo;

    }

    public int getCantidadPasajeros(){
        return cantidadPasajeros;
    }

    public boolean isConSeguro() {
        return conSeguro;
    }

    public double getPorcDescuentoGrupo() {
        return porcDescuentoGrupo;
    }


    public void setCantidadPasajeros(int cantidadPasajeros){
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public void setConSeguro(boolean conSeguro) {
        this.conSeguro = conSeguro;
    }

    public void setPorcDescuentoGrupo(double porcDescuentoGrupo) {
        this.porcDescuentoGrupo = porcDescuentoGrupo;
    }

    @Override
    public double calcularCostoTotal(){
        if(cantidadPasajeros > 10){
            return (super.calcularCostoTotal() * (1 - (porcDescuentoGrupo / 100)));
        }
        return super.calcularCostoTotal();
    }


}
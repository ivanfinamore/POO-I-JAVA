public abstract class Pasaje{
    protected int codigo;
    protected String destino;
    protected String fechaSalida;
    protected double tarifaBase;
    protected double costoBase;

    public Pasaje(int codigo, String destino, String fechaSalida, double tarifaBase, double costoBase){
        this.codigo = codigo;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.tarifaBase = tarifaBase;
        this.costoBase = costoBase;
    } 

    public int getCodigo() {
        return codigo;
    }

    public String getDestino() {
        return destino;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public double getCostoBase() {
        return costoBase;
    }



    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }
    



    public double calcularCostoTotal(){
        return (tarifaBase + costoBase);
    }

    public double calcularPrecioVenta(double valorFijo){
        return (calcularCostoTotal() + valorFijo);
    }


}
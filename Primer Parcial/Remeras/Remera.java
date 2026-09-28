public class Remera {
    protected int codigo;
    protected String nombreModelo;
    protected String temporada;
    protected double costoManoObra;
    protected double costoMateriaPrima;

    public Remera(int codigo, String nombreModelo, String temporada, double costoManoObra, double costoMateriaPrima){
        this.codigo = codigo;
        this.nombreModelo = nombreModelo;
        this.temporada = temporada;
        this.costoManoObra = costoManoObra;
        this.costoMateriaPrima = costoMateriaPrima;
    }

    public double calcularCostoTotal(){
        return (costoManoObra + costoMateriaPrima);
    }

    public double calcularPrecioVenta(double valorFijo){
        return (valorFijo + calcularCostoTotal());
    }

    public String getNombreModelo(){
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo){
        this.nombreModelo = nombreModelo;
    }

    public double getCostoManoObra(){
        return costoManoObra;
    }

    public void setCostoManoObra(double costoManoObra){
        this.costoManoObra = costoManoObra;
    }

    public String getTemporada(){
        return temporada;
    }

    public void setTemporada(String temporada){
        this.temporada = temporada;
    }

}
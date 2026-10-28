//Talle de un modelo de remera
public class Talle {
    private int numero;
    private double largo;
    private double ancho;
    private double porcentajeAdicional;

    //Constructor
    public Talle(int numero, double largo, double ancho, double porcentajeAdicional) {
        this.numero = numero;
        this.largo = largo;
        this.ancho = ancho;
        this.porcentajeAdicional = porcentajeAdicional;
    }


    //getters
    public int getNumero() {
        return numero;
    }
    public double getLargo() {
        return largo;
    }
    public double getAncho() {
        return ancho;
    }
    public double getPorcentajeAdicional() {
        return porcentajeAdicional;
    }

    

    //setters
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setLargo(double largo) {
        this.largo = largo;
    }
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    public void setPorcentajeAdicional(double porcentajeAdicional) {
        this.porcentajeAdicional = porcentajeAdicional;
    }

    //Metodo para inciso f). Recibe parametros porque el talle no sabe a que modelo pertenece: la relacion va de Modelo a Talle
    //El modelo le debe pasar su costo basico total y su materia prima
    public double calcularCosto(double costoMateriaPrima, double costoBasicoTotal){
        return costoBasicoTotal + (costoMateriaPrima * (porcentajeAdicional / 100));
    }

    
}

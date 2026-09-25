public class Circulo extends FiguraGeometrica{
    double radio;

    public Circulo(String color, double radio){
        super(color);
        this.radio = radio;
    }

    @Override                           
    public double calcularArea(){
        return Math.PI * radio* radio;
    }
}

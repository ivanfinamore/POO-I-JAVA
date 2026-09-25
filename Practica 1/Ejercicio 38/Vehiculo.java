public abstract class Vehiculo {
    private int velocidad;

    public Vehiculo(){
        this.velocidad = 0;
    }

    public void acelerar(int incremento){
        if(incremento > 0){
            velocidad+=incremento;
        }
    }

    public int getVelocidad(){
        return velocidad;
    }
}

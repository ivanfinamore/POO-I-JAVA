public abstract class Carta{
    protected String nombre;
    protected int valor;

    public Carta(String nombre, int valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    public String mostrar(){
        return valor+ ("de: ") +nombre;
    }
}
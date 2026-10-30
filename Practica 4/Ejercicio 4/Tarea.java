import java.time.LocalDate;

public class Tarea {
    private final LocalDate fecha;  //Es final porque es un atributo cuyo valor no debe cambiar despues de crear el objeto.
    private String descripcion; 
    private int duracionEnMinutos;


    public Tarea(String descripcion, int duracionEnMinutos, LocalDate fecha) {
        this.descripcion = descripcion;
        this.duracionEnMinutos = duracionEnMinutos;
        this.fecha = LocalDate.now();
    }

    public LocalDate getFecha() { return fecha; }
    public String getDescripcion() { return descripcion; }
    public int getDuracionEnMinutos() { return duracionEnMinutos; }


    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setDuracionEnMinutos(int duracionEnMinutos) { this.duracionEnMinutos = duracionEnMinutos; }
    //No hace falta poner el setter de la fecha del registro porque esta la pone el constructor solo, con LocalDate.now(), 
    // en el momento en que el tecnico registra la tarea



    


    


}

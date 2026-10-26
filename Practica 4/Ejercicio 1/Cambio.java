import java.time.LocalDate;

//Cambio que puede surgir en el diseño durante la fabricacion
public class Cambio {
    private LocalDate fecha;
    private String comentario;

    //Constructor
    public Cambio(String comentario) {
        this.fecha = LocalDate.now();   //Se registra la fecha al realizar el cambio. No es necesario pedirsela al usuario, el programa la obtiene solo.
        this.comentario = comentario;
    }

    
    //getters
    public LocalDate getFecha() {
        return fecha;
    }
    public String getComentario() {
        return comentario;
    }


    //setters
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    

    
    
}

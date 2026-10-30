import java.time.LocalDate;
import java.util.ArrayList;

public class IncidenteSoftware extends Incidente {

    private ArrayList<SistemaAfectado> sistemas; //Relacion con sistemas afectados (El enunciado pide, para los incidentes de software, indicar los sistemas donde se encontraron inconvenientes)


    public IncidenteSoftware(LocalDate fechaIncidente, String formaReporte, boolean esUrgente, 
                             String comentario, Empleado informante, Empleado tecnico, ArrayList<SistemaAfectado> sistemas) {

        super(fechaIncidente, formaReporte, esUrgente, comentario, informante, tecnico);   //Herencia. Los 4 atributos restantes los resuelve el constructor de Incidente, que se ejecuta cuando la subclase (esta) hace super

        this.sistemas = sistemas;

    }


    public ArrayList<SistemaAfectado> getSistemas() { return sistemas; }

    
    public void setSistemas(ArrayList<SistemaAfectado> sistemas) { this.sistemas = sistemas; }


    
    
    
}

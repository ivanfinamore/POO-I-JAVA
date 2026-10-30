import java.time.LocalDate;
import java.util.ArrayList;

public class IncidenteHardware extends Incidente {

    private String direccionIP;
    private ArrayList<String> repuestos;    //Puede quedar vacia



    public IncidenteHardware(LocalDate fechaIncidente, String formaReporte, boolean esUrgente, 
                             String comentario, Empleado informante, Empleado tecnico, String direccionIP, ArrayList<String> repuestos) {

        super(fechaIncidente, formaReporte, esUrgente, comentario, informante, tecnico);  //Herencia. Los 4 atributos restantes los resuelve el constructor de Incidente, que se ejecuta cuando la subclase (esta) hace super

        this.direccionIP = direccionIP;
        this.repuestos = repuestos;

    }

    
    public String getDireccionIP() { return direccionIP; }
    public ArrayList<String> getRepuestos() { return repuestos; }


    public void setDireccionIP(String direccionIP) { this.direccionIP = direccionIP; }
    public void setRepuestos(ArrayList<String> repuestos) { this.repuestos = repuestos; }




    



}

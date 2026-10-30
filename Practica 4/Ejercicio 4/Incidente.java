import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Incidente {

    //Los atributos can como protected porque es una superclase
    protected static int proximoNumero = 1001;

    protected final int numero;            //Es final porque es un atributo cuyo valor no debe cambiar despues de crear el objeto. Recibe su valor una vez: en declaracion o constructor
    protected LocalDate fechaIncidente;    //Es final porque es un atributo cuyo valor no debe cambiar despues de crear el objeto. Por eso no permite setter.
    protected final LocalDate fechaRegistro;
    protected String formaReporte;
    protected boolean esUrgente; 
    protected boolean resuelto;
    protected String comentario;

    //Aqui vienen las relaciones
    protected ArrayList<Tarea> tareas;    //Relacion: tareas realizadas (arreglo dinamico de clase 'Tarea')
    protected Empleado informante;        //Relacion: quien informa el incidente
    protected Empleado tecnico;           //Relacion: quien se encarga de solucionar el incidente



    //Varios atributos no llevan parametros, sino que son definidos, porque su valor inicial no lo decide quien crea el incidente, sino el propio enunciado
    public Incidente(LocalDate fechaIncidente, String formaReporte, boolean esUrgente, 
                    String comentario, Empleado informante, Empleado tecnico) {

        this.comentario = comentario;
        this.esUrgente = esUrgente;
        this.fechaIncidente = fechaIncidente;
        this.fechaRegistro = LocalDate.now();
        this.formaReporte = formaReporte;
        this.informante = informante;
        this.numero = proximoNumero;
        proximoNumero++;
        this.resuelto = false;            //Permanece en false hasta que se resuelve
        this.tareas = new ArrayList<>();  //Arranca sin tareas
        this.tecnico = tecnico;
    }

    
    public int getNumero() { return numero; }
    public LocalDate getFechaIncidente() { return fechaIncidente; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public String getFormaReporte() { return formaReporte; }
    public boolean isEsUrgente() { return esUrgente; }
    public boolean isResuelto() { return resuelto; }
    public String getComentario() { return comentario; }
    public ArrayList<Tarea> getTareas() { return tareas; }
    public Empleado getInformante() { return informante; }
    public Empleado getTecnico() { return tecnico; }


 
    public void setFechaIncidente(LocalDate fechaIncidente) { this.fechaIncidente = fechaIncidente; }
    public void setFormaReporte(String formaReporte) { this.formaReporte = formaReporte; }
    public void setEsUrgente(boolean esUrgente) { this.esUrgente = esUrgente; }
    public void setResuelto(boolean resuelto) { this.resuelto = resuelto; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public void setTareas(ArrayList<Tarea> tareas) { this.tareas = tareas; }
    public void setInformante(Empleado informante) { this.informante = informante; }
    public void setTecnico(Empleado tecnico) { this.tecnico = tecnico; }

    

    


    
    


    



}

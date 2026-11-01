import java.time.LocalDate;

public class Consumo {
    private final LocalDate fecha;
    private double gbVideo;
    private double gbMensajes;

    public static final double LIMITE_GB_MENSAJES = 570;
    



    public Consumo(double gbVideo, double gbMensajes) {
        this.fecha = LocalDate.now();
        this.gbVideo = gbVideo;
        this.gbMensajes = gbMensajes;
    }




    
    public LocalDate getFecha() { return fecha; }
    public double getGbVideo() { return gbVideo; }
    public double getGbMensajes() { return gbMensajes; }



    public void setGbVideo(double gbVideo) { this.gbVideo = gbVideo; }
    public void setGbMensajes(double gbMensajes) { this.gbMensajes = gbMensajes; }


    
    public boolean esValida(){
        return (gbMensajes < LIMITE_GB_MENSAJES); //Retorna true si la cantidad de gb en mensajes es menor al limite
    }
    


    
}

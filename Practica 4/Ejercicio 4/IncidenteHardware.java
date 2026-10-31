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





    //Me sirve para el inciso j)
    public static boolean esIpValida(String ip){
        String[] partes = ip.split("\\.");  //Divido la ip en partes, cada una representada entre puntos. Esto me va a servir para validarla
        

        //1ª condicion de una ip: Toda ipv4 se compone de 4 partes - 4 grupos de numeros. Si hay mas o menos, no es ip.
        if(partes.length != 4){
            return false;           
        }

        
        for(String parte : partes){     //Evaluo cada parte de la ip (cada grupo de numeros) por separado


            //2ª y 3ª condicion: No puede haber partes vacias (no haber numeros, o sea dos puntos seguidos), ni tampoco puede esta superar las 3 cifras.
            if (parte.isEmpty() || parte.length() > 3){     
                return false;
            }


            //4ª condicion: cada parte no puede ser mayor a 255 ya que se completa el octeto de bits.
            if(Integer.parseInt(parte) > 255){
                return false;
            }

            
            for(char c : parte.toCharArray()){  //Evaluo cada digito de la ip

                //5ª condicion: si un digito de la parte evaluada no es un numero, no es una ip.
                if(!Character.isDigit(c)){
                    return false;
                }
            }

        }

        return true; //Si no presenta las anomalias de las condiciones, es una ip valida.
    
    
    }

    //Lo que devuelve incidente de tipo hardware cuando le piden por equipo afectado (polimorfismo)
    @Override 
    public String getAfectado(){
        return "Equipo " +direccionIP;
    }


    



}

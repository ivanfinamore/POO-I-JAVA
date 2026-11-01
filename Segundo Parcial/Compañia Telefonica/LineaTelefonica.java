import java.util.ArrayList;

public class LineaTelefonica {
    
    private String nombreTitular;
    private String numeroLinea;

    //Asociacion con abono
    private Abono abonoContratado;

    //Asociacion con consumo
    private final ArrayList<Consumo> consumos;



    public LineaTelefonica(String nombreTitular, String numeroLinea, Abono abonoContratado) {
        this.nombreTitular = nombreTitular;
        this.numeroLinea = numeroLinea;
        this.abonoContratado = abonoContratado;
        this.consumos = new ArrayList<>();      //La linea telefonica arranca sin consumos, con el tiempo estos se van agregando
                                                //Primero debe existir la linea telefonica, el objeto. 
                                                //Por eso no es un parametro para el constructor del objeto
    }




    public String getNombreTitular() { return nombreTitular; }
    public String getNumeroLinea() { return numeroLinea; }
    public Abono getAbonoContratado() { return abonoContratado; }
    public ArrayList<Consumo> getConsumos() { return consumos; }



    public void setNombreTitular(String nombreTitular) { this.nombreTitular = nombreTitular; }
    public void setNumeroLinea(String numeroLinea) { this.numeroLinea = numeroLinea; }
    public void setAbonoContratado(Abono abonoContratado) { this.abonoContratado = abonoContratado; }
    //Los consumos no llevan setters porque estos se agregan de a uno, y el setter reemplaza la lista entera. No nos sirve


    //Me sirve para el inciso b). Obtengo los gb totales consumidos
    public double getGbConsumidos(){
        double total = 0;

        for(Consumo c : consumos){
            total += c.getGbMensajes() + c.getGbVideo();
        }

        return total;
        
    }


    //Me sirve para el inciso b). Obtengo los gb consumidos que se exceden del pactado
    public double getGbExcedentes(){
        double excedente = getGbConsumidos() - abonoContratado.getGbIncluidos();

        if(excedente < 0){
            return 0;
        }

        return excedente;
        
    }


    //Me sirve para el inciso b). Obtengo el precio total de la linea a pagar
    public double totalApagar(){
        return ( abonoContratado.getCostoMensual() + (abonoContratado.getPrecioGbExcedente() * getGbExcedentes()) );
    }
    

    




}

import java.time.LocalDate;
import java.util.ArrayList;

//Modelo de remera
public class Modelo {
    public static  String temporada = "Invierno"; //es un atributo estatico: es el mismo valor para TODOS los modelos

    
    private int codigo;
    private String tela;
    private double costoMateriaPrima;
    private double costoManoObra;
    private boolean esMusculosa;
    private LocalDate fechaConfeccion;
    private ArrayList<String> colores;
    
    //aqui van las relaciones
    private Talle[] talles;
    private Empresa bordado;
    private ArrayList<Empresa> disenadoras;
    private Cambio cambio;

    //constructor
    public Modelo(int codigo, String tela, double costoMateriaPrima, double costoManoObra, 
                  boolean esMusculosa, LocalDate fechaConfeccion, Talle[] talles, 
                  ArrayList<String> colores, Empresa bordado, ArrayList<Empresa> disenadoras) {

        this.bordado = bordado;
        this.cambio = null;         //el cambio "puede surgir durante la fabricacion". Ocurre despues de la fabricacion y no siempre existe
        this.codigo = codigo;
        this.colores = colores;
        this.costoManoObra = costoManoObra;
        this.costoMateriaPrima = costoMateriaPrima;
        this.disenadoras = disenadoras;
        this.esMusculosa = esMusculosa;
        this.fechaConfeccion = fechaConfeccion;
        this.talles = talles;
        this.tela = tela;
    }

    //getters - Temporada no necesita porque es public, se accede desde el main
    public int getCodigo() {
        return codigo;
    }
    public String getTela() {
        return tela;
    }
    public double getCostoMateriaPrima() {
        return costoMateriaPrima;
    }
    public double getCostoManoObra() {
        return costoManoObra;
    }
    public boolean isEsMusculosa() {
        return esMusculosa;
    }
    public LocalDate getFechaConfeccion() {
        return fechaConfeccion;
    }
    public ArrayList<String> getColores() {
        return colores;
    }
    public Talle[] getTalles() {
        return talles;
    }
    public Empresa getBordado() {
        return bordado;
    }
    public ArrayList<Empresa> getDisenadoras() {
        return disenadoras;
    }
    public Cambio getCambio() {
        return cambio;
    }
    public static String getTemporada() {
        return temporada;
    }
    


    //setters
    public static void setTemporada(String temporada) {
        Modelo.temporada = temporada;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setTela(String tela) {
        this.tela = tela;
    }
    public void setCostoMateriaPrima(double costoMateriaPrima) {
        this.costoMateriaPrima = costoMateriaPrima;
    }
    public void setCostoManoObra(double costoManoObra) {
        this.costoManoObra = costoManoObra;
    }
    public void setEsMusculosa(boolean esMusculosa) {
        this.esMusculosa = esMusculosa;
    }
    public void setFechaConfeccion(LocalDate fechaConfeccion) {
        this.fechaConfeccion = fechaConfeccion;
    }
    public void setColores(ArrayList<String> colores) {
        this.colores = colores;
    }
    public void setTalles(Talle[] talles) {
        this.talles = talles;
    }
    public void setBordado(Empresa bordado) {
        this.bordado = bordado;
    }
    public void setDisenadoras(ArrayList<Empresa> disenadoras) {
        this.disenadoras = disenadoras;
    }
    public void setCambio(Cambio cambio) {
        this.cambio = cambio;
    }



    //Metodos para el inciso c)
    public double getCostoBordado(){
        if (bordado!=null){                   //De antemano pregunto si es null, de otra forma explotaria con null pointer exception
            return bordado.getCostoServicio();
        }
        return 0;
    }

    public double getCostoDiseno(){
        double total = 0;
        for(Empresa e : disenadoras){
            total += e.getCostoServicio();
        }
        return total;
    }

    public double getCostoBasicoTotal(){
        return costoMateriaPrima + costoManoObra + getCostoBordado() + getCostoDiseno();
    }





    

    

    

}

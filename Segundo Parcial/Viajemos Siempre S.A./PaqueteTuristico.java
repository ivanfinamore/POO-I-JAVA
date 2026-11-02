import java.time.LocalDate;
import java.util.ArrayList;


public class PaqueteTuristico {
    protected String nombre;
    protected int codigo;
    protected String destinoPrincipal;
    protected int duracionEnDias;
    protected double precioVenta;
    protected LocalDate fechaLanzamiento;

    //Composicion: el paquete turistico se compone de una o mas estadias
    protected ArrayList<Estadia> estadias;



    public PaqueteTuristico(String nombre, int codigo, String destinoPrincipal, 
                            int duracionEnDias, double precioVenta) {
                                
        this.codigo = codigo;
        this.destinoPrincipal = destinoPrincipal;
        this.duracionEnDias = duracionEnDias;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.fechaLanzamiento = LocalDate.now(); //fecha del sistema cuando se crea el objeto
        this.estadias = new ArrayList<>();      //Al crear el objeto, se crea el espacio de memoria para la lista de estadias. 
                                                //La composicion se observa en el hecho que, cuando deja de existir el paquete turistico, dejan de existir las estadias

    }




    public String getNombre() { return nombre; }
    public int getCodigo() { return codigo; }
    public String getDestinoPrincipal() { return destinoPrincipal; }
    public int getDuracionEnDias() { return duracionEnDias; }
    public double getPrecioVenta() { return precioVenta; }
    public LocalDate getFechaLanzamiento() { return fechaLanzamiento; }
    public ArrayList<Estadia> getEstadias() { return estadias; }




    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public void setDestinoPrincipal(String destinoPrincipal) { this.destinoPrincipal = destinoPrincipal; }
    public void setDuracionEnDias(int duracionEnDias) { this.duracionEnDias = duracionEnDias; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }


    public int getTotalNoches(){
        int totalNoches = 0;
        for (Estadia e : estadias){
            totalNoches += e.getCantNoches();
        }

        return totalNoches;
    }


    public boolean tieneSoloEstadiasCortas(){
        for (Estadia e : estadias){
            if (e.getCantNoches() >= 3) {
                return false;
            }
        }

        return true;
    }

    public boolean esRentable(){
        double costo = 0;
        for (Estadia e : estadias) {
            costo += e.getHotel().getCostoPorDia() * e.getCantNoches();
        }

        return ((precioVenta - costo) > 0);
    }

    





}
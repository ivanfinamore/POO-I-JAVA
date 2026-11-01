import java.util.ArrayList;

public class Lote {
    private int codigo;
    private double precioBase;
    private boolean admiteFinanciacion;

    //Relacion del lote con el emprendimiento inmobiliario
    private EmprendimientoInmobiliario emprendimiento;
    
    //Relacion del lote con sus ofertas
    private final ArrayList<Oferta> ofertas;    //Lleva final porque no puede ser reemplazada completa la lista de ofertas (por eso no hay setter)


    public Lote(int codigo, double precioBase, boolean admiteFinanciacion, EmprendimientoInmobiliario emprendimiento) {
        this.codigo = codigo;
        this.precioBase = precioBase;
        this.admiteFinanciacion = admiteFinanciacion;
        this.emprendimiento = emprendimiento;
        this.ofertas = new ArrayList<>();   //La lista de ofertas arranca vacia. No va como parametro por los siguientes motivos:
                                            //1) Cuando se crea el lote, todavia no tiene ofertas
                                            //2) Para validar una oferta, primero tiene que existir el lote
                                            //3) Va como parámetro lo que se conoce al crear el objeto y viene de afuera

    }



    public int getCodigo() { return codigo; }
    public double getPrecioBase() { return precioBase; }
    public boolean isAdmiteFinanciacion() { return admiteFinanciacion; }
    public EmprendimientoInmobiliario getEmprendimiento() { return emprendimiento; }
    public ArrayList<Oferta> getOfertas() { return ofertas; }



    public void setCodigo(int codigo) { this.codigo = codigo; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }
    public void setAdmiteFinanciacion(boolean admiteFinanciacion) { this.admiteFinanciacion = admiteFinanciacion; }
    public void setEmprendimiento(EmprendimientoInmobiliario emprendimiento) { this.emprendimiento = emprendimiento; }
    
    
    public boolean esOfertaValida(Oferta of){
        return of.getMontoOfrecido() >= precioBase;  //retorna true si el monto ofrecido es mayor o igual al precio base
    }

    public Oferta getOfertaGanadora(){
        Oferta ganadora = null;     //sirve para que al principio ninguna sea la ganadora

        for(Oferta of : ofertas){
            if(ganadora == null || of.getMontoOfrecido() > ganadora.getMontoOfrecido()){    //si no se analizo ninguna oferta o si la oferta evaluada es mayor a la ganadora
                ganadora = of;                                                              //la oferta evaluada pasa a ser la nueva ganadora
            }
        }

        return ganadora;
    }


    
    
}

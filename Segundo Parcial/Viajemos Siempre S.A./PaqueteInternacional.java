public class PaqueteInternacional extends PaqueteTuristico {
    private String companiaAerea;
    private double precioAdicional;


    public PaqueteInternacional(String nombre, int codigo, String destinoPrincipal, int duracionEnDias, 
                                double precioVenta, String companiaAerea, double precioAdicional) {

        super(nombre, codigo, destinoPrincipal, duracionEnDias, precioVenta);   //Herencia
        this.companiaAerea = companiaAerea;
        this.precioAdicional = precioAdicional;
    }



    public String getCompaniaAerea() { return companiaAerea; }
    public double getPrecioAdicional() { return precioAdicional; }



    public void setCompaniaAerea(String companiaAerea) { this.companiaAerea = companiaAerea; }
    public void setPrecioAdicional(double precioAdicional) { this.precioAdicional = precioAdicional; }


    @Override
    public boolean esRentable(){
        double costo = 0;
        for (Estadia e : estadias) {
            costo += e.getHotel().getCostoPorDia() * e.getCantNoches();
        }

        return ((precioVenta + precioAdicional - costo) > 0);
    }



    


}
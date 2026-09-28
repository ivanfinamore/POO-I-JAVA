public class Aereo extends Pasaje{
    protected String aerolinea;

    public Aereo(int codigo, String destino, String fechaSalida, double tarifaBase, double costoBase, 
                 String aerolinea){

        super(codigo, destino, fechaSalida, tarifaBase, costoBase);
        this.aerolinea = aerolinea;

    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }


}
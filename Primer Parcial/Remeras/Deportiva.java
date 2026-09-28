public class Deportiva extends Remera{
    protected String nombreClub;

    public Deportiva(int codigo, String nombreModelo, String temporada, 
                     double costoManoObra, double costoMateriaPrima, String nombreClub){
        super(codigo, nombreModelo, temporada, costoManoObra, costoMateriaPrima);
        this.nombreClub = nombreClub;
    }


}
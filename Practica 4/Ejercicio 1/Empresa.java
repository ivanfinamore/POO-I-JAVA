//Empresa externa de la nomina
public class Empresa {
    private String cuit;
    private String razonSocial;
    private double CostoServicio;
    private String telefono; //miembro adicional

    //Constructor
    public Empresa(String cuit, String razonSocial, double costoServicio, String telefono) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        CostoServicio = costoServicio;
        this.telefono = telefono;
    }

    //getters
    public String getCuit() {
        return cuit;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    public double getCostoServicio() {
        return CostoServicio;
    }
    public String getTelefono() {
        return telefono;
    }


    //setters
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public void setCostoServicio(double costoServicio) {
        CostoServicio = costoServicio;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    

    
}

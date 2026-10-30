public class Empleado {
    private String nroDocumento;
    private String nombre;
    private String apellido;
    private String areaTrabajo;
    private boolean esTecnico;


    public Empleado(String nroDocumento, String nombre, String apellido, String areaTrabajo, boolean esTecnico) {
        this.apellido = apellido;
        this.areaTrabajo = areaTrabajo;
        this.esTecnico = esTecnico;
        this.nombre = nombre;
        this.nroDocumento = nroDocumento;
    }

    public String getNroDocumento() { return nroDocumento; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getAreaTrabajo() { return areaTrabajo; }
    public boolean isEsTecnico() { return esTecnico; }


    
    public void setNroDocumento(String nroDocumento) { this.nroDocumento = nroDocumento; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setAreaTrabajo(String areaTrabajo) { this.areaTrabajo = areaTrabajo; }
    public void setEsTecnico(boolean esTecnico) { this.esTecnico = esTecnico; }


    
    
    
    

}

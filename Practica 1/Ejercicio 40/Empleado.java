public abstract class Empleado {
    private String nombreCompleto;
    private int idEmpleado;
    private String puesto;
    protected double salario;

    public Empleado(String nombreCompleto, int idEmpleado, String puesto, double salario){
        this.nombreCompleto = nombreCompleto;
        this.idEmpleado = idEmpleado;
        this.puesto = puesto;
        this.salario = salario;
    }

    public abstract double calcularSalario();

    public void aumentarSalario(double porcentaje){
        salario += salario*porcentaje;
    }

    public void mostrarInfo(){
        System.out.println("Nombre: " +nombreCompleto);
        System.out.println("ID: " +idEmpleado);
        System.out.println("Puesto: " +puesto);
    }

    public double getSalario(){
        return salario;
    }

}

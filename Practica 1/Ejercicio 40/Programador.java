class Programador extends Empleado {

    private int horasExtra;
    private double pagoPorHora;
    
    public Programador(String nombreCompleto, int id, double salario, int horasExtra, double pagoPorHora){
        super(nombreCompleto, id, "Programador", salario);
        this.horasExtra = horasExtra; 
        this.pagoPorHora = pagoPorHora;
    }

    @Override //la anotación se utiliza específicamente en clases hijas para proporcionar una implementación concreta a los métodos abstractos heredados de una superclase
    public double calcularSalario(){
        return salario + (horasExtra*pagoPorHora);
    }

    public void programar(){
        System.out.println("El programador esta programando");
    }


}

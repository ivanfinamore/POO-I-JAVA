class Gerente extends Empleado{

    private double bono;

    public Gerente(String nombreCompleto, int id, double salario, double bono){
        super(nombreCompleto, id, "Gerente", salario);
        this.bono = bono;
    }

    @Override
    public double calcularSalario(){
        return salario + bono;
    }

    public void tomarDecision(){
        System.out.println("El gerente esta tomando decisiones");
    }
    
}

public class Main {
    public static void main(String[] args) {
        Empleado e1 = new Programador("Ivan Finamore", 1, 1500, 10, 50);
        Empleado e2 = new Gerente("Nacho Ledo", 2, 1000, 250);
        
        e1.mostrarInfo();
        System.out.println("Salario: "+e1.calcularSalario());

        e2.mostrarInfo();
        System.out.println("Salario: " +e2.calcularSalario());

        //Metodos propios  (evito volver a crear dos objetos que pertenezcan a la clase gerente y programador para que asi puedan acceder a los metodos de dichas clases, casteo en su lugar)
        ((Programador) e1).programar();
        ((Gerente)e2).tomarDecision();

        //Pude haber definido los objetos como programador y gerente, y usar los metodos heredados sin tener que castear. Pero es poco flexible

    }
}

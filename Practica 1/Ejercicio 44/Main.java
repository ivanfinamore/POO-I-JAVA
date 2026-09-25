public class Main {
    public static void main(String [] args){
        Personaje sup = new Superman("Masculino", 30, 150, 60);
        Personaje bat = new Batman("Masculino", 35, 110, 6);

        System.out.println("Situacion inicial previa al combate: ");

        // estado inicial
        bat.mostrarEstado();
        System.out.println("\n");
        sup.mostrarEstado();
        System.out.println("\n");

        // habilidades
        sup.usarHabilidad();
        bat.usarHabilidad();
        System.out.println("\n");

        // combate
        bat.atacar(sup);
        sup.atacar(bat);
        System.out.println("\n");

        // estado final
        bat.mostrarEstado();
        System.out.println("\n");
        sup.mostrarEstado();
        System.out.println("\n");

        ((Batman) bat).plainificarAtaque(sup);

    }
}

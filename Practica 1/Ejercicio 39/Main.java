public class Main {
    public static void main(String[] args) {
        Perro p1 = new Perro("Jazmin", 8, 10.5, "Cocker");
        Gato g1 = new Gato("Michi Maus", 2, 3, "Moet");

        p1.hacerSonido();
        g1.hacerSonido();

        p1.moverCola();
        g1.lamerse();

        p1.moverse();
        g1.moverse();

        p1.comer(10);
        g1.comer(10);

        System.out.println("El peso del perro es: "+p1.getPeso());
        System.out.println("El peso del gato es: "+g1.getPeso());
    }
}

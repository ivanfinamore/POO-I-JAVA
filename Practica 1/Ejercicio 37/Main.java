public class Main {
    public static void main(String[] args){    //punto de inicio del programa (boton), distinto a Main.java que es la clase o el nombre del archivo (caja)
        
        Rectangulo r = new Rectangulo("Rojo", 5, 3); //crea un objeto rectangulo 'r' con los valores indicados
        Circulo c = new Circulo("Azul", 2);                //crea un objeto circulo 'c' con los valores indicados

        System.out.println(r.calcularArea());                           //el punto '.' accede a los miembros (en este caso metodos que es calcular area) del objeto
        System.out.println(c.calcularArea());                           
    }
}


//un metodo siempre cambia un atributo
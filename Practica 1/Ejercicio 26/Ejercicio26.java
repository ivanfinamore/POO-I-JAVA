public class Ejercicio26 {
    public static void main(String[] args) {
        int edad = 18;
        if (edad >= 0 && edad < 18){
            System.out.println("No puede votar");
        }else if(edad >= 18){
            System.out.println("Puede votar");
        }else{
            System.out.println("Numero invalido");
        }
    }
}

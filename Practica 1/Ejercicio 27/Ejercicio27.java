public class Ejercicio27 {
    public static void main(String[] args){
        char operador = '*';
        double num1 = 20.2;
        double num2 = 21;
        double res = 0.0f;

        switch (operador) {
            case '+' -> res = num1 + num2;
            case '-' -> res = num1 - num2;
            case '*' -> res = num1*num2;
            case '/' -> res = num1/num2;
            default -> System.out.println("Operacion invalida");
        }
        System.out.println("El resultado es: " +res);
    }
}

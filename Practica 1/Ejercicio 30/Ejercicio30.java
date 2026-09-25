public class Ejercicio30 {
    public static void main(String[] args){
        double num1 = 32.3;
        double num2 = 32.1;
        double num3 = 32.31; 

        if (num1 >= num2 && num1 >= num3){
            System.out.println("El numero mas grande es " +num1);
        }else if (num2 >= num1 && num2 >= num3) {
            System.out.println("El numero mas grande es " +num2);
        }else if (num3 >= num1 && num3 >= num2){
            System.out.println("El numero mas grande es el " +num3);
        }
    }
}

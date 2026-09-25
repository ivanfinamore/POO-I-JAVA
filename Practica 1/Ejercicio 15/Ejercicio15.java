class Ejercicio15{
    public static void main(String []args){
        double num1 = 41.34;
        double num2 = 13.31;
        double resultado = num1/num2;
        double redondeado = (double) Math.round (resultado*100)/100;
        System.out.println("El resultado de la division con dos decimales es: " +redondeado);
    }
}
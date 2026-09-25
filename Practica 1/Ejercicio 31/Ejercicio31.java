public class Ejercicio31 {
    public static void main(String[] args){
        int cant = 0;
        int res = 0;
        for(int num = 0; cant <= 10; num++){
            if (num%2 == 0){
                res = res + num;
                cant++;
            }
        }  
        System.out.println("La suma de los primeros 10 numeros pares es: "+res); 
    }
}

public class Ejercicio24 {
    public static void main(String[]args){
        float calificacion = 101.2f;

        if (calificacion >=0 && calificacion <60){

            System.out.println("Desaprobado");

        } else if(calificacion >= 60 && calificacion <=100){

            System.out.println("Aprobado");

        }else{

            System.out.println("Numero invalido");

        }

    }
}
class Ejercicio19{
    public static void main(String[] args) {
        int num1 = 6;
        int res = num1;
        for(int i = num1-1; i>=1; --i){
            res = res*i;
        } 
        System.out.println("El factorial es: " +res);

    }
}
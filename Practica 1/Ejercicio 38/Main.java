public class Main {
    
    public static void main(String[] args){
        Vehiculo v1  = new Auto();
        Vehiculo v2 = new Bicicleta();

        v1.acelerar(10);
        v2.acelerar(10);

        System.out.print("Velocidad auto: " + v1.getVelocidad());
        
        System.out.println("");

        System.out.print("Velocidad bici: " + v2.getVelocidad());
        
    }
}

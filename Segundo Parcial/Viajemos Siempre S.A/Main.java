import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Hotel> hoteles = new ArrayList<>();
    static ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();

    static final int CANT_PAQUETES = 12;

    static void main(String args[]) {
        preCargarHoteles();
        cargarPaquetes();                                    //a
        verificarEstadiasCortas("Caribe Total");             //b
        paquetesMayoresAsemanaNoRentables();                 //c

    }


    //Hoteles precargados
    static void preCargarHoteles(){
        hoteles.add(new Hotel("Howard Johnson", "Pilar", 1000));
        hoteles.add(new Hotel("Holiday Inn", "Chascomus", 1500));
        hoteles.add(new Hotel("Hotel Ritz", "CABA", 2000));
        hoteles.add(new Hotel("Four Seasons", "Mar del Plata", 3000));
    }


    //Inciso a)
    static void cargarPaquetes(){
        while (paquetes.size() < CANT_PAQUETES){
            System.out.println("El paquete que desea ingresar es de caracter Internacional?: (s/n)");
            boolean internacional = sc.nextLine().equalsIgnoreCase("s");

            System.out.println("\nIngresar nombre del paquete turistico: ");
            String nombre = sc.nextLine();

            System.out.println("\nIngresar codigo del paquete: ");
            int codigo = sc.nextInt();
            sc.nextLine();

            System.out.println("\nIngresar destino principal del paquete: ");
            String destino = sc.nextLine();

            System.out.println("\nDuracion (en dias) del paquete ");
            int dias = sc.nextInt();
            sc.nextLine();

            System.out.println("\nIngrese precio de venta del paquete: ");
            double precio = sc.nextDouble();
            sc.nextLine();

            PaqueteTuristico paq;

            if (internacional){
                System.out.println("\nIngrese compania aerea: ");
                String compania = sc.nextLine();

                System.out.println("\nIngrese su precio adicional: ");
                double adicional = sc.nextDouble();
                sc.nextLine();

                paq = new PaqueteInternacional (nombre, codigo, destino, dias, precio, compania, adicional);
            
            } else {
                paq = new PaqueteTuristico (nombre, codigo, destino, dias, precio);
            }

            String otra;
            do { 

                System.out.println("\n===== HOTELES ====");
                int k = 0;
                for(Hotel h : hoteles){
                    System.out.println("" +(k+1)+ ". " +h.getNombre()+ " - " +h.getUbicacion());
                    k++;
                }

                System.out.println("\nElegir el hotel de su estadia por su numero: ");
                int opcion = sc.nextInt(); 
                sc.nextLine();

                System.out.println("\nCantidad de noches: ");
                int noches = sc.nextInt();
                sc.nextLine();
            

                System.out.println("\nSe permiten hacer cambios en la habitacion? (s/n): ");
                boolean cambiosHabitacion = sc.nextLine().equalsIgnoreCase("s");

                Estadia e = new Estadia(noches, hoteles.get(opcion - 1), cambiosHabitacion);

                paq.getEstadias().add(e);

                System.out.println("Desea cargar otra estadia? (s/n): ");
                otra = sc.nextLine();

            } while (otra.equalsIgnoreCase("s"));

            if (paq.getTotalNoches() > dias){
                System.out.println("Error. La cantidad total de noches supera la cantidad de dias establecida por el paquete. No se puede agregar el paquete.");
            } else {
                paquetes.add(paq);
                System.out.println("Paquete agregado con exito.");
            }

        }

    }





    //Inciso b)
    static void verificarEstadiasCortas(String nombre){
        PaqueteTuristico p = buscarPaquete(nombre);

        if (p != null) {
            if (p.tieneSoloEstadiasCortas()) {
                System.out.println("Todas sus estadias poseen una permanencia menor a 3 noches.");
            } else {
                System.out.println("No todas sus estadias poseen una permanencia menor a 3 noches.");
            }
        } else {
            System.out.println("El paquete ingresado es inexistente.");
        }
    }



    //Me sirve para el inciso b).
    static PaqueteTuristico buscarPaquete(String nombre){
        for (PaqueteTuristico p : paquetes){

            if (p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }

        }

        return null;
    }






    //Inciso c)
    static void paquetesMayoresAsemanaNoRentables(){
        System.out.println("\nPaquetes turisticos mayores a 7 dias y no rentables: ");
        for (PaqueteTuristico p : paquetes){
            if (p.getDuracionEnDias() > 7 && !p.esRentable()){
                System.out.println("Codigo: " +p.getCodigo());
                System.out.println("Nombre: " +p.getNombre());
                System.out.println("Destino principal: " +p.getDestinoPrincipal());
                System.out.println("Año de lanzamiento: " +p.getFechaLanzamiento().getYear());

                if (p instanceof PaqueteInternacional pi){
                    System.out.println("Compañia aerea: " +pi.getCompaniaAerea());
                    System.out.printf("Precio venta: $%.2f%n", pi.getPrecioVenta() + pi.getPrecioAdicional());
                } else {
                    System.out.printf("Precio venta: $%.2f%n", p.getPrecioVenta());
                }

                System.out.println("");

            }
            
        }
        
    }

}
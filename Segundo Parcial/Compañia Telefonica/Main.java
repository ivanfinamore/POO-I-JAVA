import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    //Listas precargadas de abonos y lineas telefonicas
    static ArrayList<Abono> abonos = new ArrayList<>();
    static ArrayList<LineaTelefonica> lineas = new ArrayList<>();


    public static final double LIMITE_CONSUMO = 50;


    static void main(String args[]) {
        precargarAbonos();
        precargarLineas();

        int opcion;
        do { 
            System.out.println("===== Compañia telefonica =====\n");
            System.out.println("1. Cargar consumos a una linea telefonica.");
            System.out.println("2. Ver precio total a pagar de la linea telefonica.");
            System.out.println("3. Ver lineas telefonicas con consumo excedente.");
            System.out.println("0. Salir");
            System.out.println("\nElija una opcion:");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion != 0 && opcion!= 1 && opcion!= 2 && opcion != 3){
                System.out.println("Opcion invalida.");
            }

            switch (opcion) {
                case 1 -> cargarConsumos(); //a
                case 2 -> mostrarPrecioTotal(); //b
                case 3 -> mostrarLineasConExcedentes(); //c
                default -> { }
            }

        } while (opcion != 0);

    }

    static void precargarAbonos(){
        abonos.add(new Abono ("Personal", 1500, 50, 400));
        abonos.add(new Abono("Movistar", 1300, 40, 300));
        abonos.add(new Abono("Claro", 1700, 70,550));
    }

    static void precargarLineas(){
        lineas.add(new LineaTelefonica("Enrique Perez", "115499278703", abonos.get(0)));
        lineas.add(new LineaTelefonica("Marcelo Gomez", "115468454432", abonos.get(1)));
        lineas.add(new LineaTelefonica("Ivan Martinez", "115463624578", abonos.get(2)));
    }







    //Me sirve para el inciso a) y b)
    static LineaTelefonica buscarLinea(String ingresada){

        for (LineaTelefonica l : lineas){

            if (ingresada.equals(l.getNumeroLinea())){
                return l;
            }

        }

        return null;

    }








    //Inciso a)
    static void cargarConsumos(){

        String otra;
        do { 
            LineaTelefonica linea;
            do { 
                System.out.println("\nIngrese numero de linea a la que desea cargar consumos: ");
                String lineaIngresada = sc.nextLine();

                linea = buscarLinea(lineaIngresada);

                if(linea == null){
                    System.out.println("La linea ingresada no esta registrada. Intente nuevamente.");
                }
            } while (linea == null);
            

            System.out.println("¿Cuantos consumos desea registrar?: ");
            int cant = sc.nextInt();
            sc.nextLine();
    

            for(int i = 0; i < cant; i++){
                System.out.println("\nConsumo " +(i+1)+ " de " +cant+ ":");
                System.out.println("Cantidad de gb consumidos en videos: ");
                double video = sc.nextDouble();
                sc.nextLine();

                System.out.println("Cantidad de gb consumidos en mensajes: ");
                double mensajes = sc.nextDouble();
                sc.nextLine();

                //Se crea el objeto consumo
                Consumo cons = new Consumo(video, mensajes);

                if(cons.esValida()){
                    linea.getConsumos().add(cons);
                    System.out.println("Consumo Nº" +(i+1)+ " registrado.");
                } else{
                    System.out.println("Error al cargar el consumo. El consumo diario de gb en mensajes debe ser menor a lo establecido (570).");
                }

            }
            

            System.out.println("¿Desea cargar consumos en otra linea? (s/n): ");
            otra = sc.nextLine();

        } while (otra.equalsIgnoreCase("s"));

    }









    //Inciso b)
    static void mostrarPrecioTotal(){
        String otra;
        do { 

            LineaTelefonica linea;
            do { 
                System.out.println("\nIngresar numero de linea telefonica a consultar abono total: ");
                String numero = sc.nextLine();

                linea = buscarLinea(numero);

                if(linea == null){
                    System.out.println("La linea ingresada no esta registrada. Intente nuevamente.");
                }    

            } while (linea == null);

            
            System.out.printf("Precio total a abonar: $%.2f%n", linea.totalApagar());
            System.out.printf("Cantidad de GB consumidos: %.2f%n", linea.getGbConsumidos());
            System.out.printf("Cantidad de GB excedentes: %.2f%n", linea.getGbExcedentes());
            

            System.out.println("¿Desea consultar otra linea? (s/n): ");
            otra = sc.nextLine();

        } while (otra.equalsIgnoreCase("s"));

    }





    //Inciso c)
    static void mostrarLineasConExcedentes(){
        for (LineaTelefonica l : lineas){
            if ((l.getGbConsumidos() + l.getGbExcedentes()) > LIMITE_CONSUMO){
                System.out.println("La linea " +l.getNumeroLinea()+ " supera el limite de consumo de $" +LIMITE_CONSUMO);
            } else {
                System.out.println("Ninguna linea supera el limite de consumo.");
            }
        }
    }



}

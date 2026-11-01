import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final int CANT_LOTES = 2;   //Pedido por el enunciado

    static Scanner sc = new Scanner(System.in);
    
    static ArrayList<EmprendimientoInmobiliario> emprendimientos;   //Como no sabemos la cantidad de emprendimientos inmobiliarios, lo dejamos como arrayList
    static Lote[] lotes = new Lote[CANT_LOTES];     //Como ya sabemos la cantidad de lotes, lo dejamos como arreglo





    static void main(String args[]) {

        precargarEmprendimientos();
        cargarLotes();              //a
        mostrarOfertasAltas();      //b
        mostrarOfertanteGanador();  //c

    }




    static void precargarEmprendimientos(){
        emprendimientos.add(new EmprendimientoInmobiliario("Los Robles", "Pilar",120));
        emprendimientos.add(new EmprendimientoInmobiliario("Altos del Lago", "Tigre", 85.5));
        emprendimientos.add(new EmprendimientoInmobiliario("San Matias", "Escobar", 200));
    }





    //Inciso a). Cargar los lotes
    static void cargarLotes(){
        for (int i = 0; i < CANT_LOTES; i++){

            System.out.println("Lote " +(i+1)+ " de " +CANT_LOTES+ ":\n");

            System.out.println("\nIngresar codigo del lote: ");
            int cod = sc.nextInt();
            sc.nextLine();

            System.out.println("\nIngrese precio base del lote: ");
            double precio = sc.nextDouble();
            sc.nextLine();

            System.out.println("\n¿El lote admite financiacion?: (s/n)");
            boolean financiacion = sc.nextLine().equalsIgnoreCase("s"); //si escribe "s" o "S", me devuelve true
            System.out.println("\n");

            for(EmprendimientoInmobiliario e : emprendimientos){
                int num = 1;
                System.out.println(" " +num+ ". " +e.getNombre());
                num++;
            }

            System.out.println("\nElegir emprendimiento (por numero): ");
            int opcion = sc.nextInt();

            EmprendimientoInmobiliario emp = emprendimientos.get(opcion - 1); //La opcion siempre va a ser una unidad superior a la posicion en el arrayList



            lotes[i] = new Lote(cod, precio, financiacion, emp);        //se crea el objeto lote, con los parametros necesarios del constructor



            //Se crean las ofertas, asi estas se pueden agregar al lote. Primero creo el objeto lote, despues agrego las ofertas. Antes

            System.out.println("\n¿Cuantas ofertas recibio el lote?: ");
            int cantOfertas = sc.nextInt();
            sc.nextLine();

            for (int k = 0; k < cantOfertas; k++){
                System.out.println("\nOferta " +(k+1)+ " de " +cantOfertas+ ": ");

                System.out.println("Nombre del ofertante: ");
                String nombreOfertante = sc.nextLine();

                System.err.println("Apellido del ofertante: ");
                String apellidoOfertante = sc.nextLine();

                System.out.println("Monto ofrecido: ");
                double monto = sc.nextDouble();

                Oferta of = new Oferta(nombreOfertante, apellidoOfertante, monto);

                if(lotes[i].esOfertaValida(of)){            //lotes[i] porque es array normal
                                                            //lotes.get(i) si hubiese sido arrayList
                    lotes[i].getOfertas().add(of);
                    System.out.println("\nOferta aceptada.");

                } else {
                    System.out.println("\nOferta rechazada: es inferior al precio base.");
                }

            }


        }

    }



    //Me sirve para el inciso b).
    static Lote buscarLote(int codigo){
        for (Lote l : lotes){
            if (l.getCodigo() == codigo){
                return l;
            }
        }
        return null;
    }


    //Inciso b). A partir de un codigo de lote ingresado, mostrar el precio base y las ofertas (nombre y monto del ofertante) que superen en un 10% dicho precio base.
    static void mostrarOfertasAltas(){

        System.out.println("\nIngrese el codigo del lote a consultar: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        Lote l = buscarLote(codigo);
        if (l == null){
            System.out.println("No existe ningun lote con ese codigo.");
            return;             //evito que entre al sysout de: "El precio base del lote es " y me aparezca null
        }

        System.out.println("\nEl precio base del lote es: $" +l.getPrecioBase());

        System.out.println("Ofertas que superan en un 10% al precio base: ");
        int cant = 0;
        for(Oferta of : l.getOfertas()){

            if (of.getMontoOfrecido() > (l.getPrecioBase()*1.1)){
                System.out.println(" " +of.getNombre()+ " " +of.getApellido()+ " - $" +of.getMontoOfrecido());
            } 

        }

        if (cant == 0){
            System.out.println("Ninguna.");
        }

    }




    //Inciso c). Mostrar, para cada lote, el ofertante ganador con los respectivos datos
    static void mostrarOfertanteGanador(){
        
        for (Lote l : lotes){

            Oferta of_ganadora = l.getOfertaGanadora();
            System.out.println("\nCodigo del lote: " +l.getCodigo());
            System.out.println("Emprendimiento inmobiliario: " +l.getEmprendimiento());

            if (of_ganadora != null){
                
                System.out.println("Nombre del ofertante ganador: " +of_ganadora.getNombre()+ " " +of_ganadora.getApellido());
                System.out.println("Monto ofrecido: " +of_ganadora.getMontoOfrecido());

            } else {
                System.out.println("Sin oferta ganaora");
            }
            
        }
    }
}

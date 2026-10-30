import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static ArrayList<Sistema> sistemas = new ArrayList<>();
    static ArrayList<Empleado> empleados = new ArrayList<>();
    static ArrayList<Incidente> incidentes = new ArrayList<>();
    static Scanner sc = new Scanner (System.in);




    
    public static void main(String[] args) {

        generarSistemas();                                              //i
        generarEmpleados();                                             //i

        int opcion;

        do { 
            System.out.println("\n------------------------ MESA DE AYUDA - Hard Soft S.A. --------------------------\n");
            System.out.println("1. Registrar incidentes");
            System.out.println("0. Salir");

            System.out.println("Ingresar opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 -> ingresarIncidente();                          //j

                case 0 -> System.out.println("Fin del programa.");

                default -> System.out.println("Opcion invalida");
            }

        } while (opcion != 0);
        


    }







    //Inciso i)
    static void generarSistemas(){
        sistemas.add(new Sistema(1,"Sueldos", true));
        sistemas.add(new Sistema(2, "SAP", false));
        sistemas.add(new Sistema(3, "Tango Gestion", false));
        sistemas.add(new Sistema(4, "Intranet", true));
        sistemas.add(new Sistema(5, "Mesa de Entradas", true));
    }

    //Inciso i)
    static void generarEmpleados(){
        //No tecnicos (los que reportan)
        empleados.add(new Empleado("30111222", "Ana", "Gomez", "Ventas", false));
        empleados.add(new Empleado("31222333", "Carlos", "Diaz", "Contabilidad", false));
        empleados.add(new Empleado("32333444", "Maria", "Lopez", "RRHH", false));
        empleados.add(new Empleado("33444555", "Jorge", "Ruiz", "Ventas", false));

        //Tecnicos
        empleados.add(new Empleado("28999888", "Luis", "Perez", "Sistemas", true));
        empleados.add(new Empleado("29888777", "Sofia", "Martinez", "Sistemas", true));
        empleados.add(new Empleado("27777666", "Diego", "Fernandez", "Soporte", true));
    }






    //Inciso j)
    static void ingresarIncidente(){
        System.out.println("\n¿Cuantos incidentes va a registrar?: ");
        int cant = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < cant; i++){
            System.out.println("\n   Incidente " +(i + 1)+ " de " + cant + ":");


            //Primero se pregunta el tipo, porque define que datos se piden al final
            System.out.println("\nTipo (1 = Hardware, 2 = Software): ");
            int tipoIncidente = sc.nextInt();
            sc.nextLine();


            System.out.println("\nIngresar fecha del incidente: ");
            LocalDate fecha = LocalDate.parse(sc.nextLine());


            System.out.println("\nForma del reporte - (Telefono / Mail / Chat): ");
            String reporte = sc.nextLine();


            System.out.println("\n¿Es urgente?: (s/n)");
            boolean urgente = sc.nextLine().equalsIgnoreCase("s");  //equalsIgnoreCase devuelve un boolean. Si recibe s o S devuelve true; n o lo que sea devuelve false 
            

            System.out.println("\nComentario: ");
            String comentario = sc.nextLine();


            Empleado informante = elegirInformante();

            Empleado tecnico = elegirTecnico();

            
            Incidente inc;  //Se crea la variable donde se va a guardar el incidente (debe ser de clase padre, para poder apuntar a un objeto de hardware y de software - subclases)

            
            if(tipoIncidente == 1){

                String ip;
                do{
                    System.out.println("\nIP del equipo: ");
                    ip = sc.nextLine();

                    if (!IncidenteHardware.esIpValida(ip)){
                        System.out.println("La IP ingresada no es valida. Ingrese una correcta (ejemplo: 192.168.70.3)");
                    }

                }while(!IncidenteHardware.esIpValida(ip));


                ArrayList<String> repuestos = new ArrayList<>();

                System.out.println("¿Cuantos repuestos se cambiaron?: ");
                int cant_repuestos = sc.nextInt();
                sc.nextLine();

                for(int k = 0; k < cant_repuestos; k++){

                    System.out.println(" Repuesto " +(k + 1)+ ": ");
                    repuestos.add(sc.nextLine());

                }

                inc = new IncidenteHardware(fecha, reporte, urgente, comentario, informante, tecnico, ip, repuestos);   //Creo el objeto incidente hardware


            } else{

                ArrayList<SistemaAfectado> afectados = new ArrayList<>();

                String otro;
                do { 
                    System.out.println("Sistemas: ");

                    for(int j = 0; j < sistemas.size(); j++){

                        System.out.println(" "+(j+1)+": " +sistemas.get(j).getNombreAplicacion());
                        
                    }
                        System.out.println("\nSistema afectado: ");
                        int opcion = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Mensaje de error: ");
                        String mensaje = sc.nextLine();

                        afectados.add(new SistemaAfectado(sistemas.get(opcion - 1), mensaje));

                        System.out.println("¿Otro sistema afectado? (s/n): ");
                        otro = sc.nextLine();

                    
                } while (otro.equalsIgnoreCase("s"));

                inc = new IncidenteSoftware(fecha, reporte, urgente, comentario, informante, tecnico, afectados);

            }

            incidentes.add(inc);    //añado el incidente a la lista de incidentes

            System.out.println("Incidente Nº: " +inc.getNumero()+ " registrado.");


        }


    }






    //Me sirve para el inciso j) 
    static Empleado elegirInformante(){

        System.out.println("Empleado que lo reporto: \n");

        for(int i = 0; i < empleados.size(); i++){
    
            Empleado e = empleados.get(i);

            System.out.println(" " + (i + 1) + ":  " + e.getApellido() + ", " + e.getNombre());
        }

        System.out.println("\n Opcion:");
        int opcion = sc.nextInt();
        sc.nextLine();

        return empleados.get(opcion - 1);

    }


    //Me sirve para el inciso j)
    static Empleado elegirTecnico(){
        ArrayList<Empleado> tecnicos = new ArrayList<>();
        
        for (Empleado e : empleados){
            if(e.isEsTecnico()){
                tecnicos.add(e);
            }
        }

        System.out.println("Tecnico asignado: \n");

        for (int i = 0; i < tecnicos.size(); i++){

            Empleado t = tecnicos.get(i);    //cada t es un tecnico y ademas una posicion del arreglo de tecnicos

            System.out.println(" " + (i + 1) + ":  " + t.getApellido() + ", " + t.getNombre());
        }

        System.out.println("\n Opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        return tecnicos.get(opcion - 1);
        
    }









}

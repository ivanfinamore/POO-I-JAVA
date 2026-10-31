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
            System.out.println("2. Registrar tareas de un incidente");
            System.out.println("3. Incidentes resueltos del mes por area");
            System.out.println("4. Buscar repuestos cambiados");
            System.out.println("5. Tecnicos sin asignar em los ultimos 6 meses");
            System.out.println("6. Hardware resueltos por encima del promedio");
            System.out.println("7. ¿Software pendientes son todos propios?");
            System.out.println("0. Salir");

            System.out.println("\nIngresar opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 -> ingresarIncidente();                          //j

                case 2 -> registrarTareas();                            //k

                case 3 -> listarResueltosDelMes(args[0]);                                              //l

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
            int tipoIncidente;
            do { 
                System.out.println("\nTipo (1 = Hardware, 2 = Software): ");
                tipoIncidente = sc.nextInt();
                sc.nextLine();

                if(tipoIncidente != 1 && tipoIncidente != 2){
                    System.out.println("Error: el tipo debe ser 1 o 2.");
                }

            } while (tipoIncidente != 1 && tipoIncidente != 2);
            
        


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




    //Inciso k). Registra tareas a un incidente y ademas marca si quedo resuelto.
    static void registrarTareas(){
    
        Incidente inc = buscarIncidente();

        if (inc == null){
            System.out.println("No se encontro ningun incidente con el numero de registro ingresado");
            return;
        }
        
        //Muestra el nombre del informante del incidente
        System.out.println("Incidente informado por: " +inc.getInformante().getNombre()+ " " +inc.getInformante().getApellido());

        //De cada tarea se carga: fecha, descripcion, duracion en minutos
        String otra;
        do { 

            System.out.println("Descripcion de la tarea: ");
            String descr = sc.nextLine();

            System.out.println("Tiempo insumido (minutos): ");
            int min = sc.nextInt();
            sc.nextLine();

            inc.getTareas().add(new Tarea(descr, min));     //Agrego la tarea a ese incidente a un arreglo de tareas (puede haber mas de una tarea)
                                                            //setTareas sirve para meter una lista entera de tareas ya precargada. Borra las anteriores


            System.out.println("¿Desea cargar otra tarea? (s/n): ");
            otra = sc.nextLine();

        } while (otra.equalsIgnoreCase("s"));


        System.out.println("¿El incidente quedo resuelto? (s/n): ");

        if(sc.nextLine().equalsIgnoreCase("s")){

            inc.setResuelto(true);
            System.out.println("Incidente Nº: " +inc.getNumero()+ " marcado como resuelto.");

        }
        

    }



    //Me sirve para el inciso k y otros.
    static Incidente buscarIncidente(){

        Incidente encontrado;
        do { 
            System.out.println("\nIngrese numero de incidente: ");
            int nro_incidente = sc.nextInt();
            sc.nextLine();

            encontrado = null;
            for(Incidente inc : incidentes){

                if(nro_incidente == inc.getNumero()){
                    encontrado = inc;
                }

            }

            if(encontrado == null){
                System.out.println("El numero ingresado no corresponde a un incidente");
            }

        } while (encontrado == null);
        

        return encontrado;

    }





    //Inciso l). Pasar un argumento de area de trabajo y mostrar los siguientes parametros
    static void listarResueltosDelMes(String area){

        LocalDate hoy = LocalDate.now(); //Se toma la fecha de hoy para tomar el mes presente

        System.out.println("\n--- Incidentes resueltos del mes - Area: " + area + " ---");

        for(Incidente inc : incidentes){

            boolean esDelMes = inc.getFechaRegistro().getMonthValue() == hoy.getMonthValue()    //La fecha de registro debe ser del ultimo mes del ultimo año
                            && inc.getFechaRegistro().getYear() == hoy.getYear();               //Por eso comparo con el año y el mes de la variable 'hoy'
                

            if(inc.isResuelto() && esDelMes && inc.getInformante().getAreaTrabajo().equalsIgnoreCase(area)){    //Muestro el incidente si: 
                                                                                                                //  a) fue resuelto
                                                                                                                //  b) el area de trabajo del informante coincide con la pasada por parametro
                                                                                                                //  c) el incidente fue registrado el ultimo mes del ultimo año              
                System.out.println("\nNº de Incidente: " +inc.getNumero());
                System.out.println("\nNombre del tecnico: " +inc.getTecnico().getNombre()+ " " +inc.getTecnico().getApellido());

                switch (inc.getFormaReporte()) {
                    
                    case "Telefono" -> System.out.println("Informado por: llamada telefonica");
                    case "Mail" -> System.out.println("Informado por: correo electronico");
                    case "Chat" -> System.out.println("Informado por: chat");

                }

                System.out.println("Tareas realizadas:\n");
                for(Tarea t : inc.getTareas()){
                    System.out.println(" " + t.getFecha() + " - " +t.getDescripcion()+ " - " +t.getDuracionEnMinutos()+ " Min");
                }

                //Metodo polimorfico: cada subclase responde a su manera. Java mira de que tipo es el objeto y ejecuta la version de esa subclase
                System.out.println(inc.getAfectado());


            }
            
        }

    }





}

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static final String FABRICA = "Remeras siempre remeras S.A."; //Enunciado
    static final int CANT_MODELOS = 2; //Enunciado
    static final int CANT_TALLES = 1; //Enunciado


    //Variables que usan todos los metodos del main
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Empresa> empresas = new ArrayList<>();
    static Modelo[] modelos = new Modelo[CANT_MODELOS];



    //Donde funciona el programa
    public static void main(String[] args) {

        cargarEmpresas();
        cargarModelos();        //b
        listarMusculosas();    //c

    

    }




    //Cada modelo elige de esta lista quien lo borda y quien lo diseña
    static void cargarEmpresas() {
        empresas.add(new Empresa("30-11111111-1", "Bordados del Sur", 1500, "11-4000-0001"));
        empresas.add(new Empresa("30-22222222-2", "Hilos y Puntadas", 1800, "11-4000-0002"));
        empresas.add(new Empresa("30-33333333-3", "Diseño Textil SRL", 2500, "11-4000-0003"));
        empresas.add(new Empresa("30-44444444-4", "Estampas Norte", 2000, "11-4000-0004"));
    }

    //Inciso b: carga de modelos por teclado
    static void cargarModelos(){

        for (int i = 0; i < CANT_MODELOS; i++){
            System.out.println("\n --- Modelo: " + (i+1) + " ---");


            //Cargo el codigo
            System.out.println("Codigo: ");
            int codigo = sc.nextInt();
            sc.nextLine(); //Limpio el Enter


            //Cargo la tela
            System.out.println("Tela: ");
            String tela = sc.nextLine();


            //Cargo costo de materia prima
            System.out.println("Costo de materia prima: ");
            double costoMateriaPrima = sc.nextDouble();


            //Cargo costo de mano obra
            System.out.println("Costo de mano de obra: ");
            double costoManoObra = sc.nextDouble();
            sc.nextLine();  //Limpio el Enter


            //Cargo si es musculosa
            System.out.println("¿Es musculosa? (s/n)");
            boolean esMusculosa = sc.nextLine().equalsIgnoreCase("s");  //"s" o "S" devuelve True. El resto False


            //Cargo fecha de confeccion
            System.out.println("Fecha de confeccion: (AAAA-MM-DD)");
            LocalDate fechaConfeccion = LocalDate.parse(sc.nextLine());          //Convierto texto en una fecha


            //Cargo los talles. Por cada modelo hay 4 talles
            Talle[] talles = new Talle[CANT_TALLES];
            for (int j = 0; j < CANT_TALLES; j++){
                System.out.println("Talle " +(j + 1)+ ":");

                System.out.print("    Numero: ");
                int numero = sc.nextInt();
                System.out.println("");

                System.out.print("    Largo (cm): ");
                double largo = sc.nextDouble();
                System.out.println("");

                System.out.print("    Ancho (cm): ");
                double ancho = sc.nextDouble();
                System.out.println("");

                System.out.print("    % Adicional: ");
                double porcentajeAdicional = sc.nextDouble();
                System.out.println("");

                sc.nextLine(); //Limpio el Enter

                talles[j] = new Talle(numero, largo, ancho, porcentajeAdicional); //Cada vuelta llena una posicion del arreglo con un talle, hasta llegar a 4
                
            }


            //Cargo todos los colores que tiene el modelo
            ArrayList<String> colores = new ArrayList<>();
            String otro;

            //Es un do-while porque el enunciado pide uno o varios colores
            do { 
                System.out.println("Color: ");
                colores.add(sc.nextLine());
                System.out.println("¿Otro color? (s/n):");
                otro = sc.nextLine();
            } while (otro.equalsIgnoreCase("s"));   //Si se quiere agregar otro color, "S" o "s", y vuelve al do
                                                    //No va el while simple porque este evalua la condicion al principio


            //Se muestra la lista de empresas precargadas y enumeradas para que el usuario sepa cual elegir del bordado
            System.out.println("Empresas: ");
            for(int k = 0; k < empresas.size(); k++){
                System.out.println(" " +(k + 1)+ ") " + empresas.get(k).getRazonSocial()); //accedo a la empresa de la posicion del arreglo empresas y luego a su razon social
            }

            System.out.println("Elegir empresa bordadora (0 sin bordado): ");
            int opcion = sc.nextInt();
            sc.nextLine();

            Empresa bordado = null;                   //(sin bordado) solo si el usuario elige empresa se asigna el bordado
            if (opcion != 0){
                bordado = empresas.get(opcion - 1);  //Ya que el iterador es un numero mas que la opcion
            }

        
            //Arreglo dinamico de empresas diseñadoras
            ArrayList<Empresa> disenadoras = new ArrayList<>();

            //Se pide al usuario indicar la cantidad de empresas encargadas del diseño
            System.out.println("¿Cuantas empresas hicieron el diseño?: ");
            int cant = sc.nextInt();

            //Se carga cada empresa con sus datos al arreglo dinamico
            for(int k = 0; k < cant; k++){
                System.out.println("Empresa diseñadora " +(k + 1)+ " (elegir por numero de lista): ");
                int nro = sc.nextInt();
                disenadoras.add(empresas.get(nro - 1)); //se agrega la empresa (el numero de posiciones siempre es uno menor al indicado por el usuario)
            }
            //Sin empresas diseñadoras se coloca con un 0. El for no da ninguna vuelta, la lista queda vacia
            sc.nextLine(); //Limpio el Enter



            //Cargo el modelo con toda la info ingresada
            modelos[i] = new Modelo (codigo, tela, costoMateriaPrima, costoManoObra, esMusculosa, 
                                     fechaConfeccion, talles, colores, bordado, disenadoras);



            //Agrego la posibilidad de incluir un cambio de diseño
            System.out.println("¿Hubo algun cambio? (s/n): ");
            if (sc.nextLine().equalsIgnoreCase("s")){
                System.out.println("Comentario: ");
                String comentario = sc.nextLine();
                modelos[i].setCambio(new Cambio(comentario)); // El cambio va despues de haber creado el modelo, porque se agrega con el setter sobre un modelo existente
            }

            
        }
    }


    //Inciso c: listar musculosas con distintos atributos
    static void listarMusculosas(){

        //Formato de columnas, pedido por el inciso c
        System.out.println("\n" +FABRICA+ " -------- TEMPORADA: " + Modelo.getTemporada());        //Como es static, accedo con el nombre de la clase. Es el mismo valor compartido por todos los objetos (Invierno)
        System.out.printf("%-7s %-10s %-11s %-18s %-14s %9s %9s %9s %9s %10s%n", 
                          "Codigo", "Tela", "Fecha", "Bordador", "CUIT", "M.Obra", 
                          "M.Prima", "Bordado", "Diseño", "Total"); //Imprimo con formato. Cada % se reemplaza, en orden, por el valor que va despues de la coma


        //Verifico cuantas musculosas no tienen bordado
        int sinBordado = 0;


        //Busco las musculosas en cada modelo
        for(Modelo m : modelos){

            if(m.isEsMusculosa()){
                Empresa b = m.getBordado();
                String razon = (b != null) ? b.getRazonSocial() : "-";
                String cuit  = (b != null) ? b.getCuit() : "-";

                /* Es lo mismo que hacer:

                String razon;
                Strin cuit;
                if (b != null){
                    razon = b.getRazonSocial();
                    cuit = b.getCuit();
                } else{
                    razon = "-";
                    cuit = "-";
                }
                */
               
            System.out.printf("%-7d %-10s %-11s %-18s %-14s %9.2f %9.2f %9.2f %9.2f %10.2f%n", 
                              m.getCodigo(), m.getTela(), m.getFechaConfeccion(), 
                              razon, cuit, m.getCostoManoObra(), m.getCostoMateriaPrima(), 
                              m.getCostoBordado(), m.getCostoDiseno(), m.getCostoBasicoTotal());

            }

            if (m.getBordado() == null){
                sinBordado += 1;
            }
    
        }

        //Muestro por pantalla cuantas musculosas no tienen bordado
        System.out.println("Cantidad de musculosas sin bordado: " + sinBordado);

    }



}





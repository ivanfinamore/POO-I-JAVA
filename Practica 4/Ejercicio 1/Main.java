import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static final String FABRICA = "Remeras siempre remeras S.A."; //Enunciado
    static final int CANT_MODELOS = 17; //Enunciado
    static final int CANT_TALLES = 4; //Enunciado


    //Variables que usan todos los metodos del main
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Empresa> empresas = new ArrayList<>();
    static Modelo[] modelos = new Modelo[CANT_MODELOS];



    public static void main(String[] args) {
        cargarEmpresas();
        cargarModelos();

        //Cada modelo elige de esta lista quien lo borda y quien lo diseña
        static void cargarEmpresas() {
            empresas.add(new Empresa("30-11111111-1", "Bordados del Sur", 1500, "11-4000-0001"));
            empresas.add(new Empresa("30-22222222-2", "Hilos y Puntadas", 1800, "11-4000-0002"));
            empresas.add(new Empresa("30-33333333-3", "Diseño Textil SRL", 2500, "11-4000-0003"));
            empresas.add(new Empresa("30-44444444-4", "Estampas Norte", 2000, "11-4000-0004"));
        }



    }


}





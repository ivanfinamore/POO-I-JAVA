import java.util.Scanner;

public class App{
    public static void main(String[] args){

        Terrestre.setDescuentoTemporadaBaja(200);
        double valorFijo = 1500;

        Scanner sc = new Scanner(System.in);
        Pasaje[] pasajes = new Pasaje[2];
        
        for (int i = 0; i < pasajes.length; i++) {
            System.out.println("Tipo (1-Aereo 2-PrimeraClase 3-Terrestre 4-Grupal):");
            int tipo = sc.nextInt();

            System.out.println("Codigo, destino, fecha, tarifa base y tasas:");
            int codigo = sc.nextInt();
            sc.nextLine();

            String destino = sc.next();
            sc.nextLine();

            String fecha = sc.next();

            double tarifa = sc.nextDouble();

            double tasas = sc.nextDouble();
            sc.nextLine();

            switch (tipo) {
                case 1:
                    System.out.println("Aerolinea:");
                    String aerolinea = sc.nextLine();

                    pasajes[i] = new Aereo(codigo, destino, fecha, tarifa, tasas, aerolinea);       //creo el pasaje correspondiente a la clase del objeto (Aereo)

                    break;

                case 2:
                    System.out.println("Aerolinea:");
                    String aerolineaPC = sc.nextLine();

                    System.out.println("Porcentaje adicional:");
                    double porc = sc.nextDouble();

                    pasajes[i] = new AereoPrimeraClase(codigo, destino, fecha, tarifa, tasas, aerolineaPC, porc);   //creo el pasaje correspondiente a la clase del objeto (Aereo Primera Clase)

                    break;

                case 3:
                    System.out.println("Empresa:");
                    String empresa = sc.nextLine();

                    pasajes[i] = new Terrestre(codigo, destino, fecha, tarifa, tasas, empresa);                 //creo el pasaje correspondiente a la clase del objeto (Terrestre)

                    break;

                default:
                    System.out.println("Con seguro (true/false), pasajeros y porcentaje descuento:");
                    pasajes[i] = new Grupal(codigo, destino, fecha, tarifa, tasas, sc.nextBoolean(), sc.nextInt(), sc.nextDouble());        //creo el pasaje correspondiente a la clase del objeto (Grupal)
            }

        }

        int cont = 0;
        for(Pasaje p : pasajes){

            if(p.getDestino().equalsIgnoreCase("Bariloche")){

                System.out.println("--------------------");
                System.out.println("Codigo: " +p.getCodigo());
                System.out.println("Tarifa base: " +p.getTarifaBase());
                System.out.println("Costo total: " +p.calcularCostoTotal());
                System.out.println("Precio de venta: " +p.calcularPrecioVenta(valorFijo));

                cont +=1; 

            }

        }

        if (cont == 0){

            System.out.println("No hay pasajes a Bariloche");
            
        }

        sc.close();
    }

}
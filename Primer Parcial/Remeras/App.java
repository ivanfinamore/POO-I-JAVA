

public class App {
    public static void main(String[] args){
        Remera[] remeras = new Remera[15]; 
        final double valorFijo = 5000;

        // Inicialización de remeras: arreglo de tipo Remera, que contiene objetos de las clases Remera y sus clases hijas: Deportiva, DeportivaConDryFit, Escolar y Personalizada
        // Se crean 3 remeras de cada tipo, con sus respectivos atributos y se agregan al arreglo.
        // Esto me lo permite hacer el polimorfismo, ya que puedo almacenar objetos de diferentes clases en un arreglo de tipo Remera.

        remeras[0]  = new Remera(1, "Básica Blanca", "Verano", 3000, 4000);
        remeras[1]  = new Remera(2, "Básica Negra", "Invernal", 3200, 4500);
        remeras[2]  = new Remera(3, "Manga Larga Lisa", "Invernal", 3500, 5000);

        remeras[3]  = new Deportiva(4, "Lanus Titular", "Verano", 4000, 6000, "Lanus");
        remeras[4]  = new Deportiva(5, "Boca Suplente", "Invernal", 4200, 6200, "Boca Juniors");
        remeras[5]  = new Deportiva(6, "Racing Retro", "Invernal", 3800, 5800, "Racing Club");

        remeras[6]  = new DeportivaConDryFit(7, "Running Pro", "Verano", 4500, 7000, "Club Atletismo", 15);
        remeras[7]  = new DeportivaConDryFit(8, "Training Térmica", "Invernal", 5000, 7500, "San Lorenzo", 20);
        remeras[8]  = new DeportivaConDryFit(9, "Fútbol Elite", "Invernal", 4800, 7200, "Independiente", 10);

        remeras[9]  = new Escolar(10, "Egresados 2026", "Verano", 2800, 3500, "Colegio San José");
        remeras[10] = new Escolar(11, "Educación Física", "Invernal", 2500, 3000, "Instituto Belgrano");
        remeras[11] = new Escolar(12, "Uniforme Primaria", "Invernal", 2600, 3200, "Escuela N° 5");

        remeras[12] = new Personalizada(13, "Cumpleaños", "Verano", 3000, 4000, true, 20, 10);
        remeras[13] = new Personalizada(14, "Despedida", "Invernal", 3300, 4200, false, 8, 10);
        remeras[14] = new Personalizada(15, "Empresa Logo", "Invernal", 3100, 4100, true, 30, 15);

        for (Remera remera : remeras){
            if(remera.getTemporada().equalsIgnoreCase("Invernal")){
                System.out.println("Nombre del Modelo: " +remera.getNombreModelo());
                System.out.println("Costo de mano de obra: " +remera.getCostoManoObra());
                System.out.println("Costo total: " +remera.calcularCostoTotal());
                System.out.println("Precio de venta: " +remera.calcularPrecioVenta(valorFijo));
                System.out.println("--------------------------------------------------");
            }
        }

    }
}
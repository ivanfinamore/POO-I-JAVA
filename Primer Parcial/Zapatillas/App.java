public class App{
    public static void main(String[] args){

        Zapatilla[] zapatillas = new Zapatilla[20];

        Urbana.setDescuentoLiquidacion(2000);
        double valorFijo = 1500;


        // Zapatilla(codigo, marca, talle, costoFabricacion, costoMateriales)
        zapatillas[0]  = new Zapatilla(1, "Topper", 40, 8000, 12000);
        zapatillas[1]  = new Zapatilla(2, "Fila", 43, 9000, 13000);
        zapatillas[2]  = new Zapatilla(3, "Diadora", 38, 7500, 11000);

        // Running(..., tipoPisada)
        zapatillas[3]  = new Running(4, "Nike", 42, 15000, 22000, "Neutra");
        zapatillas[4]  = new Running(5, "Adidas", 39, 14000, 21000, "Pronadora");
        zapatillas[5]  = new Running(6, "Asics", 44, 16000, 24000, "Supinadora");
        zapatillas[6]  = new Running(7, "Mizuno", 41, 15500, 23000, "Neutra");

        // RunningConAmortiguacion(..., tipoPisada, porcAdicionalAmortiguacion)
        zapatillas[7]  = new RunningConAmortiguacion(8, "Nike", 43, 18000, 26000, "Neutra", 15);
        zapatillas[8]  = new RunningConAmortiguacion(9, "Asics", 40, 17500, 25000, "Pronadora", 20);
        zapatillas[9]  = new RunningConAmortiguacion(10, "Brooks", 45, 19000, 27000, "Supinadora", 25);

        // Urbana(..., estilo)
        zapatillas[10] = new Urbana(11, "Vans", 42, 10000, 14000, "Skate");
        zapatillas[11] = new Urbana(12, "Converse", 37, 9500, 13500, "Clásica");
        zapatillas[12] = new Urbana(13, "Puma", 44, 11000, 15000, "Retro");
        zapatillas[13] = new Urbana(14, "Reebok", 41, 10500, 14500, "Casual");

        // PorEncargo(..., conGrabado, paresSolicitados, porcDescuentoMayorista)
        zapatillas[14] = new PorEncargo(15, "Topper", 42, 9000, 12000, true, 30, 10);
        zapatillas[15] = new PorEncargo(16, "Adidas", 39, 13000, 18000, false, 15, 10);
        zapatillas[16] = new PorEncargo(17, "Nike", 46, 14000, 20000, true, 50, 20);
        zapatillas[17] = new PorEncargo(18, "Fila", 40, 8500, 11500, false, 25, 15);
        zapatillas[18] = new PorEncargo(19, "Puma", 43, 11000, 16000, true, 10, 10);
        zapatillas[19] = new PorEncargo(20, "Kappa", 42, 9500, 13000, false, 21, 12);

        for(Zapatilla z : zapatillas){
            if (z.getTalle() >= 42){
                System.out.println("Marca: " + z.getMarca());
                System.out.println("Costo de materiales: " +z.getCostoMateriales());
                System.out.printf("Costo total: %.2f%n", z.calcularCostoTotal());
                System.out.printf("Precio de venta: %.2f%n", z.calcularPrecioVenta(valorFijo));
                System.out.println("-----------------------------");
            }
        }
    }
}
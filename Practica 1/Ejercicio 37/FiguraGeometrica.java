public abstract class FiguraGeometrica{       // clase base, sirve como plantilla para otras clases. Define lo que tiene una figura geometrica
    protected String color;                  // atributo comun a todas las figuras. El protected permite

    public FiguraGeometrica(String color){  // Constructor: Obliga a que TODA figura tenga un color al crearse
        this.color = color;
    }

    public abstract double calcularArea(); //no tiene implementacion dentro de la super clase. Obliga a que clases hijas definan como calcular el area
}


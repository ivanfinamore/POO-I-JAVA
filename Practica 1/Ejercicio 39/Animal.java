public abstract class Animal {
    private String nombre;
    private int edad;
    private double peso;

    public abstract void hacerSonido();                         //metodo abstracto (cada animal tiene el suyo)

    public void comer(double cantidad){                         //metodo
        peso += cantidad/10;
    }

    public void moverse(){                                      //metodo
        System.out.println("El animal se mueve");
    }

    public Animal(String nombre, int edad, double peso){      //constructor
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public double getPeso(){
        return peso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }



}

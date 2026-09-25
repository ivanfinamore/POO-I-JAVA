class Perro extends Animal{
    private String raza;
    
    public Perro(String nombre, int edad, double peso, String raza){
        super(nombre,edad,peso);
        this.raza = raza;
    }

    @Override
    public void hacerSonido(){
        System.out.println("Guau");
    }

    public void moverCola(){
        System.out.println("El perro mueve la cola");
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }


}

class Gato extends Animal{
    private String raza;

    public Gato(String nombre, int edad, double peso, String raza){
        super(nombre,edad,peso);
        this.raza = raza;
    }

    

    @Override
    public void hacerSonido(){
        System.out.println("Miau");
    }

    public void lamerse(){
        System.out.println("El gato se esta limpiando");
    }

    public String getRaza() {
        return raza;
    }



    public void setRaza(String raza) {
        this.raza = raza;
    }
    


}

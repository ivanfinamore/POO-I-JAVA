class Superman extends Personaje{
    private int energia;

    public Superman (String genero, int ataque, int vida, int energia){
        super("Superman", genero, ataque, vida);
        this.energia = energia;
    }

    @Override
    public void usarHabilidad(){
        if (energia > 20){
            System.out.println("Superman usa su vision laser");
            energia-=10;
        } else{
            System.out.println("Superman no tiene suficiente energia para atacar");
        }
    }

    @Override  //reescribo un metodo de clase padre, debo colocar Override (no siempre es para clases abstractas)
    public void atacar(Personaje enemigo){
        if (energia >= 50){
            System.out.println("Ataque potenciado de Superman debido a una gran reserva de energia");
            enemigo.recibirDanio(ataque + 10);
        } else{
            enemigo.recibirDanio(ataque);
        }
    }
    
}

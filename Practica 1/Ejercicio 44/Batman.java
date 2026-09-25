class Batman extends Personaje{

    private int gadgets; //herramientas que usa batman

    public Batman(String genero, int ataque, int vida, int gadgets){
        super("Batman", genero, ataque, vida);
        this.gadgets = gadgets;
    }

    @Override
    public void usarHabilidad(){
        if(gadgets>0){
            System.out.println("Batman lanza un batarang");
            gadgets--;
        } else{
            System.out.println("Batman no tiene gadgets disponibles");
        }
    }

    public void plainificarAtaque(Personaje enemigo){
        if(enemigo.vida < 50){
            System.out.println("Ataque estrategico de Batman");
            enemigo.recibirDanio(ataque);
        }else{
            atacar(enemigo);
        }
    }
    
}

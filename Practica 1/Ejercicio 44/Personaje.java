public abstract class Personaje {
    protected String nombre;
    protected String genero;
    protected int ataque;
    protected int vida;

    public Personaje(String nombre, String genero, int ataque, int vida){
        this.nombre = nombre;
        this.genero = genero;
        this.ataque = ataque;
        this.vida = vida;
    }

    public abstract void usarHabilidad();

    public void atacar(Personaje enemigo){
        enemigo.recibirDanio(ataque);
    }

    public void recibirDanio(int danio){
        vida-=danio;
    }

    public String nivelAtaque(){
        if(ataque >= 30 && ataque<=50){
            return "Ataque alto";
        }else if(ataque > 50){
            return "Ataque muy alto";
        }else{
            return "Ataque bajo";
        }
    }

    public void mostrarEstado(){
        System.out.println(nombre + " - Vida: " +vida+ "- Ataque: " +ataque);
        System.out.println("Nivel de ataque: "+nivelAtaque());
    }


}

public class Rectangulo extends FiguraGeometrica{
    double base;      //dato propio del rectangulo, solo existe en esta clase
    double altura;   //dato propio del rectangulo, solo existe en esta clase

    public Rectangulo(String color, double base, double altura){    //Este es el constructor, sirve para CREAR el objeto
        super(color);           //llama al constructor de la clase padre, color pertenece a FiguraGeometrica
        this.base = base;      //Guarda el valor en el objeto
        this.altura = altura; //Guarda el valor en el objeto
                             //izquierda -> atributo del objeto
                            //derecha -> parametro recibido
    }

    @Override                       //el override le dice a java: "este metodo esta sobreescribiendo uno de la clase padre". No es obligatorio, pero da a entender esto
    public double calcularArea(){  //implementa el metodo que la clase padre obligaba, cada figura tiene el suyo
        return base*altura;
    }
}

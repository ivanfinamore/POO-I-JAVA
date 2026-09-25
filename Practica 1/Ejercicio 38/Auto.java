class Auto extends Vehiculo {

    @Override
    public void acelerar(int incremento){
        super.acelerar(incremento*2);
    }

}

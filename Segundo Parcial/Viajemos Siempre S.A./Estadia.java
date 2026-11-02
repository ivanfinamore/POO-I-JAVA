public class Estadia{
    private int cantNoches;
    private boolean cambiosEnHabitacion;
    private Hotel hotel;



    public Estadia(int cantNoches, Hotel hotel, boolean cambiosEnHabitacion) {
        this.cambiosEnHabitacion = cambiosEnHabitacion;
        this.cantNoches = cantNoches;
        this.hotel = hotel;
    }



    public int getCantNoches() { return cantNoches; }
    public boolean isCambiosEnHabitacion() { return cambiosEnHabitacion; }
    public Hotel getHotel() { return hotel; }



    public void setCantNoches(int cantNoches) { this.cantNoches = cantNoches; }
    public void setCambiosEnHabitacion(boolean cambiosEnHabitacion) { this.cambiosEnHabitacion = cambiosEnHabitacion; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }

    


    

    



    
}
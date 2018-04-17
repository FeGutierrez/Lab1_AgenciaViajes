
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Flexxo333
 */
public class Travel {
    
    private int id;
    private Date inicio;
    private int duracion;
    private BookedFlight vueloSalida;
    private BookedFlight vueloRetorno;
    private Hotel hotelEstadia;
    
    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
    Date fecha = new Date();

    public Travel(Date inicio, int duracion) {
        this.inicio = inicio;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }    

    public Hotel getHotelEstadia() {
        return hotelEstadia;
    }

    public void setHotelEstadia(Hotel hotelEstadia) {
        this.hotelEstadia = hotelEstadia;
    }

    public BookedFlight getVueloSalida() {
        return vueloSalida;
    }

    public void setVueloSalida(BookedFlight vueloSalida) {
        this.vueloSalida = vueloSalida;
    }

    public BookedFlight getVueloRetorno() {
        return vueloRetorno;
    }

    public void setVueloLlegada(BookedFlight vueloRetorno) {
        this.vueloRetorno = vueloRetorno;
    }
    
    
        
    public Date sumarDias(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, this.duracion);
        return calendar.getTime();
    }
    
    public Date sumarMinutosVuelo(Date fecha, int minutosVuelo){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.MINUTE, minutosVuelo);
        return calendar.getTime();
    }
    
    public boolean registrarVueloSalida(int numeroVuelo, Date fecha, int minutosVuelo, Airport aeroSalida, Airport aeroLlegada){        
        this.vueloSalida = new BookedFlight(numeroVuelo, fecha, sumarMinutosVuelo(fecha, minutosVuelo));
        this.vueloSalida.setAeroSalida(aeroSalida);
        this.vueloSalida.setAeroRetorno(aeroLlegada);
        this.vueloSalida.setTiempoVuelo(minutosVuelo);
        return false;
    }
    public boolean registrarVueloRetorno(int numeroVuelo, Date fecha, int minutosVuelo, Airport aeroSalida, Airport aeroLlegada){        
        this.vueloRetorno = new BookedFlight(numeroVuelo, fecha, sumarMinutosVuelo(fecha, minutosVuelo));
        this.vueloRetorno.setAeroRetorno(aeroLlegada);
        this.vueloRetorno.setAeroSalida(aeroSalida);
        this.vueloRetorno.setTiempoVuelo(minutosVuelo);
        return false;
    }
    
    
    
    
}

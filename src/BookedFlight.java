
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class BookedFlight {
    
    private int numeroDeVuelo;
    private Date fechaSalida;
    private Date fechaLlegada;
    private Airport aeroSalida;
    private Airport aeroRetorno;
    private int tiempoVuelo;
    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
    Date fecha = new Date();

    public BookedFlight(int numeroDeVuelo, Date fechaSalida, Date fechaLlegada) {
        this.numeroDeVuelo = numeroDeVuelo;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
    }

    public int getTiempoVuelo() {
        return tiempoVuelo;
    }

    public void setTiempoVuelo(int tiempoVuelo) {
        this.tiempoVuelo = tiempoVuelo;
    }
    
    public int getNumeroDeVuelo() {
        return numeroDeVuelo;
    }

    public void setNumeroDeVuelo(int numeroDeVuelo) {
        this.numeroDeVuelo = numeroDeVuelo;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Airport getAeroSalida() {
        return aeroSalida;
    }

    public void setAeroSalida(Airport aeroSalida) {
        this.aeroSalida = aeroSalida;
    }

    public Airport getAeroRetorno() {
        return aeroRetorno;
    }

    public void setAeroRetorno(Airport aeroRetorno) {
        this.aeroRetorno = aeroRetorno;
    }



}

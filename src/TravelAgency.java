import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import sun.net.www.content.audio.x_aiff;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Flexxo333
 */
public class TravelAgency {
    
    private String nombre;
    //private  ArrayList<Hotel> hotelesConocidos;    
    ArrayList<Hotel> hotelesConocidos;
    ArrayList<Travel> viajesOfrecidos;
    ArrayList<Airport> aeropuertos;
    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
        Date date = new Date();

    public TravelAgency(String nombre) {
        this.nombre = nombre;
        this.hotelesConocidos = new ArrayList<>();
        this.viajesOfrecidos = new ArrayList<>();
        this.aeropuertos = new ArrayList<>();
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    

    public ArrayList<Hotel> getHotelesConocidos() {
        return hotelesConocidos;
    }

    public ArrayList<Travel> getViajesOfrecidos() {
        return viajesOfrecidos;
    }

    public ArrayList<Airport> getAeropuertos() {
        return aeropuertos;
    }
        
    //Como da varias posibilidades de false, es mas conveniente usar un indicador int al momento de usar un metodo para los mensajes de error?
    public boolean agregarHotel(Hotel hotel){
        boolean b = true;
        for (int i = 0; i < this.hotelesConocidos.size(); i++) {
            if (hotel.getNombre().equals(this.hotelesConocidos.get(i).getNombre()) && hotel.getDireccion().equals(this.hotelesConocidos.get(i).getDireccion())) {
                b=false;
                break;
            } 
        }
        for (int i = 0; i < this.hotelesConocidos.size(); i++) {
            if (hotel.getDireccion().equals(this.hotelesConocidos.get(i).getDireccion())) {
                b=false;
                break;
            } 
        }
        if (b==true) {
            this.hotelesConocidos.add(hotel);
        }
        
        return b;
    }
//    
//    public boolean agregarHotel(Hotel hotel){
//        boolean b=true;
//        for (int i = 0; i < this.hotelesConocidos.size(); i++) {
//            if (hotel.equals(this.hotelesConocidos.get(i))) {
//                b = false;
//                break;
//            }
//        }
//        if (b==true) {
//            this.hotelesConocidos.add(hotel);
//        }
//        return b;
//    }
    
    public String listarHoteles(){
        String hoteles ="Hoteles:\n";
        for (int i = 0; i < this.hotelesConocidos.size(); i++) {
            hoteles += " " + (i+1) + " Nombre: " + this.hotelesConocidos.get(i).getNombre() + " Dirección: " + this.hotelesConocidos.get(i).getDireccion()+"\n";
        }
        return hoteles;
    }
    

    public boolean agregarAeropuerto(Airport airport){
        boolean b = true;
        for (int i = 0; i < this.aeropuertos.size(); i++) {
            if (airport.getNombre().equals(this.aeropuertos.get(i).getNombre())) {
                b=false;
                break;
            }
        }
        
        if (b==true) {
            this.aeropuertos.add(airport);
        }
        return b;
    }
    
     public String listarAeropuertos(){
        String airports ="Aeropuertos:\n";
        for (int i = 0; i < this.aeropuertos.size(); i++) {
            airports += " " + (i+1) + " Nombre: " + this.aeropuertos.get(i).getNombre() + " \n";
        }
        return airports;
    }
    
    
     
    //hotelestadia
    //sumarhoras
    //vuelollegada
     
    public boolean registrarViaje(Date date, int duracionViaje, int idSalida, Airport aeropuertoSalida, 
        int duracionVueloPartida, int idRetorno, Airport aeropuertoRetorno, int duracionVueloRetorno, Hotel hotelEstadia){
        Travel travel = new Travel(date, duracionViaje);
        
        travel.setHotelEstadia(hotelEstadia);
        travel.registrarVueloSalida(idSalida, date, duracionVueloPartida, aeropuertoSalida, aeropuertoRetorno);
        travel.registrarVueloRetorno(idRetorno, travel.sumarDias(date), duracionVueloRetorno, aeropuertoRetorno, aeropuertoSalida);
        this.viajesOfrecidos.add(travel);
        travel.setId(this.viajesOfrecidos.size());
        return false;
    }
    
    public String listarResumenViajes(){
        String a = "INFO VIAJES: \n";
        for (int i = 0; i < this.viajesOfrecidos.size(); i++) {
            Travel x=this.viajesOfrecidos.get(i);
            a += "Id vuelo salida: "+ x.getVueloSalida().getNumeroDeVuelo() + " Aeropuerto salida: "+
                    x.getVueloSalida().getAeroSalida().getNombre()+" Descripcion aeropuerto: "+ x.getVueloSalida().getAeroSalida().getDescripcion() +                  
                    "\nVUELO RETORNO:\nId vuelo retorno: "+ x.getVueloRetorno().getNumeroDeVuelo() + " Aeropuerto de regreso: "+ 
                    x.getVueloRetorno().getAeroSalida().getNombre() + " Descripción aeropuerto de regreso: "+ 
                    x.getVueloRetorno().getAeroSalida().getDescripcion() + "\n\n";
                    }
        return a +"\n\n";
    }
    
        public String listarDetallesInfoViajes(){
        String a = "INFO VIAJES: \n";
        for (int i = 0; i < this.viajesOfrecidos.size(); i++) {
            Travel x=this.viajesOfrecidos.get(i);
            a += "ID: "+ x.getId()+ " Fecha registro: " + x.getFecha() + " Duracion: " + x.getDuracion() + 
                    " días.\nInfo del vuelo: \n SALIDA: \nId vuelo salida: "+ x.getVueloSalida().getNumeroDeVuelo() + " Aeropuerto salida: "+
                    x.getVueloSalida().getAeroSalida().getNombre()+" Descripcion aeropuerto: "+ x.getVueloSalida().getAeroSalida().getDescripcion() + " \nHora despegue vuelo de salida: " + x.getVueloSalida().getFechaSalida() +
                    " Hora aterrizaje: "+ x.getVueloSalida().getFechaLlegada() + "Aeropuerto aterrizaje: "+  x.getVueloSalida().getAeroRetorno().getNombre()+
                    "\nVUELO RETORNO:\nId vuelo retorno: "+ x.getVueloRetorno().getNumeroDeVuelo() + " Aeropuerto de regreso: "+ 
                    x.getVueloRetorno().getAeroSalida().getNombre()+ " Hora despegue retorno: "+ x.getVueloRetorno().getFechaSalida()+
                    " Hora aterrizaje retorno: "+ x.getVueloRetorno().getFechaLlegada()+ " Aeropuerto Retorno: " + x.getVueloRetorno().getAeroRetorno().getNombre()+ "\nHotel estadia: "+ x.getHotelEstadia().getNombre() + "\n\n";
        }
        return a +"\n";
    }
        
    public String descripcionAeropuertoNumeroVueloSalida(int id){
        Travel x=this.viajesOfrecidos.get(id);
        return "Numero de vuelo salida: " + x.getVueloSalida().getNumeroDeVuelo()+ " Descripción aeropuerto salida" + x.getVueloSalida().getAeroSalida().getDescripcion();
    }
    
    public Travel salidaMayorDuracion(){
        Travel mayorDuracion = null;
        for (int i = 0; i < this.viajesOfrecidos.size(); i++) {
            if (this.viajesOfrecidos.get(i)!=null && mayorDuracion == null) {
                mayorDuracion = this.viajesOfrecidos.get(i);
            } else {
                if (this.viajesOfrecidos.get(i)!=null && this.viajesOfrecidos.get(i).getVueloSalida().getTiempoVuelo() > mayorDuracion.getVueloSalida().getTiempoVuelo()) {
                    mayorDuracion = this.viajesOfrecidos.get(i);
                }
            }
        }
        return mayorDuracion;

    }
    
    public Travel retornoMayorDuracion(){
        Travel mayorDuracion = null;
        for (int i = 0; i < this.viajesOfrecidos.size(); i++) {
            if (this.viajesOfrecidos.get(i)!=null && mayorDuracion == null) {
                mayorDuracion = this.viajesOfrecidos.get(i);
            } else {
                if (this.viajesOfrecidos.get(i)!=null && this.viajesOfrecidos.get(i).getVueloRetorno().getTiempoVuelo() > mayorDuracion.getVueloRetorno().getTiempoVuelo()) {
                    mayorDuracion = this.viajesOfrecidos.get(i);
                }
            }
        }
        return mayorDuracion;
    }
}

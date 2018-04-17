
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Flexxo333
 */
public class Main {
    public static void main(String[] args) {
        
//        Gui gui = new Gui();
//        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gui.setSize(600,600);
//
//        gui.setVisible(true);
//        gui.setTitle("Agencia de Viajes");
        
        String fecha1 = "22/03/2017";
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
        Date date = new Date();
        
        
        

        
        
        TravelAgency agencia = new TravelAgency("Aviatur");
        
        Hotel a = new Hotel("Fontanar", "Cra. 21a #159a-28");
        System.out.println("FECHA ACTUAL: " + date);
        //System.out.println("LLEGADA: " + viaje1.sumarDias(date));
        agencia.agregarHotel(a);        
        System.out.println(agencia.listarHoteles());
        
        Airport air1 = new Airport("José Maria Cordoba", "Aeropuerto José María Córdoba en la ciudad de Medellín, Colombia");
        Airport air2 = new Airport("Aeropuerto El Dorado", "Aeropuerto El Dorado, en la ciuda de Bogotá, Colombia");
        Airport air3 = new Airport("Moscow", "Aeropuerto de Moscow");
        //Airport air4 = new Airport("Tokyo2222", "Aeropuerto de Moscow");

        agencia.agregarAeropuerto(air1);
        agencia.agregarAeropuerto(air2);
        agencia.agregarAeropuerto(air3);
        ///agencia.agregarAeropuerto(air4);
        
        System.out.println(agencia.listarAeropuertos());
        

        
        //Registrar viaje FECHA, DURACION, ID SALIDA, AEROSALIDA, DURACION 
        //VUELO SALIDA, ID RETORNO, AEORPUERTO RETORNO, DIRACOIN VUELO RETORNO, HOTEL
        agencia.registrarViaje(date, 10, 1345, air1, 30, 1346, air2, 30, a);
        agencia.registrarViaje(date, 10, 2222, air1, 55, 2223, air2, 35, a);
        //agencia.registrarViaje(date, 10, 2, air2, 3, 3, air1, 3, b);
        
       System.out.println(agencia.listarResumenViajes());
       
        System.out.println("POR ID");
        System.out.println(agencia.descripcionAeropuertoNumeroVueloSalida(0));
        
        System.out.println("Salida mayor duración: " +agencia.salidaMayorDuracion().getVueloSalida().getTiempoVuelo());
        System.out.println("Salida menor duración: "+agencia.retornoMayorDuracion().getVueloRetorno().getTiempoVuelo());
        

        
    }
}


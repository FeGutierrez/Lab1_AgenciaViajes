
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Flexxo333
 */
public class strDate {
    
    private String str;

    public strDate(String str) {
        this.str = str;
    }
    
    public Date convertir(){
        
        Date ffinal = new Date();
               
        try {
            String string = this.str;
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date date2;
            date2 = format.parse(string);
            ffinal = date2;
        } catch (ParseException ex) {
            Logger.getLogger(strDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ffinal;
    }
    
    
}

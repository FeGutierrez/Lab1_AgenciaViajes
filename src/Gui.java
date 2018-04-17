import javax.swing.JFrame;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;
/**
 *
 * @author Flexxo333
 */
public class Gui extends JFrame{
    
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JTextField textfield1;
    private ImageIcon image1;
    
    public Gui(){

        
        image1 = new ImageIcon(getClass().getResource("f.jpg"));
        label2 = new JLabel(image1);
        
        add(label2);
        
        setLayout(new FlowLayout());
        label1 = new JLabel("Hola soy un label");
        add(label1);
        
        textfield1 = new JTextField(20);
        add(textfield1);
        
        button1 = new JButton("¿Pregunta?");
        add(button1);
        
        Event e = new Event();
        button1.addActionListener(e);
    };
    
    public class Event implements ActionListener{
        public void actionPerformed(ActionEvent e){
            label1.setText("¿Cómo implementar métodos en un "
                    + "botón tomando como parametro otros campos de la ventana?");
  
        }
        
        
    }
   
}

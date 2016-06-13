import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Class ATMWindowHandler adalah kelas tambahan WindowAdapter yang berguna untuk menangani
 * window ATM GUI
 * @author Muhammad Taqiyuddin
 * @version 20/5/2016
 */
public class ATMWindowHandler extends WindowAdapter
{
    /**
     * Constructor for objects of class WindowHandler
     */
    public ATMWindowHandler()
    {
        
    }
    
    /**
     * Method override untuk menampilkan pesan ketika window di-close
     * @param windowEvent Event
     */
    public void windowClosing(WindowEvent windowEvent) {
        JOptionPane.showMessageDialog(null, "You are exiting, goodbye!");
    }
}

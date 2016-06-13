import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Class ATMButtonHandler adalah kelas yang mengimplementasikan ActionListener yang berguna untuk menangani
 * segala event yang terjadi bila kita menekan tombol yang ada di ATMGUI
 * @author Muhammad Taqiyuddin
 * @version 20/5/2016
 */
public class ATMButtonHandler implements ActionListener
{
    private ATMGUI gui;
    
    /**
     * Method ATMButtonHandler
     * @param gui objek dari kelas ATMGUI
     */
    public ATMButtonHandler(ATMGUI gui)
    {
        this.gui = gui;
    }
    
    /**
     * Method actionPerformed
     * @param e objek dari ActionEvent
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("deposit")) {
            if(searchAccount() != null) {
                depositAction(searchAccount(), gui.getAmount());
                Teller.editCustomer(Teller.getCustomer(gui.getID()));
            }
        }
        else if(e.getActionCommand().equals("withdraw")) {
            if(searchAccount() != null) {
                withdrawAction(searchAccount(), gui.getAmount());
                Teller.editCustomer(Teller.getCustomer(gui.getID()));
            }
        }
        else if(e.getActionCommand().equals("total")) {
            if(searchAccount() != null) {
                gui.setText("Total amount of money in Account " + searchAccount().getId() + ": Rp" + searchAccount().getBalance());
            }
        }
        else if(e.getActionCommand().equals("exit")) {
            JOptionPane.showMessageDialog(null, "You are exiting, goodbye!");
            System.exit(0);
        }
        else if(e.getActionCommand().equals("cust")) {
            System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                }
            });
        }
    }
    
    /**
     * Method untuk mencari account sesuai input pada GUI
     * @return a objeck dari kelas Account 
     */
    public Account searchAccount()
    {
        Account a = null;
        Customer c = null;
        try {
            c = Teller.getCustomer(gui.getID());
            try {
                a = c.getAccount(gui.getAcctType());
            } catch (AccountTypeNotFoundException notfound) {
                gui.setText(notfound.getMessage());
            }
        } catch (NullPointerException e) {
            gui.setText("Customer ID does not exist");
        }
        return a;
    }
    
    /**
     * Method withdrawAction
     * @param a Account
     * @param amount Jumlah uang yang akan diambil
     */
    public void withdrawAction(Account a, double amount)
    {
        try {
            a.withdraw(amount);
            gui.setText("" + a.getId() 
                        + " withdraws an amount of money: Rp" 
                        + gui.getAmount());
        } catch (AmountOverDrawnException e) {
            gui.setText(e.getMessage());
            JOptionPane.showMessageDialog(null, "Transaction failed");
        }
    }
    
    /**
     * Method depositAction
     * @param a Account
     * @param amount Jumlah uang yang akan disimpan
     */
    public void depositAction(Account a, double amount) {
        a.deposit(amount);
        gui.setText("" + a.getId() 
                    + " saves an amount of money: Rp" 
                    + gui.getAmount());
    }
}

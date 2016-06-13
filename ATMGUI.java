import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.*;
/**
 * Class ATMGUI adalah kelas yang menambahan class JFrame yang berasal dari Library.
 * Kelas ini berfungsi untuk menampilkan GUI tentang penanganan akun yang menyimpan dan mengambil uang 
 * dari JBANK
 * @author Muhammad Taqiyuddin
 * @version 20/52016
 */

public class ATMGUI extends JFrame 
{
    private JButton depositBtn;
    private JButton withdrawBtn;
    private JButton totalBtn;
    private JButton exitBtn;
    private JButton custBtn;
    private JLabel idLabel;
    private JLabel amountLabel;
    private JRadioButton savingsRadioBtn;
    private JRadioButton investmentRadioBtn;
    private JRadioButton locRadioBtn;
    private JRadioButton overdraftRadioBtn;
    private JTextArea textArea;
    private JTextField idField;
    private JTextField amountField;
    private ButtonGroup group;

   /**
     * Constructor ATMGUI
     */
    public ATMGUI(){
        super("ATM");
        
        depositBtn = new JButton();
        withdrawBtn = new JButton();
        totalBtn = new JButton();
        exitBtn = new JButton();
        custBtn = new JButton();
        
        idLabel = new JLabel();
        amountLabel = new JLabel();
        
        savingsRadioBtn = new JRadioButton();
        investmentRadioBtn = new JRadioButton();
        locRadioBtn = new JRadioButton();
        overdraftRadioBtn = new JRadioButton();
        
        textArea = new JTextArea();
        
        idField = new JTextField();
        amountField = new JTextField();
        
        buildGUI();
    }

    /**
     * Method to build GUI
     */
    public void buildGUI(){
        super.setSize(600,400);
        super.setResizable(false);
        super.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        super.addWindowListener(new ATMWindowHandler());
        
        //================================Panel=======================================
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.setPreferredSize(new Dimension(120,200));
        buttonPanel.setBackground(new Color(192,192,192));
        
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setLayout(new BoxLayout(checkboxPanel, BoxLayout.PAGE_AXIS));
        checkboxPanel.setPreferredSize(new Dimension(130,150));
        checkboxPanel.setBorder(BorderFactory.createTitledBorder("Account Type"));
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());
        infoPanel.setPreferredSize(new Dimension(600,150));
        
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout());
        textPanel.setPreferredSize(new Dimension(600,250));
        textPanel.setBackground(new Color(192,192,192));

        JPanel custPanel = new JPanel();
        custPanel.setLayout(new FlowLayout());
        custPanel.setPreferredSize(new Dimension(600,50));
        custPanel.setBackground(new Color(192,192,192));
        
        
        //================================ Button =====================================
        ATMButtonHandler btnHandler = new ATMButtonHandler(this);

        depositBtn.setMaximumSize(new Dimension(120,50));
        depositBtn.setBackground(new Color(214,217,223));
        depositBtn.setForeground(new Color(0,0,0));
        depositBtn.setEnabled(true);
        depositBtn.setText("Deposit");
        depositBtn.setVisible(true);
        depositBtn.setActionCommand("deposit");
        depositBtn.addActionListener(btnHandler);

        withdrawBtn.setMaximumSize(new Dimension(120,50));
        withdrawBtn.setBackground(new Color(214,217,223));
        withdrawBtn.setForeground(new Color(0,0,0));
        withdrawBtn.setEnabled(true);
        withdrawBtn.setText("Withdraw");
        withdrawBtn.setVisible(true);
        withdrawBtn.setActionCommand("withdraw");
        withdrawBtn.addActionListener(btnHandler);

        totalBtn.setMaximumSize(new Dimension(120,50));
        totalBtn.setBackground(new Color(214,217,223));
        totalBtn.setForeground(new Color(0,0,0));
        totalBtn.setEnabled(true);
        totalBtn.setText("Total");
        totalBtn.setVisible(true);
        totalBtn.setActionCommand("total");
        totalBtn.addActionListener(btnHandler);

        exitBtn.setMaximumSize(new Dimension(120,50));
        exitBtn.setBackground(new Color(214,217,223));
        exitBtn.setForeground(new Color(0,0,0));
        exitBtn.setEnabled(true);
        exitBtn.setText("Exit");
        exitBtn.setVisible(true);
        exitBtn.setActionCommand("exit");
        exitBtn.addActionListener(btnHandler);
        
        custBtn.setMaximumSize(new Dimension(120,50));
        custBtn.setBackground(new Color(214,217,223));
        custBtn.setForeground(new Color(0,0,0));
        custBtn.setEnabled(true);
        custBtn.setText("Customer Menu");
        custBtn.setVisible(true);
        custBtn.setActionCommand("cust");
        custBtn.addActionListener(btnHandler);
        
        //=============================== Label ========================================
        idLabel.setPreferredSize(new Dimension(110,35));
        idLabel.setBackground(new Color(214,217,223));
        idLabel.setForeground(new Color(0,0,0));
        idLabel.setEnabled(true);
        idLabel.setText("Enter customer id");
        idLabel.setVisible(true);

        amountLabel.setPreferredSize(new Dimension(110,35));
        amountLabel.setBackground(new Color(214,217,223));
        amountLabel.setForeground(new Color(0,0,0));
        amountLabel.setEnabled(true);
        amountLabel.setText("Enter amount here");
        amountLabel.setVisible(true);

        //=============================== Radio Button ================================
        savingsRadioBtn.setMaximumSize(new Dimension(100,35));
        savingsRadioBtn.setBackground(new Color(214,217,223));
        savingsRadioBtn.setForeground(new Color(0,0,0));
        savingsRadioBtn.setEnabled(true);
        savingsRadioBtn.setSelected(true);
        savingsRadioBtn.setText("Savings");
        savingsRadioBtn.setActionCommand("S");
        savingsRadioBtn.setVisible(true);

        investmentRadioBtn.setMaximumSize(new Dimension(100,35));
        investmentRadioBtn.setBackground(new Color(214,217,223));
        investmentRadioBtn.setForeground(new Color(0,0,0));
        investmentRadioBtn.setEnabled(true);
        investmentRadioBtn.setText("Investment");
        investmentRadioBtn.setActionCommand("I");
        investmentRadioBtn.setVisible(true);

        locRadioBtn.setMaximumSize(new Dimension(100,35));
        locRadioBtn.setBackground(new Color(214,217,223));
        locRadioBtn.setForeground(new Color(0,0,0));
        locRadioBtn.setEnabled(true);
        locRadioBtn.setText("Line Of Credit");
        locRadioBtn.setActionCommand("L");
        locRadioBtn.setVisible(true);

        overdraftRadioBtn.setMaximumSize(new Dimension(100,35));
        overdraftRadioBtn.setBackground(new Color(214,217,223));
        overdraftRadioBtn.setForeground(new Color(0,0,0));
        overdraftRadioBtn.setEnabled(true);
        overdraftRadioBtn.setText("Overdraft");
        overdraftRadioBtn.setActionCommand("O");
        overdraftRadioBtn.setVisible(true);
        
        group = new ButtonGroup();
        group.add(savingsRadioBtn);
        group.add(investmentRadioBtn);
        group.add(locRadioBtn);
        group.add(overdraftRadioBtn);

        // =================================== Text Area ===============================
        textArea.setPreferredSize(new Dimension(450,200));
        textArea.setBackground(new Color(255,255,255));
        textArea.setForeground(new Color(0,0,0));
        textArea.setEnabled(true);
        textArea.setText("Welcome to JBank");
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setVisible(true);
        
        idField.setPreferredSize(new Dimension(90,35));
        idField.setBackground(new Color(255,255,255));
        idField.setForeground(new Color(0,0,0));
        idField.setEnabled(true);
        idField.setText("1000");
        idField.setVisible(true);

        amountField.setPreferredSize(new Dimension(90,35));
        amountField.setBackground(new Color(255,255,255));
        amountField.setForeground(new Color(0,0,0));
        amountField.setEnabled(true);
        amountField.setText("0");
        amountField.setVisible(true);

        //========================== Penambahan Komponen ke Panel =======================
        checkboxPanel.add(savingsRadioBtn);
        checkboxPanel.add(investmentRadioBtn);
        checkboxPanel.add(locRadioBtn);
        checkboxPanel.add(overdraftRadioBtn);
        
        infoPanel.add(idLabel);
        infoPanel.add(idField);
        infoPanel.add(checkboxPanel);
        infoPanel.add(amountLabel);
        infoPanel.add(amountField);
        
        buttonPanel.add(depositBtn);
        buttonPanel.add(withdrawBtn);
        buttonPanel.add(totalBtn);
        buttonPanel.add(exitBtn);
        
        textPanel.add(textArea);
        textPanel.add(buttonPanel);

        custPanel.add(custBtn);
  
        super.add(infoPanel);
        super.add(textPanel);
        super.add(custPanel);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.pack();
        super.setVisible(true);
    }

    /**
     * Method Accessor getId untuk mendapatkan ID customer
     * @return ID customer
     */
    public int getID()
    {
        return Integer.parseInt(idField.getText());
    }
    
    /**
     * Method accessor getAmount untuk mendapatkan banyaknya uang yang ada pada customer
     * @return Amount
     */
    public double getAmount() 
    {
        return Double.parseDouble(amountField.getText());
    }
    
    /**
     * Method untuk mendapatkan teks dalam JTextArea
     * @return Text
     */
    public String getText()
    {
        return textArea.getText();
    }
    
    /**
     * Method untuk mengubah teks dalam JTextArea
     * @param text Text yang ingin ditampilkan
     */
    public void setText(String text)
    {
        textArea.setText(text);
    }
    
    /**
     * Method untuk mendapatkan tipe akun dari JRadioButton
     * @return Tipe akun
     */
    public char getAcctType()
    {
        return group.getSelection().getActionCommand().charAt(0);
    }
    
    /**
     * Main function
     */
    public static void main(String[] args)
    {
        //System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Teller();
                new ATMGUI();
            }
        });
    }
}
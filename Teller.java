import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.lang.Math;
import java.math.MathContext;
import java.math.RoundingMode;
import java.awt.*;
import java.io.*;
/**
 * class Teller sebagai kelas utama dari Jbank
 * @author Muhammad Taqiyuddin 
 * @version 20/5/2016
 */
public class Teller
{
    private static Date closeTime, startTime, dateOfBirth;
    public static Bank bank;
    private static MathContext mc = new MathContext(3);
    private static SortedSet<Customer> customers = new TreeSet<Customer>();
    private Customer customer; 
    private static Customer c;
    private CustomerFileReader cfr;
    private CustomerFileWriter cfw;
    
    /**
     * Constructor Teller
     */
    public Teller() {
        cfw = new CustomerFileWriter();
        cfr = new CustomerFileReader();

    }
    
    /**
     * Main method dari class Teller membuat object meng-assign object a1 ke c1
     * mengisi nilai balance dan nama lalu menampilkan keduanya.
     * @param args Command-Line Arguments
     */
    public static void main(String[] args) 
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            c = new Customer("Muhammad", "Taqiyuddin", sdf.parse("31/03/1995"));
        }
        catch (ParseException e) {
            System.out.println("Exception :" + e.getMessage());
        }
        c.setPhoneNumber("0851");
        c.setAddress("Griya Lembah", "Depok", "Jawa", "16417");
        c.setEmail("mtaqiyuddin31@gmail.com");
        try{
            c.setCustID(1000);
        }catch(CustUnknownException e){
            System.out.println(e.getMessage());
        }
        Savings s = new Savings(c, 500);
        Investment i = new Investment(c, 500, 100);
        LineOfCredit l = new LineOfCredit(c, 500, 30);
        try {
            c.addAccount(s);
            c.addAccount(i);
            c.addAccount(l);
        } catch(AccountTypeAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        try {
            Teller.createNewCustomer(c);
        } catch(Exception e) {
            System.out.println("Failed to add customer");
        }
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Teller();
                new ATMGUI();
            }
        });
    }
    
    /**
     * Method getCustomer to iterate between the Sorted Set
     * @param custId
     */
    public static Customer getCustomer(int custID) {
        Customer cust = null;
        Iterator<Customer> itr = customers.iterator();
        while(itr.hasNext()) {
            cust = itr.next();
            if(cust.getCustomerId() == custID) {
                return cust;
            }
            else {
                cust = null;
            }
        }
        return cust;
    }
    
    /**
     * Method untuk melakukan edit customer dalam SortedSet
     * @param custID ID customer
     */
    public static void editCustomer(Customer c) 
    {
        Iterator<Customer> itr = customers.iterator();
        while(itr.hasNext()) {
            if(itr.next().getCustomerId() == c.getCustomerId()) {
                itr.remove();
            }
        }
        createNewCustomer(c);
    }
    
    /**
     * Method getCustomer2 to iterate between the sorted set after readObject
     */
    public Customer getCustomer2(SortedSet<Customer> a, int id){
        Customer c = null;
        Iterator<Customer> it = a.iterator();
        while(it.hasNext()){
            c = it.next();
            if(c.getCustomerId() == id){
                break;
            }
        }
        return c;
    }
    
    /**
     * Method createNewCustomer untuk membuat Customer baru 
     * @param c Customer 
     */
    public static void createNewCustomer(Customer c) 
    {
        customers.add(c);
        CustomerFileWriter writer = new CustomerFileWriter();
        writer.saveCustomers(customers);
    }
    
    /**
     * Method Accessor getCustomer untk mencari Customer
     * @param custId nomor ID Customer
     * @return ke objek Customer
     */
    public static Customer getNewCustomer(int custID)
    {
        Customer cust = null;
        Iterator<Customer> itr = customers.iterator();
        while(itr.hasNext()) {
            cust = itr.next();
            if(cust.getCustomerId() == custID) {
                return cust;
            }
            else {
                cust = null;
            }
        }
        return cust;
    }    
    
    /**
     * Method getCloseTime Mendapatkan waktu tutup
     * @return Waktu tutup
     */
    public static Date getCloseTime() {
        return closeTime;
    }
    
    /**
     * Method getStartTime Mendapatkan waktu mulai
     * @return Waktu buka
     */
    public static Date getStartTime() {
        return startTime;
    }
    
    /**
     * Method setCloseTime Menentukan waktu tutup
     * @param hour Satuan Jam
     * @param min Satuan Menit
     */
    public static void setCloseTime(int year,int month,int day,int hour, int min) {
        Bank.closeTime = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
    /**
     * Method setStartTime Menentukan waktu mulai
     * @param hour Satuan Jam
     * @param min Satuan Menit
     */
    public static void setStartTime(int year,int month,int day, int hour, int min) {
        Bank.startTime = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
    /**
     * Method setStartTime Menentukan waktu mulai
     * @param hour Satuan Jam
     * @param min Satuan Menit
     */
    public static void printTime() {
        System.out.println(Bank.getHoursOfOperation());
    }
}

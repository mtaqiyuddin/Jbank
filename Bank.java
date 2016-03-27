import java.text.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.*;
import java.text.SimpleDateFormat;
/**
 * Class bank
 * @author Muhammad Taqiyuddin 
 * @version 19/02/2016
 */
public class Bank
{
    // instance variables - replace the example below with your own
    private static double creditInterestRate, investmentInterestRate, premiumInterestRate;
    private static BigDecimal creditRate, investmentRate, premiRate;
    public static int lastCustID, nextCustID, numOfCurrentCustomer, nextID;
    private String phone;
    public static Date closeTime, startTime;
    public String website;
    public static final int MAX_CUSTOMERS;
    public static final String BANK_NAME = "JBANK", BANK_ADDRESS = "1234 JavaStreet, AnyCity, ThisState, 34567";
    static {
        Scanner s = new Scanner(System.in);
        System.out.print("\nMasukkan jumlah maksimum customer: ");
        int x= s.nextInt();
        MAX_CUSTOMERS = x;
    }
    
    private static Customer[] Customers = new Customer[MAX_CUSTOMERS];
    
    /*Constructor objek class Bank*/
    public Bank(){
        //inisiasi
    }
    
    /**
     * Method addCustomer Menambahkan objek customer ke array Customers
     * @param customer Objek dari kelas Customer
     * @return True or False
     */
    public static boolean addCustomer (Customer customer) {
        for (int i = 0; i < Customers.length; i++){
            if (Customers[i] == null) {
                Customers[i] = customer;
                return true;
            } 
        }
        return false;
    }
    
    /**
     * Method getCustomer Mendapatkan objek customer berdasarkan ID
     * @param custID Customer ID
     * @return Objek Customer atau Null
     */
    public static Customer getCustomer (int custID) {
        for (int i = 0; i < Customers.length; i++){
            if (Customers[i].getCustomerId() == custID) {
                return Customers[i];
            } 
        }
        return null;
    }
    
    /**
     * Method getMaxNumOfCustomers Mendapatkan jumlah maksimum customer
     * @return Jumlah maksimum customer
     */
    public static int getMaxNumOfCustomers () {
        return MAX_CUSTOMERS;
    }
    
    /**
     * Method getAddress
     */
    /*public static String getAddress()
    {
        return null;
    }*/
        
    /**
     * Method getMaxCustomers
     */
    /*public static int getMaxCustomers()
    {
        return MAX_CUSTOMERS;
    }*/
    
    /**
     * Method getName
     */
    /*public static String getName()
    {
        return null;
    }*/
    /**
     * Method getCreditRate
     */
    public static double getCreditRate()
    {
        return creditInterestRate;
    }
    
    /**
     * Method getInvestmentRate
     */
    public static double getInvestmentRate()
    {
        return investmentInterestRate;
    }
    
    /**
     * Method getPremiumRate
     */
    public static double getPremiumRate() {
        return premiumInterestRate;
    }
    
     /**
     * Method getHoursOfOperation
     */
    public static String getHoursOfOperation()
    {
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm a");
        return ft.format(startTime) + " TO " + ft.format(closeTime);
    }
    
    /**
     * Method setHoursOfOperation Menentukan waktu operasi
     * @return True atau False
     */
    public boolean setHoursOfOperation(Date startTime, Date closeTime) {
        if (this.startTime != null || this.closeTime != null) {
            startTime = this.startTime;
            closeTime = this.closeTime;
            return true;
        } else {
            startTime = this.startTime;
            closeTime = this.closeTime;
            return false;
        }
    }
    
    /**
    * Method getStartTime
    * @return waktu mulai
    */
    public static Date getStartTime (){
        return startTime;
    }
    
    /**
    * Method setStartTime
    * @param hour Satuan Jam
    * @param min Satuan Menit
    */
    public static void setStartTime (int hour, int min){   
        startTime = new GregorianCalendar(0,0,0,hour, min).getTime();
    }
    
    /**
    * Method getCloseTime
    * @return waktu tutup
    */
    public static Date getCloseTime()
    {
       return closeTime;
    }
    
    /**
    * Method getStartTime
    * @param hour Satuan Jam
    * @param min Satuan Menit
    */
   public static void setCloseTime (int hour, int min){
       closeTime = new GregorianCalendar(0,0,0,hour, min).getTime();
   }
    
    /**
     * Method getLastID
     */
    public static int getLastID()
    {
        return lastCustID;
    }
    
    /**
     * Method getNumOfCurrentCustomers
     * @return Jumlah pelanggan saat ini
     */
    public static int getNumOfCurrentCustomers() {
        return numOfCurrentCustomer;
    }
    
    /**
     * Method getNextID
     */
    public static int getNextID() {
        if (nextCustID == 0)  {
            lastCustID = 1000;
            nextCustID = 1000;
            numOfCurrentCustomer = 1;
            return nextCustID;
        }
        else if (numOfCurrentCustomer == MAX_CUSTOMERS){
            return nextCustID;
        }
        else {
            lastCustID = nextCustID;
            nextCustID = lastCustID + 1;
            numOfCurrentCustomer++;
            return nextCustID;
        }
    }
    
    public static String getWebsite() {
        return null;
    }
    
    /**
     * Method getPhone
     */
    public static String getPhone() {
        return null;
    }
    
    /**
     * Method setCreditRate
     * @param rate Nilai Rasio Kredit
     */
    public static void setCreditRate(double rate) {
    }
    
    /**
     * Method setInvestmentRate
     * @param rate Nilai Rasio Investment
     */
    public static void setInvestmentRate(double rate) {
    }
    
    /**
     * Method setPremium
     * @param rate Nilai Rasio Kredit
     */
    public static void setPremium(double rate) {
    }
    
    public void printAllCustomers() {
        for (Customer c : Customers) {
            System.out.println(c);
        }
    }
}

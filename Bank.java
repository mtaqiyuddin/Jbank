import java.text.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.*;
import java.text.SimpleDateFormat;
/**
 * Class bank
 * @author Muhammad Taqiyuddin 
 * @version 20/5/2016
 */
public class Bank
{
    // instance variables
    private static double creditInterestRate, investmentInterestRate, premiumInterestRate;
    private static BigDecimal creditRate, investmentRate, premiRate;
    public static int lastCustID, nextCustID, numOfCurrentCustomer, nextID;
    private static String phone;
    public static Date closeTime, startTime;
    public static String website;
    public static final int MAX_CUSTOMERS = 4;
    public static final String BANK_NAME = "JBANK", BANK_ADDRESS = "1234 JavaStreet, AnyCity, ThisState, 34567";
    
    /*static {
        Scanner s = new Scanner(System.in);
        System.out.print("\nMasukkan jumlah maksimum customer: ");
        int x= s.nextInt();
        MAX_CUSTOMERS = x;
    }*/
    
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
        boolean customerAdded = false;
        int i = 0;
        if(numOfCurrentCustomer <= Customers.length) {
            int notUsed = -1;
            for(i = 0; i < Customers.length; i++) {
                if(Customers[i] == null && notUsed == -1) {
                    notUsed = i;
                }
                else {
                    customerAdded = false;
                }
            }
            if(notUsed != -1) {
                Customers[notUsed] = customer;
                customerAdded = true;
            }
        }
        return customerAdded;
    }
    
    /**
     * Method getMaxNumOfCustomers Mendapatkan jumlah maksimum customer
     * @return Jumlah maksimum customer
     */
    public static int getMaxNumOfCustomers () {
        return MAX_CUSTOMERS;
    }

    /**
     * Method getCreditRate
     * @return rate kredit
     */
    public static double getCreditRate()
    {
        return creditInterestRate;
    }
    
    /**
     * Method getInvestmentRate
     * @return rate investment
     */
    public static double getInvestmentRate()
    {
        return investmentInterestRate;
    }
    
    /**
     * Method getPremiumRate
     * @return rate premi
     */
    public static double getPremiumRate() {
        return premiumInterestRate;
    }
    
     /**
     * Method getHoursOfOperation
     * @return waktu mulai sampai waktu selesai
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
     * Method accessor getCustomer
     * @param custID nomor ID customer
     * @return Customer
     */
    public static Customer getCustomer(int custID)
    {
        Customer c = null;
        int i = 0;
        for(i = 0; i < Customers.length; i++) {
            if(Customers[i] != null && custID == Customers[i].getCustomerId()) {
                c = Customers[i];
                return c;
            }
        }
        return c;
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
     * @return id terakhir
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
     * @return id selanjutnya
     */
    public static int getNextID() {
        int lokal = 0;
        if (nextCustID == 0){
            lastCustID = 1000;
            lokal = 1000;
            numOfCurrentCustomer++;
            nextCustID = lokal;
            return lokal;
        }
        else{
            if (numOfCurrentCustomer == MAX_CUSTOMERS){
                lokal = 0;
                nextCustID = lokal;
                return lokal;
            }
            lastCustID = nextCustID;
            lokal = lastCustID + 1;
            numOfCurrentCustomer++;
            nextCustID = lokal;
            return lokal;
        }
    }
    
    public static String getWebsite() {
        return website;
    }
    
    /**
     * Method getPhone
     */
    public static String getPhone() {
        return phone;
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
            if (c != null){
                System.out.println(c);
            }
        }
    }
}

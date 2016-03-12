import java.text.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    private static Date closeTime, startTime;
    public String website;
    public static final int MAX_CUSTOMERS =20 ;
    public static final String BANK_NAME = "JBANK", BANK_ADDRESS = "1234 JavaStreet, AnyCity, ThisState, 34567";
    
    /*Constructor objek class Bank*/
    private Bank(){
        //inisiasi
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
        return null;
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
    * @param strTime waktu mulai
    */
    public static void setStartTime (Date start){   
        startTime = start;
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
    * @param waktu tutup
    */
   public static void setCloseTime (Date close){
       closeTime = close;
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
}

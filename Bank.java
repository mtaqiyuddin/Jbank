
/**
 * Class bank
 * @author Muhammad Taqiyuddin 
 * @version 19/02/2016
 */
public class Bank
{
    // instance variables - replace the example below with your own
    private static double creditInterestRate, investmentInterestRate, premiumInterestRate;
    private static int lastCustID, nextCustID, numOfCurrentCustomer, nextID;
    public static int maxNumOfCustomers =20 ;
    private String closeTime, phone, startTime;
    public String website, bankName = "JBANK", bankAddress = "1234 JavaStreet, AnyCity, ThisState, 34567";
    
    /**
     * Method getAddress
     */
    public static String getAddress()
    {
        return null;
    }
    
    /**
     * Method getCreditRate
     */
    public static double getCreditRate()
    {
        return 0;
    }
    
    /**
     * Method getInvestmentRate
     */
    public static double getInvestmentRate()
    {
        return 0;
    }
    
     /**
     * Method getHoursOfOperation
     */
    public static String getHoursOfOperation()
    {
        return null;
    }
    
    /**
     * Method getLastID
     */
    public static int getLastID()
    {
        return 0;
    }
    
    /**
     * Method getMaxCustomers
     */
    public static int getMaxCustomers()
    {
        return 0;
    }
    
    /**
     * Method getNumOfCurrentCustomers
     * @return Jumlah pelanggan saat ini
     */
    public static int getNumOfCurrentCustomers() {
        return numOfCurrentCustomer;
    }
    
    /**
     * Method getName
     */
    public static String getName()
    {
        return null;
    }
    
    /**
     * Method getNextID
     */
    public static int getNextID() {
        if (nextCustID == 0)  {
            lastCustID = 1000;
            nextCustID = 1000;
            return nextCustID;
        }
        else {
            lastCustID = nextCustID;
            nextCustID = lastCustID + 1;
            return nextCustID;
        }
    }
    public static String getWebsite() {
        return null;
    }
    public static double getPremiumRate() {
        return 0;
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

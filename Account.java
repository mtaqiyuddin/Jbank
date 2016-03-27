import java.math.BigDecimal;
import java.lang.Math;
import java.math.MathContext;

/**
 * Class Account menghasilkan object Account dan terdiri dari beberapa method
 * @author Muhammad Taqiyuddin 
 * @version 19/02/2016
 */
public abstract class Account
{
    // instance variables - replace the example below with your own
    public char acctType;
    public double balance;
    public String id;
    protected int numOfDays;
    
    /**
     * Method Constructor Account
     */
    public Account() {
    }
    
    /**
     * Method Constructor Account
     * @param type Tipe dari Akun
     * @param amount Jumlah Nilai
     */
    /*
    public Account(Customer cust, double amount, char type) {
        acctType = type;
        balance = amount;
        id = cust.getCustomerId()+ "" + type;
    }
    */
    public String toString() {
        System.out.println("Account Type  :   " + acctType);
        System.out.println("ID            :   " + id);
        System.out.println("Balance       :   " + balance);
        return "";
    }
    
    public String toString(String ID) {
        System.out.println("ID            :   " + id);
        return id;
    }
    
    /**
     * Method deposit untuk mendeposit atau menambahkan sejumlah uang ke akun
     * @param amount Jumlah Nilai
     */
    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        } else {
            balance += amount;
            return true;
        }   
    }
    
    /**
     * Method getBalance
     * @return Jumlah balance yang dimiliki
     */
    public double getBalance() {
        return balance;
    }
    
     /**
     * Method getId
     * @return ID dari akun yang bersangkutan
     */
    public String getId() {
        return id;
    }
    
    /**
     * Method setBalance Menentukan jumlah balance pada suatu akun 
     * @param amount Jumlah Nilai
     */
    public void setBalance(double amount) {
        balance = amount;
    }
    
    /**
     * Method withdraw Mengambil sejumlah uang dari suatu akun 
     * @param amount Jumlah Nilai Kas
     */
    public abstract boolean withdraw(double amount);

    protected static double futureValue(double balance, double rate, double compound, double period) {
        MathContext mc = new MathContext(3);
        BigDecimal bal = new BigDecimal (balance);
        BigDecimal r = new BigDecimal (rate);
        BigDecimal n = new BigDecimal (compound);
        BigDecimal t = new BigDecimal (period);
        BigDecimal f1 = r.divide(n, mc.DECIMAL32).add(new BigDecimal(1));
        BigDecimal f2 = n.multiply(t, mc.DECIMAL32);
        BigDecimal f3 = new BigDecimal (Math.pow(f1.doubleValue(), f2.doubleValue()),mc.DECIMAL32);
        BigDecimal f4 = f3.multiply(bal, mc.DECIMAL32);
        return f4.doubleValue();
    }
}
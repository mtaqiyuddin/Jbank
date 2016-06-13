import java.math.BigDecimal;
import java.lang.Math;
import java.math.MathContext;
import java.io.Serializable;

/**
 * Class abstrak Account menangani akun
 * @author Muhammad Taqiyuddin 
 * @version 20/5/2016
 */
public abstract class Account
{
    // instance variables
    public double balance;
    public String id;
    
    /**
     * Method toString untuk mendapatkan string dari variable
     * @return ID dari akun yang bersangkutan
     */
    public String toString(int ID) {
        return String.format(ID + "");
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
    public abstract void withdraw(double amount) throws AmountOverDrawnException;

    /**
     * Method futureValue digunakan untuk menghitung nilai uang di masa depan
     * @param balance jumlah balance
     * @param rate nilai bunga
     * @param compound nilai gabungan
     * @param period lama uang disimpan
     */
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
import java.io.Serializable;

/**
 * Class Saving adalah kelas tambahan dari Account yang berfungsi untuk menyimpan uang
 * @author Muhammad Taqiyuddin
 * @version 27/3/2016
 */
public class Savings extends Account implements Serializable
{
    // instance variables
    protected double interestEarned;

    /**
     * Constructor for objects of class Savings
     * @param cust Objek dari Customer
     * @param amount Jumlah uang
     */
    public Savings(Customer cust, double amount)
    {
        super();
        setBalance(amount);
        id = Integer.toString(cust.getCustomerId());
    }

    /**
     * Method getInterestEarned mengakses banyaknya bunga yang didapat
     * @return ke interestEarned
     */
    public double getInterestEarned()
    {
        return interestEarned;
    }
    
    /**
     * Method withdraw mengambil uang dari akun
     * @param amount Jumlah uang yang akan diambil
     * @throws AmountOverDrawnException jika uang yang dimabil melebihi dari saldo 
     */
    public void withdraw(double amount) throws AmountOverDrawnException
    {
        if (balance-amount < 0) {
            throw new AmountOverDrawnException(this);
        } else {
            balance -= amount;
        }
    }
    
    /**
     * Method addDailyInterest menghitung bunga berdasarkan hari
     * @param days hari
     */
    public void addDailyInterest(int days)
    {
        double interestRate = 0.03;
        double A, period;
        period = (double)days / 365;
        A = futureValue(balance, interestRate, 360, period);
        interestEarned = A - balance;
        balance = A;
    }
}

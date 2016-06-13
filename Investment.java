import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.*;

/**
 * Class Investment adalah kelas tambahan dari Saving.Kelas ini akan memberikan penanaman modal yang
 * diserati dengan suk bunga yang sudah di tentukan
 * @author Muhammad Taqiyuddin
 * @version 20/5/2016
 */
public final class Investment extends Savings implements Serializable
{
    // instance variables
    private Date startDate, endDate;
    private int term;
    private double interestRate;
    
    /**
     * Constructor for objects of class Investment
     * @param cust objeck kelas Customer
     * @param amount jumlah saldo
     * @param months bulan
     */
    public Investment(Customer cust, double amount, int months)
    {
        super(cust, amount);
        this.term = term;
        int localTerm;
        Calendar cal = new GregorianCalendar();
        startDate = cal.getTime();
        if (term < 6) {
            localTerm = 6;
        } else {
            localTerm = term;
        }
        cal.add(Calendar.MONTH, localTerm);
        endDate = cal.getTime();
        if (term <= 6) {
            interestRate = 0.05;
        } else if (term > 6 && term <=12) {
            interestRate = 0.06;
        } else {
            interestRate = 0.07;
        }
    }
    
    /**
     * Method addDailyInterest mengitung bunga berdasarkan hari
     * @param days hari
     */
    @Override
    public void addDailyInterest(int days){
        double Days = (int)days;
        double A, period;
        period = Days / 365;
        A = futureValue(balance, interestRate, 360, period);
        interestEarned = A - balance;
        balance = A;
    }
    
    /**
     * Method withdraw mengambil uang dari akun 
     * @param amount jumlah yang diambil
     * @Exception AmountOverDrawnException jika mengambil uang melebihi saldo
     */
    @Override
    public void withdraw(double amount) throws AmountOverDrawnException {
        if (balance - amount >= 100) {
           if (Calendar.getInstance().before(endDate)) {
               if ( (balance * 0.8) - amount >= 100 ) {
                   balance *= 0.8;
                   balance -= amount;
               } 
           } 
       } 
       else {
           throw new AmountOverDrawnException(this);
       }
   } 
}

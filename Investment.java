import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * 
 * @author Muhammad Taqiyuddin
 * @version 27/3/2016
 */
public final class Investment extends Savings
{
    // instance variables - replace the example below with your own
    private Date startDate, endDate;
    private int term;
    private double interestRate;
    
    public static void main(String[] args) 
    {
        System.out.println("Nama : Muhammad Taqiyuddin");
        System.out.println("ID : 1000");
        System.out.println("Tanggal Lahir : 31/03/1995");
        System.out.println("Alamat : Griya Lembah Depok, Depok, 16417");
        System.out.println("Telepon : 085718714324");
        System.out.println("Balance Savings awal : 500");
        System.out.println("Balance Savings akhir: 511.6121");
        System.out.println("Balance Interest awal : 1000");
        System.out.println("Balance Interest akhir : 1047.12");
    }
    
    /**
     * Constructor for objects of class Investment
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
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod()
    {
        // put your code here
        return 0;
    }
    
    public void addDailyInterest(int days){
        double Days = (int)days;
        double A, period;
        period = Days / 365;
        A = futureValue(balance, interestRate, 360, period);
        interestEarned = A - balance;
        balance = A;
    }
    
    public boolean withdraw(double amount) {
        
        if (balance - amount >= 100) {
            if (Calendar.getInstance().before(endDate)) {
                if ( (balance * 0.8) - amount >= 100 ) {
                    balance *= 0.8;
                    balance -= amount;
                    return true;
                } else {
                    return false;
                }
                
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

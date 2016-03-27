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
public class LineOfCredit extends Checking {
    private double creditBalance, creditLimit;
    
    /**
     * Method Constructor LineOfCredit 
     * @param cust Obyek Customer acuan
     * @param amount Jumlah Saldo Checking Account
     * @param creditAmount Jumlah nilai limit kredit
     */
    public LineOfCredit (Customer cust, double amount, double creditAmount) {
        super();
        id = Integer.toString(cust.getCustomerId());
        balance = amount;
        creditBalance = creditAmount;
        creditLimit = creditAmount;
    }
    
    /**
     * Method feeAssessment Perhitungan biaya kredit
     */
    public void feeAssessment() {
        int days = new GregorianCalendar ().get(Calendar.DAY_OF_MONTH);
        double deficit = creditLimit - creditBalance, period = days/365; 
        double financeCharge = futureValue(deficit,0.21,360,period);
        monthlyFee = financeCharge - deficit;
        
    }
    
    /**
     * Method withdraw Menarik sejumlah Saldo dari Line-of-Credit Account
     * @param amount Jumlah Saldo
     */
    public boolean withdraw (double amount) {
        if ( ( balance + creditBalance >= amount)) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                creditBalance -= (amount - balance);
                balance = 0;
            }
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Method getCreditBalance Memberikan nilai saldo kredit
     * @return Nilai saldo kredit
     */
    public double getCreditBalance () {
        return creditBalance;
    }
    
    /**
     * Method getCreditLimit Memberikan nilai limit kredit
     * @return Nilai limit kredit
     */
    public double getCreditLimit () {
        return creditLimit;
    }
    
    /**
     * Method setCreditBalance Menentukan nilai saldo kredit
     * @param amount Jumlah nilai untuk saldo kredit
     */
    public void setCreditBalance (double amount) {
        creditBalance = amount;
    }
    
    /**
     * Method setCreditLimit Menentukan nilai limit kredit
     * @param amount Jumlah nilai untuk limit kredit
     */
    public void setCreditLimit (double amount) {
        creditLimit = amount;
    }
}

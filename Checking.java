
/**
 * 
 * 
 * @author Muhammad Taqiyuddin
 * @version 27/3/2016
 */
public abstract class Checking extends Account {
    protected double monthlyFee;
    /**
     * Metode abstrak untuk mengecek biaya Checking Account
     */
    protected abstract void feeAssessment();
    
    /**
     * Metode abstrak untuk mengecek biaya Checking Account
     */
    public void resetMonthlyFee() {
        monthlyFee = 0;
    }
    
    public double getMonthlyFee() {
        return monthlyFee;
    }
}

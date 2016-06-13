
/**
 * Class Abstrak Checking adalah kelas tambahan dari Account yang bertugas untuk melakukan checking 
 * apabila Customer menarik uang melebihi saldo dari akun saving
 * @author Muhammad Taqiyuddin
 * @version 20/5/2016
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
    
    /**
     * Metode abstrak untuk mengecek biaya bulanan
     * @return fee
     */
    public double getMonthlyFee() {
        return monthlyFee;
    }
}

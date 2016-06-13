import java.io.*;

/**
 * Class OverDraftProtect adalah kelas tambahan dari Checking.
 * Kelas ini akan memberikan limit credit untuk penarikan yang melebihi saldo Customer 
 * @author Muhammad Taqiyuddin
 * @version 27/3/2016
 */
public class OverDraftProtect extends Checking implements Serializable {
    private Savings savingsAccount;

    /**
     * Method Constructor dari OverDraftProtect
     * @param cust Obyek Customer yang bersangkutan
     * @param amount Jumlah saldo yang ingin dimasukkan
     * @param save Obyek Savings Account sebagai acuan
     */
    public OverDraftProtect(Customer cust, double amount, Savings save) {
        super();
        id = Integer.toString(cust.getCustomerId());
        balance = amount;
        savingsAccount = save;
    }
    
    /**
     * Method feeAssessment Perhitungan biaya proteksi Overdraft
     */
    public void feeAssessment () {
        monthlyFee += 3;
        balance -= 3;
    }
    
    /**
     * Method withdraw Menarik sejumlah Saldo dari Overdraft Account
     * @param amount Jumlah Saldo
     */
    public void withdraw (double amount) throws AmountOverDrawnException {
        if(amount > balance + savingsAccount.getBalance() - 10){
            throw new AmountOverDrawnException(this);
        } else if (amount > balance){
            balance = 0;
            savingsAccount.withdraw(amount - balance);
            feeAssessment();

        }else{
            balance = balance - amount;
            feeAssessment();
        }
    }
}
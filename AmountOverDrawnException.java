import java.lang.Exception;

/**
 * Class AmountOverDrawnException adalah kelas tambahan dari Exception yang menangani apabila terjadi error 
 * jika pengambilan uang melibihi dari saldo
 * @author Muhammad Taqiyuddin
 * @version 20/5/2016
 */
public class AmountOverDrawnException extends Exception
{
    // instance variables
    private Account acctType;

    /**
     * Constructor for objects of class AmountOverDrawnException
     * @param a Account
     */
    public AmountOverDrawnException(Account a)
    {
        super("Insufficient funds");
        acctType = a;
    }
    
    /**
     * Method accessor getMessage
     * @return message pesan error
     */
    public String getMessage()
    {
        if (acctType instanceof Savings) {
            return super.getMessage() + " in Savings Account";
        }
        else if (acctType instanceof Investment) {
            return super.getMessage() + " in Investment Account";
        }
        else if (acctType instanceof LineOfCredit) {
            return super.getMessage() + " in LineOfCredit Account";
        }
        else if (acctType instanceof OverDraftProtect) {
            return super.getMessage() + " in OverDraftProtect Account";
        }
        else{
            return super.getMessage();
        }
    }
}

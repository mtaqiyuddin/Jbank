import java.lang.Exception;

/**
 * Class AccountTypeAlreadyExistsException adalah kelas tambahan  dari Exception yang menangani apabila terjadi error 
 * jika tipe dari akun sudah ada
 * @author Muhammad Taqiyuddin
 * @version 20/5/2016
 */
public class AccountTypeAlreadyExistsException extends Exception
{
    // instance variables
    private Account acctType;
    public String message;

    /**
     * Method Constructor AccountTypeAlreadyExistException
     * @param c karakter account
     */
    public AccountTypeAlreadyExistsException(Account acct)
    {
        super("Unable to create duplicate account of type");
        acctType = acct;
    }
    
    /**
     * Method accessor getMessage
     * @return message pesan error
     */
    public String getMessage()
    {
        String message = "";
        if(acctType instanceof Savings && !(acctType instanceof Investment)) {
            message = super.getMessage() + " Savings";
        }
        else if(acctType instanceof Investment) {
            message = super.getMessage() + " Investment";
        }
        else if(acctType instanceof LineOfCredit) {
            message = super.getMessage() + " Line-Of-Credit";
        }
        else if(acctType instanceof OverDraftProtect) {
            message = super.getMessage() + " Overdraft Protection";
        }
        return message;
    }
}

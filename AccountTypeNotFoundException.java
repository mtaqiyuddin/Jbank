import java.lang.Exception;

/**
 * Class AccountTypeNotFoundException adalah kelas tambahan dari Exception yang menangani apabila terjadi error 
 * jika tipe dari akun tidak ditemukan
 * @author Muhammad Taqiyuddin
 * @version 20/5/2016
 */
public class AccountTypeNotFoundException extends Exception
{
    // instance variables
    private char acctType;
    public String message;

    /**
     * Constructor for objects of class AmountOverDrawnException
     * @param c karakter dari akun
     */
    public AccountTypeNotFoundException(char c)
    {
        // initialise instance variables
        super("account does not exist");
        acctType = c;
    }
    
    /**
     * Method accessor getMessage
     * @return message pesan error
     */
    public String getMessage()
    {
        switch (acctType) {
                case 'S': 
                    message = "Savings " + super.getMessage();
                case 'I': 
                    message = "Investment " + super.getMessage();
                case 'L': 
                    message = "LineOfCredit " + super.getMessage() ;
                case 'O': 
                    message = "OverDraftProtect " + super.getMessage();
        }
        return message;
    }
}

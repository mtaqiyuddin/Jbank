
/**
 * Class Account menghasilkan object Account dan terdiri dari beberapa method
 * @author Muhammad Taqiyuddin 
 * @version 19/02/2016
 */
public class Account
{
    // instance variables - replace the example below with your own
    private char acctType;
    private double balance;
    private String id;
    
    /**
     * Method Constructor Account
     */
    public Account() {
    }
    
    /**
     * Method Constructor Account
     * @param type Tipe dari Akun
     * @param amount Jumlah Nilai
     */
    public Account(char type, double amount) {
        acctType = type;
        balance = amount;
    }
    
    /**
     * Method deposit untuk mendeposit atau menambahkan sejumlah uang ke akun
     * @param amount Jumlah Nilai
     */
    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        } else {
            balance += amount;
            return true;
        }   
    }
    
    /**
     * Method getAcctType
     * @return Nama tipe akun
     */
    public char getAcctType() {
        return acctType;
    }
    
    /**
     * Method getBalance
     * @return Jumlah balance yang dimiliki
     */
    public double getBalance() {
        return balance;
    }
    
     /**
     * Method getId
     * @return ID dari akun yang bersangkutan
     */
    public String getId() {
        return id;
    }
    
    /**
     * Method setBalance Menentukan jumlah balance pada suatu akun 
     * @param amount Jumlah Nilai
     */
    public void setBalance(double amount) {
        balance = amount;
    }
    
    /**
     * Method setID Menentukan nama ID dari sebuah akun
     * @param acctID Nama ID Account
     */
    public void setID(String acctId) {
        id = acctId;
    }
    
    /**
     * Method setAcctType Menentukan tipe akun
     * @param type Tipe Akun pelanggan
     */
    public void setAcctType(char type) {
        acctType = type;
    }
    
    /**
     * Method withdraw Mengambil sejumlah uang dari suatu akun 
     * @param amount Jumlah Nilai Kas
     */
    public boolean withdraw(double amount) {
        if (balance-amount < 0) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}

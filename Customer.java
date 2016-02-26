import java.util.regex.*;
/**
 * class Customer menghasilkan object Customer dan terdiri dari beberapa method
 * @author Muhammad Taqiyuddin 
 * @version 19/02/2016
 */
public class Customer
{
    // instance variables
    private String cityAddress,dateOfBirth,email,firstName,lastName,streetAddress,phoneNumber,zipOrPostalCode;
    private int custId,numberOfCurrentAccounts;
    private Account accounts = new Account();
    private Pattern pattern;
    private Matcher matcher;
    private static final String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    /**
     * Method Constructor Customer
     */
    public Customer() {
    }
    
    /**
     * Method Constructor Customer
     * @param fname Nama Panjang
     * @param lname Nama Belakang
     * @param dob Tanggal Lahir
     */
    public Customer(String fname, String lname, String dob) {
    }
    
    /**
     * Method Constructor Customer
     * @param firstName Nama Panjang
     * @param lastName Nama Belakang
     * @param dateOfBirth Tanggal Lahir
     * @param custID ID customer
     */
    public Customer(String firstName, String lastName, String dateOfBirth, int custId){
    }
    
    /**
     * Method getName
     * @return Nama lengkap dari Customer (Nama Belakang,Nama Depan)
     */
    public String getName() {
        return lastName + "," + firstName;
    }
    
    /**
     * Method getAddress
     * @return Data Lokasi Tempat Tinggal (Nama Jalan, Nama Kota, Kode Pos)
     */
    public String getAddress() {
        return streetAddress + "," + cityAddress + "," + zipOrPostalCode;
    }
    
    /**
     * Method getAccount
     * @return Semua akun yang dimiliki suatu Customer
     */
    public Account getAccount() {
        return accounts;
    }
    
    /**
     * Method getCustomerId
     * @return Nomor Idenditas yang dimiliki suatu Customer
     */
    public int getCustomerId() {
        return custId;
    }
    
    /**
     * Method getEmail
     * @return Nama email yang dimiliki suatu Customer
     */
    public String getEmail() {
        return email;
    }
    
    private String getCustomerName() {
        return null;
    }
    
    /**
     * Method setAccount mendaftarkan akun yang dimiliki customer
     * @param accounts Akun Pelanggan Baru
     */
    public void setAccount(Account accounts) {
        this.accounts = accounts;
    }
    
    /**
     * Method getNumOfAccounts
     * @return Jumlah akun yang dimiliki suatu Customer
     */
    public int getNumOfAccounts() {
        return numberOfCurrentAccounts;
    }
    
    /**
     * Method getPhoneNumber
     * @return Nomor telepon yang dimiliki suatu Customer
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
     /**
     * Method setAddress mendaftarkan Nama Jalan, Kota, dan Kode Pos untuk Customer
     * @param street Nama Jalan
     * @param city Nama Kota
     * @param code Nomor Kode Pos
     */
    public void setAddress(String street, String city, String code) {
        cityAddress = city;
        zipOrPostalCode = code;
        streetAddress = street;
    }
    
     /**
     * Method setEmail mendaftarkan alamat email dari Customer
     * @param emailAddress Alamat Email
     */
    public boolean setEmail(String emailAddress) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(emailAddress);
        if (matcher.matches()) {
            email = emailAddress;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Method setName mendaftarkan nama Customer
     * @param fname Nama Panjang
     * @param lname Nama Belakang
     */
    public void setName(String lname, String fname) {
        firstName = fname;
        lastName = lname;
    }
    
    /**
     * Method setPhoneNumber mendaftarkan nomor telefon
     * @param phoneNum Nomor Telepon
     */
    public void setPhoneNumber(String phoneNum) {
        phoneNumber = phoneNum;
    }
}

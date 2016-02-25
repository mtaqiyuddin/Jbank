
/**
 * 
 * @author Muhammad Taqiyuddin 
 * @version 19/02/2016
 */
public class Customer
{
    // instance variables
    private String cityAddress,dateOfBirth,email,firstName,lastName,streetAddress,phoneNumber,zipOrPostalCode;
    private int custId,numberOfCurrentAccounts;
    private Account accounts = new Account();
    
    public Customer() {
    }
    public Customer(String fname, String lname, String dob) {
    }
    public Customer(String firstName, String lastName, String dateOfBirth, int custId){
    }
    public String getName() {
        return firstName + "," + lastName;
    }
    public String getAddress() {
        return streetAddress + "," + cityAddress + "," + zipOrPostalCode;
    }
    public Account getAccount() {
        return accounts;
    }
    private int getCustomerId() {
        return 0;
    }
    private String getEmail() {
        return null;
    }
    private String getCustomerName() {
        return null;
    }
    public void setAccount(Account accounts) {
        this.accounts = accounts;
    }
    public int getNumOfAccounts() {
        return 0;
    }
    private String getPhoneNumber() {
        return null;
    }
    public void setAddress(String street, String city, String code) {
        cityAddress = city;
        zipOrPostalCode = code;
        streetAddress = street;
    }
    private void setEmail(String emailAddress) {
        return;
    }
    public void setName(String lname, String fname) {
        firstName = fname;
        lastName = lname;
    }
    private void setPhoneNumber(String phoneNum) {
        return;
    }
}

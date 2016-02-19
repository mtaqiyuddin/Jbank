
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
    private String getAddress() {
        return null;
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
    public int getNumOfAccounts() {
        return 0;
    }
    private String getPhoneNumber() {
        return null;
    }
    private void setAddress(String street, String city, String code) {
        return;
    }
    private void setEmail(String emailAddress) {
        return;
    }
    private void setCustomerName(String lname, String cfname) {
        return;
    }
    private void setPhoneNumber(String phoneNum) {
        return;
    }
}

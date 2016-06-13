import java.util.regex.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.io.Serializable;
/**
 * class Customer menghasilkan object Customer dan terdiri dari beberapa method
 * @author Muhammad Taqiyuddin 
 * @version 20/5/2016
 */
public class Customer implements Comparable<Customer>, Serializable
{
    // instance variables
    public String cityAddress, stateAddress,email,firstName,lastName,streetAddress,phoneNumber,zipOrPostalCode;
    public Date dateOfBirth;
    public int custId;
    private Account a;
    private Account[] accounts = new Account[4];
    public int numberOfCurrentAccounts;
    public Pattern pattern;
    public static final String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    /**
     * Method Constructor Customer
     */
    public Customer() {
        custId = Bank.getNextID();
    }

    /**
     * Method Constructor Customer
     * @param firstName Nama Panjang
     * @param lastName Nama Belakang
     * @param dateOfBirth Tanggal Lahir
     */
    public Customer(String firstName, String lastName, Date dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.custId = Bank.getNextID();
    }
    
    /**
     * Method getName
     * @return Nama lengkap dari Customer (Nama Belakang,Nama Depan)
     */
    public String getName() {
        return lastName + "," + firstName;
    }
    
    /**
     * Method getFirstName
     * @return Nama depan dari Customer
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Method getLastName
     * @return Nama belakang dari Customer
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Method mutator DOB
     * @param DOB DOB
     */
    public void setDOB(Date DOB)
    {
        dateOfBirth = DOB;
    }
    
    /**
     * Method setCustID
     * @return id Customer ID
     */
    public void setCustID(int id)throws CustUnknownException
    {
        if (id<=1020)
        {
            custId = id;
        }
        else
        {
            throw new CustUnknownException();
        }
    }
    
    /**
     * Method getAddress
     * @return Data Lokasi Tempat Tinggal (Nama Jalan, Nama Kota, Kode Pos)
     */
    public String getAddress() {
        return streetAddress + "," + cityAddress + "," + zipOrPostalCode;
    }
    
    /**
     * Method getAddress
     * @return streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }
    
    /**
     * Method getAddress
     * @return streetAddress
     */
    public String getStateAddress() {
        return stateAddress;
    }
    
    /**
     * Method getAddress
     * @return cityAddress
     */
    public String getCityAddress() {
        return cityAddress;
    }
    
    /**
     * Method getAddress
     * @return zipCode
     */
    public String getZipCode() {
        return zipOrPostalCode;
    }
    
    /**
     * Method getAccount
     * @return Semua akun yang dimiliki suatu Customer
     */
    public Account getAccount(char type) throws AccountTypeNotFoundException
    {
        Account a = null;
        int i = 0;
        for(i = 0; i < accounts.length; i++) {
            switch(type) {
                case 'S': 
                    if((accounts[i] instanceof Savings) && !(accounts[i] instanceof Investment)) {
                        a = accounts[i];
                        return a;
                    }
                    break;
                case 'I': 
                    if(accounts[i] instanceof Investment) {
                        a = accounts[i];
                        return a;
                    }
                    break;
                case 'L': 
                    if(accounts[i] instanceof LineOfCredit) {
                        a = accounts[i];
                        return a;
                    }
                    break;
                case 'O': 
                    if(accounts[i] instanceof OverDraftProtect) {
                        a = accounts[i];
                        return a;
                    }
                    break;
            }
        }
        throw new AccountTypeNotFoundException(type);
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
     * Method getNumOfAccounts
     * @return Jumlah akun yang dimiliki suatu Customer
     */
    public int getNumOfAccounts() {
        return numberOfCurrentAccounts;
    }
    
    /**
     * Method addAccount
     * @param objek akun
     * @exception AccountTypeAlreadyExistsException jika akun sudah ada
     */
    public void addAccount(Account acc) throws AccountTypeAlreadyExistsException{
        int i = 0;
        if(numberOfCurrentAccounts < 5) {
            int notUsed = -1;
            for(i = 0; i < accounts.length; i++) {
                if(accounts[i] != null) {
                    if(accounts[i].getClass().equals(acc.getClass())) {
                        throw new AccountTypeAlreadyExistsException(acc);
                    }
                }
                else if(accounts[i] == null && notUsed == -1) {
                    notUsed = i;
                }
            }
            if(notUsed != -1) {
                this.accounts[notUsed] = acc;
                numberOfCurrentAccounts++;
            }
        }
        else {
            System.out.println("Jumlah akun sudah maksimum!");
        }
    }
    
    /**
     * Method addAccount
     * @param objek akun
     * @throws AccountTypeNotFoundException jika tipe akun tidak ditemukan
     */ 
    public boolean removeAccount(char type) throws AccountTypeNotFoundException
    {
        Account a = null;
        boolean acctRemoved = false;
        int i = 0;
        for(i = 0; i < accounts.length; i++) {
            switch(type) {
                case 'S': 
                    if((accounts[i] instanceof Savings) && !(accounts[i] instanceof Investment)) {
                        accounts[i] = null;
                        numberOfCurrentAccounts--;
                        acctRemoved = true;
                    }
                    break;
                case 'I': 
                    if(accounts[i] instanceof Investment) {
                        accounts[i] = null;
                        numberOfCurrentAccounts--;
                        acctRemoved = true;
                    }
                    break;
                case 'L': 
                    if(accounts[i] instanceof LineOfCredit) {
                        accounts[i] = null;
                        numberOfCurrentAccounts--;
                        acctRemoved = true;
                    }
                    break;
                case 'O': 
                    if(accounts[i] instanceof OverDraftProtect) {
                        accounts[i] = null;
                        numberOfCurrentAccounts--;
                        acctRemoved = true;
                    }
                    break;
            }
            
            if(accounts[i] == null && acctRemoved) {
                if(i < accounts.length - 1) {
                    a = accounts[i];
                    accounts[i] = accounts[i+1];
                    accounts[i+1] = a;
                }
                return acctRemoved;
            }
        }
        throw new AccountTypeNotFoundException(type);
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
    public void setAddress(String street, String city, String state, String code) {
        cityAddress = city;
        zipOrPostalCode = code;
        stateAddress = state;
        streetAddress = street;
    }
    
     /**
     * Method setEmail mendaftarkan alamat email dari Customer
     * @param emailAddress Alamat Email
     */
    public boolean setEmail(String emailAddress) {
        pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailAddress);
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
    
    /**
     * Method getDOB mendapatkan tanggal lahir 
     * @return tanggal lahir
     */
    public Date getDOB(){
       return dateOfBirth;
    }
    
    /**
     * Method compareTo 
     * @param other Customer
     * @return 1, 0, atau -1 
     */
    public int compareTo(Customer other) {
        if(this.custId > other.custId) {
            return 1;
        }
        else if(this.custId < other.custId) {
            return -1;
        }
        else {
            return 0;
        }
    }
    
    /**
     * Method toString untuk menampilkan info customer
     * @return String
     */
    public String toString()
    {
        SimpleDateFormat dobFormat = new SimpleDateFormat("dd MMM yyyy");
        System.out.println("Informasi Kostumer");
        System.out.println("Nama                    : " + this.getName());
        try {
            System.out.println("DOB                     : " + dobFormat.format(this.getDOB()));
        } catch (NullPointerException e) {
            System.out.println("DOB                     : ");
        }
        System.out.println("No Telepon              : " + this.getPhoneNumber());
        System.out.println("Email                   : " + this.getEmail());
        System.out.println("Address                 : " + this.getAddress());
        System.out.println("ID Customer             : " + this.getCustomerId());
        System.out.println("Informasi Akun Kostumer");
        try {
            System.out.println("Balance Savings         : " + this.getAccount('S').getBalance());
        } catch (AccountTypeNotFoundException e) {
            System.out.println("Customer tidak memiliki account Savings");
        }
        try {
            System.out.println("Balance Investment      : " + this.getAccount('I').getBalance());
        } catch (AccountTypeNotFoundException e) {
            System.out.println("Customer tidak memiliki account Investment");
        }
        try {
            System.out.println("Balance Line-of-Credit  : " + this.getAccount('L').getBalance());
        } catch (AccountTypeNotFoundException e) {
            System.out.println("Customer tidak memiliki account Line-of-Credit");
        }
        try {
            System.out.println("Balance Overdraft       : " + this.getAccount('O').getBalance());
        } catch (AccountTypeNotFoundException e) {
            System.out.println("Customer tidak memiliki account Overdraft");
        }
        return "";
    }
}

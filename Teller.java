import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.lang.Math;
import java.math.MathContext;
import java.math.RoundingMode;
/**
 * class Teller sebagai kelas utama dari Jbank
 * @author Muhammad Taqiyuddin 
 * @version 19/02/2016
 */
public class Teller
{
    private static Date closeTime, startTime;
    private static MathContext mc = new MathContext(3);
    /**
     * Main method dari class Teller membuat object meng-assign object a1 ke c1
     * mengisi nilai balance dan nama lalu menampilkan keduanya.
     * @param args Command-Line Arguments
     */
    public static void main(String[] args) 
    {
        int balance,year,month,day;
        Scanner s = new Scanner(System.in);
        String input = "",fname,lname,DOB,phone,city,street,zip,email;
        char acctType;
        Customer customers;
        boolean loop;
            
        Bank bank = new Bank();
            
        for (int i = 0; i <= Bank.getMaxNumOfCustomers(); i++) {
            fname = null;
            lname = null;
            DOB = null;
            phone = null;
            city = null;
            street = null;
            zip = null;
            email = null;
            balance = 0;
            year = 0;
            month = 0;
            day = 0;
            acctType = '\0';
            loop = false;
            do {
                System.out.println("Apakah ingin membuat Customer? (Y/N)");
                input = s.next();
                if ( ( input.equals("y") ) || ( input.equals("Y")) ) {
                    loop = true;
                    break;
                } 
                else if ( ( input.equals("n") ) || ( input.equals("N") ) ) {
                    System.out.println("Program Berhenti"); 
                    loop = false;
                    break;
                } 
                else {
                    System.out.println("Input Hanya Y Atau N Saja\n");
                }
            } while(!loop);
            
            if(loop){
                System.out.print("Masukkan nama depan anda: ");
                input = s.next();
                fname = input;
                System.out.print("Masukkan nama belakang anda: ");
                input = s.next();
                lname = input;
                System.out.print("Masukkan Tahun Lahir : ");
                year = s.nextInt();
                System.out.print("Masukkan Bulan Lahir : ");
                month = s.nextInt() - 1;
                System.out.print("Masukkan Hari Lahir : ");
                day = s.nextInt();
                System.out.print("Masukkan nomor telepon anda: ");
                input = s.next();
                phone = input; 
                System.out.print("Masukkan kota anda: ");
                input = s.next();
                city = input;   
                System.out.print("Masukkan alamat jalan anda: ");
                input = s.next();
                street = input;   
                System.out.print("Masukkan kode pos anda: ");
                input = s.next();
                zip = input;   
                System.out.print("Masukkan email anda: ");
                input = s.next();
                email = input;
                System.out.println("S: Savings; O: Overdraft; I:Investment; L: Credit Checking; T: Tidak Membuat");
                System.out.print("Masukkan jenis akun (S/O/I/L/T): ");
                customers = new Customer(fname, lname, (new GregorianCalendar(year , month, day).getTime()));
                customers.setPhoneNumber(phone); 
                customers.setAddress(street, city, zip);
                customers.setEmail(email);
                do {
                    input = s.next();
                    if (input.equals("T")) {
                        System.out.print("Tidak membuat akun");
                        break;
                    } 
                    else if(input.equals("S") || input.equals("O") || input.equals("I") || input.equals("L")){
                        acctType = input.charAt(0);
                        do {
                            System.out.print("Memasukkan nilai saldo awal: ");
                            input = s.next();
                            balance = Integer.parseInt(input);
                            if (balance<=0) {
                                System.out.println("Balance tidak boleh negatif!");
                            } 
                            else {
                                break;
                            }
                        } while(true);
                        //customers.addAccount(balance, acctType);
                        break;
                    }
                    else {
                        System.out.print("Input Tidak Sesuai\n"); 
                    }
                } while(true);
                if (customers != null){
                    System.out.println( bank.addCustomer(customers)?"Customer ditambahkan": "Customer tidak ditambahkan" );
                }
            }
            else {
                break;
            }
          bank.printAllCustomers();
          customers = Bank.getCustomer(1000);
          //Account acc = new Account(customers,1000,'C');
          //System.out.println("Account Type: " + acc.getAcctType());
          //System.out.println("Balance     : " + acc.getBalance());
          //System.out.println("ID          : " + acc.getId());
        }
    }
    
    /**
     * Constructor Teller
     */
    public Teller() {
    }
    
    /*
    public void newAccount() {
        Customer cust = new Customer();
        Account saving = new Account (cust, 1000, 'S');
        Account invest = new Account (cust, 1000, 'I');
        Account creditline = new Account (cust, 500, 'L');
        double s, i;
        // Untuk Saving Account (rate 3%)
        System.out.println("Balance Saving sekarang: US$" + saving.getBalance());
        s = new BigDecimal(futureValue(saving.getBalance(),0.03,360,1)).subtract(new BigDecimal(saving.getBalance()),mc.DECIMAL32).doubleValue();
        System.out.println("Balance tambahan tahun depan  (1 year): US$" + s);
        saving.deposit(s);
        System.out.println("Balance Saving masa depan: US$" + saving.getBalance());
        // Untuk Invest Account (rate 7%)
        System.out.println("\nBalance Investment sekarang: US$" + invest.getBalance());
        i = new BigDecimal(futureValue(invest.getBalance(),0.07,360,1)).subtract(new BigDecimal(invest.getBalance()),mc.DECIMAL32).doubleValue();
        System.out.println("Balance Investment tambahan tahun depan (12 Months - Term): US$" + i);
        invest.deposit(i);
        System.out.println("Balance Investment masa depan: US$" + invest.getBalance());
        // Untuk Credit Account
        saving.setBalance(500);
        double withdraw = 750;
        double financeCharge = 0;
        System.out.println("Balance Saving: US$" + saving.getBalance());
        System.out.println("Nilai LOC: US$" + creditline.getBalance());
        System.out.println("Pengambilan : US$" + withdraw);
        if (saving.getBalance()<withdraw) {
            financeCharge = withdraw - saving.getBalance();
            saving.withdraw(withdraw-financeCharge);
            creditline.withdraw(financeCharge);
        }
        System.out.println("\nBalance Saving: US$" + saving.getBalance());
        System.out.println("Nilai LOC: US$" + creditline.getBalance());
        double iC = futureValue(financeCharge,0.18,360,1) - financeCharge;
        System.out.println("Rate LOC (1 year) : US$" + iC);
        financeCharge += iC;
        System.out.println("Total Biaya: US$" + financeCharge);
    }
    */
   
    public static double futureValue(double balance, double rate, double compound, double period) {
        BigDecimal bal = new BigDecimal (balance);
        BigDecimal r = new BigDecimal (rate);
        BigDecimal n = new BigDecimal (compound);
        BigDecimal t = new BigDecimal (period);
        BigDecimal f1 = r.divide(n, mc.DECIMAL32).add(new BigDecimal(1));
        BigDecimal f2 = n.multiply(t, mc.DECIMAL32);
        BigDecimal f3 = new BigDecimal (Math.pow(f1.doubleValue(), f2.doubleValue()),mc.DECIMAL32);
        BigDecimal f4 = f3.multiply(bal, mc.DECIMAL32);
        return f4.doubleValue();
    }
    
    /**
     * Method getCloseTime Mendapatkan waktu tutup
     * @return Waktu tutup
     */
    public static Date getCloseTime() {
        return closeTime;
    }
    
    /**
     * Method getStartTime Mendapatkan waktu mulai
     * @return Waktu buka
     */
    public static Date getStartTime() {
        return startTime;
    }
    
    /**
     * Method setCloseTime Menentukan waktu tutup
     * @param hour Satuan Jam
     * @param min Satuan Menit
     */
    public static void setCloseTime(int year,int month,int day,int hour, int min) {
        Bank.closeTime = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
    /**
     * Method setStartTime Menentukan waktu mulai
     * @param hour Satuan Jam
     * @param min Satuan Menit
     */
    public static void setStartTime(int year,int month,int day, int hour, int min) {
        Bank.startTime = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
    /**
     * Method setStartTime Menentukan waktu mulai
     * @param hour Satuan Jam
     * @param min Satuan Menit
     */
    public static void printTime() {
        System.out.println(Bank.getHoursOfOperation());
    }
}

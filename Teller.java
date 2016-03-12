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
    private static MathContext mc = new MathContext(3);
    /**
     * Main method dari class Teller membuat object meng-assign object a1 ke c1
     * mengisi nilai balance dan nama lalu menampilkan keduanya.
     * @param args Command-Line Arguments
     */
    public static void main(String[] args) 
    {
        Account saving = new Account ('S', 1000);
        Account invest = new Account ('I', 1000);
        Account creditline = new Account ('L', 500);
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
        /*
        int balance,year,month,day;
        Scanner s = new Scanner(System.in);
        String input = "",fname,lname,DOB,phone;
        char acctType;
        Customer customers;
        
        do {
            Date d1,d2;
            d1 = new GregorianCalendar(2016, 3, 10, 8, 0).getTime() ;
            d2 = new GregorianCalendar(2016, 3, 10, 16, 30).getTime();
       
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm ");
            String date = sdf.format(d1.getTime()); 
            System.out.println(date);
          
            SimpleDateFormat ampm = new SimpleDateFormat("hh:mm aa");
            String date1 = ampm.format(d2.getTime()); 
            System.out.println(date1);
            System.out.println(d1+" To " +d2);
            
            System.out.println("Apakah ingin membuat Customer? (Y/N)");
            input = s.next();
            if ( ( input.equals("y") ) || ( input.equals("Y")) ) {
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
                customers = new Customer(fname, lname, (new GregorianCalendar(year , month, day).getTime()));
                customers.setPhoneNumber(phone); 
                customers.getDOB();
                System.out.println("S: Savings; O: Overdraft; I:Investment; L: Credit Checking; T: Tidak Membuat");
                System.out.print("Masukkan jenis akun (S/O/I/L/T): ");
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
                        if (customers != null) {
                            customers.setAccount(new Account(acctType,balance));
                            customers.getAccount().setID(String.valueOf(customers.getCustomerId() ) + acctType);
                        }
                        break;
                    }
                    else {
                        System.out.print("Input Tidak Sesuai\n"); 
                    }
                } while(true);
                System.out.println("Berikut adalah informasi pengguna");
                System.out.println("ID: " + customers.getAccount().getId());
                System.out.println("First Name: " + customers.firstName);
                System.out.println("Last Name: " + customers.lastName);
                System.out.println("DOB: " + customers.getDOB());
                System.out.println("Balance: " + customers.getAccount().getBalance());
                break;
            } 
            else if ( ( input.equals("n") ) || ( input.equals("N") ) ) {
                System.out.println("Program Berhenti"); 
                break;
            } 
            else {
                System.out.println("Input Hanya Y Atau N Saja\n");
        }
      } 
      while(true);
      */
    }
    
    /**
     * Constructor Teller
     */
    public Teller()
    {
    }
    
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
}

import java.util.Scanner;
import java.util.Date;

/**
 * class Teller sebagai kelas utama dari Jbank
 * @author Muhammad Taqiyuddin 
 * @version 19/02/2016
 */
public class Teller
{
    /**
     * Main method dari class Teller membuat object meng-assign object a1 ke c1
     * mengisi nilai balance dan nama lalu menampilkan keduanya.
     * @param args Command-Line Arguments
     */
    public static void main(String[] args) 
    {
        int balance;
        Scanner s = new Scanner(System.in);
        String input = "",fname,lname,DOB,phone;
        char acctType;
        Customer customers;
        /*
        Customer c1 = new Customer(); //Membuat object dari class Customer dengan nama c1
        c1.setName("Sanadhi","Sutandi"); //Mengubah nama dari c1
        System.out.println(c1.getName()); //Print nama c1
        
        Account a1 = new Account(), acc; //Membuat object dari class Account dengan nama a1 dan acc sebagai variable referensi
        a1.setBalance(5000); //Mengubah nilai balance pada object a1
        c1.setAccount(a1); //Assign object a1 ke c1
        acc = c1.getAccount(); //Mengambil nilai referensi object Account dari object c1
        System.out.println(acc.getBalance());  //Print nilai balance dari a1 yang telah di-assign 
        */
       do {
            System.out.println("Apakah ingin membuat Customer? (Y/N)");
            input = s.next();
            if ( ( input.equals("y") ) || ( input.equals("Y")) ) {
                System.out.print("Masukkan nama depan anda: ");
                input = s.next();
                fname = input;
                System.out.print("Masukkan nama belakang anda: ");
                input = s.next();
                lname = input;
                System.out.print("Masukkan tanggal lahir anda (DD-MM-YY): ");
                input = s.next();
                DOB = input;
                System.out.print("Masukkan nomor telepon anda: ");
                input = s.next();
                phone = input;   
                customers = new Customer(fname,lname,DOB);
                customers.setPhoneNumber(phone);               
                System.out.println("S: Savings; O: Overdraft; I:Investment; L: Credit Checking; T: Tidak Membuat");
                System.out.print("Masukkan jenis akun (S/O/I/L/T): ");
                input = s.next();
                if (input.equals("T")) {
                    System.out.print("Tidak membuat akun");
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
                }
                else {
                   System.out.print("Input Tidak Sesuai"); 
                }
                System.out.println("Berikut adalah informasi pengguna");
                System.out.println("ID: " + customers.getAccount().getId());
                System.out.println("First Name: " + customers.firstName);
                System.out.println("Last Name: " + customers.lastName);
                System.out.println("DOB: " + customers.dateOfBirth);
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
    }
    
    /**
     * Constructor Teller
     */
    public Teller()
    {
    }
    
}

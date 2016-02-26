
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
        Customer c1 = new Customer(); //Membuat object dari class Customer dengan nama c1
        c1.setName("Sanadhi","Sutandi"); //Mengubah nama dari c1
        System.out.println(c1.getName()); //Print nama c1
        
        Account a1 = new Account(), acc; //Membuat object dari class Account dengan nama a1 dan acc sebagai variable referensi
        a1.setBalance(5000); //Mengubah nilai balance pada object a1
        c1.setAccount(a1); //Assign object a1 ke c1
        acc = c1.getAccount(); //Mengambil nilai referensi object Account dari object c1
        System.out.println(acc.getBalance());  //Print nilai balance dari a1 yang telah di-assign 
        
    }
    
    /**
     * Constructor Teller
     */
    public Teller()
    {
    }
    
}

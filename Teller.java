
/**
 * 
 * @author Muhammad Taqiyuddin 
 * @version 19/02/2016
 */
public class Teller
{
    // instance variables - replace the example below with your ownn
    public Teller()
    {
    }
    
    public static void main(String[] args) 
    {
        Customer c1 = new Customer();
        c1.setName("Sanadhi","Sutandi");
        System.out.println(c1.getName());
        
        Account a1 = new Account(), acc;
        a1.setBalance(5000);
        c1.setAccount(a1);
        acc = c1.getAccount();
        System.out.println(acc.getBalance());
        
    }
    
}

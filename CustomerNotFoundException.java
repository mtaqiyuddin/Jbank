
/**
 * Write a description of class a here.
 * 
 * @author Muhammad Taqiyuddin
 * @version 20/5/2016
 */
public class CustomerNotFoundException extends Exception
{
    /**
     * Constructor for objects of class CustomerNotFoundException
     */
    public CustomerNotFoundException(int id)
    {
        super("Customer ID" + id + "Not Found");
    }
}
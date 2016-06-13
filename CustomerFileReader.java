import java.util.*;
import java.io.*;

/**
 * Class CustomerFileReader adalah kelas yang berfungsi untuk mambaca info semua customer dari file customers.dat
 * @author Muhammad Taqiyuddin
 * @version 20/5/2016
 */
public class CustomerFileReader implements Serializable
{
    // instance variables - replace the example below with your own
    public File objectFile;
    public ObjectInputStream objectInputStream;
    public FileInputStream fileInputStream;

    /**
     * Constructor for objects of class CustomerFileWriter
     */
    public CustomerFileReader()
    {
    }

    /**
     * Method readCustomer untuk membaca info customer dari file
     * @return SortedSet customer
     */

    public SortedSet<Customer> readCustomers()
    {
        SortedSet<Customer> customers = null;
        try {
            objectFile = new File("customers.dat");
            fileInputStream = new FileInputStream(objectFile);
            objectInputStream = new ObjectInputStream(fileInputStream);
            try {
                customers = (SortedSet<Customer>) objectInputStream.readObject();
            } finally {
                objectInputStream.close();
                fileInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return customers;
    }
}

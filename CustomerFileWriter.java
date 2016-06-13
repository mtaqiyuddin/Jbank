import java.util.*;
import java.io.*;

/**
 * Class CustomerFileWriter adalah kelas yang berfungsi untuk menulis info semua customer dari file customers.dat
 * @author Muhammad Taqiyuddin
 * @version 20/5/2016
 */
public class CustomerFileWriter implements Serializable
{
    // instance variables
    public File objectFile;
    public ObjectOutputStream objectOutputStream;
    public FileOutputStream fileOutputStream;

    /**
     * Constructor for objects of class CustomerFileWriter
     */
    public CustomerFileWriter()
    {
    }

    /**
     * Method saveCustomers untuk menuliskan info customer dari file
     * @param customers dari SortedSet customer
     */
    public void saveCustomers(SortedSet<Customer> customers)
    {
        try {
            objectFile = new File("customers.dat");
            objectFile.createNewFile();
            fileOutputStream = new FileOutputStream(objectFile);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            try {
                objectOutputStream.writeObject(customers);
            } finally {
                objectOutputStream.close();
                fileOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

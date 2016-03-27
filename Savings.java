
/**
 * 
 * 
 * @author Muhammad Taqiyuddin
 * @version 27/3/2016
 */
public class Savings extends Account
{
    // instance variables - replace the example below with your own
    protected double interestEarned;

    /**
     * Constructor for objects of class Savings
     */
    public Savings(Customer cust, double amount)
    {
        super();
        id = Integer.toString(cust.getCustomerId());
    }

    public double getInterestEarned()
    {
        // put your code here
        return interestEarned;
    }
    
    public boolean withdraw(double amount)
    {
        if (balance-amount < 0) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
    
    public void addDailyInterest(int days)
    {
        double interestRate = 0.03;
        double A, period;
        period = (double)days / 365;
        A = futureValue(balance, interestRate, 360, period);
        interestEarned = A - balance;
        balance = A;
    }
}

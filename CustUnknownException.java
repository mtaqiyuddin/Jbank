public class CustUnknownException extends Exception
{
    public CustUnknownException()
    {
        super("ID out of limit !");
    }

    @Override
    public String getMessage()
    {
        return super.getMessage();
    }
}

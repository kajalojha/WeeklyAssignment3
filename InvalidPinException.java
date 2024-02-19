package WeeklyAssignment3_Atm_Simulation;

public class InvalidPinException extends Exception
{
    public InvalidPinException(String message){
        super(message);
    }
}

 class accountNotFound extends Exception
 {
    public accountNotFound(String message)
    {
        super(message);
    }
}
class insufficientFund extends Exception
{
    public insufficientFund(String message)
    {
        super(message);
    }
}
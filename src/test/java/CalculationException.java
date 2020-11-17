 

public class CalculationException  extends Exception { 
    
    public CalculationException(String msg) {
        super(msg);
    }
    
    public CalculationException(String msg, Throwable e) {
        super(msg, e);
    }
}
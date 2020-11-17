import java.util.Map;

public abstract class Calculator<O> {

    public boolean validateParams(Map<String, ?> params) {
        return true;
    }

    protected abstract O calculate(Map<String, ?> params) throws CalculationException;
}

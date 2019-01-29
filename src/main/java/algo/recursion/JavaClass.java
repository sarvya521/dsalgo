package recursion;

import java.util.HashMap;
import java.util.Map;

public class JavaClass {
	private static JavaClass INSTANCE = null;

    public static JavaClass getInstance()
    {
        if ( INSTANCE == null )
        {
            INSTANCE = new JavaClass();
        }
        return INSTANCE;
    }

    private JavaClass() {
    }
	
}

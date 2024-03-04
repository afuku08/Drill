	
import java.text.*;

public class Convert {
    private static final DecimalFormat df = new DecimalFormat();

    public static double atod(String str) {
        double x;
        try {
            Number n = getNumber(str);
            x = n.doubleValue();
        } catch(ParseException a) {
            x = 0.0;
        }
        return x;
    }
    public static float atof(String str) {
        float x;
        try {
            Number n = getNumber(str);
            x = n.floatValue();
        } catch(ParseException a) {
            x = 0.0F;
        }
        return x;
    }
    public static int atoi(String str) {
        int x;
        try {
            Number n = getNumber(str);
            x = n.intValue();
        } catch(ParseException a) {
            x = 0;
        }
        return x;
    }
    public static long atol(String str) {
        long x;
        try {
            Number n = getNumber(str);
            x = n.longValue();
        } catch(ParseException a) {
            x = 0L;
        }
        return x;
    }
    private static Number getNumber(String str) throws ParseException {
        return df.parse(str.trim());
    }
}
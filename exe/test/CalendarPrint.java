import java.util.*;

/*GregorianCalendar表示テストプログラム */
public class CalendarPrint {
    public static void main(String[] args){
        Calendar calendar = new GregorianCalendar();
        Date d = new Date();
        calendar.setTime(d);
        System.out.println("Dateの出力:" + d);
        System.out.println("ERA:" + calendar.get(Calendar.ERA));
        System.out.println("YEAR:" + calendar.get(Calendar.YEAR));
        System.out.println("MONTH:" + calendar.get(Calendar.MONTH));
        System.out.println("WEEK_OF_YEAR:" + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("WEEK_OF_MONTH:" + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("DATE:" + calendar.get(Calendar.DATE));
        System.out.println("DAY_OF_MONTH:" + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("DAY_OF_YEAR:" + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("DAY_OF_WEEK:" + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("DAY_OF_WEEK_IN_MONTH: "     +
            calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
        System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
        System.out.println("HOUR_OF_DAY: " + 
            calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
        System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
        System.out.println("MILLISECOND: " +
            calendar.get(Calendar.MILLISECOND));
        System.out.println("ZONE_OFFSET: "     +
            (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
        System.out.println("DST_OFFSET: " +
            (calendar.get(Calendar.DST_OFFSET)/(60*60*1000)));
        System.out.println("ActualMaximum of DAY_OF_MONTH: " + 
            calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("ActualMaximum of WEEK_OF_MONTH: " + 
            calendar.getActualMaximum(Calendar.WEEK_OF_MONTH));
        System.out.println("ActualMaximum of DAY_OF_YEAR: " + 
            calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        System.out.println("ActualMaximum of WEEK_OF_YEAR: " + 
            calendar.getActualMaximum(Calendar.WEEK_OF_YEAR));
        System.out.println("ActualMinimum of DAY_OF_MONTH: " + 
            calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        System.out.println("ActualMinimum of WEEK_OF_MONTH: " + 
            calendar.getActualMinimum(Calendar.WEEK_OF_MONTH));
        System.out.println("ActualMinimum of DAY_OF_YEAR: " + 
            calendar.getActualMinimum(Calendar.DAY_OF_YEAR));
        System.out.println("ActualMinimum of WEEK_OF_YEAR: " + 
            calendar.getActualMinimum(Calendar.WEEK_OF_YEAR));
    }
}

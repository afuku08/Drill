import java.util.*;

public class SimpleDay implements Day{
    int year;
    int month;
    int day;

    public SimpleDay(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear(){ 
        return year; 
    }

    public int getMonth(){ 
        return month; 
    }

    public int getDay(){ 
        return day; 
    }

    public int getIndex(){
        Calendar cal = new GregorianCalendar(getYear(), getMonth()-1, getDay());
        return cal.get(Calendar.DAY_OF_YEAR)-1;
    }

    public int getNameofDay(){
        Calendar cal = new GregorianCalendar(getYear(), getMonth()-1, getDay());
        return cal.get(Calendar.DAY_OF_WEEK)-1;
    }

    public String getDayString(){
        return (year + "/" + month + "/" + day);
    }

    public String toString(){
        return getDayString();
    }

    public Object clone(){
        try{
            return super.clone();
        }catch(CloneNotSupportedException e){
            return null;
        }
    }

    public Day makeCopy(){
        return (Day)clone();
    }
}

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
        return 0;
    }

    public int getNameofDay(){
        return 0;
    }

    public String getDayString(){
        return (year + "/" + month + "/" + day);
    }

    public String toString(){
        return getDayString();
    }
}

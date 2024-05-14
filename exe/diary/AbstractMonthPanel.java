import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.*;

public abstract class AbstractMonthPanel extends JPanel implements DaySelector{
    protected int year;
    protected int month;
    protected int maxWeeks;
    protected int maxDays;
    protected GregorianCalendar g;
    protected int firstNameOfDay;

    /*AbstractMonthPanelコンストラクタ */
    AbstractMonthPanel(int year,int month){
        this.year = year;
        this.month = month;
        g = new GregorianCalendar(year,month-1,1);
        maxDays = g.getActualMaximum(Calendar.DAY_OF_MONTH);
        maxWeeks = g.getActualMaximum(Calendar.WEEK_OF_MONTH);
        firstNameOfDay = g.get(GregorianCalendar.DAY_OF_WEEK)-1;
    }

    /*AbstractMonthPanelコンストラクタ */
    AbstractMonthPanel(GregorianCalendar calendar){
        g = (GregorianCalendar)calendar.clone();
        g.set(Calendar.DATE,1);
        this.year = g.get(Calendar.YEAR);
        this.month = g.get(Calendar.MONTH) + 1;
        maxDays = g.getActualMaximum(Calendar.DAY_OF_MONTH);
        maxWeeks = g.getActualMaximum(Calendar.WEEK_OF_MONTH);
        firstNameOfDay = g.get(GregorianCalendar.DAY_OF_WEEK)-1;
    }

    /*当月のGregorianCalendarのコピーを生成する */
    /*@return java.util.GregorianCalendar */
    public GregorianCalendar getMyCalendar(){
        return (GregorianCalendar)g.clone();
    }
}

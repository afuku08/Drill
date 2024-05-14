import java.util.*;
import java.awt.*;
import javax.swing.*;

public class MonthPanel extends AbstractMonthPanel{
    protected int currentDay;
    protected GridLayout myGrid;

    /*MonthPanelコンストラクタ */
    MonthPanel(int year, int month){
        super(year,month);
        myGrid = new GridLayout(0,7);
        setLayout(myGrid);
        arrangePanel();
    }

    /*MonthPanelコンストラクタ */
    MonthPanel(GregorianCalendar g){
        super(g);
        myGrid = new GridLayout(0,7);
        setLayout(myGrid);
        arrangePanel();
    }

    public void selectDay(int day){
        currentDay = day;
        System.out.println("#### " + day);
    }

    public static JPanel createMonthPanel(int year,int month){
        //MonthPanel m = new MonthPanel(year,month);
        //return m;
        GregorianCalendar g = new GregorianCalendar(year, month-1, 1);
        g.setFirstDayOfWeek(Calendar.MONDAY);
        return new MonthPanel(g);
    }

    void arrangePanel(){
        int firstDayOfWeek = g.getFirstDayOfWeek()-1;

        /*曜日ラベルの配置 */
        for(int i=0;i<7;++i){
            add(makeLabel(namesOfDay[(firstDayOfWeek+i)%7]));
        }

        /*配置済みの日付の数（今月分のみ） */
        int days = 0;

        /*日付の配置 */
        for(int w=0;w<maxWeeks;++w){
            /*週の配置 */
            for(int d=0;d<7;++d){
                /*毎週の日付の配置 */
                if(days == 0 && d != firstNameOfDay){
                    /*先月分 */
                    add(makeLabel("／"));
                }else if(days == maxDays){
                    /*来月分 */
                    add(makeLabel("／"));
                }else{
                    days++;
                    add(makeButton(days));
                }
            }
        }
    }

    JButton makeButton(int d){
        JButton b = new JButton(""+d);
        Action act = new DaySelectAction(d,this);
        b.addActionListener(act);
        b.setBackground(Color.LIGHT_GRAY);
        b.setOpaque(false);
        return b;
    }

    /*中央に表示位置をあわせたラベルを 生成する*/
    /*@return javax.swing.JLabel */
    /*@param s java.lang.String */
    private JLabel makeLabel(String s) {
        return new JLabel(s,SwingConstants.CENTER);
    }
}

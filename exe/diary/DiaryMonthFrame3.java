import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class DiaryMonthFrame3 extends BaseFrame implements MonthSelector{
    private ButtonGroup group = new ButtonGroup();
    private JPanel buttonPanel = new JPanel();
    private int year;
    private int currentMonth = 1;
    private JPanel currentMonthPanel = null;
    private Container myContentPane = getContentPane();
    private Action[] actions = new Action[12];

    DiaryMonthFrame3(int year){
        super("Diary Month Selection",0.6,0.5,0.2,0.2);

        addWindowListener(new WindowTerminator());
        this.year = year;

        for(int i=1;i<=12;++i){
            actions[i-1] = makeAction(i);
            addRadioButton(actions[i-1],buttonPanel,group);
        }
        Border b = BorderFactory.createEtchedBorder(Color.CYAN,Color.BLACK);
        buttonPanel.setBorder(BorderFactory.createTitledBorder(b,year+"年"));
        myContentPane.add(buttonPanel,BorderLayout.NORTH);
    }

    public void selectMonth(int m){
        if(currentMonthPanel != null) myContentPane.remove(currentMonthPanel);
        currentMonth = m;
        currentMonthPanel = MonthPanel.createMonthPanel(year, m);
        myContentPane.add(currentMonthPanel);
        setVisible(true);
    }

    public int getYear(){ return year; }
    public int getMonth(){ return currentMonth; }

    Action makeAction(int month){
        String name = monthName[month-1];
        return new MonthSelectAction(name, month, this);
    }

    JRadioButton addRadioButton(Action act,JPanel p,ButtonGroup g){
        JRadioButton b = new JRadioButton((String)act.getValue(Action.NAME));
        p.add(b);
        g.add(b);
        b.addActionListener(act);
        b.setActionCommand(act.getValue(ACTION_CODE).toString());
        return b;
    }
}

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class DiaryMonthFrame4 extends BaseFrame implements MonthSelector{
    private ButtonGroup group = new ButtonGroup();
    private JRadioButton[] buttons = new JRadioButton[12];
    private ButtonGroup group2 = new ButtonGroup();
    private JRadioButtonMenuItem[] mbuttons = new JRadioButtonMenuItem[12];

    private JPanel buttonPanel = new JPanel();
    private JMenuBar menuBar = new JMenuBar();
    private int year;
    private int currentMonth = 1;
    private JPanel currentMonthPanel = null;
    private Container myContentPane = getContentPane();
    private Action[] actions = new Action[12];

    /*パネルのキャッシュ */
    private JPanel[] monthPanels = new JPanel[12];

    DiaryMonthFrame4(int year){
        super("Diary Month Selection",0.6,0.5,0.2,0.2);

        addWindowListener(new WindowTerminator());
        this.year = year;
        JMenu month_menu = new JMenu(year+"年");
        for(int i=0;i<12;++i){
            actions[i] = makeAction(i+1);
            buttons[i] = addRadioButton(actions[i], buttonPanel, group);
            mbuttons[i] = addRadioButtonMenuItem(actions[i],month_menu,group2);
            monthPanels[i] = null;
        }
        menuBar.add(month_menu);
        setJMenuBar(menuBar);

        Border b = BorderFactory.createEtchedBorder(Color.CYAN,Color.BLACK);
        buttonPanel.setBorder(BorderFactory.createTitledBorder(b,year+"年"));
        myContentPane.add(buttonPanel,BorderLayout.NORTH);
    }

    public void selectMonth(int m){
        if(currentMonthPanel != null){
            currentMonthPanel.setEnabled(false);

            myContentPane.remove(currentMonthPanel);
            monthPanels[currentMonth-1] = currentMonthPanel;
        } 

        currentMonth = m;
        if(monthPanels[m-1] == null){
            currentMonthPanel = MonthPanel.createMonthPanel(year, m);
        }else{
            currentMonthPanel = monthPanels[m-1];
        }
        myContentPane.add(currentMonthPanel);

        currentMonthPanel.setEnabled(true);
        changeRadioButtonState(m);
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

    JRadioButtonMenuItem addRadioButtonMenuItem(Action act,JMenu m,ButtonGroup g){
        JRadioButtonMenuItem b = new JRadioButtonMenuItem((String)act.getValue(Action.NAME));
        b.addActionListener(act);
        m.add(b);
        g.add(b);
        b.setActionCommand(act.getValue(ACTION_CODE).toString());
        return b;
    }
    private void changeRadioButtonState(int i){
        buttons[i-1].setSelected(true);
        mbuttons[i-1].setSelected(true);
    }
}
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/* 年単位の日記帳に対するフレーム */
class AnnualVolumeFrame extends BaseFrame implements MonthSelector {
    private ButtonGroup group = new ButtonGroup();
    private JRadioButton[] buttons = new JRadioButton[12];
    private ButtonGroup group2 = new ButtonGroup();
    private JRadioButtonMenuItem[]  mbuttons = new JRadioButtonMenuItem[12];

    private JPanel buttonPanel = new JPanel();
    private JMenuBar menuBar = new JMenuBar();
    private int year;
    private int currentMonth = 1;
    private MonthEditPanel currentMonthPanel = null;
    private Container myContentPane = getContentPane();
    private Action[] actions = new Action[12];
    protected MonthEditPanel[] monthPanels = new MonthEditPanel[12];

    /* パネルのキャッシュ */
    protected Annual myAnnual;

    AnnualVolumeFrame(Annual an) {
        super(an.getYear() + "年 日記帳",0.6,0.5,0.2,0.2);
        addWindowListener(new WindowTerminator());
        myAnnual = an;
        year = an.getYear();

        JMenu month_menu = new JMenu(year + "年");
        for( int i = 0 ; i < 12 ; ++i ) {
            actions[i] = makeAction(i+1);
            buttons[i] = addRadioButton(actions[i],buttonPanel,group);
            mbuttons[i] = 
                addRadioButtonMenuItem(actions[i],month_menu,group2);
            monthPanels[i] = null;
        }
        menuBar.add(month_menu);
        setJMenuBar(menuBar);

        Border b = BorderFactory.createEtchedBorder(Color.CYAN,Color.BLACK);
        buttonPanel.setBorder(BorderFactory.createTitledBorder(b,year + "年"));
        myContentPane.add(buttonPanel,BorderLayout.NORTH);
    }

    public void selectMonth(int m) {
        if( currentMonthPanel != null ) {

            /* パネルを休眠状態にする */
            currentMonthPanel.setEnabled(false);
            myContentPane.remove(currentMonthPanel);

            /* コンテントペインから取り外す */
            monthPanels[currentMonth - 1] = currentMonthPanel; 

            /* キャッシュに登録する */
        }
        currentMonth = m;

        /* キャッシュは空か？ */
        if( monthPanels[m-1] == null ) {
            currentMonthPanel =
                MonthEditPanel.createMonthEditPanel(myAnnual.getMonthly(m));

        /* パネルを新しく作る */
        } else {

            /* キャッシュにヒットした */
            currentMonthPanel = monthPanels[m-1];
        }
        myContentPane.add(currentMonthPanel);

        /* パネルをコンテントペインに登録する */
        /* 活動状態に設定する、表示更新可能 */
        currentMonthPanel.setEnabled(true);
        changeRadioButtonState(m);
        setVisible(true);
    }

    public int getYear() { return year; }
    public int getMonth() { return currentMonth; }

    Action makeAction(int month){
        String name = monthName[month - 1];
        return  new MonthSelectAction(name,month,this);
    }

    JRadioButton addRadioButton(Action act,JPanel p,ButtonGroup g){
        /* JRadioButton b = new JRadioButton(act); JDK1.3 or later */
        JRadioButton b = new JRadioButton((String)act.getValue(Action.NAME));
        b.addActionListener(act);
        p.add(b);
        g.add(b);
        b.setActionCommand(act.getValue(ACTION_CODE).toString());
        return b;
    }

    JRadioButtonMenuItem addRadioButtonMenuItem(Action act,JMenu m,ButtonGroup g){
        /* JRadioButtonMenuItem b = new JRadioButtonMenuItem(act); */
        /* JDK1.3 or later */
        JRadioButtonMenuItem b 
            = new JRadioButtonMenuItem((String)act.getValue(Action.NAME));
        b.addActionListener(act);
        m.add(b);
        g.add(b);
        b.setActionCommand(act.getValue(ACTION_CODE).toString());
        return b;
    }
    private void changeRadioButtonState(int i) {
        buttons[i-1].setSelected(true);
        mbuttons[i-1].setSelected(true);
    }
}
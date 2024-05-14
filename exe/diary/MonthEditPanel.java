import java.awt.event.*;
import javax.swing.*;

/* 月編集パネル最終版 */
class MonthEditPanel extends MonthPanel {
    Monthly currentMonthly;
    protected JFrame currentDayFrame = null;

    /* MonthEditPanel コンストラクタ */
    /* @param year int */
    /* @param month int */
    MonthEditPanel(int year, int month) {
        super(year, month);
    }

    /* MonthEditPanel コンストラクタ */
    /* @param g java.util.GregorianCalendar */
    MonthEditPanel(java.util.GregorianCalendar g) {
        super(g);
    }

    /* MonthEditPanel コンストラクタ */
    /* @param g java.util.GregorianCalendar */
    MonthEditPanel(Monthly m) {
        super(m.getCalendar());
        currentMonthly = m;
    }

    public void selectDay(int day) {
        if(currentMonthly == null || currentDay == day) return;
            Diary d = currentMonthly.getDiary(day);
            if( d == null ) { 
                d = currentMonthly.createNewDiary(day);
            }
            currentDayFrame = new MyDiaryEditFrame(d);
            currentDayFrame.setVisible(true);
            currentDay = day;
    }

    /* Monthly 編集パネルを作る */
    /* @return MonthEditPanel */
    /* @param m Monthly */
    public static MonthEditPanel createMonthEditPanel(Monthly m) {
        return new MonthEditPanel(m);
    }

    /* 管理中のMonthlyを取り出す */
    /* @return Monthly */
    public Monthly getMonthly() {
        return currentMonthly;
    }

    private class MyDiaryEditFrame extends DiaryEditFrame {
        class DiaryEditConfirmation extends WindowAdapter {
            public void windowClosing(WindowEvent e) {
                Diary d = showDiaryDialog();
                if(d != null) {
                    int day = d.getDay().getDay();
                    currentMonthly.setDiary(day,d);
                }
                currentDay = 0;
            }
        }
        MyDiaryEditFrame(Diary d) {
            super(d);
            addWindowListener(new DiaryEditConfirmation());
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }
}

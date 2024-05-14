import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/* 完成版DiaryEditFrame */
class DiaryEditFrame extends BaseFrame implements ActionListener,DiaryConstants{
    private Action[] edtAction = new Action[actionCod.length];
    private Container mycontentPane = getContentPane();
    private Box mybox = Box.createVerticalBox();
    private Diary diary;
    private JTextArea ta;
    private JScrollPane scroll;
    private AffairDialog ad;

    /* selected affair */
    private AffairButton currentAffairButton = null;

    /* copy */
    private Affair copyBuffer = null;
    private AffairButton primaryAffairButton;
    private Vector<AffairButton> schedulelistButtons = new Vector<AffairButton>();
    private JPanel affairPanel = new JPanel();
    private JPanel outerAffairPanel = new JPanel();
    private Object lock = new Object();

    class AffairButton extends JButton {
        private Affair af;
        private String title;
        AffairButton(String t,Affair a) {
            super(t+a.getAffairString());
            af = a;
            title = t;
            addActionListener(DiaryEditFrame.this);
            setBackground(Color.LIGHT_GRAY);
            setOpaque(false);
        }

        void setAffair(Affair a) {
            af = a;
            setText(title+af.getAffairString());
            repaint();
        }

        Affair getAffair() {
            return af;
        }
    }

    /* 日記帳編集アクション 内部クラス */
    class DiaryEditAction extends AbstractAction implements DiaryConstants {
        public void actionPerformed(ActionEvent e) {
            int cmd = ((Integer)getValue(ACTION_CODE)).intValue();
            switch( cmd ) {
                case OPEN : break;
                case OUTPUT: break;
                case EXIT : dispatchEvent(new WindowEvent(
                                    DiaryEditFrame.this,
                                    WindowEvent.WINDOW_CLOSING));
                            break;
                case NEW : newAffair(); break;
                case EDIT : editAffair(); break;
                case CUT : cutAffair(); break;
                case PASTE : pasteAffair(); break;
                case COPY : copyAffair();  break;
                case DELETE : deleteAffair(); break;
                default : break;
            }
        }

        DiaryEditAction(String name,int action_code,Icon icn) {
            putValue(ACTION_CODE,Integer.valueOf(action_code));
            putValue(Action.NAME,name);
            putValue(Action.SMALL_ICON,icn);
        }
    }

    DiaryEditFrame(Diary diary) {
        super(diary.getDay().getDayString(),0.4,0.6,0.2,0.2);

        /* addWindowListener(new WindowTerminator()); */
        this.diary = diary;
        ad = new AffairDialog(this);

        setUpDiaryDisplay();
        setUpTextArea();
        setUpActions();
        mycontentPane.add(mybox,BorderLayout.CENTER);
    }

    private void setUpDiaryDisplay() {
        /* FlowLayout panel */
        outerAffairPanel.setBackground(Color.WHITE);

        /* GridLayout inside FlowLayout */
        affairPanel.setLayout(new GridLayout(15,1));
        affairPanel.setBackground(Color.WHITE);
        primaryAffairButton = 
            new AffairButton("本日の重要事項：",diary.getPrimaryAffair());
        affairPanel.add(primaryAffairButton);
        primaryAffairButton.setOpaque(false);

        ObjectIteration oi = diary.getScheduleList().createIteration();

        while(oi.hasNext()) {
            insertAffair((Affair)oi.next());
        }
        outerAffairPanel.add(affairPanel);
        mybox.add(outerAffairPanel);
    }

    private void setUpActions() {
        JMenu m = new JMenu("編集");
        JToolBar tb = new JToolBar();
        JButton ab;
        for( int i = 0; i < actionCod.length ; ++i ) {
            edtAction[i] = new DiaryEditAction( actionNam[i],actionCod[i],
                                                new ImageIcon(actionImg[i]));
            m.add(edtAction[i]);
            ab = tb.add(edtAction[i]);
            ab.setToolTipText(actionNam[i]);
        }
        JMenuBar mbar = new JMenuBar();
        mbar.add(m);
        setJMenuBar(mbar);
        mycontentPane.add(tb,BorderLayout.SOUTH);
        edtAction[ACT_OPEN].setEnabled(false);
        edtAction[ACT_OUTPUT].setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        selectAffair((AffairButton)e.getSource());
        affairPanel.repaint();
    }

    private void setUpTextArea() {
        ta = new JTextArea(diary.getMemo().getMemoString(),4,40);
        scroll = new JScrollPane(ta);
        mybox.add(scroll);
    }

    /* Affairをコピーバッファにコピーする */
    private void copyAffair() {
        synchronized(lock) {
            AffairButton a = currentAffairButton;
            if(a !=null) {
                copyBuffer = a.getAffair();
            }
        }
    }

    /* AffairをCUTする */
    private void cutAffair() {
        synchronized(lock) {
            if(currentAffairButton != null) {
                copyBuffer = currentAffairButton.getAffair();
                removeButton();
            }
        }
        setVisible(true);
    }

    /* Affairを消去する */
    private void deleteAffair() {
        synchronized(lock) {
            if(currentAffairButton != null) {
                removeButton();
            }
        }
        setVisible(true);
    }

    /* Affair を編集用ダイアログにて編集する */
    private void editAffair() {
        synchronized(lock) {
            AffairButton b = currentAffairButton;
            if( b != null ) {
                Affair a = b.getAffair();
                if(ad.showAffairDialog(a)) {
                    b.setAffair(a);
                }
                affairPanel.repaint();
                return;
            }
        }
        Affair a = diary.createNewAffair();
        if(ad.showAffairDialog(a)) {
            insertAffair(a);
        }
        setVisible(true);
    }

    /* 新しいAffairを追加する */
    private void newAffair() {
        insertAffair(diary.createNewAffair());
        setVisible(true);
    }

    /* コピーバッファのAffairをペーストする */
    private void pasteAffair() {
        Affair a = null;
        synchronized(lock) {
            a = copyBuffer;
            if(a == null) return;
            if( currentAffairButton != null ) {
                currentAffairButton.setAffair(a.makeCopy());
                affairPanel.repaint();
                return;
            }
        }
        insertAffair(a.makeCopy());
        affairPanel.repaint();
        setVisible(true);
    }

    /* 新しいAffairボタンをスケジュールリスト表示に追加する */
    private void insertAffair(Affair a) {
        AffairButton bb = new AffairButton("予定：",a);
        bb.setHorizontalAlignment(SwingConstants.LEFT);
        bb.setOpaque(false);
        affairPanel.add(bb);
        schedulelistButtons.add(bb);
    }

    /* actionPerformed より呼び出される */
    /* AffairButton選択時の処理 */
    private void selectAffair(AffairButton a) {
        synchronized(lock) {
            if(currentAffairButton == a) {
                currentAffairButton.setOpaque(false);

                /* toggle */
                currentAffairButton = null;
            } else {
                if(currentAffairButton != null ) {
                    currentAffairButton.setOpaque(false);
                }
                a.setOpaque(true);
                currentAffairButton = a;
            }
        }
    }

    /* ボタンを削除する */
    /* ただし、primaryAffairに対しては単に内容を空白にする */
    private void removeButton() {
        AffairButton a = currentAffairButton;
        if(a == primaryAffairButton) {
            a.setAffair(diary.createNewAffair());
        } else {
            a.setEnabled(false);
            affairPanel.remove(a);
            schedulelistButtons.remove(a);
            affairPanel.repaint();
            currentAffairButton = null;
        }
    }

    /* 日記情報を取り出す */
    /* @param d Diary */
    private void getDiary(Diary d) {
        d.setDay(diary.getDay());
        d.setPrimaryAffair(primaryAffairButton.getAffair());

        ScheduleList list = d.getScheduleList();
        ObjectIteration oi = list.createIteration();

        Affair a;
        while(oi.hasNext()) {
            /* ScheduleList中の不要なAffairを取り除く */
            a = (Affair)oi.next();
            list.removeAffair(a);
        }

        Iterator e = schedulelistButtons.iterator();
        AffairButton ab;
        while(e.hasNext()) {
            ab = (AffairButton)e.next();
            list.addAffair(ab.getAffair());
        }
        d.getMemo().setMemoString(ta.getText());
    }

    /* 日記編集処理の終了確認をする */
    /* @return boolean */
    /* @param d Diary */
    public boolean showDiaryDialog(Diary d) {
        boolean status = false;
        int selection = JOptionPane.showConfirmDialog(null,
                            "日記情報の更新をしますか？",
                            "編集終了確認",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.WARNING_MESSAGE);
        if( selection == JOptionPane.OK_OPTION ) {
            getDiary(d);
            dispose();
            status = true;
        } else if(selection == JOptionPane.NO_OPTION) {
            dispose();
        } else {
            setVisible(true);
        }
        return status;
    }
    public Diary showDiaryDialog() {
        return  ( showDiaryDialog(diary) ? diary : null);
    }
}
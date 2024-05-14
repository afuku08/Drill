import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BorderLayoutFrame extends BaseFrame implements ActionListener {
    BorderLayoutFrame(Diary d) {
        super("BorderLayout test.",0.4,0.4,0.2,0.2);
        addWindowListener(new WindowTerminator());
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        p.setBackground(Color.WHITE);

        p.add(createButton("日付：：" + d.getDay().getDayString()));
        p.add(createButton("本日の重要事項：" + d.getPrimaryAffair().getAffairString()));
        p.add(createButton("スケジュール"));

        ObjectIteration oi = d.getScheduleList().createIteration();
        Affair a;
        while(oi.hasNext()){
            a = (Affair)oi.next();
            p.add(createButton(a.getAffairString()));
        }

        p.add(createButton("メモ：" + d.getMemo().getMemoString()));

        Container c = getContentPane();
        c.add(p);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        JButton b = (JButton) e.getSource();

        /*ボタンは不透明か？ */
        if(b.isOpaque()){

            /*ボタンを透明に設定 */
            b.setOpaque(false);

            /*ボタンテキストをコマンド文字列に戻す */
            b.setText(s);
        }else{
            /*不透明に設定 */
            b.setOpaque(true);

            /*ボタンテキストの末尾に'!'を追加 */
            b.setText((s+"!"));
        }
        repaint();
    }

    private JButton createButton(String s){
        JButton b = new JButton(s);
        b.setActionCommand(s);
        b.addActionListener(this);
        b.setBackground(Color.LIGHT_GRAY);
        b.setOpaque(false);
        return b;
    }
}

class DiaryGridFrame extends BaseFrame implements ActionListener {
    DiaryGridFrame(Diary d){
        super("BorderLayout test.",0.4,0.4,0.2,0.2);
        addWindowListener(new WindowTerminator());
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(0,1,3,3));
        p.setBackground(Color.WHITE);

        p.add(createButton("日付：：" + d.getDay().getDayString()));
        p.add(createButton("本日の重要事項：" + d.getPrimaryAffair().getAffairString()));
        p.add(createButton("スケジュール"));

        ObjectIteration oi = d.getScheduleList().createIteration();
        Affair a;
        while(oi.hasNext()){
            a = (Affair)oi.next();
            p.add(createButton(a.getAffairString()));
        }

        p.add(createButton("メモ：" + d.getMemo().getMemoString()));

        Container c = getContentPane();
        c.add(p);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        JButton b = (JButton) e.getSource();

        /*ボタンは不透明か？ */
        if(b.isOpaque()){

            /*ボタンを透明に設定 */
            b.setOpaque(false);

            /*ボタンテキストをコマンド文字列に戻す */
            b.setText(s);
        }else{
            /*不透明に設定 */
            b.setOpaque(true);

            /*ボタンテキストの末尾に'!'を追加 */
            b.setText((s+"!"));
        }
        repaint();
    }

    private JButton createButton(String s){
        JButton b = new JButton(s);
        b.setActionCommand(s);
        b.addActionListener(this);
        b.setBackground(Color.LIGHT_GRAY);
        b.setOpaque(false);
        return b;
    }
}

public class TestDiaryFrame {
    public static void main(String[] args){
        ScheduleList s1 = new SimpleScheduleList();

        Affair  a;

        Day d1 = new SimpleDay(2010,7,20);

        s1.addAffair(new SimpleAffair(9,30,"会議","本社ビル","山田太郎"));
        s1.addAffair(new SimpleAffair(11,30,"見学","代々木","赤塚富士子"));
        s1.addAffair(a = new SimpleAffair(15,30,"商談","新宿","鈴木次郎"));
        s1.addAffair(new SimpleAffair(16,45,null,null,"名前なし"));

        Diary dia1 = new SimpleDiary();
        dia1.setDay(d1);
        dia1.setScheduleList(s1);
        dia1.setPrimaryAffair(a);
        dia1.setMemo(new SimpleMemo(
                    "鈴木は、金もち、ただし、タフネゴシエータ。心してかかること。"));
        JFrame f = new DiaryGridFrame(dia1);
        f.setVisible(true);

    }
}

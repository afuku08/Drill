import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DiaryPanel extends JPanel implements ActionListener{
    private Diary current;
    private Diary[] diary;
    public int currentIndex;
    private Font f = new Font("SansSerif",Font.BOLD, 16);
    private FontMetrics fm;
    private JButton next;
    private JButton previous;

    public DiaryPanel(Diary[] d){
        if(d.length>0) current = d[0];
        else current = null;
        setBackground(Color.WHITE);
        currentIndex = 0;
        diary = d;

        next = new JButton(">>");
        previous = new JButton("<<");

        add(previous);
        add(next);

        next.addActionListener(this);
        previous.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if(source == next){
            currentIndex += 1;
            if(currentIndex >= diary.length) currentIndex = 0;
        }else if(source == previous){
            currentIndex -= 1;
            if(currentIndex < 0) currentIndex = diary.length - 1;
        }
        current = diary[currentIndex];

        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(current == null) return;

        Graphics g2 = g.create();
        if(fm == null){
            fm = g2.getFontMetrics(f);
        }
        
        g.setFont(f);

        int height = fm.getHeight();
        int cx = 100;
        int cy = 100;
        String s;

        s = "日付：：" + current.getDay().getDayString();
        g.drawString(s, cx, cy);
        cy += height;

        s = "本日の重要事項：" + current.getPrimaryAffair().getAffairString();
        g.drawString(s, cx, cy);
        cy += height;

        s = "スケジュール";
        g.drawString(s, cx, cy);
        cy += height;

        ObjectIteration oi = current.getScheduleList().createIteration();
        Affair a;
        while(oi.hasNext()){
            a = (Affair)oi.next();
            g.drawString(a.getAffairString(), cx, cy);
            cy += height;
        }

        s = "メモ：" + current.getMemo().getMemoString();
        g.drawString(s, cx, cy);
    }
}

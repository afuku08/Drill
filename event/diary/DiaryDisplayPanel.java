import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DiaryDisplayPanel extends JPanel{
    private Diary current;
    private Font f = new Font("SansSerif",Font.BOLD, 16);
    private FontMetrics fm;

    public DiaryDisplayPanel(Diary d){
        current = d;
        setBackground(Color.WHITE);
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

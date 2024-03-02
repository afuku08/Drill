import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DiaryButtonPanel extends JPanel implements ActionListener{
    private Diary[] diary;
    private int currentIndex;
    private JButton next;
    private JButton previous;
    private boolean isInitialState = true;

    public DiaryButtonPanel(Diary[] d){
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

        if(isInitialState){
            currentIndex = 0;
            isInitialState = false;
        }

        if(source == next){
            currentIndex += 1;
            if(currentIndex >= diary.length) currentIndex = 0;
        }else if(source == previous){
            currentIndex -= 1;
            if(currentIndex < 0) currentIndex = diary.length - 1;
        }

        JFrame f = new DiaryDisplayFrame(diary[currentIndex]);
        f.setVisible(true);
        repaint();
    }
}

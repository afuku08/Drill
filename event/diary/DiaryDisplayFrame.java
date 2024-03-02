import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class DiaryDisplayFrame extends JFrame{
    public DiaryDisplayFrame(Diary diary){
        setTitle("This is a Diary");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * 0.6),(int)(d.height * 0.6));
        setLocation((int)(d.width * 0.2),(int)(d.height * 0.2));
        addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    dispose();
                }
            }
        );
        getContentPane().add(new DiaryDisplayPanel(diary));
    }
}

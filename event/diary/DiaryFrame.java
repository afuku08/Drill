import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DiaryFrame extends JFrame{
    DiaryFrame(Diary[] diary) {
        setTitle("This is a Diary");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize((int)(d.width * 0.6),(int)(d.height * 0.6));
        setLocation((int)(d.width * 0.2),(int)(d.height * 0.2));
        addWindowListener(new WindowTerminator());
        getContentPane().add(new DiaryPanel(diary));
    }
}

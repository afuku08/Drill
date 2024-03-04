import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChangeColorAction extends AbstractAction{
    private Component target;

    ChangeColorAction(String name,Icon icon,Color c,Component comp){
        target = comp;
        putValue(Action.NAME,name);
        putValue(Action.SMALL_ICON,icon);
        putValue("color",c);
    }

    public void actionPerformed(ActionEvent e) {
        Color c = (Color)getValue("color");
        target.color = c;
        target.repaint();
    }
}

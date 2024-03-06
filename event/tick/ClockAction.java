import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.*;
import javax.awt.event.*;

public class ClockAction extends AbstractAction{
    ClockMethods target;

    ClockAction(String name,int action_code,ClockMethods clock){
        putValue(Action.NAME, name);
        putValue("action_code", new Integer(action_code));
        target = clock;
    }

    public void actionPerformed(ActionEvent e) {
        switch(((Integer)getValue("action_code")).intValue()){
            case ClockMethods.START_CLOCK : target.startClock(); break;
            case ClockMethods.STOP_CLOCK : target.stopClock(); break;
            case ClockMethods.TICK_CLOCK : target.tickClock(); break;
            case ClockMethods.RESET_CLOCK : target.resetClock(); break;
            case ClockMethods.DEFAULT_CLOCK : target.defaultClock(); break;
            default : return;
        }
    }
}

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class DaySelectAction extends AbstractAction implements DiaryConstants{
    DaySelector target;
    public void actionPerformed(ActionEvent e){
        int day = ((Integer)getValue(ACTION_CODE)).intValue();
        target.selectDay(day);
    }
    DaySelectAction(int action_code,DaySelector select){
        putValue(ACTION_CODE, Integer.valueOf(action_code));
        putValue(Action.NAME, ""+ action_code);
        target = select;
    }
}

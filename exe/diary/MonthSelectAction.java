import javax.swing.*;
import java.awt.event.*;

public class MonthSelectAction extends AbstractAction implements DiaryConstants{
    MonthSelector target;
    public void actionPerformed(ActionEvent e){
        int month = ((Integer)getValue(ACTION_CODE)).intValue();
        target.selectMonth(month);
    }
    MonthSelectAction(String name,int action_code,MonthSelector select){
        putValue(Action.NAME, name);
        putValue(ACTION_CODE, Integer.valueOf(action_code));
        target = select;
    }
}

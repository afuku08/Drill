import java.awt.*;
import java.awt.event.*;

class TickEvent extends ActionEvent {
    public final static int TICK_EVENT = AWTEvent.RESERVED_ID_MAX + 10002;
    public TickEvent(Tick tk) {
        super(tk,TICK_EVENT,"tick");
    }
}

package kingdom.original;

import java.util.EventObject;

/**
 * @author No.1412
 * @version 2018/7/21
 * 事件对象
 */
public class Event extends EventObject {

    private String acton;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public Event(Object source) {
        super(source);
    }

    public String getActon() {
        return acton;
    }

    public void setActon(String acton) {
        this.acton = acton;
    }
}

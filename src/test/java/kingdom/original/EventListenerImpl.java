package kingdom.original;

/**
 * @author No.1412
 * @version 2018/7/21
 */
public class EventListenerImpl implements EventListener {

    @Override
    public void eat(Event event) {
        System.out.println(event.getActon());
        System.out.println(event.getSource());
    }
}

package kingdom.original;

/**
 * @author No.1412
 * @version 2018/7/21
 * @Description: 事件源
 */
public class EventSource {

    private EventListener eventListener;

    public EventSource() {
        register(new EventListenerImpl());
    }

    public void register(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void eat() {
        Event event = new Event(this);
        event.setActon("洗手");
        eventListener.eat(event);
        System.out.println("开始吃饭");
    }

}

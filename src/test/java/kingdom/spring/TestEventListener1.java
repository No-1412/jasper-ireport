package kingdom.spring;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author No.1412
 * @version 2018/7/21
 * @Description: 事件监听器
 */
@Async
@Component
public class TestEventListener1 {

    @EventListener
    public void onApplicationEvent(TestEvent event) {
        System.out.println("Test1-> "+event.getMsg());
        ((SpringEventSource)event.getSource()).processTask();
    }

    @EventListener
    public void onApplicationEvent2(TestEvent event) throws InterruptedException {
        System.out.println("Test2-> "+event.getMsg());
        ((SpringEventSource)event.getSource()).processTask();
    }

    @EventListener
    public void onApplicationEvent3(TestEvent event) {
        System.out.println("Test3-> "+event.getMsg());
        ((SpringEventSource)event.getSource()).processTask();
    }
}

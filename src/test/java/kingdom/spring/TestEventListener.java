package kingdom.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author No.1412
 * @version 2018/7/21
 * @Description: 事件监听器
 */
@Component
public class TestEventListener implements ApplicationListener<TestEvent> {
    @Override
    public void onApplicationEvent(TestEvent testEvent) {
        System.out.println("Test-> "+testEvent.getMsg());
        System.out.println(testEvent.getSource());
    }
}

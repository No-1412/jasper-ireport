package kingdom.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author No.1412
 * @version 2018/7/21
 * @Description: 事件源
 */
@Component
public class SpringEventSource {

    @Autowired
    private ApplicationContext applicationContext;

    public void publishEvent() {
//        ApplicationListener applicationListener = new TestEventListener();
        TestEvent testEvent = new TestEvent(this);
        testEvent.setMsg("打隐藏Boss");
        applicationContext.publishEvent(testEvent);
//        applicationListener.onApplicationEvent(testEvent);
        System.out.println("大Boss");
    }

    public void processTask() {
        System.out.println("副监听执行任务");
    }

}

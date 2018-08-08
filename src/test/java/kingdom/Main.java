package kingdom;

import kingdom.original.EventSource;
import kingdom.spring.SpringEventSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author No.1412
 * @version 2018/7/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-spring-context.xml")
public class Main {

    @Autowired
    private SpringEventSource springEventSource;

    @Test
    public void testOrigEvent() {
        EventSource eventSource = new EventSource();
        eventSource.eat();
    }

    @Test
    public void testSpringEvent() throws InterruptedException {
        springEventSource.publishEvent();
//        Thread.sleep(3000);
    }
}

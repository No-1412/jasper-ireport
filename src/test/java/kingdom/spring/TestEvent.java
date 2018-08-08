package kingdom.spring;

import org.springframework.context.ApplicationEvent;

/**
 * @author No.1412
 * @version 2018/7/21
 * @Description: 事件对象
 */
public class TestEvent extends ApplicationEvent {

    private String msg;

    public TestEvent(Object source) {
        super(source);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

import org.demo.MySpringBootWebSocket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

/**
 * ActiveTest
 *
 * @author hss
 * @date 2019/12/18 18:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootWebSocket.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ActiveTest {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue  queue;

    @Autowired
    private Topic topic;

    @Test
    public void activeTest(){
        for(int i = 0; i < 10; i ++ ){
            jmsMessagingTemplate.convertAndSend(queue,"producer =="+ i);
            jmsMessagingTemplate.convertAndSend(topic,"producer =="+ i);
        }
    }
}

package org.demo.activemq.consumer;

import cn.hutool.log.Log;
import org.demo.activemq.config.ActiveConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Consumer
 *
 * @author hss
 * @date 2019/12/18 18:01
 */
@Component
public class Consumer {

    private final static Log logger = Log.get(Consumer.class);

    @JmsListener(destination = ActiveConfig.TOPIC,containerFactory = "jmsListenerContainerTopic")
    public void onTopicMessage(String msg) {
        logger.info("接收到topic消息：{}",msg);
    }

    @JmsListener(destination = ActiveConfig.QUEUE,containerFactory = "jmsListenerContainerQueue")
    public void onQueueMessage(String msg) {
        logger.info("接收到queue消息：{}",msg);
    }
}

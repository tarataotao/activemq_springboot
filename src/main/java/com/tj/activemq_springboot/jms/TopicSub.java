package com.tj.activemq_springboot.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息订阅
 */
@Component
public class TopicSub {

    @JmsListener(destination = "video.topic",containerFactory = "jmsListenerContainerTopic")
    public void receive(String text){
        System.out.println("video.topic 消费者：receivel="+text);

    }
    @JmsListener(destination = "video.topic",containerFactory = "jmsListenerContainerTopic")
    public void receive2(String text){
        System.out.println("video.topic 消费者：receivel="+text);

    }

    /**
     * 没得加containerFactory = "jmsListenerContainerTopic"的情况下，无法订阅消息
     * @param text
     */
    @JmsListener(destination = "video.topic")
    public void receive3(String text){
        System.out.println("video.topic 消费者：receivel="+text);

    }
}

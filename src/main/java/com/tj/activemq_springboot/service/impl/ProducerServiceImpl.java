package com.tj.activemq_springboot.service.impl;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

import com.tj.activemq_springboot.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate; //用来发送消息到broker的对象

    @Autowired
    private Queue queue;


    @Override
    public void sendMessage(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    @Override
    public void sendMessage(String message) {
        jmsMessagingTemplate.convertAndSend(this.queue,message);
    }


    //----------------发布订阅相关代码---------------------

    @Autowired
    private Topic topic;
    @Override
    public void publish(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.topic,msg);
    }
}

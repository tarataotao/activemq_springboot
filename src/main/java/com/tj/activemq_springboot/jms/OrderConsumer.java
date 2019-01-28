package com.tj.activemq_springboot.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @JmsListener(destination = "order.queue")
    public void receiveQueue(String text){
        System.out.println("orderConsumer收到的报文为："+text);
    }

    @JmsListener(destination = "common.queue")
    public void receiveCommonQueue(String text){
        System.out.println("receiveCommonQueue收到的报文为："+text);
    }
}

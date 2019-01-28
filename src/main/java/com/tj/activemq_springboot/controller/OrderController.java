package com.tj.activemq_springboot.controller;

import com.tj.activemq_springboot.domain.JsonData;
import com.tj.activemq_springboot.service.ProducerService;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.jms.Destination;


/**
 * 模拟微信支付回调
 */

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Resource
    private ProducerService producerService;

    @GetMapping("order")
    public Object order(String msg){
        //生成消息队列地址
        Destination destination=new ActiveMQQueue("order.queue");
        producerService.sendMessage(destination,msg);
        return JsonData.buildSuccess();
    }
    @GetMapping("common")
    public Object common(String msg){
        producerService.sendMessage(msg);
        return JsonData.buildSuccess();
    }

    @GetMapping("topic")
    public Object topic(String msg){
        producerService.publish(msg);
        return JsonData.buildSuccess();
    }
}

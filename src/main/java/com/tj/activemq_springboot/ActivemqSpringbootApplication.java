package com.tj.activemq_springboot;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@SpringBootApplication
@EnableJms //开启致辞jms
public class ActivemqSpringbootApplication {
	//交给spring进行管理，方便后续进行注入
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("common.queue");
	}

    /**
     * 主题对象交给spring管理
     * @return
     */
	@Bean
	public Topic topic(){
	    return new ActiveMQTopic("video.topic");
    }
	public static void main(String[] args) {
		SpringApplication.run(ActivemqSpringbootApplication.class, args);
	}

	//需要给topic定义独立的JmsListenerContainer
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }

}


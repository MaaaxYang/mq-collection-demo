package com.atom.mq.rabbit.producer;

import com.atom.mq.rabbit.exchange.ExchangeConfig;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @program: mq-collection-demo
 * @description:
 * @author: Maxxx.Yg
 * @create: 2018-11-19 10:40
 **/
@Component
public class DemoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public boolean topicSend(Object message){
        rabbitTemplate.convertAndSend(ExchangeConfig.topicExchange,"demo2-topic-routingKey.one",message,new CorrelationData(UUID.randomUUID().toString()));
        return true;
    }

    public boolean directSend(Object message){
        rabbitTemplate.convertAndSend(ExchangeConfig.directExchange,"demo-direct-routingKey",message,new CorrelationData(UUID.randomUUID().toString()));
        return true;
    }

    public boolean fanoutSend(Object message){
        rabbitTemplate.convertAndSend(ExchangeConfig.fanoutExchange,"demo2-fanout-routingKey",message,new CorrelationData(UUID.randomUUID().toString()));
        return true;
    }
}


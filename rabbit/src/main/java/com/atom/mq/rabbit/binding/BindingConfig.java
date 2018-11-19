package com.atom.mq.rabbit.binding;

import com.atom.mq.rabbit.exchange.ExchangeConfig;
import com.atom.mq.rabbit.queue.QueueConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: mq-collection-demo
 * @description:
 * @author: Maxxx.Yg
 * @create: 2018-11-19 10:08
 **/
@Configuration
public class BindingConfig {

    @Autowired
    private QueueConfig queueConfig;


    @Autowired
    private ExchangeConfig exchangeConfig;

    @Bean
    public Binding demoBinding(){
        return BindingBuilder
                .bind(queueConfig.demoQueue())
                .to(exchangeConfig.directExchange())
                .with("demo-direct-routingKey")
                .noargs();
    }


    @Bean
    public Binding demo2Binding(){
        return BindingBuilder
                .bind(queueConfig.demo2Queue())
                .to(exchangeConfig.topicExchange())
                .with("demo2-topic-routingKey.*")
                .noargs();
    }


    @Bean
    public Binding demo3Binding(){
        return BindingBuilder
                .bind(queueConfig.demo2Queue())
                .to(exchangeConfig.fanoutExchange())
                .with("demo2-fanout-routingKey")
                .noargs();
    }
}

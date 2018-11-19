package com.atom.mq.rabbit.exchange;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: mq-collection-demo
 * @description:
 * @author: Maxxx.Yg
 * @create: 2018-11-19 10:03
 **/
@Configuration
public class ExchangeConfig {

    public final static String directExchange = "directExchange";

    public final static String topicExchange = "topicExchange";

    public final static String fanoutExchange = "fanoutExchange";


    @Bean
    public Exchange directExchange(){
        // 或者 new DirectExchange("xxx");
        return ExchangeBuilder.directExchange("directExchange").build();
    }


    @Bean
    public Exchange topicExchange(){
        // new TopicExchange("xxx");
        return ExchangeBuilder.topicExchange("topicExchange").build();
    }


    @Bean
    public Exchange fanoutExchange(){
        // new FanoutExchange("xxx");
        return ExchangeBuilder.fanoutExchange("fanoutExchange").build();
    }
}

package com.atom.mq.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @program: mq-collection-demo
 * @description:
 * @author: Maxxx.Yg
 * @create: 2018-11-19 15:47
 **/
@Component
public class KafkaConsumer {


    @KafkaListener(topics = {"app_log"})
    public void receive(String message){
        System.out.println("app_log--消费消息:" + message);
    }

}

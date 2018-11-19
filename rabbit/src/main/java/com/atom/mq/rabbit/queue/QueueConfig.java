package com.atom.mq.rabbit.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: mq-collection-demo
 * @description:
 * @author: Maxxx.Yg
 * @create: 2018-11-19 09:59
 **/
@Configuration
public class QueueConfig {

    /**
     * 队列名称demo，开启持久化：ture（默认开启持久化）
     * @return
     */
    @Bean
    public Queue demoQueue(){
        return new Queue("demo",true);
    }


    /**
     * 队列名称demo2，关闭持久化：false
     * @return
     */
    @Bean
    public Queue demo2Queue(){
        return new Queue("demo2",false);
    }

}

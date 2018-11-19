package com.atom.mq.rabbit;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: mq-collection-demo
 * @description:
 * @author: Maxxx.Yg
 * @create: 2018-11-19 09:55
 **/
@SpringBootApplication
@EnableRabbit
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

}

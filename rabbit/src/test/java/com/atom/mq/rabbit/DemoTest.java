package com.atom.mq.rabbit;

import com.atom.mq.rabbit.producer.DemoProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @program: mq-collection-demo
 * @description:
 * @author: Maxxx.Yg
 * @create: 2018-11-19 11:26
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DemoTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DemoProducer demoProducer;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test1(){
        DemoMessage demoMessage = new DemoMessage();
        demoMessage.setDate(new Date());
        demoMessage.setId(1);
        demoMessage.setName("测试样例");
        demoProducer.directSend(demoMessage);

        //Object o = applicationContext.getBean("demoListener");
        System.out.println("end");
    }




}

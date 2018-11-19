package com.atom.mq.rabbit.consumer;

import com.atom.mq.rabbit.DemoMessage;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Correlation;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;

/**
 * @program: mq-collection-demo
 * @description:
 * @author: Maxxx.Yg
 * @create: 2018-11-19 11:07
 **/
@Component
@Slf4j
public class DemoConsumer {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private MessageConverter messageConverter;

//    @Bean
//    public SimpleMessageListenerContainer listenerContainer() {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
//        container.setQueueNames("demo");
//        // 默认true
//        container.setExposeListenerChannel(true);
//        // 默认1
//        container.setConcurrentConsumers(1);
//        container.setMaxConcurrentConsumers(Runtime.getRuntime().availableProcessors());
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        container.setMessageListener(new ChannelAwareMessageListener() {
//            @Override
//            public void onMessage(Message message, Channel channel) throws Exception {
//                channel.basicQos(1);
//                Object object = messageConverter.fromMessage(message);
//                log.info("listenerContainer:{}",object.toString());
//
//                // 消费成功确认
//                //channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//
//                // 消费失败重新入队
//                channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
//            }
//        });
//        return container;
//    }


    @RabbitListener(
            queues = "demo",
            containerFactory = "rabbitListenerContainerFactory")
    public void demoListener(DemoMessage demoMessage,Message message,Channel channel) throws IOException {
        log.info("demoListener:{}",demoMessage.toString());
        // throw new RuntimeException("强制异常");

        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}

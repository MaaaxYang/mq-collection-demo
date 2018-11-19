package com.atom.mq.rabbit.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ErrorHandler;

import javax.annotation.PostConstruct;

/**
 * @program: mq-collection-demo
 * @description:
 * @author: Maxxx.Yg
 * @create: 2018-11-19 10:52
 **/
@Configuration
@Slf4j
public class BasicConfig {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public MessageConverter messageConverter(){
        return new SimpleMessageConverter();
    }

    /**
     * 设置确认回调
     */
    @PostConstruct
    public void init(){
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack){
                    log.info("消息：{} 发送成功",correlationData.getId());
                }else{
                    log.error("消息：{} 发送失败：{}",correlationData.getId(),cause);
                }
            }
        });

        rabbitTemplate.setMessageConverter(messageConverter());
    }

}




### 正确的RabbitMQ使用方法

##### 依赖
```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
```

##### 主要的几个注解：
- @EnableRabbit
- @RabbitListener

##### 配置文件
``` 
spring:
  rabbitmq:
    publisher-confirms: true
    addresses: rabbit.ops.com:8889
    username: tbbdev
    password: tbbdev
    virtual-host: /tbbdev
    listener:
      simple:
        acknowledge-mode: manual // auto 自动、manual手动
        max-concurrency: 8 // 最大8个线程
        concurrency: 1
        default-requeue-rejected: true // 开启拒绝从入队列
```


##### 准备
- Queue
- Exchange
- Binding


##### 发送消息
```
rabbitTemplate.convertAndSend()
```

##### 接收消息(手动确认方式)
``` 
    @RabbitListener(
            queues = "demo",
            containerFactory = "rabbitListenerContainerFactory")
    public void demoListener(DemoMessage demoMessage,Message message,Channel channel) throws IOException {
        log.info("demoListener:{}",demoMessage.toString());
        // throw new RuntimeException("强制异常");

        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
```

##### 接收消息（自动确认方式）
``` 
    @RabbitListener(
            queues = "demo",
            containerFactory = "rabbitListenerContainerFactory")
    public void demoListener(DemoMessage demoMessage) {
        log.info("demoListener:{}",demoMessage.toString());
        // throw new RuntimeException("强制异常");
    }
```
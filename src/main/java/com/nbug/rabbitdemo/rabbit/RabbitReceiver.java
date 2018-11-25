package com.nbug.rabbitdemo.rabbit;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * rabbit消息接收
 * @RabbitListener("myqueue")  表示监听队列myqueue
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        //如果没有该队列和exchange，则会自动创建
        //表示绑定了队列hello，和key,以及exchange
        value = @Queue("hello"),
        key = "mykey",
        exchange = @Exchange(name = "q1",type = "topic")
))
@Slf4j
public class RabbitReceiver {

    @RabbitHandler//表示如果接收到消息就去执行下面的方法
    public void get(@Payload String message, @Headers Map<String,Object> header, Channel channel) throws IOException {

        Long tag=(Long)header.get(AmqpHeaders.DELIVERY_TAG);
        log.info("message:{}",message);
        //表示接收到了消息，进行签收
        channel.basicAck(tag,false);
    }

}

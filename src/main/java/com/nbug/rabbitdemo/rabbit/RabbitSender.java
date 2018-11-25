package com.nbug.rabbitdemo.rabbit;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 发送消息，在test包下有测试发送
 */
@Component
@Slf4j
public class RabbitSender {
    @Autowired
   private RabbitTemplate rabbitTemplate;

   public void send(){
       log.info("开始发送消息======================");
       for (int i = 0; i < 100; i++) {
           Date date = new Date();
           rabbitTemplate.convertAndSend("hello",date.toString());
           log.info("发送消息第"+i+"条======================成功");

       }
       log.info("发送消息结束======================");
   }
}

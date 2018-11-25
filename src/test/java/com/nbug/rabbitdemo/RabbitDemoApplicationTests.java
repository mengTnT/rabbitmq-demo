package com.nbug.rabbitdemo;

import com.nbug.rabbitdemo.rabbit.RabbitSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitDemoApplicationTests {
    @Autowired
    RabbitSender rabbitSender;

    @Test
    public void contextLoads() {
        //发送消息
        rabbitSender.send();
    }

}

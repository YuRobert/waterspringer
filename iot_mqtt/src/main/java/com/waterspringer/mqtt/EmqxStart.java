package com.waterspringer.mqtt;


import com.waterspringer.mqtt.entity.EmqxClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *项目启动执行
 */
@Component
@Order(value = 1)   //执行顺序控制
public class EmqxStart implements ApplicationRunner {

    @Autowired
    private EmqxClient emqxClient;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception{
        emqxClient.connect();
    }
}

package com.waterspringer.iot_datareceive;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Robert17
 * @create2023-06-25-15:32
 */


@ComponentScan(basePackages = "com.waterspringer")
@MapperScan({"com.waterspringer.iot_datareceive.mapper","com.waterspringer.security.mapper"})
@SpringBootApplication
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class DataReceiveApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(DataReceiveApplication.class, args);
    }
}

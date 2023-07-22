package com.waterspringer.iot_datarecive.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.server.ServerEndpointConfig;

/**
 * 开启 WebSocket 支持
 * @author Siona
 * @date 2020/4/8 17:40
 **/
@Configuration
public class WebSocketConfig  extends ServerEndpointConfig.Configurator
{

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

//    @Override
//    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response)
//    {
//        HttpSession httpSession = (HttpSession) request.getHttpSession();
//        if (httpSession != null)
//        {
//            // 读取session域中存储的数据
//            sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
//        }
//        super.modifyHandshake(sec, request, response);
//    }



}


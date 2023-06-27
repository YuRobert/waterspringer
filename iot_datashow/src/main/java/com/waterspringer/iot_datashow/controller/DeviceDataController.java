package com.waterspringer.iot_datashow.controller;


import com.alibaba.fastjson.JSON;
import com.waterspringer.commonutils.R;
import com.waterspringer.iot_datashow.entity.DeviceData;
import com.waterspringer.iot_datashow.entity.DeviceNotice;
import com.waterspringer.iot_datashow.websocket.client.WebSocketServer;
import com.waterspringer.iot_datashow.websocket.entity.LoginUser;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Robert
 * @since 2023-06-25
 */
@RestController
@RequestMapping("/iot_datashow/device-data")
public class DeviceDataController {
//l7412948l5.imdo.co/iot_datashow/device-data/recivedata
    @PostMapping("/recivedata")
    public R reciveData(@RequestBody DeviceData deviceData)
    {
        LoginUser loginUser = new LoginUser("111","111");
        System.out.println(deviceData);
        try
        {
            WebSocketServer.sendInfo(JSON.toJSONString(deviceData),loginUser);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return R.ok();
        //clirntID:tainwei/chexing/uuid
        //tianwei/type/carsend

        //tianwei/type/seversend
    }
    @PostMapping("/recivenotice")
    public R reciveNotice(@RequestBody DeviceNotice deviceNotice)
    {
        LoginUser loginUser = new LoginUser("111","111");
        System.out.println(deviceNotice);
        try
        {
            WebSocketServer.sendInfo(JSON.toJSONString(deviceNotice),loginUser);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return R.ok();
    }
    @GetMapping("/hello")
    public R Hello()
    {
        return R.ok().message("HELLO");
    }

}

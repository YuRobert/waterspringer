package com.waterspringer.iot_datarecive.controller;


import com.alibaba.fastjson.JSON;
import com.waterspringer.commonutils.R;
import com.waterspringer.iot_datarecive.entity.DeviceData;
import com.waterspringer.iot_datarecive.entity.DeviceDetails;
import com.waterspringer.iot_datarecive.entity.DeviceNotice;
import com.waterspringer.iot_datarecive.service.DeviceDetailsService;
import com.waterspringer.iot_datarecive.websocket.client.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DeviceDetailsService deviceDetailsService;

//l7412948l5.imdo.co/iot_datashow/device-data/recivedata
    @PostMapping("/recivedata")
    public R reciveData(@RequestBody DeviceData deviceData)
    {
        System.out.println(deviceData);
        try
        {
            //TODO 可以改成redis去查询,写在业务层中
            DeviceDetails details = deviceDetailsService.getById(deviceData.getDeviceId());
            WebSocketServer.sendInfo(JSON.toJSONString(deviceData),details.getPurchaseCompany());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return R.ok();
    }
    @PostMapping("/recivenotice")
    public R reciveNotice(@RequestBody DeviceNotice deviceNotice)
    {
        System.out.println(deviceNotice);
        try
        {
            //TODO 可以改成redis去查询,写在业务层中
            DeviceDetails details = deviceDetailsService.getById(deviceNotice.getDeviceId());
            WebSocketServer.sendInfo(JSON.toJSONString(deviceNotice),details.getPurchaseCompany());
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

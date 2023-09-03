package com.waterspringer.iot_datareceive.controller;


import com.alibaba.fastjson.JSON;
import com.waterspringer.commonutils.ResponseResult;
import com.waterspringer.commonutils.map.BaiduMapGeocoderUtil;
import com.waterspringer.iot_datareceive.entity.DeviceHistoryData;
import com.waterspringer.iot_datareceive.entity.DeviceDetails;
import com.waterspringer.iot_datareceive.entity.DeviceNotice;
import com.waterspringer.iot_datareceive.service.DeviceDetailsService;
import com.waterspringer.iot_datareceive.service.DeviceHistoryDataService;
import com.waterspringer.iot_datareceive.websocket.client.WebSocketServer;
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
@RequestMapping("/iot_datareceive/device-data")
public class DeviceHistoryDataController
{

    @Autowired
    private DeviceDetailsService deviceDetailsService;

    @Autowired
    private DeviceHistoryDataService historyDataService;

//l7412948l5.imdo.co/iot_datashow/device-data/receivedata
    @PostMapping("/receivedata")
    public ResponseResult receiveData(@RequestBody DeviceHistoryData deviceHistoryData)
    {
        System.out.println("*********************");
        System.out.println(deviceHistoryData);
        System.out.println("*********************");
        //TODO 可以改成redis去查询,写在业务层中
        DeviceDetails details = deviceDetailsService.getByDeviceId(deviceHistoryData.getDeviceId());
        try
        {
            WebSocketServer.sendInfo(JSON.toJSONString(deviceHistoryData),details.getPurchaseCompany());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        deviceHistoryData.setDeviceType(details.getDeviceType());
        deviceHistoryData.setPosition(BaiduMapGeocoderUtil.getAddressInfoByLngAndLat(deviceHistoryData.getLongitude(), deviceHistoryData.getLatitude()));
        historyDataService.save(deviceHistoryData);
        return ResponseResult.ok();
    }

    @GetMapping("/hello")
    public ResponseResult Hello()
    {
        return ResponseResult.ok().message("HELLO");
    }

}

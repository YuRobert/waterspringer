package com.waterspringer.iot_datareceive.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waterspringer.commonutils.ResponseResult;
import com.waterspringer.iot_datareceive.entity.DeviceDetails;
import com.waterspringer.iot_datareceive.entity.DeviceEvent;
import com.waterspringer.iot_datareceive.entity.DeviceNotice;
import com.waterspringer.iot_datareceive.mapper.DeviceEventMapper;
import com.waterspringer.iot_datareceive.service.DeviceDetailsService;
import com.waterspringer.iot_datareceive.service.DeviceEventService;
import com.waterspringer.iot_datareceive.websocket.client.WebSocketServer;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Robert
 * @since 2023-07-31
 */
@RestController
@RequestMapping("/iot_datareceive/device-event")
public class DeviceEventController {


    @Autowired
    private DeviceEventMapper deviceEventMapper;
    @Autowired
    private DeviceDetailsService deviceDetailsService;

    @Autowired
    private DeviceEventService deviceEventService;
    @PostMapping("/receivenotice")
    public ResponseResult receiveNotice(@RequestBody DeviceEvent deviceEvent)
    {

        System.out.println(deviceEvent);
        DeviceEvent newDeviceEvent = new DeviceEvent();
        BeanUtils.copyProperties(deviceEvent, newDeviceEvent);
        try
        {
            //TODO 可以改成redis去查询,写在业务层中
            DeviceDetails details = deviceDetailsService.getByDeviceId(deviceEvent.getDeviceId());
            WebSocketServer.sendInfo(JSON.toJSONString(deviceEvent),details.getPurchaseCompany());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        deviceEventService.save(newDeviceEvent);
        return ResponseResult.ok();
    }
    @GetMapping("/getEventList/{deviceId}")
    public ResponseResult getEventList(@PathVariable String deviceId)
    {
        QueryWrapper<DeviceEvent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("device_id", deviceId);

        List<DeviceEvent> list = deviceEventService.list(queryWrapper);
        return ResponseResult.ok().data("deviceEventList",list);
    }

}


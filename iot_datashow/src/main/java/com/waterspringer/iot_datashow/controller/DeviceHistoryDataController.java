package com.waterspringer.iot_datashow.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waterspringer.commonutils.ResponseResult;
import com.waterspringer.iot_datashow.entity.DeviceHistoryData;
import com.waterspringer.iot_datashow.service.DeviceHistoryDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Robert
 * @since 2023-07-23
 */
@RestController
@RequestMapping("/iot_datashow/device-history-data")
public class DeviceHistoryDataController {

    @Autowired
    private DeviceHistoryDataService historyDataService;
    @GetMapping("/getHistoryData")
    public ResponseResult getHistoryData(@RequestParam(value = "deviceId") String deviceId,
                                         @RequestParam(value = "startTime",required = false) String startTime,
                                         @RequestParam(value = "endTime",required = false) String endTime)
    {
        QueryWrapper<DeviceHistoryData> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("upload_time");
        queryWrapper.eq("device_id", deviceId);
        queryWrapper.apply(StringUtils.isNotEmpty(startTime),
                        "date_format (upload_time,'%Y-%m-%d %H:%i:%s') >= date_format('" + startTime + "','%Y-%m-%d %H:%i:%s')")
                .apply(StringUtils.isNotEmpty(endTime),
                        "date_format (upload_time,'%Y-%m-%d %H:%i:%s') <= date_format('" + endTime + "','%Y-%m-%d %H:%i:%s')");

        List<DeviceHistoryData> deviceHistoryData = historyDataService.list(queryWrapper);
        return ResponseResult.ok().data("deviceHistoryDataList",deviceHistoryData);
    }

}


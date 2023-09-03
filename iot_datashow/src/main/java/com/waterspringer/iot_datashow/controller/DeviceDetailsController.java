package com.waterspringer.iot_datashow.controller;


import com.waterspringer.commonutils.ResponseResult;
import com.waterspringer.iot_datashow.entity.DeviceCurrentData;
import com.waterspringer.iot_datashow.entity.DeviceDetails;
import com.waterspringer.iot_datashow.entity.webvo.DeviceInfoWebVo;
import com.waterspringer.iot_datashow.mapper.DeviceDetailsMapper;
import com.waterspringer.iot_datashow.service.DeviceCurrentDataService;
import com.waterspringer.iot_datashow.service.DeviceDetailsService;
import com.waterspringer.security.utils.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Robert
 * @since 2023-07-22
 */
@RestController
@RequestMapping("/iot_datashow/device-details")
public class DeviceDetailsController {


    @Autowired
    private SecurityUtils securityUtils;

    @Autowired
    private DeviceDetailsMapper deviceDetailsMapper;

    @Autowired
    private DeviceDetailsService detailsService;

    @Autowired
    private DeviceCurrentDataService currentDataService;
    @GetMapping("/getDetails/{deviceId}")
    public ResponseResult getDeviceDetails(@PathVariable String deviceId)
    {
        DeviceInfoWebVo deviceInfoWebVo = deviceDetailsMapper.getInfoById(deviceId);

        return  ResponseResult.ok().data("deviceInfo",deviceInfoWebVo);
    }

    @PreAuthorize("hasAnyAuthority('sys:dev:add')")
    @PostMapping("/addDeviceDetails")
    public ResponseResult addDeviceDetails(@RequestBody DeviceDetails deviceDetails)
    {
        String companyName = securityUtils.getLoginUserInfo().getCompanyName();
        deviceDetails.setProduceCompany(companyName);
        try
        {
            detailsService.save(deviceDetails);
        }
        catch (Exception e)
        {
            return ResponseResult.error().message("设备已经存在");
        }
        DeviceCurrentData deviceCurrentData = new DeviceCurrentData();
        BeanUtils.copyProperties(deviceDetails,deviceCurrentData);
        deviceCurrentData.setCurrentStatus("2");
        currentDataService.save(deviceCurrentData);

        return  ResponseResult.ok();
    }

}


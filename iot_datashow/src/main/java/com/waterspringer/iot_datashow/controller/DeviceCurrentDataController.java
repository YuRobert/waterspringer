package com.waterspringer.iot_datashow.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waterspringer.commonutils.ResponseResult;
import com.waterspringer.iot_datashow.entity.DeviceCurrentData;
import com.waterspringer.iot_datashow.mapper.DeviceCurrentDataMapper;
import com.waterspringer.iot_datashow.service.DeviceCurrentDataService;
import com.waterspringer.security.entity.LoginUser;
import com.waterspringer.security.entity.User;
import com.waterspringer.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/iot_datashow/device-current-data")
public class DeviceCurrentDataController {
    @Autowired
    private DeviceCurrentDataService currentDataService;

    @Autowired
    private DeviceCurrentDataMapper currentDataMapper;

    @Autowired
    private SecurityUtils securityUtils;
    @GetMapping("/getAllCurrentData")
    public ResponseResult getAllCurrentDataList()
    {

        User user = securityUtils.getLoginUserInfo();
        List<DeviceCurrentData> deviceCurrentDataList = currentDataMapper.getAllCurrentDataByCompany(user.getCompanyName());
        return ResponseResult.ok().data("deviceCurrentDataList",deviceCurrentDataList);
    }


}


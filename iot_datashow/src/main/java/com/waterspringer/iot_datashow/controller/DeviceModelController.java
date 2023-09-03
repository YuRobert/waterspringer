package com.waterspringer.iot_datashow.controller;


import com.waterspringer.commonutils.ResponseResult;
import com.waterspringer.commonutils.oss.service.OssService;
import com.waterspringer.iot_datashow.entity.DeviceModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Robert
 * @since 2023-07-28
 */
@RestController
@RequestMapping("/iot_datashow/device-model")
public class DeviceModelController {

    private OssService ossService;

//    @PostMapping("/addDeviceModel")
//    public ResponseResult addDeviceModel(@RequestPart("file")MultipartFile file ,DeviceModel deviceModel)

}


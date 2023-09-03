package com.waterspringer.iot_datareceive.service;

import com.waterspringer.iot_datareceive.entity.DeviceDetails;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Robert
 * @since 2023-06-25
 */
public interface DeviceDetailsService extends IService<DeviceDetails> {

    DeviceDetails getByDeviceId(String deviceId);
}

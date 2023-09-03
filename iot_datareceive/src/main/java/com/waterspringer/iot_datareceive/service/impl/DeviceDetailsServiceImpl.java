package com.waterspringer.iot_datareceive.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waterspringer.iot_datareceive.entity.DeviceDetails;
import com.waterspringer.iot_datareceive.mapper.DeviceDetailsMapper;
import com.waterspringer.iot_datareceive.service.DeviceDetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Robert
 * @since 2023-06-25
 */
@Service
public class DeviceDetailsServiceImpl extends ServiceImpl<DeviceDetailsMapper, DeviceDetails> implements DeviceDetailsService {

    @Override
    public DeviceDetails getByDeviceId(String deviceId)
    {
        QueryWrapper<DeviceDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("device_id", deviceId);
        DeviceDetails deviceDetails = baseMapper.selectOne(queryWrapper);
        return deviceDetails;
    }
}

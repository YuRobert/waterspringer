package com.waterspringer.iot_datareceive.service.impl;

import com.waterspringer.iot_datareceive.entity.DeviceEvent;
import com.waterspringer.iot_datareceive.mapper.DeviceEventMapper;
import com.waterspringer.iot_datareceive.service.DeviceEventService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Robert
 * @since 2023-07-31
 */
@Service
public class DeviceEventServiceImpl extends ServiceImpl<DeviceEventMapper, DeviceEvent> implements DeviceEventService {

}

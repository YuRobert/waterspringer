package com.waterspringer.iot_datashow.mapper;

import com.waterspringer.iot_datashow.entity.DeviceDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.waterspringer.iot_datashow.entity.webvo.DeviceInfoWebVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Robert
 * @since 2023-07-22
 */
@Mapper
public interface DeviceDetailsMapper extends BaseMapper<DeviceDetails> {


    DeviceInfoWebVo getInfoById(String deviceId);
}

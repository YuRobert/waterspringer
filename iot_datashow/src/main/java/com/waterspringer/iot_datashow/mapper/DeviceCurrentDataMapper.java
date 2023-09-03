package com.waterspringer.iot_datashow.mapper;

import com.waterspringer.iot_datashow.entity.DeviceCurrentData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Robert
 * @since 2023-07-23
 */
@Mapper
public interface DeviceCurrentDataMapper extends BaseMapper<DeviceCurrentData> {

    List<DeviceCurrentData> getAllCurrentDataByCompany(String companyName);
}

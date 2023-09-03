package com.waterspringer.iot_datareceive.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Robert
 * @since 2023-07-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DeviceCurrentData对象", description="")
public class DeviceCurrentData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "device_id", type = IdType.ID_WORKER_STR)
    private String deviceId;

    private String deviceType;

    private String latitude;

    private String longitude;

    private String message1;

    private String message2;

    private String message3;

    private String message4;

    private String message5;

    private String message6;

    private String currentStatus;

    private Date updateTime;


}

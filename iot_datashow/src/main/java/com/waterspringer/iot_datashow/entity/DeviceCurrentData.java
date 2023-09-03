package com.waterspringer.iot_datashow.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2023-07-23
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

    @TableField("message1")
    private String lhStatus;

    @TableField("message2")
    private String ltStatus;

    @TableField("message3")
    private String rhStatus;

    @TableField("message4")
    private String rtStatus;

    private String message5;

    private String message6;

    private String currentStatus;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}

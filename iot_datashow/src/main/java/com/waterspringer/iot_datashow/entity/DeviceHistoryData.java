package com.waterspringer.iot_datashow.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@ApiModel(value="DeviceHistoryData对象", description="")
public class DeviceHistoryData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "device_id", type = IdType.ID_WORKER_STR)
    private String deviceId;

    private String deviceType;

    private String latitude;

    private String longitude;


    //    @JSONField(alternateNames = "lhStatus")
    @JsonProperty("lhStatus")
    private String message1;

    @JsonProperty("ltStatus")
    private String message2;

    @JsonProperty("rhStatus")
    private String message3;

    @JsonProperty("rtStatus")
    private String message4;

    private String message5;

    private String message6;

    private String position;

    @TableField(fill = FieldFill.INSERT)
    private Date uploadTime;

}

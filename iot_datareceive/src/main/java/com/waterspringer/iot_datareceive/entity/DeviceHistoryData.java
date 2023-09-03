package com.waterspringer.iot_datareceive.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Robert
 * @since 2023-06-25
 */
@JsonIgnoreProperties
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DeviceData对象", description="")
public class DeviceHistoryData implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonAlias("clientid")
    @TableId(value = "device_id", type = IdType.ID_WORKER_STR)
    private String deviceId;

    @JsonAlias("deviceName")
    private String deviceType;

    private String longitude;

    private String latitude;

//    payload.lfstatus as lfStatus,
//    payload.lbstatus as lrStatus,
//    payload.rfstatus as rfStatus,
//    payload.rbstatus as rbStatus,

    @JsonAlias("lhStatus")

    private String message1;

    @JsonAlias("ltStatus")
    @JSONField(alternateNames = "ltStatus")
    private String message2;


    @JsonAlias("rhStatus")
    @JSONField(alternateNames = "rhStatus")
    private String message3; //lhStatus


    @JsonAlias("rtStatus")
    @JSONField(alternateNames = "rtStatus")
    private String message4;

//    private String status;

    private String message5;

    private String message6;

    private String position;


    @TableField(fill = FieldFill.INSERT)
    private Date uploadTime;


}

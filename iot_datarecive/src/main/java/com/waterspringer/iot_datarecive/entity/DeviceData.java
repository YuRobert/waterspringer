package com.waterspringer.iot_datarecive.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
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
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DeviceData对象", description="")
public class DeviceData implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonAlias("clientid")
    @TableId(value = "device_id", type = IdType.ID_WORKER_STR)
    private String deviceId;

    @JsonAlias("message1")
    private String longitude;

    private String latitude;

//    payload.lfstatus as lfStatus,
//    payload.lbstatus as lrStatus,
//    payload.rfstatus as rfStatus,
//    payload.rbstatus as rbStatus,

    private String lhStatus;

    private String ltStatus;

    private String rhStatus;

    private String rtStatus;

    private String status;

    @JsonAlias("deviceName")
    private String deviceName;

    private String message5;

    private String message6;


}

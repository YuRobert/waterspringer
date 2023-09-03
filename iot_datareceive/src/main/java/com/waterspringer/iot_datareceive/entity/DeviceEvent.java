package com.waterspringer.iot_datareceive.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;

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
 * @since 2023-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DeviceEvent对象", description="")
public class DeviceEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonAlias("clientid")
    private String deviceId;

    @JsonAlias("event")
    private String deviceEvent;


    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}

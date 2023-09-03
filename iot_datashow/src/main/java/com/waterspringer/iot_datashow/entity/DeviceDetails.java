package com.waterspringer.iot_datashow.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @since 2023-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DeviceDetails对象", description="")
public class DeviceDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "device_id", type = IdType.ID_WORKER_STR)
    private String deviceId;

    private String deviceType;

    private String produceCompany;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date produceTime;

    private String purchaseCompany;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date purchaseTime;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}

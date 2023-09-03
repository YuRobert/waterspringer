package com.waterspringer.iot_datareceive.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
@ApiModel(value="DeviceDetails对象", description="")
public class DeviceDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonAlias("clientid")
    private String deviceId;

    private String deviceType;

    private String produceCompany;

    private String purchaseCompany;

    private Date createTime;

    private Date updateTime;


}

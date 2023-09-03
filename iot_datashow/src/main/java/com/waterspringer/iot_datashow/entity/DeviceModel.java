package com.waterspringer.iot_datashow.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
 * @since 2023-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DeviceModel对象", description="")
public class DeviceModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "model_id", type = IdType.ID_WORKER_STR)
    private String modelId;

    private String deviceType;

    private String deviceAvatar;

    private String message1;

    private String message2;

    private String message3;

    private String message4;

    private String message5;

    private String message6;

    private Date createTime;

    private String createdBy;

    private Date updateTime;

    private String updateBy;


}

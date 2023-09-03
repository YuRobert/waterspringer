package com.waterspringer.iot_datashow.entity;

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
 * @since 2023-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CompanyInformation对象", description="")
public class CompanyInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String companyId;

    private String companyName;

    private String companyTel;

    private Date createTime;

    private String createdBy;

    private Date updateTime;

    private String updateBy;

    private Long deleteFlag;


}

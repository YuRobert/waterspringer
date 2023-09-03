package com.waterspringer.iot_datashow.entity.webvo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author Robert17
 * @create2023-07-23-11:16
 */
@Data
public class DeviceInfoWebVo
{
    private String deviceId;

    private String deviceType;

    private String produceCompany;

    private Date produceTime;

    private String produceCompanyTel;

    private String purchaseCompany;

    private Date purchaseTime;

    private String purchaseCompanyTel;
}

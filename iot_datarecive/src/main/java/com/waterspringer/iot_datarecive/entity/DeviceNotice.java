package com.waterspringer.iot_datarecive.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * @author Robert17
 * @create2023-06-27-13:43
 */
@Data
public class DeviceNotice
{
    @JsonAlias("clientid")
    private String deviceId;

    @JsonAlias("event")
    private String event;
}

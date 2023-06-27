package com.waterspringer.iot_datashow.websocket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Robert17
 * @create2023-06-26-11:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser
{
    private String userId;

    private String companyId;
}

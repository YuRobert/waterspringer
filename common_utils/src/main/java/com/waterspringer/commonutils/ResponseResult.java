package com.waterspringer.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Robert17
 * @create2022-10-23-9:08
 */
@Data
public class ResponseResult
{
    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "返回码")
    private Integer code;
    @ApiModelProperty(value = "返回消息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();
    private ResponseResult(){}
    public static ResponseResult ok(){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setCode(ResultCode.SUCCESS);
        responseResult.setMessage("成功");
        return responseResult;
    }
    public static ResponseResult error(){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(false);
        responseResult.setCode(ResultCode.ERROR);
        responseResult.setMessage("失败");
        return responseResult;
    }
    public ResponseResult success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    public ResponseResult message(String message){
        this.setMessage(message);
        return this;
    }
    public ResponseResult code(Integer code){
        this.setCode(code);
        return this;
    }
    public ResponseResult data(String key, Object value){
        this.data.put(key, value);
        return this;
    }
    public ResponseResult data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}

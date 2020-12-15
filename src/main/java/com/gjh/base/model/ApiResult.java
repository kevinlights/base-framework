package com.gjh.base.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Result of API
 * @author guangjh
 * @version 1.0
 * @date 2020/12/15 21:51
 */
@ApiModel(description = "Result of API")
public class ApiResult<T> {
    @ApiModelProperty("status code")
    private Integer status;

    @ApiModelProperty("message, success or error message")
    private String message;

    @ApiModelProperty("data")
    private T data;

    public static <T> ApiResult ok(T data) {
        return new ApiResult<T>(200, "success", data);
    }

    public static <T> ApiResult error(Integer status, String message) {
        return new ApiResult(status, message, null);
    }

    public ApiResult(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

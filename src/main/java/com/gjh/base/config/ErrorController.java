package com.gjh.base.config;

import com.gjh.base.model.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author guangjh
 * @version 1.0
 * @date 2020/12/15 23:26
 */
@RestControllerAdvice
public class ErrorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResult exception(final Throwable throwable) {
        LOGGER.error("Exception during execution of Base Framework application", throwable);
        String errMsg = (throwable != null ? throwable.getMessage() : "Unknow error");
        return ApiResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), errMsg);
    }
}

package com.gjh.base.controller;

import com.gjh.base.model.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guangjh
 * @version 1.0
 * @date 2020/12/15 21:51
 */
@RestController
@RequestMapping("/")
public class BaseController {

    @GetMapping("/index")
    public ApiResult index() {
        return ApiResult.ok("Index");
    }
}

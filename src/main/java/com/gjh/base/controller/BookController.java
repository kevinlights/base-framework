package com.gjh.base.controller;

import com.gjh.base.model.ApiResult;
import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guangjh
 * @version 1.0
 * @date 2020/12/15 23:18
 */
@Api(tags = "App - Book API")
@RestController
@RequestMapping("/book")
public class BookController {

    @PreAuthorize("hasAuthority('BookList')")
    @GetMapping("/list")
    public ApiResult list() {
        return ApiResult.ok("book list");
    }

    @PreAuthorize("hasAuthority('BookAdd')")
    @GetMapping("/add")
    public ApiResult add() {
        return ApiResult.ok("book add successfully");
    }

    @PreAuthorize("hasAuthority('BookDetail')")
    @GetMapping("/detail")
    public ApiResult detail() {
        return ApiResult.ok("book detail");
    }

}

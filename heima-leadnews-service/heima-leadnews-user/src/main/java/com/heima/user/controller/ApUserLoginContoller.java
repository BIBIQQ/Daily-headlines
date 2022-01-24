package com.heima.user.controller;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.LoginDto;
import com.heima.user.service.ApUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author FF
 * @date 2022/1/23
 * @TIME:17:11
 */
@RestController
@RequestMapping("/api/v1/login")
@Api(value = "app端用户登录", tags = "ap_user", description = "app端用户登录API")
public class ApUserLoginContoller {

    @Autowired
    private ApUserService apUserService;

    /**
     * 用户登录
     * @param dto
     * @return
     */
    @PostMapping("/login_auth")
    @ApiOperation("用户登录")
    public ResponseResult login(@RequestBody LoginDto dto) {
        return apUserService.login(dto);

    }
}

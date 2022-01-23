package com.heima.user.controller;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.LoginDto;
import org.springframework.web.bind.annotation.*;

/**
 * @author FF
 * @date 2022/1/23
 * @TIME:17:11
 */
@RestController
@RequestMapping("/api/v1/login")
public class ApUserLoginContoller {

    @PostMapping("/login_auth")
    public ResponseResult login(@RequestBody LoginDto dto) {

        return null;
    }
}

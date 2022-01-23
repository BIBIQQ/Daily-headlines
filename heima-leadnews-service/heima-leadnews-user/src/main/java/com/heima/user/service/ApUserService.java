package com.heima.user.service;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.LoginDto;

/**
 * @author FF
 * @date 2022/1/23
 * @TIME:17:12
 */
public interface ApUserService {
    // 用户登录
    ResponseResult login(LoginDto dto);
}

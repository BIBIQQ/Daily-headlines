package com.heima.user.service.impl;

import com.alibaba.nacos.common.utils.StringUtils;
import com.heima.common.exception.CustomException;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.user.dtos.LoginDto;
import com.heima.model.user.pojos.ApUser;
import com.heima.user.mapper.ApUserMapper;
import com.heima.user.service.ApUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author FF
 * @date 2022/1/23
 * @TIME:17:12
 */
@Service
public class ApUserServiceImpl  implements ApUserService {

    @Autowired
    private ApUserMapper apUserMapper;

    /**
     * 用户登录
     * @param dto
     * @return
     */
    @Override
    public ResponseResult login(LoginDto dto) {
        // 非空判断
        if(StringUtils.isEmpty(dto.getPhone()) || StringUtils.isEmpty(dto.getPassword())  ){
            throw new CustomException(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        // 用户登录
        // 通过 手机号 搜索出用户信息
       ApUser apUser =  apUserMapper.getOneByPhone(dto.getPhone());
       // 非空判断
        if(apUser == null){
            // 用户没有用户信息  自动注册
        }
        //  判断密码




        // 游客登录

        return null;
    }
}

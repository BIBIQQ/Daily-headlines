package com.heima.user.service.impl;

import com.alibaba.nacos.common.utils.StringUtils;
import com.heima.common.exception.CustomException;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.user.dtos.LoginDto;
import com.heima.model.user.pojos.ApUser;
import com.heima.user.mapper.ApUserMapper;
import com.heima.user.service.ApUserService;

import com.heima.utils.common.AppJwtUtil;
import com.heima.utils.common.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author FF
 * @date 2022/1/23
 * @TIME:17:12
 */
@Service
public class ApUserServiceImpl implements ApUserService {

    @Autowired
    private ApUserMapper apUserMapper;

    /**
     * 用户登录
     *
     * @param dto
     * @return
     */
    @Override
    public ResponseResult login(LoginDto dto) {
        // 非空判断
        if (StringUtils.isEmpty(dto.getPhone()) && StringUtils.isEmpty(dto.getPassword())) {
            //游客  同样返回token  id = 0
            Map<String, Object> map = new HashMap<>();
            map.put("token", AppJwtUtil.getToken(0l));
            return ResponseResult.okResult(map);
        }
        // 校验码 手机号 正确性
        Matcher matcher = Pattern.compile("^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$")
                .matcher(dto.getPhone());
        if(!matcher.matches()){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        // 用户登录
        // 通过 手机号 搜索出用户信息
        ApUser apUser = apUserMapper.getOneByPhone(dto.getPhone());
        // 非空判断
        if (apUser == null) {
            //抛出 没有用户异常
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST, "用户不存在");
        }
        //  判断密码
        String md5 = MD5Utils.encodeWithSalt(apUser.getPassword(), apUser.getSalt());
        if (!dto.getPassword().equals(md5)) {
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        // 传递 JWT
        Map map = new HashMap<>();
        map.put("token", AppJwtUtil.getToken(apUser.getId().longValue()));
        apUser.setSalt("");
        apUser.setPassword("");
        map.put("user",apUser);
        return ResponseResult.okResult(map);
    }
}

package com.heima.user.mapper;

import com.heima.model.user.pojos.ApUser;
import org.apache.ibatis.annotations.Select;

/**
 * @author FF
 * @date 2022/1/23
 * @TIME:16:28
 */
public interface ApUserMapper {

    @Select("select * from ap_user where phone = #{phone}")
    ApUser getOneByPhone(String phone);
}

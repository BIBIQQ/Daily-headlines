package com.heima.user.mapper;

import com.heima.model.user.pojos.ApUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author FF
 * @date 2022/1/23
 * @TIME:16:28
 */
@Mapper
public interface ApUserMapper {


    ApUser getOneByPhone(String phone);
}

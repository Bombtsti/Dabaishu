package com.lian.xhs.mapper;

import com.lian.xhs.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author alex wong
 * @since 2024-03-11
 */
@Repository
public interface TUserMapper extends BaseMapper<TUser> {

    TUser selectUserById(String id);
    TUser selectUserByUsername(String username);
}

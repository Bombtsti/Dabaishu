package com.lian.xhs.mapper;

import com.lian.xhs.entity.TFollower;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lian.xhs.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zlw
 * @since 2024-03-17 04:43:48
 */
@Repository
public interface TFollowerMapper extends BaseMapper<TFollower> {

    TFollower getFollowerByUid(String userId, String followerId);

    boolean followById(String followerId);
}

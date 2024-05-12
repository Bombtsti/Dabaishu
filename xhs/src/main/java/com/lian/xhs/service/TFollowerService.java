package com.lian.xhs.service;

import com.lian.xhs.entity.TFollower;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zlw
 * @since 2024-03-17 04:43:48
 */
public interface TFollowerService extends IService<TFollower> {

    boolean isFollow(String id);

    boolean followById(String followerId);
}

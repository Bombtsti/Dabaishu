package com.lian.xhs.service;

import com.lian.xhs.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author alex wong
 * @since 2024-03-11
 */
public interface TUserService extends IService<TUser> {

    TUser selectUserById(String id);
}

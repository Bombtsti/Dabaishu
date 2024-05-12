package com.lian.xhs.service.impl;

import com.lian.xhs.entity.TUser;
import com.lian.xhs.entity.UserDetail;
import com.lian.xhs.mapper.TUserMapper;
import com.lian.xhs.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lian.xhs.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author alex wong
 * @since 2024-03-11
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService{

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public TUser selectUserById(String id) {
        return tUserMapper.selectUserById(id);
    }
}

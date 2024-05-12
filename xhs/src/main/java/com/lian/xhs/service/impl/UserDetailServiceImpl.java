package com.lian.xhs.service.impl;

import com.lian.xhs.entity.TUser;
import com.lian.xhs.entity.UserDetail;
import com.lian.xhs.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TUser tUser = tUserMapper.selectUserByUsername(username);
        if (Objects.isNull(tUser)){
            throw new UsernameNotFoundException("用户名为空");
        }
        return new UserDetail(tUser);
    }
}

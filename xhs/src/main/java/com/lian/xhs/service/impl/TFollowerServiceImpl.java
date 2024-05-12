package com.lian.xhs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lian.xhs.entity.TFollower;
import com.lian.xhs.entity.TUser;
import com.lian.xhs.mapper.TFollowerMapper;
import com.lian.xhs.service.TFollowerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lian.xhs.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zlw
 * @since 2024-03-17 04:43:48
 */
@Service
public class TFollowerServiceImpl extends ServiceImpl<TFollowerMapper, TFollower> implements TFollowerService {

    @Autowired
    private TFollowerMapper tFollowerMapper;

    @Autowired
    private TUserService tUserService;

    @Override
    public boolean isFollow(String followerId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = (String) authentication.getPrincipal();

        TFollower tFollower = tFollowerMapper.getFollowerByUid(userId,followerId);

        if (tFollower != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean followById(String followerId) {

        TFollower follower = new TFollower();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = (String) authentication.getPrincipal();

        follower.setUid(userId);
        follower.setFid(followerId);
        // 得到当前用户
        TUser currentUser = tUserService.getById(userId);
        TUser followerUser = tUserService.getById(followerId);
        if (isFollow(followerId)) {
            currentUser.setFollowerCount(currentUser.getFollowerCount() - 1);
            followerUser.setFanCount(followerUser.getFanCount() - 1);
            this.remove(new QueryWrapper<TFollower>().eq("uid", userId).eq("fid", followerId));
        } else {
            currentUser.setFollowerCount(currentUser.getFollowerCount() + 1);
            followerUser.setFanCount(followerUser.getFanCount() + 1);
            this.save(follower);
        }
        boolean b = tUserService.updateById(currentUser);
        boolean b1 = tUserService.updateById(followerUser);
        if (b && b1){
            return true;
        }
        return false;
    }
}

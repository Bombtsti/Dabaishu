package com.lian.xhs.controller;

import com.lian.xhs.result.Result;
import com.lian.xhs.service.TFollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zlw
 * @since 2024-03-17 04:43:48
 */
@RestController
@RequestMapping("/api/follower")
public class TFollowerController {

    @Autowired
    private TFollowerService tFollowerService;


    @GetMapping("followById")
    public Result<?> followById(String followerId){
        boolean b = tFollowerService.followById(followerId);
        return Result.ok(b);
    }

    @GetMapping("isFollow")
    public Result<?> isFollow(String followerId){
        boolean b = tFollowerService.isFollow(followerId);
        return Result.ok(b);
    }
}

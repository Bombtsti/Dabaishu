package com.lian.xhs.controller;


import com.lian.xhs.entity.TUser;
import com.lian.xhs.mapper.TUserMapper;
import com.lian.xhs.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author alex wong
 * @since 2024-03-11
 */
@RestController
@RequestMapping("/t-user")
public class TUserController {

    @Autowired
    private TUserMapper tUserMapper;

    @RequestMapping("getUserById")
    public Result<?> getTUserById(String id){
        TUser tUser = tUserMapper.selectUserById(id);
        return Result.ok(tUser);
    }
}


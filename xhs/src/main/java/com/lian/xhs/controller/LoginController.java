package com.lian.xhs.controller;

import com.lian.xhs.entity.TUser;

import com.lian.xhs.entity.UserDetail;
import com.lian.xhs.result.Result;
import com.lian.xhs.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("api/login")
    public Result<?> login(@RequestBody TUser tUser){
        Authentication token = new UsernamePasswordAuthenticationToken(tUser.getUsername(), tUser.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("登陆失败");
        }

        UserDetail principal = (UserDetail) authenticate.getPrincipal();
//        String id = principal.getTUser().getId();
        String jwt = JwtUtils.getJwtToken(principal,1000 * 60 * 60 * 24);
        Map<String,Object> map = new HashMap<>();
        map.put("token",jwt);
        map.put("userInfo", principal.getTUser());

//        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return Result.ok(map);
    }

}

package com.kkk.controller;

import com.kkk.prooerties.JwtProperties;
import com.kkk.utils.JwtUtil;
import com.kkk.utils.Result;
import com.kkk.domain.dto.UserDto;
import com.kkk.domain.entity.User;
import com.kkk.domain.vo.UserLoginVo;
import com.kkk.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/5/29 16:04
 * @Version V1.0
 */
@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        user = userService.login(user);
        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);

        UserLoginVo userLoginVo = UserLoginVo.builder()
                .user(user)
                .token(token)
                .build();
        return Result.okResult(userLoginVo);
    }

    @ApiOperation("注册用户")
    @PostMapping
    public Result addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return Result.okResult();
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public Result uploadAvatar(User user) {
        userService.uploadAvatar(user);
        return Result.okResult();
    }

    @GetMapping("/test")
    public Result test() {
        return Result.okResult("test");
    }

   /* @GetMapping("/page")
    public Result pageUser(){
        userService.page();
        return null;
    }*/
}

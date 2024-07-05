package com.kkk.controller;

import com.kkk.common.exception.SystemException;
import com.kkk.common.utils.AppHttpCodeEnum;
import com.kkk.common.utils.Result;
import com.kkk.domain.dto.UserDto;
import com.kkk.domain.entity.User;
import com.kkk.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/5/29 16:04
 * @Version V1.0
 */
@Api(tags = "用户登录相关接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        if (!StringUtils.hasText(user.getUsername())) {
            //提示必须要输入用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        User login = userService.login(user);
        return Result.okResult(login);
    }

    @ApiOperation("注册用户")
    @PostMapping
    public Result addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return Result.okResult();
    }

    @GetMapping("/test")
    public Result test() {
        return Result.okResult("test");
    }
}

package com.kkk.service.impl;

import com.kkk.common.exception.SystemException;
import com.kkk.common.exception.base.BaseKnownException;
import com.kkk.common.utils.AppHttpCodeEnum;
import com.kkk.common.utils.BeanCopyUtils;
import com.kkk.common.utils.JwtUtil;
import com.kkk.common.utils.RedisCache;
import com.kkk.domain.dto.UserDto;
import com.kkk.domain.entity.LoginUser;
import com.kkk.domain.entity.User;
import com.kkk.domain.vo.BlogUserLoginVo;
import com.kkk.domain.vo.UserInfoVo;
import com.kkk.mapper.UserMapper;
import com.kkk.service.FileUploadService;
import com.kkk.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/5/29 16:38
 * @Version V1.0
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FileUploadService fileUploadService;


    /**
     * 新增用户
     * @param userDto
     */
    public void addUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        //user.setEmail("123@qq.com");
        user.setCreateTime(new Date());
        user.setLoginTime(new Date());
        userMapper.insert(user);
    }


    public BlogUserLoginVo login(User user) {
        /*UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (ObjectUtils.isEmpty(authenticate)) {
            throw new SystemException(504,"用户名或密码错误");
        }
        final LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        final String userId = loginUser.getUser().getId().toString();
        final String jwt = JwtUtil.createJWT(userId);
        //把用户信息存入redis
        redisCache.setCacheObject("bloglogin:"+userId,loginUser);
        //把token和userinfo封装 返回
        //把User转换成UserInfoVo
        BlogUserLoginVo vo = new BlogUserLoginVo(jwt,user);
        return vo;*/
        if(user.getUsername()==null||user.getUsername().equals(""))
            throw new BaseKnownException("用户名密码不能为空。");
        User userInfo = userMapper.getUserByName(user.getUsername(),user.getPassword());
        if (ObjectUtils.isEmpty(userInfo)) {
            //throw new BaseKnownException("用户名密码不能为空");
            throw new SystemException(AppHttpCodeEnum.LOGIN_ERROR);
        }
        final String jwt = JwtUtil.createJWT(userInfo.getId().toString());
        userInfo.setLoginTime(new Date());
        return new BlogUserLoginVo(jwt, user);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Override
    public void uploadAvatar(User user) {
        userMapper.updateById(user);
    }
}

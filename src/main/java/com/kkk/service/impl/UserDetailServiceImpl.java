package com.kkk.service.impl;

import com.aliyuncs.ram.model.v20150501.GetUserResponse;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kkk.domain.entity.LoginUser;
import com.kkk.domain.entity.User;
import com.kkk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 创建security中的UserDetailsService的实现类
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/5/13 22:07
 * @Version V1.0
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userDao;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        final LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        qw.eq(User::getUsername, name);
        User user = userDao.selectOne(qw);
        if (Objects.isNull(user)) {
            //如果用户名为空
            throw new RuntimeException("用户不存在");
        }

        return new LoginUser(user,null);
    }
}

package com.kkk.service.impl;

import com.kkk.common.exception.SystemException;
import com.kkk.common.utils.AppHttpCodeEnum;
import com.kkk.domain.entity.User;
import com.kkk.mapper.UserMapper;
import com.kkk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/5/29 16:38
 * @Version V1.0
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User login(User user) {
        User userInfo = userMapper.getUserByName(user.getUsername(),user.getPassword());
        if (ObjectUtils.isEmpty(userInfo)) {
            throw new SystemException(AppHttpCodeEnum.LOGIN_ERROR);
        }
        return userInfo;
    }
}

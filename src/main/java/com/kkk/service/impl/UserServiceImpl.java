package com.kkk.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kkk.domain.dto.PageUserDto;
import com.kkk.exception.base.BaseKnownException;
import com.kkk.domain.dto.UserDto;
import com.kkk.domain.entity.User;
import com.kkk.mapper.UserMapper;
import com.kkk.service.UserService;
import com.kkk.utils.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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


    public User login(User user) {
        String password = user.getPassword();
        final User user1 = userMapper.getUserByName(user.getUsername());
        if (user1 == null) {
            throw new BaseKnownException("该用户名不存在");
        }
        //对密码进行md5加密
        //password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(user1.getPassword())){
            throw new BaseKnownException("密码错误");
        }
        return user1;
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

    @Override
    public PageResult page(PageUserDto pageUserDto) {
        PageHelper.startPage(pageUserDto.getPage(), pageUserDto.getPageSize());
        Page<User> page = userMapper.getPage(pageUserDto);
        final long total = page.getTotal();
        final List<User> result = page.getResult();
        return new PageResult(total, result);
    }
}

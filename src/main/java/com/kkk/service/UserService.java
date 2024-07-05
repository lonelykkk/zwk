package com.kkk.service;

import com.kkk.domain.dto.UserDto;
import com.kkk.domain.entity.User;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/5/29 16:38
 * @Version V1.0
 */
public interface UserService {
    void addUser(UserDto userDto);

    User login(User user);
}

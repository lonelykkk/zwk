package com.kkk.service;

import com.kkk.domain.dto.UserDto;
import com.kkk.domain.entity.User;
import com.kkk.domain.vo.BlogUserLoginVo;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/5/29 16:38
 * @Version V1.0
 */
public interface UserService {
    void addUser(UserDto userDto);

    BlogUserLoginVo login(User user);

    void uploadAvatar(User user);
}

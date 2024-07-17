package com.kkk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.kkk.domain.dto.PageUserDto;
import com.kkk.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/5/29 16:39
 * @Version V1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{


    void addUser(User user);

    @Select("select * from user where username = #{username}")
    User getUserByName(String username);

    Page<User> getPage(PageUserDto pageUserDto);
}

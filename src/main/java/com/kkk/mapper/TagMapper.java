package com.kkk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkk.domain.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 18/7/2024 上午 10:22
 * @Version V1.0
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {
    String getNameById(Long id);
}

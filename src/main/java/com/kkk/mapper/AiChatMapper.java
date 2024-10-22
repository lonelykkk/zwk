package com.kkk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkk.domain.entity.AiChat;
import com.kkk.domain.vo.AiChatVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/9/26 10:15
 * @Version V1.0
 */
@Mapper
public interface AiChatMapper extends BaseMapper<AiChat> {
    List<AiChatVo> getChatList(Long userId);

    List<AiChatVo> getByChatList(Long listId);
}

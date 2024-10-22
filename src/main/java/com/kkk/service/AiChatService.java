package com.kkk.service;

import com.kkk.domain.vo.AiChatVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/9/23 9:14
 * @Version V1.0
 */
public interface AiChatService {
    void chat(HttpServletResponse response, String msg);

    List<AiChatVo> getChatList();

    List<AiChatVo> getByChatList(Long listId);
}

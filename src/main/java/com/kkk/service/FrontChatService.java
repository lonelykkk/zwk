package com.kkk.service;

import com.kkk.utils.Result;
import com.kkk.domain.dto.ChatAskDTO;
import com.kkk.domain.vo.ChatInfo;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/7/5 9:15
 * @Version V1.0
 */
public interface FrontChatService {

    Result<ChatInfo> sendAsk(ChatAskDTO chatAskDTO);
}

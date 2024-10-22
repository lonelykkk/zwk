package com.kkk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kkk.domain.entity.ChatList;

/**
* @author 喻凯
* @description 针对表【chat_list(chat对话列表)】的数据库操作Service
* @createDate 2024-10-22 10:50:11
*/
public interface ChatListService extends IService<ChatList> {

    void newChatList(String title);
}

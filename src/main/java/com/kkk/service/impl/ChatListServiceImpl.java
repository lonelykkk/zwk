package com.kkk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kkk.context.BaseContext;
import com.kkk.domain.entity.ChatList;
import com.kkk.service.ChatListService;
import com.kkk.mapper.ChatListMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author 喻凯
* @description 针对表【chat_list(chat对话列表)】的数据库操作Service实现
* @createDate 2024-10-22 10:50:11
*/
@Service
public class ChatListServiceImpl extends ServiceImpl<ChatListMapper, ChatList>
    implements ChatListService {

    @Resource
    private ChatListMapper chatListMapper;
    @Override
    public void newChatList(String title) {
        if (title == null) {
            title = "无标题";
        }
        ChatList chatList = new ChatList();
        chatList.setTitle(title);
        chatList.setCreate_time(new Date());
        chatList.setTotal(0);
        chatList.setUpdate_time(new Date());
        chatList.setUserId(BaseContext.getUserId());
        chatListMapper.insert(chatList);
    }
}





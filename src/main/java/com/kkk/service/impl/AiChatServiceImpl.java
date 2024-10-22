package com.kkk.service.impl;

import cn.yam.sychatsdk.SyClient;
import cn.yam.sychatsdk.config.SyChatProperties;
import com.kkk.context.BaseContext;
import com.kkk.domain.entity.AiChat;
import com.kkk.domain.entity.ChatList;
import com.kkk.domain.vo.AiChatVo;
import com.kkk.exception.SystemException;
import com.kkk.mapper.AiChatMapper;
import com.kkk.mapper.ChatListMapper;
import com.kkk.service.AiChatService;
import com.kkk.utils.AppHttpCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/9/23 9:14
 * @Version V1.0
 */
@Service
@Slf4j
public class AiChatServiceImpl implements AiChatService {
    @Resource
    private SyChatProperties syChatProperties;
    @Resource
    private AiChatMapper aiChatMapper;
    @Resource
    private ChatListMapper chatListMapper;
    /**
     * AI对话
     * @param response
     * @param msg
     */
    @Override
    public void chat(HttpServletResponse response, String msg) {
        Long listId = 1L;
        SyClient client = new SyClient(syChatProperties);
        try {
            AiChat aiChat = new AiChat();
            String answer = client.chat(msg);

            //将问答插入数据库
            aiChat.setQuestion(msg);
            aiChat.setAnswer(answer);
            aiChat.setUserId(BaseContext.getUserId());
            aiChat.setCreateTime(new Date());
            aiChat.setListId(listId);
            aiChatMapper.insert(aiChat);

            System.out.println(response);
            log.info("请求响应为：{}", response);
            log.info("回答：{}", answer);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write(answer);
        } catch (Exception e) {
            throw new RuntimeException("GPT接口异常：" + e);
        }

    }

    @Override
    public List<AiChatVo> getChatList() {
        List<AiChatVo> chatVoList = aiChatMapper.getChatList(BaseContext.getUserId());
        if (chatVoList == null) {
            throw new SystemException(AppHttpCodeEnum.GET_AI_CHAT);
        }
        return chatVoList;
    }

    @Override
    public List<AiChatVo> getByChatList(Long listId) {
        ChatList chatList = chatListMapper.selectById(listId);
        //获取当前对话列表的用户id并校验
        Long userId = chatList.getUserId();
        if (!Objects.equals(userId, BaseContext.getUserId())) {
            throw new SystemException();
        }
        List<AiChatVo> chatVoList = aiChatMapper.getByChatList(listId);
        return chatVoList;
    }
}

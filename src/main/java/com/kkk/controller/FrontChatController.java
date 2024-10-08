package com.kkk.controller;

import com.kkk.utils.Result;
import com.kkk.domain.dto.ChatAskDTO;
import com.kkk.domain.vo.ChatInfo;
import com.kkk.service.FrontChatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "chatGpt相关接口")
@RequestMapping("/front-chat")
public class FrontChatController {


    @Autowired
    private FrontChatService chatService;


    /**
     * @param chatAskDTO
     * @return
     * @des: 发起提问
     */
    @ApiOperation("ChatGpt对话接口")
    @PostMapping("send-ask")
    //@RequiresAuthentication
    public Result<ChatInfo> sendAsk(@RequestBody ChatAskDTO chatAskDTO) {
        return chatService.sendAsk(chatAskDTO);
    }
    // todo 导出对话

}
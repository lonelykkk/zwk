package com.kkk.controller;

import com.kkk.domain.vo.AiChatVo;
import com.kkk.service.AiChatService;
import com.kkk.service.ChatListService;
import com.kkk.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: kkk
 */
@Api(tags = "gpt相关接口")
@RestController
@RequestMapping("/sdk")
@Slf4j
public class ChatController {

   @Resource
   private AiChatService aiChatService;
   @Resource
   private ChatListService chatListService;

   @ApiOperation("gpt对话接口")
   @GetMapping("/chat")
   public void chat(HttpServletResponse response, String msg) {
      aiChatService.chat(response, msg);
   }

   @ApiOperation("根据当前对话列表id查询对话")
   @GetMapping("/list/{listId}")
   public Result<List<AiChatVo>> getByChatList(@PathVariable("listId") Long listId) {
      List<AiChatVo> chatVoList = aiChatService.getByChatList(listId);
      return Result.okResult(chatVoList);
   }

   @ApiOperation("查询当前用户的ai对话")
   @GetMapping("/list")
   public Result<List<AiChatVo>> getChatList() {
      List<AiChatVo> chatVoList = aiChatService.getChatList();
      return Result.okResult(chatVoList);
   }

   @PostMapping("/newChatList")
   public Result newChatList(String title) {
      chatListService.newChatList(title);
      return Result.okResult();
   }

}
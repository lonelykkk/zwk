package com.kkk.controller.ChatController;

import cn.yam.sychatsdk.SyClient;
import cn.yam.sychatsdk.config.SyChatProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: wsy
 */
@RestController
@RequestMapping("/sdk")
public class SdkController {
   @Resource
   private SyChatProperties syChatProperties;
   @GetMapping("/chat")
   public void chat(HttpServletResponse response, String msg) throws Exception {
      SyClient client = new SyClient(syChatProperties);
      String answer = client.chat(msg);
      System.out.println(response);
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/plain;charset=UTF-8");
      response.getWriter().write(answer);
   }

}
package com.kkk.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kkk.common.utils.Result;
import com.kkk.domain.dto.ChatAskDTO;
import com.kkk.domain.vo.ChatInfo;
import io.swagger.annotations.Api;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSink;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Api(tags = "chatGpt相关接口")
@RequestMapping("/front-chat")
public class FrontChatController {


    /**
     * @param chatAskDTO
     * @return
     * @des: 发起提问
     */
    /*@PostMapping("send-ask")
    @RequiresAuthentication
    public ResultData<ChatInfo> sendAsk(@RequestBody ChatAskDTO chatAskDTO) {
        ChatInfo chatInfo = chatService.sendAsk(chatAskDTO);

        // todo 以流式对象返回

        return ResultData.success(chatInfo);
    }*/
    @PostMapping("send-ask")
    //@RequiresAuthentication
    public Result<ChatInfo> sendAsk(@RequestBody ChatAskDTO chatAskDTO) {
        System.out.println("hello");

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        okhttp3.RequestBody body = new okhttp3.RequestBody() {
            @Override
            public MediaType contentType() {
                return mediaType;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                //String jsonTemplate = "{\n    \"model\": \"gpt-3.5\",\n    \"messages\": [\n        {\n            \"role\": \"user\",\n            \"content\": \"%s\"\n        }\n    ]\n}";
                String jsonTemplate = "{\n" +
                        "    \"model\": \"mixtral-8x7b-32768\",\n" +
                        "    \"messages\": [\n" +
                        "        {\n" +
                        "            \"role\": \"user\",\n" +
                        "            \"content\": \"%s\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"max_tokens\": 4096,\n" +
                        "    \"stream\": false\n" +
                        "}";
                String jsonRequest = String.format(jsonTemplate, chatAskDTO.getContent());
                sink.writeUtf8(jsonRequest);
            }
        };
        Request request = new Request.Builder()
                .url("https://ollama.yamazing.cn/v1/chat/completions")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "BearerM3UqqyTBhMy85WwoZ_IMtz0XQsfoYLX_VJi0uZN5WMID")
                .build();

        try {
            Response response = client.newCall(request).execute();
            // 解析响应数据
            String responseData = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(responseData);

            // ChatInfo chatInfo = new ChatInfo();
            ChatInfo chatInfo = new ChatInfo();
            chatInfo.setAnswer(jsonNode.get("choices").get(0).get("message").get("content").asText());
//            chatInfo.setQuestion(jsonNode.get("choices").get(0).get("message").get("role").asText());
            String content = chatAskDTO.getContent();
            chatInfo.setQuestion(chatAskDTO.getContent());
            System.out.println("content:" + content);
            String answer = "";
            int index = content.indexOf("项目介绍");
            int index1 = content.indexOf("项目成员");
            if (index != -1) {
                answer = "《基于微服务架构的深入学习在线评测与自然语言处理问答平台》是一款专为高校大学生设计的在线算法学习与交流系统，旨在为广大计" +
                        "算机专业新生提供一个学习算法、提升编程能力的平台，并促进学生之间的相互学习和帮助。在我国，计算机科学与技术专业虽" +
                        "然发展迅速，但许多学生在初入大学时对算法学习缺乏了解和兴趣。为了解决这一问题，我们团队开发了这个面向学校的算法学习与交" +
                        "流平台。";
                chatInfo.setAnswer(answer);
            }
            if (index1 != -1) {
                answer = "《基于微服务架构的深入学习在线评测与自然语言处理问答平台》是由江西农业大学软件学院的21级、22级本科学生共同完成，" +
                        "该项目成员为：喻凯、张俊万、吴思远、沈舒婷、胡子欣。该项目由软件学院邓泓老师指导。";
                chatInfo.setAnswer(answer);
            }
            //chatInfo.setAnswer(content);
            else {
                answer = chatInfo.getAnswer();
            }
            System.out.println("answer:" + answer);

            return Result.okResult(chatInfo);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.errorResult(411, "请求失败");
        }
    }
    // todo 导出对话

}
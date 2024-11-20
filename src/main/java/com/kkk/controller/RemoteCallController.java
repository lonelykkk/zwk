package com.kkk.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kkk.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/10/26 17:28
 * @Version V1.0
 */
@RestController
@Slf4j
@RequestMapping("/remote")
public class RemoteCallController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 英汉互译
     * @param msg
     * @param type
     * @return
     */
    @GetMapping("/translation")
    public Result<String> remoteDemo(String msg, String type) {
        if (type.isEmpty()) {
            type = "json";
        }

        try {
            String baseUrl = "https://api.lolimi.cn/API/qqfy/api.php";
            String url = baseUrl + "?msg=" + msg + "&type=" + type;
            String response = restTemplate.getForObject(url, String.class);
            System.out.println(response);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode textNode = rootNode.path("text");
            String text = textNode.asText();
            return Result.okResult(text);
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}

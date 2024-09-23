package com.kkk;

import cn.yam.sychatsdk.config.SyChatProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date ${DATE} ${TIME}
 * @Version V1.0
 */

@SpringBootApplication
@EnableConfigurationProperties(SyChatProperties.class)// 扫描读取yaml配置
public class Main {
    // hello world
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
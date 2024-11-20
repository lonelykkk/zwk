package com.kkk;

import com.kkk.client.RemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/11/20 8:20
 * @Version V1.0
 */
@SpringBootTest
public class Test {

    @Autowired
    private RemoteClient remoteClient;

    @org.junit.jupiter.api.Test
    public void test01() {
        String chat = remoteClient.getAiChat("帮我用java写一个快速排序代码");
        System.out.println(chat);
    }

    @org.junit.jupiter.api.Test
    public void test02() {
        String smtp = remoteClient.sendSmtp("test@qq.com");
        System.out.println(smtp);
    }
}

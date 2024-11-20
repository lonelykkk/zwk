package com.kkk.chatgpt;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/9/22 21:53
 * @Version V1.0
 */
import com.kkk.client.RemoteClient;
import okhttp3.*;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;

public class OpenAIChat {

/*    public static void main(String[] args) throws IOException, JSONException {
        String url = "https://api.openai-hk.com/v1/chat/completions";

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");

        String json = "{\n" +
                "  \"max_tokens\": 1200,\n" +
                "  \"model\": \"gpt-3.5-turbo\",\n" +
                "  \"temperature\": 0.8,\n" +
                "  \"top_p\": 1,\n" +
                "  \"presence_penalty\": 1,\n" +
                "  \"messages\": [\n" +
                "    {\n" +
                "      \"role\": \"system\",\n" +
                "      \"content\": \"You are ChatGPT, a large language model trained by OpenAI. Answer as concisely as possible.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"role\": \"user\",\n" +
                "      \"content\": \"使用java帮我写一个快速排序\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "hk-l0ik8q100004543128fa47fb2113ad7a48be4de270945998")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        String result = response.body().string();

        JSONObject jsonObject = new JSONObject(result);
        // 获取choices数组中的第一个元素
        JSONObject firstChoice = jsonObject.getJSONArray("choices").getJSONObject(0);

        // 从第一个元素中获取message对象
        JSONObject messageObject = firstChoice.getJSONObject("message");

        // 从message对象中获取content字段
        String content = messageObject.getString("content");

        // 输出获取到的content内容
        System.out.println(content);

        //System.out.println(result);
    }*/

   /* public static void main(String[] args) {
        RemoteClient remoteClient = new RemoteClient();
        String translation = remoteClient.getTranslation("输入你需要翻译的内容，中英文均可");
        System.out.println(translation);  //输出翻译后的结果
    }*/

}
package com.bowchan.listenner;
import okhttp3.*;

import java.io.IOException;

public class DiscordWebhook {
    // Discord 頻道的 Webhook URL
    private static final String WEBHOOK_URL1 = "https://discord.com/api/webhooks/1093531716557226025/r-gPA5rlRJP0IDVfLUsS5_mfxf4HktwmO2-p5gqWEo6VkBFH1xgXc7ZDJCSEOUNWtaCR";
    private static final String WEBHOOK_URL ="https://discord.com/api/webhooks/1093580421691879525/dqKVwsiHD7rOGD3w8q__-jjCii85dz3hS6hmpd2MO_uiikVZ7lSDF-xgHfvGjMTe9wrR";
    public DiscordWebhook() throws IOException {
        // 建立 OkHttpClient 用於 HTTP 請求
        OkHttpClient client = new OkHttpClient();

        // 建立 JSON 格式的訊息內容
        String messageContent = "{\"content\":\" 我想釣\t***~~SSX景淳助教~~***\t＞Ａ＜\"}";

        // 建立 RequestBody
        RequestBody requestBody = RequestBody.create(messageContent, MediaType.parse("application/json"));

        // 建立 POST 請求
        Request request = new Request.Builder()
                .url(WEBHOOK_URL)
                .post(requestBody)
                .build();

        // 發送 POST 請求
        Response response = client.newCall(request).execute();

        // 檢查回應狀態碼是否為 204 No Content
        if (response.code() != 204) {
            System.out.println("Failed to send message: " + response.body().string());
        } else {
            System.out.println("Message sent successfully!");
        }

        // 釋放資源
        response.close();
    }
}

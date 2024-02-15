package org.launchcode.givewise.service;

import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailjetService {

    @Value("${mailjet.api-key}")
    private String apiKey;

    @Value("${mailjet.api-secret}")
    private String apiSecret;

    public void sendEmail(String to, String subject, String text) {
        try {
            MailjetClient client = new MailjetClient(apiKey, apiSecret);

            MailjetRequest request = new MailjetRequest(Emailv31.resource)
                    .property(Emailv31.MESSAGES, new JSONArray()
                            .put(new JSONObject()
                                    .put("From", new JSONObject()
                                            .put("Email", "givewise92@gmail.com"))
                                    .put("To", new JSONArray()
                                            .put(new JSONObject()
                                                    .put("Email", to)))
                                    .put("Subject", subject)
                                    .put("TextPart", text)));

            MailjetResponse response = client.post(request);
            System.out.println(response.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
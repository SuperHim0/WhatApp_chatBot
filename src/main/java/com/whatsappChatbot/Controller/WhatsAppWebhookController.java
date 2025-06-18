package com.whatsappChatbot.Controller;

import com.whatsappChatbot.Services.SendWhatsAppReplyService;
import com.whatsappChatbot.dto.ChatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class WhatsAppWebhookController {

    @Value("${WHATSAPP_ACCESS_TOKEN}")
    private String VERIFY_TOKEN;

    @Autowired
    private SendWhatsAppReplyService service;

    @GetMapping
    public ResponseEntity<String> verifyWebhook(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.challenge") String challenge,
            @RequestParam("hub.verify_token") String verifyToken
    ) {
        System.out.println("Verification Token from Meta: " + VERIFY_TOKEN);
        if ("subscribe".equals(mode) && VERIFY_TOKEN.equals(verifyToken)) {
            return ResponseEntity.ok(challenge);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Verification failed");
        }
    }

    @PostMapping
    public ResponseEntity<Void> receiveMessage(@RequestBody Map<String, Object> payload) {
        try {

            System.out.println("Received webhook payload." + payload);

            List<Map<String, Object>> entry = (List<Map<String, Object>>) payload.get("entry");
            if (entry == null || entry.isEmpty()) return ResponseEntity.ok().build();

            Map<String, Object> changes = (Map<String, Object>) ((List<Map<String, Object>>) entry.get(0).get("changes")).get(0);
            Map<String, Object> value = (Map<String, Object>) changes.get("value");
            //normal msg
            List<Map<String, Object>> messages = (List<Map<String, Object>>) value.get("messages");

            if (messages != null && !messages.isEmpty()) {
                Map<String, Object> message = messages.get(0);
                String from = (String) message.get("from");

                Map<String, Object> text = (Map<String, Object>) message.get("text");
                    String body = text != null ? (String) text.get("body") : "";
                if (text != null && !text.isEmpty()) {
                    Map<String,Object > interactive = (Map<String, Object>) message.get("interactive");
                    String type = (String) interactive.get("type");
                    Map<String, Object> stringObjectMap = (Map<String, Object>) interactive.get(type);
                    body = (String) stringObjectMap.get("title");
                }
                long epochSeconds = Long.parseLong((String) message.get("timestamp"));
                LocalDateTime timestamp = LocalDateTime.ofEpochSecond(epochSeconds, 0, java.time.ZoneOffset.UTC);

                System.out.println("Received message from: " + from);
                System.out.println("Message body: " + body);

                ChatRequest request = new ChatRequest();
                request.setMessage(body);
                request.setPhone(from);
                request.setLocalDateTime(timestamp);
                System.out.println("ChatRequest add success");
                service.sendMessageToUser(request);
                System.out.println("calling send msg done");
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().build();
    }
}

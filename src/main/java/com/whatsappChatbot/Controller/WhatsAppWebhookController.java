package com.whatsappChatbot.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class WhatsAppWebhookController {

    @GetMapping
    public ResponseEntity<String> verifyWebhook(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.challenge") String challenge,
            @RequestParam("hub.verify_token") String verifyToken
    ) {
        String VERIFY_TOKEN = "EAAKX5I4f7TYBO7sOHImUiZBq3uLv8aJ9zda4ogBZCMiZC2Uixhl5nAyTcrpzNCiD2df7dl0dwz4ZCX4gW28QXcsYLHKwl19pSELUBiv29xhKkzZAGZBfApStI35mtnGoZBAuQ374yHraVs7YdZAj3V7WivJHIJcsry9ypFjHijwsboHZCMoGn92skUfrM0JNNsiKpgmbrMTZAvZAbNBXHFNAJ9ytZAadGu6qZB11WEYMGZAos7CD8tClAV9AEZD";
        if ("subscribe".equals(mode) && VERIFY_TOKEN.equals(verifyToken)) {
            return ResponseEntity.ok(challenge);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Verification failed");
        }
    }

    @PostMapping
    public ResponseEntity<Void> receiveMessage(@RequestBody Map<String, Object> payload) {
        try {
            // Navigate the nested payload
            List<Map<String, Object>> entry = (List<Map<String, Object>>) payload.get("entry");
            Map<String, Object> changes = (Map<String, Object>) ((List<Map<String, Object>>) entry.get(0).get("changes")).get(0);
            Map<String, Object> value = (Map<String, Object>) changes.get("value");

            List<Map<String, Object>> messages = (List<Map<String, Object>>) value.get("messages");
            if (messages != null && !messages.isEmpty()) {
                Map<String, Object> message = messages.get(0);
                String from = (String) message.get("from"); // phone number
                Map<String, Object> text = (Map<String, Object>) message.get("text");
                String body = (String) text.get("body"); // message body

                System.out.println("Received message from: " + from);
                System.out.println("User message: " + body);

                // TODO: Process message and respond if needed
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }
}


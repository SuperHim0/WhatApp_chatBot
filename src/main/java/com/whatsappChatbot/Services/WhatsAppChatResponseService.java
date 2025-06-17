package com.whatsappChatbot.Services;

import com.whatsappChatbot.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WhatsAppChatResponseService {

    public ResponseEntity<WhatsAppMessageResponse> WhatsAppChatWithButtonService(ChatRequest req){
        String messageText = "Hi Pablo! Your gardening workshop is scheduled for 9am tomorrow. Use the buttons if you need to reschedule. Thank you!";

        WhatsAppMessageResponse response = new WhatsAppMessageResponse();
        response.setTo(req.getPhone());

        Header header = new Header();
        header.setText("Choose Shipping Option");

        Body body = new Body();
        body.setText(messageText);

        Footer footer = new Footer();
        footer.setText("Lucky Shrub: Your gateway to succulents!™");

        Reply change = new Reply("change-button", "Change");
        Reply cancel = new Reply("cancel-button", "Cancel");

        Button b1 = new Button();
        b1.setReply(change);
        Button b2 = new Button();
        b2.setReply(cancel);

        Action action = new Action();
        action.setButtons(List.of(b1, b2));

        Interactive interactive = new Interactive();
        interactive.setHeader(header);
        interactive.setBody(body);
        interactive.setFooter(footer);
        interactive.setAction(action);

        response.setInteractive(interactive);

        return ResponseEntity.ok(response);
    }

    public WhatsAppListMessageResponse WhatsAppChatWithListService(ChatRequest req) {
        WhatsAppListMessageResponse response = new WhatsAppListMessageResponse();
        response.setTo(req.getMessage());

        Header header = new Header();
        header.setText("Choose Shipping Option");

        Body body = new Body();
        body.setText("Which shipping option do you prefer?");

        Footer footer = new Footer();
        footer.setText("Lucky Shrub: Your gateway to succulents™");

        // Rows
        Row row1 = new Row();
        row1.setId("priority_express");
        row1.setTitle("Priority Mail Express");
        row1.setDescription("Next Day to 2 Days");

        Row row2 = new Row();
        row2.setId("priority_mail");
        row2.setTitle("Priority Mail");
        row2.setDescription("1–3 Days");

        Row row3 = new Row();
        row3.setId("usps_ground_advantage");
        row3.setTitle("USPS Ground Advantage");
        row3.setDescription("2–5 Days");

        Row row4 = new Row();
        row4.setId("media_mail");
        row4.setTitle("Media Mail");
        row4.setDescription("2–8 Days");

        // Sections
        Section section1 = new Section();
        section1.setTitle("I want it ASAP!");
        section1.setRows(List.of(row1, row2));

        Section section2 = new Section();
        section2.setTitle("I can wait a bit");
        section2.setRows(List.of(row3, row4));

        // Action
        ListAction action = new ListAction();
        action.setButton("Shipping Options");
        action.setSections(List.of(section1, section2));

        // Combine into interactive
        InteractiveList interactive = new InteractiveList();
        interactive.setHeader(header);
        interactive.setBody(body);
        interactive.setFooter(footer);
        interactive.setAction(action);

        response.setInteractive(interactive);

        return (response);
    }

}

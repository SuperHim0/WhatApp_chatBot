package com.whatsappChatbot.Services;

import com.whatsappChatbot.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WhatsAppChatResponseService {

    public ResponseEntity<WhatsAppMessageResponse> whatsAppChatWithButtonsService(ChatRequest req){
        String messageText = "How can i assist you Today? Please Select the option from the main menu that bets fits your concern. Thank you!";

        WhatsAppMessageResponse response = new WhatsAppMessageResponse();
        response.setTo(req.getPhone());

        Header header = new Header();
        header.setText("Welcome to Dev.himanshu");

        Body body = new Body();
        body.setText(messageText);

        Footer footer = new Footer();
        footer.setText("dev.himanshu");

        Reply change = new Reply("contact", "contact");
        Reply cancel = new Reply("services", "Services");

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

    public WhatsAppListMessageResponse whatsAppChatWithListService(ChatRequest req) {
        WhatsAppListMessageResponse response = new WhatsAppListMessageResponse();
        response.setTo(req.getPhone());

        Header header = new Header();
        header.setText("Choose Services Option");

        Body body = new Body();
        body.setText("Which service option do you prefer?");

        Footer footer = new Footer();
        footer.setText("dev.himanshu™");

        // Rows
        Row row1 = new Row();
        row1.setId("single_pages");
        row1.setTitle("want a single page site");
        row1.setDescription("took 2 Days to build");

        Row row2 = new Row();
        row2.setId("multiple_pages");
        row2.setTitle("multiple pages site");
        row2.setDescription("depend on the pages");

        Row row3 = new Row();
        row3.setId("fullstack_single_page");
        row3.setTitle("single page full stack");
        row3.setDescription("took 1 week to build");

        Row row4 = new Row();
        row4.setId("fullstack_multiple_page");
        row4.setTitle("multiple page full stack");
        row4.setDescription("it took 4 weeks ");

        // Sections
        Section section1 = new Section();
        section1.setTitle("Front End!");
        section1.setRows(List.of(row1, row2));

        Section section2 = new Section();
        section2.setTitle("Full Stack");
        section2.setRows(List.of(row3, row4));

        // Action
        ListAction action = new ListAction();
        action.setButton("Services Options");
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

    public Map<String, Object> whatAppMessageDefaultResponse(ChatRequest request){
        String messageText = "Hello there! \uD83D\uDC4B Welcome to Dev.himanshu a java Developer.";

//        WhatAppMessageDefaultResponse response = new WhatAppMessageDefaultResponse();
//        response.setTo(request.getPhone());

        Map<String, Object> textContent = new HashMap<>();
        textContent.put("body", messageText);

        Map<String, Object> body = new HashMap<>();
        body.put("messaging_product", "whatsapp");
        body.put("to", request.getPhone());
        body.put("type", "text");
        body.put("text", textContent);

        Text text = new Text();
        text.setBody(messageText);
        return body;

    }

    public Map<String, Object> whatAppMessageResponse(ChatRequest request, String messageText){
//        String messageText = "Hello there! \uD83D\uDC4B Welcome to Dev.himanshu a java Developer.";

        WhatAppMessageDefaultResponse response = new WhatAppMessageDefaultResponse();
        response.setTo(request.getPhone());

        Map<String, Object> textContent = new HashMap<>();
        textContent.put("body", messageText);

        Map<String, Object> body = new HashMap<>();
        body.put("messaging_product", "whatsapp");
        body.put("to", request.getPhone());
        body.put("type", "text");
        body.put("text", textContent);

        Text text = new Text();
        text.setBody(messageText);
        return body;

//        return (response);
    }

    public WhatsAppMessageResponse whatsAppChatWithButtonService(ChatRequest req,String messageText){
//        String messageText = "How can i assist you Today? Please Select the option from the main menu that bets fits your concern. Thank you!";

        WhatsAppMessageResponse response = new WhatsAppMessageResponse();
        response.setTo(req.getPhone());

        Header header = new Header();
//        header.setText("Welcome to Dev.himanshu");

        Body body = new Body();
        body.setText(messageText);

        Footer footer = new Footer();
        footer.setText("dev.himanshu");

        Reply mainMenu = new Reply("main-menu", "Main Menu");
//        Reply cancel = new Reply("services", "Services");

        Button b1 = new Button();
        b1.setReply(mainMenu);
//        Button b2 = new Button();
//        b2.setReply(cancel);

        Action action = new Action();
        action.setButtons(List.of(b1));

        Interactive interactive = new Interactive();
        interactive.setHeader(header);
        interactive.setBody(body);
        interactive.setFooter(footer);
        interactive.setAction(action);

        response.setInteractive(interactive);

        return (response);
    }

}

package com.example.demo.web;

import com.example.demo.entity.Message;
import com.example.demo.request.MessageData;
import com.example.demo.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("messages")
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("message",
                "Hello, Vue-Spring-MySQL-Python-WebGL");
        return "welcome";
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Message> saveMessage(@RequestBody MessageData data) {
        Message saved = messageService.save(data.getText());

        if (saved == null) {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok(saved);
    }
}

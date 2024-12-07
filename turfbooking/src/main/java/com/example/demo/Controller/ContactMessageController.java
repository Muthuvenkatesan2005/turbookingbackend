
package com.example.demo.Controller;

import com.example.demo.Model.ContactMessage;
import com.example.demo.Service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contact")
public class ContactMessageController {

    @Autowired
    private ContactMessageService service;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody ContactMessage contactMessage) {
        service.saveMessage(contactMessage);
        return ResponseEntity.ok("Message received and stored successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactMessage> getMessageById(@PathVariable Long id) {
        Optional<ContactMessage> message = service.getMessageById(id);
        if (message.isPresent()) {
            return ResponseEntity.ok(message.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ContactMessage>> getAllMessages() {
        List<ContactMessage> messages = service.getAllMessages();
        return ResponseEntity.ok(messages);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMessage(@PathVariable Long id, @RequestBody ContactMessage contactMessage) {
        if (service.updateMessage(id, contactMessage)) {
            return ResponseEntity.ok("Message updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable Long id) {
        if (service.deleteMessage(id)) {
            return ResponseEntity.ok("Message deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


package com.example.demo.Service;

import com.example.demo.Model.ContactMessage;
import com.example.demo.Repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository repository;

    public ContactMessage saveMessage(ContactMessage contactMessage) {
        return repository.save(contactMessage);
    }

    public Optional<ContactMessage> getMessageById(Long id) {
        return repository.findById(id);
    }

    public List<ContactMessage> getAllMessages() {
        return repository.findAll();
    }

    public boolean updateMessage(Long id, ContactMessage contactMessage) {
        if (repository.existsById(id)) {
            contactMessage.setId(id);
            repository.save(contactMessage);
            return true;
        }
        return false;
    }

    public boolean deleteMessage(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

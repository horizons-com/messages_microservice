package com.horizons.messages_microservice.controllers;

import com.horizons.messages_microservice.models.Message;
import com.horizons.messages_microservice.repositories.MessageRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Message> getAllMessages() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Message getMessageById(@PathVariable("id") ObjectId id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyMessageById(@PathVariable("id") ObjectId id, @Valid @RequestBody Message message) {
        message.setId(id);
        repository.save(message);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Message createMessage (@Valid @RequestBody Message message) {
        message.setId(ObjectId.get());
        message.setDate(Instant.now());
        repository.save(message);
        return message;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMessage(@PathVariable ObjectId id) {
        repository.delete(repository.findById(id));
    }
}

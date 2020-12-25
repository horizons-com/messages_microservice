package com.horizons.messages_microservice.repositories;

import com.horizons.messages_microservice.models.Message;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    Message findById(ObjectId id);
    List<Message> findMessageBySenderUsername(String username);
    List<Message> findMessageByRecipientUsername(String username);
    // List<Message> findByReceiverUsername(String senderUsername);
}

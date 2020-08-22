package com.horizons.messages_microservice.repositories;

import com.horizons.messages_microservice.models.Message;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
    Message findById(ObjectId id);
}

package com.horizons.messages_microservice.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Message {
    @Id
    private ObjectId id;
    private String content;
    private ObjectId senderId;
    private ObjectId recipientId;

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ObjectId getSenderId() {
        return senderId;
    }

    public void setSenderId(ObjectId senderId) {
        this.senderId = senderId;
    }

    public ObjectId getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(ObjectId recipientId) {
        this.recipientId = recipientId;
    }
}

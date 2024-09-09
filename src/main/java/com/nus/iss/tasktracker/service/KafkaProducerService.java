package com.nus.iss.tasktracker.service;


public interface KafkaProducerService {
    void sendMessage(String topic, String message);


    // FIXME - HANDLE PUSH FOR BELOW EVENTS
    /*
    void handleUserInfoCreated(String message);
    void handleUserInfoDeleted(String message);
    void handleGroupInfoCreated(String message);
    void handleGroupInfoDeleted(String message);

     */

}

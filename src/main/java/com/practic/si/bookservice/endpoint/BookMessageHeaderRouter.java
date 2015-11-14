package com.practic.si.bookservice.endpoint;

import org.springframework.integration.annotation.Router;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: swatimhankare
 * Date: 11/14/15
 * Time: 2:40 PM
 */
@Component
public class BookMessageHeaderRouter {
     @Router (inputChannel = "bookChannel")
    public String getMessageChannel(@Header("MESSAGE_TYPE") String messageType)      {
        switch(messageType) {
            case "ADDBOOK" : return "bookAddChannel"  ;
            case "REMOVEBOOK" : return "bookRemoveChannel"  ;
            case "UPDATEBOOK" : return "bookUpdateChannel"  ;
            case "GETBOOK" : return "bookGetChannel"  ;

        }
        return "errorChannel";
    }
}

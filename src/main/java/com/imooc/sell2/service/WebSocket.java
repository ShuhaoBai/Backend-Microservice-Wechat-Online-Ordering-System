package com.imooc.sell2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Shuhao Bai on 10/24/19
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {
    private Session session;
    private static CopyOnWriteArraySet<WebSocket> webSocket = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocket.add(this);
        log.info("【websocket message】New Connection, total number = {}", webSocket.size());
    }

    @OnClose
    public void onClose(){
        webSocket.remove(this);
        log.info("【websocket message】Connection Broke, total number = {}", webSocket.size());
    }

    @OnMessage
    public void onMessage(String message){
        log.info("【websocket message】Receive Message from Client End:", message);
    }
    public void sendMessage(String message){
        for(WebSocket webSocket: webSocket){
            log.info("【websocket message】BroadCast Message, message ={}", message);
            try{
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

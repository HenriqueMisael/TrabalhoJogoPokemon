package util;

import java.util.LinkedList;

public class DefaultOutput {

    private static LinkedList<String> pendingMessages = new LinkedList<String>();
    private static LinkedList<String> sendedMessages = new LinkedList<String>();
    
    public static void message(String newMessage) {
        pendingMessages.add(newMessage);
    }
    
    public static void emptyQueue() {
        while(!pendingMessages.isEmpty()) {
            showMessage(pendingMessages.remove());
            delay();
        }
    }
    
    public static void repeat() {
        for(String message:sendedMessages) {
            sendMessage(message);
        }
    }
    
    public static void showMessage(String message) {
        System.out.println(message);
    }

    private static void sendMessage(String message) {
        showMessage(message);
        sendedMessages.add(message);
    }

    private static void delay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }
}

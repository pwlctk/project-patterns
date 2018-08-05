package pl.pwlctk.patterns.behavior.mediator;

import java.util.HashMap;
import java.util.Map;

public class Chatroom {

    private Map<String, User> participants = new HashMap<>();

    public void register(User user) {
        user.setChatroom(this);
        participants.put(user.getName(), user);
    }

    public void send(User from, String to, String message) {
        User user = participants.get(to);
        user.notify(from.getName());
        user.recive(from.getName(), message);
    }
}

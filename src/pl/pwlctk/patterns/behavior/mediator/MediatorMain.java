package pl.pwlctk.patterns.behavior.mediator;

public class MediatorMain {
    public static void main(String[] args) {
        Chatroom chatroom = new Chatroom();
        User user1 = new User("Paweł");
        User user2 = new User("Iza");
        User user3 = new User("Magda");
        User user4 = new User("Agnieszka");

        chatroom.register(user1);
        chatroom.register(user2);
        chatroom.register(user3);
        chatroom.register(user4);
        user1.send("Iza", "Hello");
    }
}

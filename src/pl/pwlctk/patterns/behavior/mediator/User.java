package pl.pwlctk.patterns.behavior.mediator;

public class User {

    private String name;
    private Chatroom chatroom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

    public User(String name) {
        this.name = name;
    }

    public void send(String to, String message) {
        chatroom.send(this, to, message);

    }

    public void recive(String from, String message) {
        System.out.println(name + " dostał wiadomość od " + from + ": " + message);
    }

    public void notify(String from){
        System.out.println(name + " ma wiadomość od "+ from);
    }


}

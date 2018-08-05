package pl.pwlctk.patterns.structural.facade.client;

import pl.pwlctk.patterns.structural.facade.Facade;

public class Client {

    public static void main(String[] args) {
        Facade facade = new Facade();
        String s = facade.showProject("Marzenia", "TV", "Iphone 11", "Sport car", "Big house");
        System.out.println(s);
    }
}

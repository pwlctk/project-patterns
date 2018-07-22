package pl.pwlctk.patterns.structural.flyweight;

public class FlyweightMain {
    public static void main(String[] args) {
        DocumentParser parser = new DocumentParser();
        DocumentFlyweightFactory factory = new DocumentFlyweightFactory(parser);
        Document document1 = factory.getDocument("plik1","Instrukcja obsługi lodówki");
        Document document2 = factory.getDocument("plik2","Tytuł -- Wiadomość");
        Document document3 = factory.getDocument("plik1","Instrukcja obsługi lodówki");
        Document document4 = factory.getDocument("plik4","Instrukcja obsługi lodówki");

        System.out.println("Doc 1 = Doc 2 = " + (document1 == document2));
        System.out.println("Doc 1 = Doc 3 = " + (document1 == document3));
        System.out.println("Doc 1 = Doc 4 = " + (document1 == document4));

    }
}

package pl.pwlctk;

public class CounterService {
    private int counter;
    private String name;

    public String registerVisit(String visitorName) {
        counter++;
        name = visitorName;

        return createMessageForVisitor();
    }

    private String createMessageForVisitor() {
        return "Hello " + name + ". You are " + counter + " visitor of this service";
    }


    public static void main(String[] args) {
        CounterService cs = new CounterService();
        System.out.println(cs.registerVisit("Janek"));
        System.out.println(cs.registerVisit("Paweł"));

        Integer a = 1;
        Integer b = 1;
        Integer c = 128;
        Integer d = 128;

        System.out.println(a == b); //true bo java tworzy sobie tablice i traktuje to jako typ prosty tablica do 127 tylko
        System.out.println(c == d); // false

    }

}

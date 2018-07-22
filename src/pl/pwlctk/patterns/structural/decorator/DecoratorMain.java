package pl.pwlctk.patterns.structural.decorator;

public class DecoratorMain {
    public static void main(String[] args) {
        Viewable viewable = new Fine("Piłeś przed zajęciami programowania!");
        viewable = new Admonishment(viewable);

        viewable.show();
    }
}

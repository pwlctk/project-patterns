package pl.pwlctk.patterns.structural.decorator;

public class Admonishment extends FineDecorator{

    public Admonishment(Viewable viewable) {
        super(viewable);
    }

    @Override
    protected void showBefore() {
        System.out.println("------UPOMNIENIE------");
    }

    @Override
    protected void showAfter() {
        System.out.println("To tylko upomnienie. Idź na piwo!");
    }
}

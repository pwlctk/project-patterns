package pl.pwlctk.patterns.structural.decorator;

public class FineDecorator implements Viewable {
    private final Viewable viewable;

    public FineDecorator(Viewable viewable) {
        this.viewable = viewable;
    }

    @Override
    public void show() {
        showBefore();
        viewable.show();
        showAfter();

    }

    protected void showBefore(){

    }

    protected void showAfter(){

    }
}

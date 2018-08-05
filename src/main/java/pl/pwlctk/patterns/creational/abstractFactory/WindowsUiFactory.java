package pl.pwlctk.patterns.creational.abstractFactory;

public class WindowsUiFactory implements UiAbstractFactory {
    @Override
    public Button getButton() {
        return new WindowsButton();
    }

    @Override
    public Input getInput() {
        return new WindowsInput();
    }
}

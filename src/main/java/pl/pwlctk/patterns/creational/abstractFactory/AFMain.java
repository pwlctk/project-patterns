package pl.pwlctk.patterns.creational.abstractFactory;

public class AFMain {
    public static void main(String[] args) {
        UiAbstractFactory factory = new WindowsUiFactory();
        Button button = factory.getButton();
        button.show();
        Input input = factory.getInput();
        input.write("Hej");
        input.write("Hello");
        System.out.println(input.getText());
    }
}

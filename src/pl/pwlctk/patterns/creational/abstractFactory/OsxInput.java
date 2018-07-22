package pl.pwlctk.patterns.creational.abstractFactory;

public class OsxInput implements Input {
    private String text;
    @Override
    public void write(String value) {
        text = value;
    }

    @Override
    public String getText() {
        return text;
    }
}

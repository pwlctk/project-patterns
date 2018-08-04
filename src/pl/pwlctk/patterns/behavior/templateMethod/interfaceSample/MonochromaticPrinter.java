package pl.pwlctk.patterns.behavior.templateMethod.interfaceSample;

public class MonochromaticPrinter implements Printer {
    @Override
    public void getInk() {
        System.out.println("załadowano tusz czarny");
    }

    @Override
    public void loadPaper() {
        System.out.println("pobrano papier zwykły A4");
    }

    @Override
    public void prepareDocument() {
        System.out.println("zmieniono kolory obrazu na wersje czarnobiałą");
    }

    @Override
    public void printDocument() {
        System.out.println("zaczęto drukowanie w skali szarości");
    }
}

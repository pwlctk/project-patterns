package pl.pwlctk.patterns.behavior.templateMethod.abstractSample;

public class MonochromaticPrinter extends Printer {
    @Override
    void getInk() {
        System.out.println("załadowano tusz czarny");
    }

    @Override
    void loadPaper() {
        System.out.println("pobrano papier zwykły A4");
    }

    @Override
    void prepareDocument() {
        System.out.println("zmieniono kolory obrazu na wersje czarnobiałą");
    }

    @Override
    void printDocument() {
        System.out.println("zaczęto drukowanie w skali szarości");
    }
}

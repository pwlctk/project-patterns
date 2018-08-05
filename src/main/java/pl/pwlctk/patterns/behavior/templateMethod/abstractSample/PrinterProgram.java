package pl.pwlctk.patterns.behavior.templateMethod.abstractSample;

public class PrinterProgram {
    public static void main(String[] args) {
        Printer printer = new MonochromaticPrinter();
        printer.print();
    }
}

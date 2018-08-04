package pl.pwlctk.patterns.behavior.templateMethod.interfaceSample;

public class PrinterProgram {
    public static void main(String[] args) {
        Printer printer = new MonochromaticPrinter();
        printer.print();
    }
}

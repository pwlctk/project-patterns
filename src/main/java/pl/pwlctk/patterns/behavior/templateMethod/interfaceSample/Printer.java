package pl.pwlctk.patterns.behavior.templateMethod.interfaceSample;

public interface Printer {
    void getInk();

    void loadPaper();

    void prepareDocument();

    void printDocument();

    default void print() {
        prepareDocument();
        loadPaper();
        getInk();
        printDocument();
    }
}

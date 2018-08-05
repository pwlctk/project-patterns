package pl.pwlctk.patterns.behavior.templateMethod.abstractSample;

public abstract class Printer {
    abstract void getInk();
    abstract void loadPaper();
    abstract void prepareDocument();
    abstract void printDocument();

    void print(){
        prepareDocument();
        loadPaper();
        getInk();
        printDocument();


    }
}

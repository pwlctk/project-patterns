package pl.pwlctk.tasks.program;

public class PrintEvaluator implements Evaluator {
    private static final String REGEX = "\\$\\w+";
    private PrintParser printParser;

    PrintEvaluator(Instruction instruction, ProgramMemory programMemory) {
        printParser = new PrintParser(REGEX, instruction.getArguments(), programMemory);
    }

    @Override
    public void evaluate() {
        printParser.parse();
        System.out.println(printParser.getLineToPrint());

    }
}

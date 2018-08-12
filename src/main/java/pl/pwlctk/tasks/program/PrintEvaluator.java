package pl.pwlctk.tasks.program;

public class PrintEvaluator implements Evaluator {
    private final String REGEX = "\\$(\\w+)";
    private final PrintParser printParser;

    PrintEvaluator(Instruction instruction, ProgramMemory programMemory) {
        printParser = new PrintParser(REGEX, instruction.getArguments(), programMemory);
    }

    @Override
    public void evaluate() {
        printParser.parse();
        System.out.println(printParser.getLineToPrint());

    }
}

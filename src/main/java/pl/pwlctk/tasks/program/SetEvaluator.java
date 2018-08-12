package pl.pwlctk.tasks.program;

public class SetEvaluator implements Evaluator {
    private static final String REGEX = "(\\S+)\\s+(.*)";
    private ProgramMemory programMemory;
    private GetSetParser getSetParser;

    SetEvaluator(Instruction instruction, ProgramMemory programMemory) {
        this.programMemory = programMemory;
        this.getSetParser = new GetSetParser(instruction.getArguments(), REGEX);
    }

    @Override
    public void evaluate() {
        getSetParser.parse();
        String key = getSetParser.getKey();
        String value = getSetParser.getValue();
        programMemory.addValue(key, value);
    }
}


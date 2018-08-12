package pl.pwlctk.tasks.program;

public class GetEvaluator implements Evaluator {
    private final String REGEX = "(\\S+)\\s+(\\S+).*";
    private final ProgramMemory programMemory;
    private final GetSetParser getSetParser;

    GetEvaluator(Instruction instruction, ProgramMemory programMemory) {
        this.programMemory = programMemory;
        this.getSetParser = new GetSetParser(instruction.getArguments(), REGEX);
    }

    @Override
    public void evaluate() {
        getSetParser.parse();
        String key = getSetParser.getKey();
        String newValue = getSetParser.getValue();

        programMemory.addValue(key, newValue);
    }
}



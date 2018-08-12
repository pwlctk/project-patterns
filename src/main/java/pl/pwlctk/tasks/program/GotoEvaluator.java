package pl.pwlctk.tasks.program;

public class GotoEvaluator implements Evaluator {
    private final String REGEX = "(\\d+)";
    private final GotoParser gotoParser;
    private final ProgramMemory programMemory;
    private Instruction instruction;

    GotoEvaluator(Instruction instruction, ProgramMemory programMemory) {
        this.instruction = instruction;
        this.gotoParser = new GotoParser(this.instruction.getArguments(), REGEX);
        this.programMemory = programMemory;
    }

    @Override
    public void evaluate() {
        if (programMemory.getRunSet().add(instruction)) {
            gotoParser.parse();
            Long address = gotoParser.getNumber();
            int index = programMemory.getIndex(address);
            programMemory.setIndex(index);
        }
    }
}


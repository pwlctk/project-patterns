package pl.pwlctk.tasks.program;

public class EvaluatorNameFactory implements EvaluatorFactory {
    private final ProgramMemory programMemory;

    EvaluatorNameFactory(ProgramMemory programMemory) {
        this.programMemory = programMemory;

    }

    @Override
    public Evaluator createEvaluator(Instruction instruction) {
        String type = instruction.getType();
        if ("PRINT".equalsIgnoreCase(type)) {
            return new PrintEvaluator(instruction, programMemory);
        }

        if ("SET".equalsIgnoreCase(type)) {
            return new SetEvaluator(instruction, programMemory);
        }

        if ("GET".equalsIgnoreCase(type)) {
            return new GetEvaluator(instruction, programMemory);
        }

        if ("CAL".equalsIgnoreCase(type)) {
            return new CalEvaluator(instruction);
        }

        if ("GOTO".equalsIgnoreCase(type)) {
            return new GotoEvaluator(instruction, programMemory);
        }

        return new UnknownEvaluator(instruction);
    }
}

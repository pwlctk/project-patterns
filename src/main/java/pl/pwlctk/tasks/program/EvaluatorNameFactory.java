package pl.pwlctk.tasks.program;

public class EvaluatorNameFactory implements EvaluatorFactory {
    @Override
    public Evaluator createEvaluator(Instruction instruction, ProgramMemory programMemory) {
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

        return new UnknownEvaluator(instruction);
    }
}

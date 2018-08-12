package pl.pwlctk.tasks.program;

class ProgramRunner {
    private final ProgramMemory programMemory;
    private final EvaluatorFactory evaluatorFactory;

    ProgramRunner(ProgramMemory programMemory, EvaluatorFactory evaluatorFactory) {
        this.programMemory = programMemory;
        this.evaluatorFactory = evaluatorFactory;
    }

    void run() {
        while (programMemory.hasNextInstruction()) {
            Instruction instruction = programMemory.getNextInstruction();
            evaluatorFactory.createEvaluator(instruction).evaluate();

        }
    }
}

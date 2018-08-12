package pl.pwlctk.tasks.program;

class ProgramRunner {
    ProgramMemory programMemory;
    EvaluatorFactory evaluatorFactory;

    ProgramRunner(ProgramMemory programMemory, EvaluatorFactory evaluatorFactory) {
        this.programMemory = programMemory;
        this.evaluatorFactory = evaluatorFactory;
    }

    void run() {

        for (Instruction instruction : programMemory.getInstructions()) {
            evaluatorFactory.createEvaluator(instruction, programMemory).evaluate();
        }
    }
}

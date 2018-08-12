package pl.pwlctk.tasks.program;

public interface EvaluatorFactory {

    Evaluator createEvaluator(Instruction instruction, ProgramMemory programMemory);
}

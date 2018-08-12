package pl.pwlctk.tasks.program;

public class UnknownEvaluator implements Evaluator {
    private Instruction instruction;

    UnknownEvaluator(Instruction instruction) {
        this.instruction = instruction;
    }

    @Override
    public void evaluate() {
        System.out.println("Nieznana komenda: " + instruction.getType());
    }
}

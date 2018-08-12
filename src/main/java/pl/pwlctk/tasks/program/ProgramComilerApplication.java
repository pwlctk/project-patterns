package pl.pwlctk.tasks.program;

import java.io.IOException;

class ProgramComilerApplication {
    public static void main(String[] args) throws IOException {
        InstructionParser parser = new InstructionParser();
        ProgramMemory programMemory = new ProgramMemory();
        EvaluatorFactory evaluatorFactory = new EvaluatorNameFactory(programMemory);
        ProgramLoader loader = new ProgramLoader(programMemory, parser);

        loader.load();

        ProgramRunner starter = new ProgramRunner(programMemory, evaluatorFactory);
        starter.run();
    }
}

package pl.pwlctk.tasks.program;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        Parser parser = new Parser();
        InstructionLoader instructionLoader = new InstructionLoader();

        List<String> fullInstructions = instructionLoader.loadInstructionsFromDisk();

        System.out.println(fullInstructions);

        List<Instruction> instructions = new ArrayList<>();
        for (String fullInstruction : fullInstructions) {
            instructions.add(parser.parse(fullInstruction));
        }

        System.out.println(instructions);
    }



}

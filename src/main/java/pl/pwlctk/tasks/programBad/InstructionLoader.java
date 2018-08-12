package pl.pwlctk.tasks.programBad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class InstructionLoader {
    private List<Instruction> instructions;
    private InstructionParser instructionParser;

    InstructionLoader(String pattern) {
        this.instructionParser = new InstructionParser(pattern);
    }

    List<Instruction> loadInstructionsFromDisk() {
        try {
            String path = "src/main/resources/instructions.txt";
            Stream<String> stream = Files.lines(Paths.get(path));
            instructions = stream.map(instr -> instructionParser.parse(instr)).collect(Collectors.toList());
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instructions;
    }
}

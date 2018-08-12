package pl.pwlctk.tasks.program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

class ProgramLoader {
    private final ProgramMemory programMemory;
    private final InstructionParser parser;

    ProgramLoader(ProgramMemory programMemory, InstructionParser parser) {
        this.programMemory = programMemory;
        this.parser = parser;
    }

    void load() throws IOException {
        Files.lines(Paths.get("src\\main\\resources\\instructions.txt"))
                .forEach(this::loadLine);
    }

    private void loadLine(String line){
        Optional<Instruction> instruction = parser.parseToInstruction(line);
        instruction.ifPresent(programMemory::addInstruction);

//        if (instruction.isPresent()) {
//            programMemory.addInstruction(instruction.get());
//        }
//        instruction.ifPresent(instruction1 ->
//                programMemory.addInstruction(instruction1));
    }
}

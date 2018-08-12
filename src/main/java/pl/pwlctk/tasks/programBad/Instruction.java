package pl.pwlctk.tasks.programBad;

//Lombok automatycznie nam generuje wszystkie gettery oraz settery, constructor, equals itd...

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class Instruction {
    private Long lineNumber;
    private String instructionName;
    private String instructionArguments;


    Instruction(Long lineNumber, String instructionName, String instructionArguments) {
        this.lineNumber = lineNumber;
        this.instructionName = instructionName;
        this.instructionArguments = instructionArguments;
    }
}

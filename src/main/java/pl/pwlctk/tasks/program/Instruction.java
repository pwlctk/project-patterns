package pl.pwlctk.tasks.program;

public class Instruction {
    private long lineNumber;
    private String instructionName;
    private String instructionArguments;

    Instruction(long lineNumber, String instructionName, String instructionArguments) {
        this.lineNumber = lineNumber;
        this.instructionName = instructionName;
        this.instructionArguments = instructionArguments;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "line: " + lineNumber +
                ", name: '" + instructionName + '\'' +
                ", arguments: '" + instructionArguments + '\'' +
                '}';
    }
}

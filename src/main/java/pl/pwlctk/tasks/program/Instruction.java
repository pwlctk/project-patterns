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

    public long getLineNumber() {
        return lineNumber;
    }

    public String getInstructionName() {
        return instructionName;
    }

    public String getInstructionArguments() {
        return instructionArguments;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "lineNumber=" + lineNumber +
                ", instructionName='" + instructionName + '\'' +
                ", instructionArguments='" + instructionArguments + '\'' +
                '}' + "\n";
    }
}

package pl.pwlctk.tasks.program;

import lombok.Data;

@Data
class Instruction {
    private Long address;
    private String type, arguments;

    public Instruction() {
    }

    public Instruction(Long address, String type, String arguments) {
        this.address = address;
        this.type = type;
        this.arguments = arguments;
    }
}

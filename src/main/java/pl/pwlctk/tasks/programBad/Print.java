package pl.pwlctk.tasks.programBad;

class Print {

    void printer(Instruction instruction) {
        if (instruction.getInstructionName().equalsIgnoreCase("print")) {
            System.out.println(instruction.getInstructionArguments());
        } else {
            System.out.println("Nieprawidłowa komenda");
        }
    }
}

package pl.pwlctk.tasks.program;

class Print {

    static void printer(Instruction instruction){
        if(instruction.getInstructionName().equalsIgnoreCase("print")) {
            System.out.println(instruction.getInstructionArguments());
        } else {
            System.out.println("Nieprawidłowa komenda");
        }
    }
}

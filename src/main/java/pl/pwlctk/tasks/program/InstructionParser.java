package pl.pwlctk.tasks.program;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InstructionParser {

    private final Pattern PATTERN = Pattern.compile("(\\d+)\\s+(\\S+)\\s+(.*)");

    Optional<Instruction> parseToInstruction(String line) {
        Matcher matcher = PATTERN.matcher(line);
        if (matcher.find()) {
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            Instruction instruction = new Instruction();
            instruction.setAddress(Long.valueOf(group1));
            instruction.setType(group2);
            instruction.setArguments(group3);
            return Optional.of(instruction);
        }
        return Optional.empty();
    }
}

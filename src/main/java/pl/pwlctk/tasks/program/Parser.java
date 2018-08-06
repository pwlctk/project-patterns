package pl.pwlctk.tasks.program;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private Pattern compile = Pattern.compile(("(\\d+)\\s+([A-Z]+)\\s+(.*)"));


    Instruction parse(String fullInstruction) {
        Matcher matcher = compile.matcher(fullInstruction);
        Instruction instruction;
        if (matcher.find()) {
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            instruction = new Instruction(Long.parseLong(group1), group2, group3);
            return instruction;
        }
        return null;
    }
}

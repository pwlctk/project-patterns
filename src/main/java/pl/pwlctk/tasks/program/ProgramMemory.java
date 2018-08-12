package pl.pwlctk.tasks.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProgramMemory {
    private List<Instruction> instructions = new ArrayList<>();
    private Map<String, String> values = new HashMap<>();

    void addInstruction(Instruction instruction) {
        instructions.add(instruction);
    }

    List<Instruction> getInstructions() {
        return instructions;
    }

    void addValue(String key, String value) {
        values.put(key, value);
    }

    String getValue(String key) {
        return values.getOrDefault(key,"Zonk!");
    }

    Map<String, String> getValues() {
        return values;
    }
}

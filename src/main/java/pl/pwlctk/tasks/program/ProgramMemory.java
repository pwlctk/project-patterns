package pl.pwlctk.tasks.program;

import java.util.*;

class ProgramMemory {
    private List<Instruction> instructions = new ArrayList<>();
    private Map<String, String> values = new HashMap<>();
    private Set<Instruction> runSet = new HashSet<>();
    private int index = 0;

    void addInstruction(Instruction instruction) {
        instructions.add(instruction);
    }

    void addValue(String key, String value) {
        values.put(key, value);
    }

    String getValue(String key) {
        return values.getOrDefault(key, "Zonk!");
    }

    int getIndex(Long adress) {
        int index = 0;
        for (int i = 0; i < instructions.size(); i++) {
            if (instructions.get(i).getAddress().equals(adress)) {
                index = i;
            }
        }
        return index;
    }

    void setIndex(int index) {
        this.index = index;
    }

    boolean hasNextInstruction() {
        return index < instructions.size();
    }

    Instruction getNextInstruction() {
        return instructions.get(index++);
    }

    public Set<Instruction> getRunSet() {
        return runSet;
    }

}

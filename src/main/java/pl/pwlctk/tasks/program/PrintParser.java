package pl.pwlctk.tasks.program;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PrintParser {
    private String regex;
    private String parseArguments;
    private final ProgramMemory programMemory;
    private String lineToPrint;

    PrintParser(String regex, String parseArguments, ProgramMemory programMemory) {
        this.regex = regex;
        this.parseArguments = parseArguments;
        this.programMemory = programMemory;
    }

    void parse() {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parseArguments);
        while (matcher.find()) {
            String variableName = matcher.group(0).substring(1);
            parseArguments = parseArguments.replaceFirst("\\$" + variableName, programMemory.getValue(variableName));
        }
        lineToPrint = parseArguments;
    }

    String getLineToPrint() {
        return lineToPrint;
    }
}

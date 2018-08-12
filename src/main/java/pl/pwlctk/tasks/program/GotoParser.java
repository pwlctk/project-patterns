package pl.pwlctk.tasks.program;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GotoParser {
    private String regex;
    private String lineNumber;
    private Long number;

    GotoParser(String lineNumber, String regex) {
        this.lineNumber = lineNumber;
        this.regex = regex;
    }

    void parse() {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lineNumber);
        if (matcher.find()) {
            number = Long.valueOf(matcher.group(1));
        }
    }

    Long getNumber() {
        return number;
    }
}

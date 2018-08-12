package pl.pwlctk.tasks.program;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GetSetParser {
    private String regex;
    private String parseArguments;

    private String key;
    private String value;

    GetSetParser(String parseArguments, String regex) {
        this.parseArguments = parseArguments;
        this.regex = regex;
    }

    void parse() {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parseArguments);
        if (matcher.find()) {
            key = matcher.group(1);
            value = matcher.group(2);
        }
    }

    String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

package pl.pwlctk.tasks.program;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CalParser {
    private String regex;
    private String parseArguments;

    private int number1;
    private int number2;
    private String operator;

    CalParser(String parseArguments, String regex) {
        this.parseArguments = parseArguments;
        this.regex = regex;
    }

    void parse() {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parseArguments);
        if (matcher.find()) {
            number1 = Integer.parseInt(matcher.group(1));
            operator = matcher.group(2);
            number2 = Integer.parseInt(matcher.group(3));
        }
    }

    int getNumber1() {
        return number1;
    }

    int getNumber2() {
        return number2;
    }

    String getOperator() {
        return operator;
    }
}

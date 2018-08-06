package pl.pwlctk.tasks.program;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramCompilerApplication {
    private long lineNumber;
    private String orderName;
    private String orderArguments;

    public static void main(String[] args) {
        Pattern compile = Pattern.compile(("(\\d+)\\s+([A-Z]+)\\s+(.*)"));
        Matcher matcher = compile.matcher("12 PRINT Hello World");
        if (matcher.find()) {
            String group0 = matcher.group(0);
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);

            System.out.println(group0);
            System.out.println(group1);
            System.out.println(group2);
            System.out.println(group3);
        }


    }
}

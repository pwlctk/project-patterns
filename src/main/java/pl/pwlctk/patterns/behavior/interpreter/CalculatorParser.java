package pl.pwlctk.patterns.behavior.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalculatorParser {

    private List<Expression> parse(String value) {
        List<Expression> expressionList = new ArrayList<>();
        String[] split = value.split(" ");
        for (String s : split) {
            if ("+".equals(s)) {
                Expression expression = new PlusNumbersExpression();
                expressionList.add(expression);
            } else {
                Expression expression = new AddNumberExpression(Integer.valueOf(s));
                expressionList.add(expression);
            }

        }
        return expressionList;
    }

    public void evaluate() {
        Stack<Integer> context = new Stack<>();
        List<Expression> parse = parse("3 4 +");
        for (Expression expression : parse) {
            expression.interpret(context);
        }

        System.out.println(context.pop());

    }
}


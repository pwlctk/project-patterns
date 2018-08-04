package pl.pwlctk.patterns.behavior.interpreter;

import java.util.Stack;

public class PlusNumbersExpression implements Expression {

    @Override
    public void interpret(Stack<Integer> context) {
        Integer value1 = context.pop();
        Integer value2 = context.pop();
        context.push(value1 + value2);
    }
}

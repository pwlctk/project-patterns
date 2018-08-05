package pl.pwlctk.patterns.behavior.interpreter;

import java.util.Stack;

public class AddNumberExpression implements Expression {

    private Integer value;

    public AddNumberExpression(Integer value) {
        this.value = value;
    }



    @Override
    public void interpret(Stack<Integer> context) {
        context.push(value);

    }
}

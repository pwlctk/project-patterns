package pl.pwlctk.patterns.behavior.interpreter;

import java.util.Stack;

public interface Expression {

    void interpret(Stack<Integer> content);
}

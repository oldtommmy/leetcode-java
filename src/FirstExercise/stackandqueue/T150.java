package FirstExercise.stackandqueue;

import java.util.ArrayDeque;

public class T150 {
    public int evalRPN(String[] tokens) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {

            if ("+".equals(tokens[i])) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(tokens[i])) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(tokens[i])) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(tokens[i])) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                stack.push(pop2 / pop1);
            } else {
                stack.push(stack.pop());
            }
        }
        return stack.pop();
    }
}

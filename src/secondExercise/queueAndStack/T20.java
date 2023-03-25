package secondExercise.queueAndStack;

import java.util.Stack;

public class T20 {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int length = ch.length;
        if (length % 2 != 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!stack.isEmpty()) {
                Character peek = stack.peek();
                if ((peek == '{' && ch[i] == '}') ||(peek == '[' && ch[i] == ']') ||(peek == '(' && ch[i] == ')')) {
                    stack.pop();
                } else {
                    stack.push(ch[i]);
                }
            } else {
                stack.push(ch[i]);
            }
        }
        return stack.isEmpty();
    }
}

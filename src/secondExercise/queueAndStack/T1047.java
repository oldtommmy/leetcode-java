package secondExercise.queueAndStack;

import java.util.Deque;
import java.util.LinkedList;

public class T1047 {
    public String removeDuplicates(String s) {

        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!deque.isEmpty()) {
                char peek = deque.peek();
                if (peek == c) {
                    deque.pop();
                } else {
                    deque.push(c);
                }
            } else {
                deque.push(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append(deque.poll());
        }
        return builder.toString();
    }
}

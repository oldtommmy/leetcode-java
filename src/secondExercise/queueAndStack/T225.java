package secondExercise.queueAndStack;

import java.util.LinkedList;
import java.util.Queue;

public class T225 {
    class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
        }

        public int pop() {
            int i = queue.size();
            while (i-- > 0) {
                queue.offer(queue.poll());
            }
            return queue.poll();
        }

        public int top() {
            int i = queue.size();
            while (i-- > 0) {
                queue.offer(queue.poll());
            }
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}

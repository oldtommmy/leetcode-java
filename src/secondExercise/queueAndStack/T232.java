package secondExercise.queueAndStack;

import java.util.Stack;

/**
 * 使用栈实现队列
 */
public class T232 {
    class MyQueue {

        Stack<Integer> inStack;
        Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.empty()) {
                while (!inStack.empty()) {
                    outStack.push(inStack.peek());
                    inStack.pop();
                }
            }
            Integer peek = outStack.peek();
            outStack.pop();
            return peek;
        }

        public int peek() {
            if (outStack.empty()) {
                while (!inStack.empty()) {
                    outStack.push(inStack.peek());
                    inStack.pop();
                }
            }
            Integer peek = outStack.peek();
            return peek;
        }

        public boolean empty() {
            return inStack.empty() && outStack.empty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}

package FirstExercise.stackandqueue;

import java.util.Stack;

/**
 *  232. 用栈实现队列
 */

public class T232 {

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
@SuppressWarnings({"all"})
class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack();
        outStack = new Stack();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}

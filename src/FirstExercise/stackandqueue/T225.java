package FirstExercise.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *   225. 用队列实现栈
 */
@SuppressWarnings({"all"})
public class T225 {
}

@SuppressWarnings({"all"})
class MyStack {

    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int size = queue.size();
        while (size-- > 1) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    public int top() {
        int size = queue.size();
        while (size-- > 1) {
            queue.offer(queue.poll());
        }
        int poll = queue.poll();
        queue.offer(poll);
        return poll;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
/*
  Use two queues
  class MyStack {

      Queue<Integer> queue1;
      Queue<Integer> queue2;

      public MyStack() {
          queue1 = new LinkedList<>();
          queue2 = new LinkedList<>();
      }

      public void push(int x) {
          queue1.offer(x);
      }

      public int pop() {
          Integer poll = -1;
          while (!queue1.isEmpty()) {
              poll = queue1.poll();
              if (queue1.isEmpty()) {
                  break;
              }
              queue2.offer(poll);
          }
          while (!queue2.isEmpty()) {
              queue1.offer(queue2.poll());
          }
          return poll;
      }

      public int top() {
          Integer poll = -1;
          while (!queue1.isEmpty()) {
              poll = queue1.poll();
              queue2.offer(poll);
          }
          while (!queue2.isEmpty()) {
              queue1.offer(queue2.poll());
          }
          return poll;
      }

      public boolean empty() {
          return queue1.isEmpty();
      }
  }
 */
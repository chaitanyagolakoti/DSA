package StackandQueue;

import java.util.Stack;

public class ImplementQueuewithStacks {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public ImplementQueuewithStacks() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
        return second.pop();
    }

    public int peek() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
        return second.peek();
    }

    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueuewithStacks queue = new ImplementQueuewithStacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.pop()); // Output: 1
        System.out.println(queue.peek()); // Output: 2
        System.out.println(queue.empty()); // Output: false

        queue.push(4);
        System.out.println(queue.pop()); // Output: 2
        System.out.println(queue.pop()); // Output: 3
        System.out.println(queue.empty()); // Output: false
    }
}

package datastructure;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> stackPreMin;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        stackPreMin = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (stackPreMin.isEmpty()) {
            stackPreMin.push(val);
        } else {
            stackPreMin.push(Math.min(stackPreMin.peek(), val));
        }
    }

    public void pop() {
        stack.pop();
        stackPreMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackPreMin.peek();
    }
}

package Stacks_and_Queues;

import java.util.Stack;

//Leetcode: (Qn:232)
//https://leetcode.com/problems/implement-queue-using-stacks/description/
public class ImplementQueueUsingTwoStacks {
    //push efficient code
    private Stack<Integer> first;
    private Stack<Integer> second;

    public ImplementQueueUsingTwoStacks() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        while(!first.isEmpty()){
            second.push(first.pop());
        }

        int popped = second.pop();

        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return popped;
    }

    public int peek() {
        while(!first.isEmpty()){
            second.push(first.pop());
        }

        int popped = second.peek();

        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return popped;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}

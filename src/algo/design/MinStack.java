package algo.design;

import java.util.ArrayList;
import java.util.List;

public class MinStack {


    public static void main(String[] args) {
        MinStackUsingTwoStacks minStackUsingTwoStacks = new MinStackUsingTwoStacks();
        MinStackUsingMinInfoAtEachNode minStackUsingMinInfoAtEachNode = new MinStackUsingMinInfoAtEachNode();

        minStackUsingTwoStacks.push(-2);
        minStackUsingMinInfoAtEachNode.push(-2);

        minStackUsingTwoStacks.push(0);
        minStackUsingMinInfoAtEachNode.push(0);

        minStackUsingTwoStacks.push(-3);
        minStackUsingMinInfoAtEachNode.push(-3);

        System.out.println(minStackUsingTwoStacks.getMin());
        System.out.println(minStackUsingMinInfoAtEachNode.getMIn());

        minStackUsingTwoStacks.pop();
        minStackUsingMinInfoAtEachNode.pop();

        System.out.println(minStackUsingTwoStacks.top());
        System.out.println(minStackUsingMinInfoAtEachNode.top());

        System.out.println(minStackUsingTwoStacks.getMin());
        System.out.println(minStackUsingMinInfoAtEachNode.getMIn());

        minStackUsingTwoStacks.push(-4);
        minStackUsingMinInfoAtEachNode.push(-4);

        minStackUsingTwoStacks.push(-4);
        minStackUsingMinInfoAtEachNode.push(-4);


        System.out.println(minStackUsingTwoStacks.top());
        System.out.println(minStackUsingMinInfoAtEachNode.top());

        System.out.println(minStackUsingTwoStacks.getMin());
        System.out.println(minStackUsingMinInfoAtEachNode.getMIn());

        minStackUsingTwoStacks.pop();
        minStackUsingMinInfoAtEachNode.pop();

        System.out.println(minStackUsingTwoStacks.top());
        System.out.println(minStackUsingMinInfoAtEachNode.top());

        System.out.println(minStackUsingTwoStacks.getMin());
        System.out.println(minStackUsingMinInfoAtEachNode.getMIn());

        minStackUsingTwoStacks.pop();
        minStackUsingMinInfoAtEachNode.pop();

        System.out.println(minStackUsingTwoStacks.top());
        System.out.println(minStackUsingMinInfoAtEachNode.top());

        System.out.println(minStackUsingTwoStacks.getMin());
        System.out.println(minStackUsingMinInfoAtEachNode.getMIn());


    }

    public static class MinStackUsingMinInfoAtEachNode {
        private static class Node {
            int val;
            int min;

            public Node(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }

        private final List<Node> stack;

        public MinStackUsingMinInfoAtEachNode() {
            stack = new ArrayList<>();
        }

        public void push(int val) {
            int min = stack.isEmpty() ? val : Math.min(val, stack.get(stack.size() - 1).min);
            stack.add(new Node(val, min));
        }

        public void pop() {
            stack.remove(stack.size() - 1);
        }

        public int top() {
            return stack.get(stack.size() - 1).val;
        }

        public int getMIn() {
            return stack.get(stack.size() - 1).min;
        }

    }


    public static class MinStackUsingTwoStacks {
        private final List<Integer> stack;
        private final List<Integer> minStack;

        public MinStackUsingTwoStacks() {
            stack = new ArrayList<>();
            minStack = new ArrayList<>();
        }

        public void push(int val) {
            stack.add(val);
            // NOTE: less than or equal to is important because we can insert the same value multiple times and while removing we need to remove only the topmost element to keep the minStack in sync
            if (minStack.isEmpty() || val <= minStack.get(minStack.size() - 1)) {
                minStack.add(val);
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            int removed = stack.remove(stack.size() - 1);
            if (removed == minStack.get(minStack.size() - 1)) {
                minStack.remove(minStack.size() - 1);
            }
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return minStack.get(minStack.size() - 1);
        }

    }
}


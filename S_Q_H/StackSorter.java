import java.util.*;
class StackSorter {
    public void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty() || stack.size() == 1) {
            return;
        }
        int temp = stack.pop();
        sortStack(stack);
        insertAtCorrectPosition(stack, temp);
    }
    private void insertAtCorrectPosition(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        insertAtCorrectPosition(stack, element);
        stack.push(temp);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(3);
        StackSorter sorter = new StackSorter();
        sorter.sortStack(stack);
        System.out.println("Sorted stack: " + stack);
    }
}

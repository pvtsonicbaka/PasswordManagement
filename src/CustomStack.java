import java.util.NoSuchElementException;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 10;
    private String[] stack;
    private int top;

    public CustomStack() {
        stack = new String[INITIAL_CAPACITY];
        top = -1;
    }

    // Pushes an item onto the stack
    public void push(String item) {
        if (top == stack.length - 1) {
            resize();
        }
        stack[++top] = item;
    }

    // Pops an item from the stack
    public String pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        String item = stack[top];
        stack[top--] = null; // Clear the reference
        return item;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Displays all items in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("No login history available.");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    // Resizes the stack array when it is full
    private void resize() {
        int newCapacity = stack.length * 2;
        String[] newStack = new String[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}

import java.util.NoSuchElementException;

public class Part2 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Current Stack: " + stack);
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        System.out.println("Current Stack: " + stack); 

        stack.pop(); 
        try {
            stack.pop(); 
        } catch (NoSuchElementException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        Stack<String> stringStack = new Stack<>();
        stringStack.push("hello");
        stringStack.push("world");
        System.out.println("Popped: " + stringStack.pop());
    }
}
 class Stack<T> extends LinkedList<T> {
    public void push(T item) {
        addFirst(item);  
    }

    public T pop() {
        if (getSize() == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        return remove(0); 
    }
}

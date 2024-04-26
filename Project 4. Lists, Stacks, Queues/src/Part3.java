import java.util.NoSuchElementException;

public class Part3{
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Current Queue: " + queue);
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        System.out.println("Current Queue: " + queue); 

        queue.dequeue(); 
        try {
            queue.dequeue(); 
        } catch (NoSuchElementException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        Queue<String> stringQueue = new Queue<>();
        stringQueue.enqueue("hello");
        stringQueue.enqueue("world");
        System.out.println("Dequeued: " + stringQueue.dequeue());
    }
}
 class Queue<T> extends LinkedList<T> {
    public void enqueue(T item) {
        add(item);  
    }

    public T dequeue() {
        if (getSize() == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        return remove(0); 
    }
}

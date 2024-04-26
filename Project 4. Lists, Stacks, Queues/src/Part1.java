import java.util.Iterator;
import java.util.NoSuchElementException;
public class Part1 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(0, 10);
        int element = linkedList.get(1);
        linkedList.addFirst(15);
        int removedElement = linkedList.remove(2);
        linkedList.removeAll(10);
        int size = linkedList.getSize();
        Iterator<Integer> iterator = linkedList.iterator();

        while (iterator.hasNext()) {
            int nextElement = iterator.next();
            System.out.println(nextElement);
        }

        System.out.println("Element: " + element);
        System.out.println("Removed Element: " + removedElement);
        System.out.println("Size: " + size);
        System.out.println(linkedList);
    }
}
 class LinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        T element;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public void add(T e) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void add(int index, T element) {
        if (index == size) {
            add(element);
        } else {
            Node<T> x = getNode(index);
            final Node<T> pred = x.prev;
            final Node<T> newNode = new Node<>(pred, element, x);
            x.prev = newNode;
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            size++;
        }
    }

    public T get(int index) {
        return getNode(index).element;
    }

    public void addFirst(T e) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    public T remove(int index) {
        Node<T> x = getNode(index);
        return unlink(x);
    }

    public boolean remove(T e) {
        for (Node<T> x = first; x != null; x = x.next) {
            if (e.equals(x.element)) {
                unlink(x);
                return true;
            }
        }
        return false;
    }

    public void removeAll(T e) {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
            if (e.equals(x.element)) {
                unlink(x);
            }
            x = next;
        }
    }

    public int getSize() {
        return size;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }   

    private class ListIterator implements Iterator<T> {
        private Node<T> lastReturned;
        private Node<T> next;
        private int nextIndex;

        ListIterator() {
            next = first;
            nextIndex = 0;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.element;
        }
    }

    private Node<T> getNode(int index) {
        Node<T> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    private T unlink(Node<T> x) {
        final T element = x.element;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.element = null;
        size--;
        return element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> x = first;
        while (x != null) {
            sb.append(x.element.toString());
            if (x.next != null) sb.append(", ");
            x = x.next;
        }
        return sb.toString();
    }
}

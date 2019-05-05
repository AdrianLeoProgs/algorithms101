package practice.section3_linked_lists;

public class MyLinkedList<T> implements ILinkedList<T> {
    private Node<T> head;
    private Node<T> last;
    private int size;

    @Override
    public void insert(int index, T obj) {
        if (head == null) {
            addFront(obj);
            return;
        }
        Node<T> newNode = new Node<>(obj);
        Node<T> current = head;
        int iteration = 0;
        while (current.getNext() != null) {
            if (iteration == index - 1) {
                Node<T> temp = current.getNext();
                current.setNext(newNode);
                current.getNext().setNext(temp);
            }
            current = current.getNext();
            iteration++;
        }
        size++;
    }

    @Override
    public void addFront(T obj) {
        Node<T> newNode = new Node<>(obj);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    @Override
    public void addBack(T obj) {
        Node<T> newNode = new Node<>(obj);
        last = newNode;
        if (head == null) {
            addFront(obj);
            return;
        }
        Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        size++;
        current.setNext(newNode);
    }

    @Override
    public T delete(T val) {
        if (head == null) {
            return null;
        }
        if (head.getValue().equals(val)) {
            head = head.getNext();
        }

        Node<T> current = head;
        T deleted;
        while (current.getNext() != null) {
            if (current.getNext().getValue().equals(val)) {
                deleted = current.getNext().getValue();
                current.setNext(current.getNext().getNext());
                size--;
                return deleted;
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public boolean contains(Object obj) {
        if (head == null) {
            return false;
        }

        Node<T> current = head;
        while (current != null) {
            if (current.getValue().equals(obj)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public T get(int index) throws Exception {
        checkEmpty();
        Node<T> current = head;
        int iteration = 0;
        while (current.getNext() != null) {
            if (iteration == index) {
                return current.getValue();
            }
            current = current.getNext();
            iteration++;
        }
        return null;
    }

    @Override
    public T getFirst() throws Exception{
        checkEmpty();
        return head.getValue();
    }

    @Override
    public T getLast() throws Exception {
        checkEmpty();
        if (last != null) {
            return last.getValue();
        }
        Node<T> current = head;
        while (current.getNext() != null) {
                current = current.getNext();
        }
        last = current;
        return last.getValue();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            builder.append("[ ")
                    .append(current.getValue())
                    .append(" ]")
                    .append(current.getNext() == null ? "" : " -> ");
            current = current.getNext();
        }
        return builder.toString();
    }

    private void checkEmpty() throws Exception {
        if (head == null) {
            throw new Exception("List is empty.");
        }
    }
}

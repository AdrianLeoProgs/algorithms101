package practice.section3_linked_lists;

public interface ILinkedList<T> {

    void insert(int index, T obj);

    void addFront(T obj);

    void addBack(T obj);

    T delete(T val);

    boolean contains(T obj);

    T get(int index) throws Exception;

    T getFirst() throws Exception;

    T getLast() throws Exception;

    int getSize();

    void clear();
}

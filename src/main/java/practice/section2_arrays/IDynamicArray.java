package practice.section2_arrays;

public interface IDynamicArray<T> {

    T[] getArray();

    void insert(int index, T obj) throws ArrayIndexOutOfBoundsException;

    void add(T obj);

    T delete(int index) throws ArrayIndexOutOfBoundsException;

    boolean contains(T obj);

    T get(int index) throws ArrayIndexOutOfBoundsException;

    T getFirst();

    T getLast();

    int getSize();

    int getCapacity();
}

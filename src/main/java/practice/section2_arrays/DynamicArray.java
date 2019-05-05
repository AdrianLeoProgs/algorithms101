package practice.section2_arrays;

import java.util.Arrays;

public class DynamicArray<T> implements IDynamicArray<T> {
    private T[] array;
    private final ArraySupplier<T> supplier;
    private int capacity;
    private int size;

    DynamicArray(ArraySupplier<T> supplier, int capacity) {
        this.supplier = supplier;
        this.capacity = capacity;
        this.array = this.supplier.get(capacity);
        this.size = 0;
    }

    @Override
    public T[] getArray() {
        return array;
    }

    @Override
    public void insert(int index, T obj) throws ArrayIndexOutOfBoundsException {
        if (size == capacity) {
            resize();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        this.array[index] = obj;
        incrementSize();
    }

    @Override
    public void add(T obj) {
        if (size == this.capacity) {
            resize();
        }
        this.array[size] = obj;
        incrementSize();
    }

    @Override
    public T delete(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= this.capacity) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        T deletedObj = this.array[index];
        for (int i = index; i < this.size; i++) {
                this.array[i] = this.array[i + 1];
        }
        decrementSize();
        return deletedObj;
    }

    @Override
    public T get(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= this.capacity) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return this.array[index];
    }

    @Override
    public boolean contains(T obj) {
        for (T item : array) {
            if (item.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T getFirst() {
        return this.array[0];
    }

    @Override
    public T getLast() {
        return this.array[this.size - 1];
    }

    @Override
    public int getCapacity() {
        return this.array.length;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    private void resize() {
        capacity *= 2;
        T[] temp = supplier.get(capacity);
        System.arraycopy(this.array, 0, temp, 0, this.array.length);
        this.array = temp;
    }

    private void incrementSize() {
        this.size++;
    }

    private void decrementSize() {
        this.size--;
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "array=" + Arrays.toString(array) +
                ", supplier=" + supplier +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }
}
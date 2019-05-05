package practice.section2_arrays;

@FunctionalInterface
public interface ArraySupplier<T> {
    T[] get(int capacity);
}

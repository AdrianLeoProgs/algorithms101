package practice.section2_arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {
    private IDynamicArray<Object> arr;

    @Before
    public void setUp() {
        this.arr = new DynamicArray<>(Object[]::new, 10);
    }

    @Test
    public void insertTest() {
        for (int i = 0; i < 10; i++) {
            arr.insert(i, i + 1);
        }
        Assert.assertEquals(10, arr.getSize());
        Assert.assertEquals(6, (int) arr.get(5));
        Assert.assertEquals(10, arr.getLast());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void insertOutOfBounds() {
        arr.insert(11, 323);
    }

    @Test
    public void addTest() {
        for (int i = 0; i < 20; i++) {
            this.arr.add(i + 1);
        }
        Assert.assertEquals(1, (int) arr.getFirst());
        Assert.assertEquals(20, (int) arr.getLast());
        Assert.assertEquals(20, arr.getSize());
        Assert.assertEquals(20, arr.getCapacity());
    }

    @Test
    public void addInsertTest() {
        arr.add(0);
        arr.add(1);
        arr.add(2);

        arr.insert(1, 987);

        Assert.assertEquals(4, arr.getSize());
        Assert.assertEquals(0, (int) arr.get(0));
        Assert.assertEquals(987, (int) arr.get(1));
        Assert.assertEquals(1, (int) arr.get(2));
        Assert.assertEquals(2, (int) arr.get(3));
    }

    @Test
    public void deleteTest() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        arr.delete(2);
        Assert.assertEquals(1, (int ) arr.get(0));
        Assert.assertEquals(2, (int ) arr.get(1));
        Assert.assertEquals(4, (int ) arr.get(2));
        Assert.assertEquals(5, (int ) arr.get(3));
        Assert.assertEquals(6, (int ) arr.get(4));
    }
}

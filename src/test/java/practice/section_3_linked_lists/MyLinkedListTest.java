package practice.section_3_linked_lists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import practice.section3_linked_lists.ILinkedList;
import practice.section3_linked_lists.MyLinkedList;

public class MyLinkedListTest {
    private ILinkedList<Object> linkedList;

    @Before
    public void setUp() {
        linkedList = new MyLinkedList<>();
    }

    @Test
    public void addInsertDeleteContainsTest() throws Exception {
        linkedList.addFront("hey");
        linkedList.addBack("there");
        linkedList.addBack("guys");
        Assert.assertEquals(3, linkedList.getSize());

        linkedList.insert(1, "lol");
        Assert.assertEquals(4, linkedList.getSize());

        Assert.assertEquals("lol", linkedList.delete("lol"));
        Assert.assertEquals(3, linkedList.getSize());
        Assert.assertTrue(linkedList.contains("guys"));

        linkedList.clear();
        linkedList.addBack("trying again");
        Assert.assertTrue(linkedList.contains("trying again"));
        Assert.assertEquals(1, linkedList.getSize());
        Assert.assertEquals("trying again", linkedList.getLast());
    }
}

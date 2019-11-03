package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private ImmutableArrayList empty;
    private ImmutableArrayList oneEl;
    private ImmutableArrayList array;

    @Before
    public void setUp() {
        empty = new ImmutableArrayList();
        Object[] data1 = {1};
        oneEl = new ImmutableArrayList(data1);
        Object[] data = {1, "2", 3.0};
        array = new ImmutableArrayList(data);
    }
    @Test
    public void testAdd() {
        Object[] exp = {1,"2", 3.0, 4};
        Object[] expEmpty = {1, "2"};
        ImmutableArrayList arr = (ImmutableArrayList) empty.add(1);
        ImmutableArrayList arr1 = (ImmutableArrayList) arr.add(1, "2");
        ImmutableArrayList arr2 = (ImmutableArrayList) oneEl.add(3.0);
        ImmutableArrayList arr3 = (ImmutableArrayList) arr2.add(1, "2");
        ImmutableArrayList arr4 = (ImmutableArrayList) arr3.add(4);
        ImmutableArrayList arr5 = (ImmutableArrayList) array.add(4);
        ImmutableArrayList expectedEmpty = new ImmutableArrayList(expEmpty);
        ImmutableArrayList expected = new ImmutableArrayList(exp);
        assertArrayEquals(arr1.toArray(), expectedEmpty.toArray());
        assertArrayEquals(arr4.toArray(), expected.toArray());
        assertArrayEquals(arr5.toArray(), expected.toArray());
    }
    @Test
    public void testAddAll() {
        Object[] exp = {1,"2", 3.0, 4, "5"};
        ImmutableArrayList expected = new ImmutableArrayList(exp);
        Object[] empty1 = {3.0, 4, "5"};
        Object[] empty2 = {1,"2"};
        ImmutableArrayList arr = (ImmutableArrayList) empty.addAll(empty1);
        ImmutableArrayList emptyAct = (ImmutableArrayList) arr.addAll(0, empty2);
        Object[] one1 = {3.0, 4, "5"};
        Object[] one2 = {"2"};
        ImmutableArrayList arr1 = (ImmutableArrayList) oneEl.addAll(one1);
        ImmutableArrayList oneAct = (ImmutableArrayList) arr1.addAll(1, one2);
        Object[] array1 = {"5"};
        Object[] array2 = {4};
        ImmutableArrayList arr2 = (ImmutableArrayList) array.addAll(array1);
        ImmutableArrayList arrayAct = (ImmutableArrayList) arr2.addAll(3, array2);
        assertArrayEquals(emptyAct.toArray(), expected.toArray());
        assertArrayEquals(oneAct.toArray(), expected.toArray());
        assertArrayEquals(arrayAct.toArray(), expected.toArray());

    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWrongIndex() {
        empty.get(3);
    }

    @Test
    public void testGet() {
        Object a = array.get(1);
        Object b = array.get(2);
        assertEquals(a, "2");
        assertEquals(b, 3.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWrongIndex() {
        empty.remove(3);
    }

    @Test
    public void testRemove() {
        ImmutableArrayList actual = (ImmutableArrayList) array.remove(1);
        ImmutableArrayList expected = new ImmutableArrayList(new Object[]{1, 3.0});
        assertArrayEquals(actual.toArray(), expected.toArray());

    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWrongIndex() {
        empty.set(3, "1");
    }

    @Test
    public void testIndexOf() {
        int a = array.indexOf("2");
        int b = array.indexOf(5);
        assertEquals(a, 1);
        assertEquals(b, -1);
    }


    @Test
    public void testClear() {
        ImmutableArrayList actual = (ImmutableArrayList) array.clear();
        ImmutableArrayList expected = new ImmutableArrayList();
        assertArrayEquals(actual.toArray(), expected.toArray());

    }
}

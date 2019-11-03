package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    private ImmutableLinkedList empty;
    private ImmutableLinkedList oneEl;
    private ImmutableLinkedList list;

    @Before
    public void setUp() {
        empty = new ImmutableLinkedList();
        Object[] data1 = {1};
        oneEl = new ImmutableLinkedList(data1);
        Object[] data = {1, "2", 3.0};
        list = new ImmutableLinkedList(data);
    }

    @Test
    public void testAdd() {
        Object[] exp = {1, "2", 3.0, 4};
        Object[] expEmpty = {1, "2"};
        ImmutableLinkedList arr = (ImmutableLinkedList) empty.add(1);
        ImmutableLinkedList arr1 = (ImmutableLinkedList) arr.add(1, "2");
        ImmutableLinkedList arr2 = (ImmutableLinkedList) oneEl.add(3.0);
        ImmutableLinkedList arr3 = (ImmutableLinkedList) arr2.add(1, "2");
        ImmutableLinkedList arr4 = (ImmutableLinkedList) arr3.add(4);
        ImmutableLinkedList arr5 = (ImmutableLinkedList) list.add(4);
        ImmutableLinkedList expectedEmpty = new ImmutableLinkedList(expEmpty);
        ImmutableLinkedList expected = new ImmutableLinkedList(exp);
        assertArrayEquals(arr1.toArray(), expectedEmpty.toArray());
        assertArrayEquals(arr4.toArray(), expected.toArray());
        assertArrayEquals(arr5.toArray(), expected.toArray());
    }

    @Test
    public void testAddAll() {
        Object[] exp = {1, "2", 3.0, 4, "5"};
        ImmutableLinkedList expected = new ImmutableLinkedList(exp);
        Object[] empty1 = {3.0, 4, "5"};
        Object[] empty2 = {1, "2"};
        ImmutableLinkedList arr = (ImmutableLinkedList) empty.addAll(empty1);
        ImmutableLinkedList emptyAct = (ImmutableLinkedList) arr.addAll(0, empty2);
        Object[] one1 = {3.0, 4, "5"};
        Object[] one2 = {"2"};
        ImmutableLinkedList arr1 = (ImmutableLinkedList) oneEl.addAll(one1);
        ImmutableLinkedList oneAct = (ImmutableLinkedList) arr1.addAll(1, one2);
        Object[] array1 = {"5"};
        Object[] array2 = {4};
        ImmutableLinkedList arr2 = (ImmutableLinkedList) list.addAll(array1);
        ImmutableLinkedList arrayAct = (ImmutableLinkedList) arr2.addAll(3, array2);
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
        Object a = list.get(1);
        Object b = list.get(2);
        assertEquals(a, "2");
        assertEquals(b, 3.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWrongIndex() {
        empty.remove(-3);
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList actual = (ImmutableLinkedList) list.remove(0);
        ImmutableLinkedList expected = new ImmutableLinkedList(new Object[]{"2", 3.0});
        ImmutableLinkedList actual1 = (ImmutableLinkedList) list.remove(2);
        ImmutableLinkedList expected1 = new ImmutableLinkedList(new Object[]{1, "2"});
        assertArrayEquals(actual.toArray(), expected.toArray());
        assertArrayEquals(actual1.toArray(), expected1.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWrongIndex() {
        empty.set(3, "1");
    }

    @Test
    public void testSet() {
        ImmutableLinkedList actual = (ImmutableLinkedList) list.set(1, 5);
        ImmutableLinkedList expected = new ImmutableLinkedList(new Object[]{1, 5, 3.0});
        assertArrayEquals(actual.toArray(), expected.toArray());
    }

    @Test
    public void testIndexOf() {
        int a = list.indexOf("2");
        int b = list.indexOf(5);
        assertEquals(a, 1);
        assertEquals(b, -1);
    }


    @Test
    public void testClear() {
        ImmutableLinkedList actual = (ImmutableLinkedList) list.clear();
        ImmutableLinkedList expected = new ImmutableLinkedList();
        assertArrayEquals(actual.toArray(), expected.toArray());

    }

    @Test
    public void testSize() {
        int a = empty.size();
        int b = list.size();
        assertEquals(a, 0);
        assertEquals(b, 3);

    }

    @Test
    public void testEmpty() {
        boolean a = empty.isEmpty();
        boolean b = list.isEmpty();
        assertTrue(a);
        assertFalse(b);

    }

    @Test
    public void testToString() {
        String a = list.toString();
        assertEquals(a, "{1, 2, 3.0}");

    }

    @Test(expected = NullPointerException.class)
    public void testGetFirstEmpty() {
        empty.getFirst();
    }

    @Test
    public void testGetFirst() {
        Object a = list.getFirst();
        Object b = oneEl.getFirst();
        assertEquals(a, 1);
        assertEquals(b, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLastEmpty() {
        empty.getLast();
    }

    @Test
    public void testGetLast() {
        Object a = list.getLast();
        Object b = oneEl.getLast();
        assertEquals(a, 3.0);
        assertEquals(b, 1);
    }

    public void testAddFirst() {
        ImmutableLinkedList a = list.addFirst(1);
        ImmutableLinkedList b = oneEl.addFirst(2);
        assertArrayEquals(a.toArray(), new Object[]{1, 1, "2", 3.0});
        assertArrayEquals(b.toArray(), new Object[]{2, 1});
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList a = list.addLast(1);
        ImmutableLinkedList b = oneEl.addLast(2);
        assertArrayEquals(a.toArray(), new Object[]{1, "2", 3.0, 1});
        assertArrayEquals(b.toArray(), new Object[]{1, 2});
    }

    public void testRemoveFirst() {
        ImmutableLinkedList a = list.removeFirst();
        ImmutableLinkedList b = oneEl.removeFirst();
        assertArrayEquals(a.toArray(), new Object[]{"2", 3.0});
        assertArrayEquals(b.toArray(), new Object[]{});
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList a = list.removeLast();
        ImmutableLinkedList b = oneEl.removeLast();
        assertArrayEquals(a.toArray(), new Object[]{1, "2"});
        assertArrayEquals(b.toArray(), new Object[]{});
    }



}

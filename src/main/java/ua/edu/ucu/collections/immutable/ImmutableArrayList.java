package ua.edu.ucu.collections.immutable;


public class ImmutableArrayList implements ImmutableList {

    private int length;
    private static final int DEFAULT_LENGTH = 10;
    private Object[] elements;

    public ImmutableArrayList() {
        this.elements = new Object[DEFAULT_LENGTH];
        this.length = 0;
    }

    public ImmutableArrayList(Object[] arrayGiven) {
        this.length = arrayGiven.length;
        this.elements = new Object[arrayGiven.length];
        System.arraycopy(arrayGiven, 0, this.elements, 0, arrayGiven.length);
    }

    public int getLength() {
        return this.length;
    }

    private void indexCheck(int index) {
        if (index != 0 && index > this.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    @Override
    public ImmutableList add(Object e) {
        return this.add(this.length, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] newElement = new Object[1];
        newElement[0] = e;
        return this.addAll(index, newElement);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return this.addAll(0, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        this.indexCheck(index);
        if (index < this.length) {
            this.length = index;
        }
        Object[] newElements = new Object[this.length + c.length];
        System.arraycopy(this.elements, 0, newElements, 0, this.length);
        System.arraycopy(c, 0, newElements, this.length, c.length);
        return new ImmutableArrayList(newElements);
    }

    @Override
    public Object get(int index) {
        this.indexCheck(index);
        return this.elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        this.indexCheck(index);
        Object[] newElements = new Object[this.length - 1];
        System.arraycopy(this.elements, 0, newElements, 0, index);
        if (index + 1 < this.length) {
            System.arraycopy(this.elements, index + 1, newElements, index, this.length - index - 1);
        }
        return new ImmutableArrayList(newElements);

    }

    @Override
    public ImmutableList set(int index, Object e) {
        this.indexCheck(index);
        Object[] newElements = this.toArray();
        newElements[index] = e;
        return new ImmutableArrayList(newElements);

    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.length; i++) {
            if (this.elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.getLength();
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newElements = new Object[this.length];
        System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
        return newElements;
    }

}



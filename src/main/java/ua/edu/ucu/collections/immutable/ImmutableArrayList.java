package ua.edu.ucu.collections.immutable;


public class ImmutableArrayList implements ImmutableList {

    private int length;
    private static final int DEFAULT_LENGTH = 0;
    private Object[] elements;

    public ImmutableArrayList() {
        elements = new Object[DEFAULT_LENGTH];
        length = 0;
    }

    public ImmutableArrayList(Object[] arrayGiven) {
        length = arrayGiven.length;
        elements = new Object[arrayGiven.length];
        System.arraycopy(arrayGiven, 0, elements, 0, arrayGiven.length);
    }

    private void indexCheck(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    @Override
    public ImmutableList add(Object e) {
        return add(length, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] newElement = new Object[1];
        newElement[0] = e;
        return addAll(index, newElement);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        indexCheck(index);
        Object[] newElements = new Object[length + c.length];
        System.arraycopy(elements, 0, newElements, 0, index);
        System.arraycopy(c, 0, newElements, index, c.length);
        System.arraycopy(elements, index, newElements, index+c.length, length-index);
        return new ImmutableArrayList(newElements);
    }

    @Override
    public Object get(int index) {
        indexCheck(index);
        return elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        indexCheck(index);
        Object[] newElements = new Object[length - 1];
        System.arraycopy(elements, 0, newElements, 0, index);
        if (index + 1 < length) {
            System.arraycopy(elements, index + 1, newElements, index, length - index - 1);
        }
        return new ImmutableArrayList(newElements);

    }

    @Override
    public ImmutableList set(int index, Object e) {
        indexCheck(index);
        Object[] newElements = toArray();
        newElements[index] = e;
        return new ImmutableArrayList(newElements);

    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < length; i++) {
            if (elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newElements = new Object[length];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        return newElements;
    }

    @Override
    public String toString(){
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("{");
        for (int i = 0; i < length; i++){
            toReturn.append(elements[i]);
            if (i != length - 1){
                toReturn.append(", ");
            }
        }
        toReturn.append("}");
        return toReturn.toString();
    }


}



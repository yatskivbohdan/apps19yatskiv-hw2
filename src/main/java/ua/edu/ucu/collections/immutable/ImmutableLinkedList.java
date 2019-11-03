package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private int length;

    public ImmutableLinkedList() {
        head = null;
        length = 0;
    }

    public ImmutableLinkedList(Object[] array) {
        length = array.length;
        head = new Node(array[0]);
        Node currentNode = head;
        for (int i = 1; i < length; i++) {
            currentNode.setNext(new Node(array[i]));
            currentNode = currentNode.getNext();
        }
    }

    public void indexCheck(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(e);
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(length - 1);
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(length - 1);
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
        if (length == 0) {
            return new ImmutableLinkedList(c);
        }
        indexCheck(index);
        Object[] array = toArray();
        Object[] newArray = new Object[length + c.length];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(c, 0, newArray, index, c.length);
        System.arraycopy(array, index, newArray, index+c.length, length-index);
        return new ImmutableLinkedList(newArray);
    }

    @Override
    public Object get(int index) {
        indexCheck(index);
        int currentIndex = 0;
        Node currentNode = head;
        while (currentIndex != index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return currentNode.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        indexCheck(index);
        ImmutableLinkedList newList = makeCopy();
        int currentIndex = 0;
        Node currentNode = newList.head;
        if (index == 0) {
            newList.head = currentNode.getNext();
            newList.length--;
            return newList;
        }
        while (currentIndex != index - 1) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        currentNode.setNext(currentNode.getNext().getNext());
        newList.length--;
        return newList;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        indexCheck(index);
        ImmutableLinkedList newList = makeCopy();
        int currentIndex = 0;
        Node currentNode = newList.head;
        while (currentIndex != index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        currentNode.setValue(e);
        return newList;
    }

    @Override
    public int indexOf(Object e) {
        ImmutableLinkedList newList = makeCopy();
        Node currentNode = newList.head;
        for (int i = 0; i < newList.length; i++) {
            if (currentNode.getValue() == e) {
                return i;
            } else {
                currentNode = currentNode.getNext();
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
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] toReturn = new Object[length];
        Node currentNode = head;
        for (int i = 0; i < length; i++) {
            toReturn[i] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }
        return toReturn;
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("{");
        Node currentNode = head;
        for (int i = 0; i < length; i++) {
            toReturn.append(currentNode.getValue());
            if (i != length - 1) {
                toReturn.append(", ");
            }
            currentNode = currentNode.getNext();
        }
        toReturn.append("}");
        return toReturn.toString();
    }

    public ImmutableLinkedList makeCopy() {
        if (isEmpty()) {
            return new ImmutableLinkedList();
        }
        ImmutableLinkedList newList = new ImmutableLinkedList();
        newList.head = new Node(head.getValue());
        newList.length = length;
        Node currentNode = head.getNext();
        Node currentNode1 = newList.head;
        while (currentNode != null) {
            currentNode1.setNext(new Node(currentNode.getValue()));
            currentNode1 = currentNode1.getNext();
            currentNode = currentNode.getNext();
        }
        return newList;
    }
}

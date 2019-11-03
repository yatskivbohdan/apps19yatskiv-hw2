package ua.edu.ucu.collections.immutable;

public class Node {
    private Node next;

    private Object value;

    public Node(Object value) {
        this.value = value;
        next = null;

    }
    public Node(Object value, Node next) {
        this.value = value;
        this.next = next;

    }

    public Object getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}

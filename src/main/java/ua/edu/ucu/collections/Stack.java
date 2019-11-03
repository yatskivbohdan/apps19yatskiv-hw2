package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList list;

    public Stack(){
        list = new ImmutableLinkedList();
    }

    public Object peek(){
        return list.getFirst();
    }

    public void push(Object item){
        list = list.addFirst(item);
    }

    public Object pop(){
        Object item = list.getFirst();
        list = list.removeFirst();
        return item;
    }
}

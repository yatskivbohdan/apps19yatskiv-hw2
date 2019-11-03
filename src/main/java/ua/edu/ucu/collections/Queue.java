package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList list;

    public Queue(){
        list = new ImmutableLinkedList();
    }

    public Object peek(){
        return list.getFirst();
    }

    public void enqueue(Object item){
        list = list.addLast(item);
    }

    public Object dequeue(){
        Object item = list.getFirst();
        list = list.removeFirst();
        return item;
    }
}

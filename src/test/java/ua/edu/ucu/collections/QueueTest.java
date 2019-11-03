package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    private Queue queue;

    @Before
    public void setUp(){
        queue = new Queue();
    }

    @Test
    public void testEnqueue(){
        for(int i = 0; i<10; i++){
            queue.enqueue(i);
            assertEquals(queue.peek(), 0);
        }
    }

    @Test
    public void testDequeue(){
        for(int i=0; i<10; i++){
            queue.enqueue(i);
        }
        for(int i=9; i>1; i--){
            Object peek = queue.peek();
            Object item = queue.dequeue();
            assertEquals(peek, item);
        }
    }
    
}

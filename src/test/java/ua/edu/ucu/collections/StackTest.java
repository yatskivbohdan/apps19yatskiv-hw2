package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    private Stack stack;

    @Before
    public void setUp(){
        stack = new Stack();
    }

    @Test
    public void testPush(){
        for(int i=0; i<10; i++){
            stack.push(i);
            assertEquals(stack.peek(), i);
        }
        assertEquals(stack.peek(), 9);
    }

    @Test
    public void testPop(){
        for(int i=0; i<10; i++){
            stack.push(i);
        }
        for(int i=9; i>1; i--){
            Object peek = stack.peek();
            Object item = stack.pop();
            assertEquals(peek, item);
        }
    }
}

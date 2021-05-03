import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQueue {

    @Test
    //Testet, welche Größe eine Queue hat
    public void testSize() {
        Queue myQueue = new Queue();

        myQueue.enqueue(11);
        myQueue.enqueue(12);
        myQueue.enqueue(13);

        assertEquals(myQueue.size(), 3);

    }

    @Test
    //Testet, ob ein neues Element hinten in die Schlange eingefügt wird
    public void testEnqueue() {
        Queue myQueue = new Queue();

        myQueue.enqueue(1);
        myQueue.enqueue(2);

        assertEquals(myQueue.size(), 2);
    }

    @Test
    public void testDequeue() {
        Queue myQueue = new Queue();

        myQueue.enqueue(11);
        myQueue.enqueue(22);
        myQueue.dequeue();

        assertEquals(myQueue.size(), 1);
    }

    @Test
    public void testDequeues() {
        Queue myQueue = new Queue();

        myQueue.enqueue(11);
        myQueue.enqueue(22);
        myQueue.enqueue(11);
        myQueue.enqueue(22);

        myQueue.dequeue(3);
        Assertions.assertEquals(1, myQueue.size());
    }

    @Test
    //Testet, ob die Exception QueueTooSmall geworfen wird
    public void testQueueTooSmallWithZeroValues() {

        //von Leerem Stack soll etwas abgezogen werden - wift Exception
        Assertions.assertThrows(QueueTooSmallException.class, () -> {
            new Queue().dequeue();
        });
    }

    @Test
    //Testet, ob die Exception QueueTooSmall geworfen wird
    public void testQueueTooSmall() {

        //Die Exception, die geworfen werden soll steht vorher, die Auslöser in den {}
        Assertions.assertThrows(QueueTooSmallException.class, () -> {
            Queue myStack = new Queue();
            myStack.enqueue(1);
            myStack.enqueue(2);
            myStack.enqueue(3);
            myStack.enqueue(4);
            myStack.dequeue(5);
        });

    }


}

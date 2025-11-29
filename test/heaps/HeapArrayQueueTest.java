package heaps;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class HeapArrayQueueTest {

    @Test
    void testInitialSizeIsZero() {
        HeapArrayQueue<Integer, String> q = new HeapArrayQueue<>();
        assertEquals(0, q.size());
    }

    @Test
    void testAddSingleElement() {
        HeapArrayQueue<Integer, String> q = new HeapArrayQueue<>();
        q.add(10, "A");
        assertEquals(1, q.size());
        assertEquals("A", q.element());
    }

    @Test
    void testAddMaintainsHeapProperty() {
        HeapArrayQueue<Integer, String> q = new HeapArrayQueue<>();
        q.add(1, "A");
        q.add(10, "B");
        q.add(5, "C");

        assertEquals("B", q.element());
    }

    @Test
    void testRemoveThrowsExceptionWhenEmpty(){
        HeapArrayQueue<Integer,String> q = new HeapArrayQueue<>();
        assertThrows(NoSuchElementException.class,() -> q.remove());
    }

    @Test void testRemoveReturnsInCorrectOrderLeftOnly() {
        HeapArrayQueue<Integer, String> q = new HeapArrayQueue<>();
        q.add(3, "A"); q.add(10, "B");
        q.add(7, "C"); assertEquals("B", q.remove());
        assertEquals("C", q.remove()); assertEquals("A", q.remove());
        assertEquals(0, q.size());
    }

    @Test void testRemoveReturnsInCorrectOrderLeftSonBigger() {
        HeapArrayQueue<Integer, String> q = new HeapArrayQueue<>();
        q.add(3, "A");
        q.add(10, "B");
        q.add(7, "C");
        q.add(11, "D");
        assertEquals("D", q.remove());
        assertEquals("B", q.remove());
        assertEquals("C", q.remove());
        assertEquals("A", q.remove());
        assertEquals(0, q.size());
    }

    @Test void testRemoveReturnsInCorrectOrderRightSonBigger() {
        HeapArrayQueue<Integer, String> q = new HeapArrayQueue<>();
        q.add(11, "A");
        q.add(9, "B");
        q.add(10, "C");
        q.add(3, "D");
        assertEquals("A", q.remove());
        assertEquals("C", q.remove());
        assertEquals("B", q.remove());
        assertEquals("D", q.remove());
        assertEquals(0, q.size());
    }

    @Test
    void testStableOrderWithSamePriorityLeftOnly() {
        HeapArrayQueue<Integer, String> q = new HeapArrayQueue<>();
        q.add(5, "A");
        q.add(5, "B");
        q.add(5, "C");
        assertEquals("A", q.remove());
        assertEquals("B", q.remove());
        assertEquals("C", q.remove());
    }

    @Test
    void testStableOrderWithSamePriority() {
        HeapArrayQueue<Integer, String> q = new HeapArrayQueue<>();
        q.add(5, "A");
        q.add(5, "B");
        q.add(5, "C");
        q.add(5,"D");
        assertEquals("A", q.remove());
        assertEquals("B", q.remove());
        assertEquals("C", q.remove());
        assertEquals("D", q.remove());
    }

    @Test void testCapacityExpansion() {
        HeapArrayQueue<Integer, Integer> q = new HeapArrayQueue<>();

        for (int i = 0; i < 20; i++) {
            q.add(i, i);
        }

        assertEquals(20, q.size());
    }
}
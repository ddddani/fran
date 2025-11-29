package heaps;

import org.junit.jupiter.api.Test;

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

    @Test void testRemoveReturnsInCorrectOrder() {
        HeapArrayQueue<Integer, String> q = new HeapArrayQueue<>();
        q.add(3, "A"); q.add(10, "B");
        q.add(7, "C"); assertEquals("B", q.remove());
        assertEquals("C", q.remove()); assertEquals("A", q.remove());
        assertEquals(0, q.size());
    }

    @Test void testStableOrderWithSamePriority() {
        HeapArrayQueue<Integer, String> q = new HeapArrayQueue<>();
        q.add(5, "A");
        assertEquals("A", q.remove());
        assertEquals("B", q.remove());
        assertEquals("C", q.remove());
    }

    @Test void testCapacityExpansion() {
        HeapArrayQueue<Integer, Integer> q = new HeapArrayQueue<>();

        for (int i = 0; i < 20; i++) {
            q.add(i, i);
        }

        assertEquals(20, q.size());
    }
}
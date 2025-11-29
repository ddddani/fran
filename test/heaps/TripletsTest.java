package heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TripletsTest {

    @Test
    void testSomeCompare() {
        var triplet1 = new HeapArrayQueue.Triplet<Integer, Object>(
                1, 1L, new Object());
        var triplet2 = new HeapArrayQueue.Triplet<Integer, Object>(
                2, 2L, new Object());
        assertTrue(triplet2.compareTo(triplet1) > 0);
    }

    @Test void testPriorityComparison() {
        var t1 = new HeapArrayQueue.Triplet<>(1, 1L, "A");
        var t2 = new HeapArrayQueue.Triplet<>(2, 2L, "B");
        assertTrue(t2.compareTo(t1) > 0);
        assertTrue(t1.compareTo(t2) < 0);
    }

    @Test void testEqualPriorityUsesTimestamp() {
        var t1 = new HeapArrayQueue.Triplet<>(5, 1L, "A");
        var t2 = new HeapArrayQueue.Triplet<>(5, 2L, "B");
        assertTrue(t1.compareTo(t2) > 0);
    }
}

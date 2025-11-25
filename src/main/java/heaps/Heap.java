package heaps;

import java.util.PriorityQueue;

public class HeapArrayQueue<P extends Comparable<? super P>, V> implements PriorityQueue<P, V> {
    private static final int INITIAL_QUEUE_CAPACITY = 1;

    private Triplet<?, ?> triplets;
    private int size = 0;
    private long nexTimeStamp = 0L;
 }

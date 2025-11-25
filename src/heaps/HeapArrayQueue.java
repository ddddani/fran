package heaps;

import java.util.PriorityQueue;

public class HeapArrayQueue<P extends Comparable<? super P>, V> implements PriorityQueue<P, V> {
    private static final int INITIAL_QUEUE_CAPACITY = 1;

    private Triplet<?, ?> triplets;
    private int size = 0;
    private long nexTimeStamp = 0L;

    record Triplet<P extends Comparable<?super P>, V>
            (P priority, long timeStamp, V value) implements Comparable<Triplet<P, V>>{
        @Override
        public int compareTo(Triplet<P, V> other){
            return 2;
        }
    }
    public HeapArrayQueue(){

    }

}

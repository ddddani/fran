package heaps;

import java.util.NoSuchElementException;

public class HeapArrayQueue<P extends Comparable<? super P>, V> implements PriorityQueue<P, V> {
    private static final int INITIAL_QUEUE_CAPACITY = 1;

    private Triplet<P, V>[] triplets;
    private int size = 0;
    private long nextTimeStamp = 0L;

    record Triplet<P extends Comparable<?super P>, V>
            (P priority, long timeStamp, V value) implements Comparable<Triplet<P, V>>{

        @Override
        public int compareTo(Triplet<P, V> other){
            int cmp = this.priority.compareTo(other.priority);
            if (cmp != 0){
                return cmp;
            }
            int timeCmp = Long.compare(other.timeStamp, this.timeStamp);
            return timeCmp;
        }
    }

    public HeapArrayQueue(){
        this.triplets = new Triplet[INITIAL_QUEUE_CAPACITY];
        this.size = 0;
        this.nextTimeStamp = 0L;
    }

    private static int parentIndex(int i) {
        return i / 2;
    }
    private static int leftIndex(int i) {
        return i * 2;
    }
    private static int rightIndex(int i) {
        return i * 2 + 1;
    }
    private boolean exists(int index) {
        return 1 <= index && index <= size();
    }

    @Override
    public void add(P priority, V value){
        Triplet<P, V> trip = new Triplet<>(priority, nextTimeStamp, value);
        nextTimeStamp++;

        if (size + 1 == triplets.length) {
            ensureCapacity();
        }

        size++;
        triplets[size] = trip; int current = size;

        while (current > 1) { int parent = parentIndex(current);
            Triplet<P, V> currentTrip = triplets[current];
            Triplet<P, V> parentTrip = triplets[parent];

            if (currentTrip.compareTo(parentTrip) <= 0) {
                break;
            }

            swap(current, parent);
            current = parent;
        }
    }

    @Override
    public V remove(){
        if(element() == null) throw new NoSuchElementException();
        var E = element();
        swap(1, size());
        triplets[size] = null;
        size --;
        int current = 1;
        while(exists(leftIndex(current))) {
            Triplet<P, V> actual = triplets[current];
            Triplet<P, V> leftSon = triplets[leftIndex(current)];

            if (!exists(rightIndex(current))) {
                if (actual.compareTo(leftSon) > 0) break;
                swap(current, leftIndex(current));
                current = leftIndex(current);
            } else {
                Triplet<P, V> rightSon = triplets[rightIndex(current)];
                if (actual.compareTo(leftSon) > 0 && actual.compareTo(rightSon) > 0) break;
                if (leftSon.compareTo(rightSon) > 0) {
                    swap(current, leftIndex(current));
                    current = leftIndex(current);
                } else {
                    swap(current, rightIndex(current));
                    current = rightIndex(current);
                }
            }
        }
        return E;
    }

    @Override
    public V element(){
        if(size() == 0) throw new NoSuchElementException();
        return triplets[1].value;
    }

    public int size(){
        return size;
    }

    private void swap(int i, int j) {
        Triplet<P,V> temporal = triplets[i];
        triplets[i] = triplets[j];
        triplets[j] = temporal;
    }

    private void ensureCapacity(){
        Triplet<P, V>[] newArray = new Triplet[triplets.length * 2];
        System.arraycopy(triplets, 0, newArray, 0, triplets.length);
        triplets = newArray;
    }
}

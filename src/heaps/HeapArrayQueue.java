package heaps;

import java.util.NoSuchElementException;

public class HeapArrayQueue<P extends Comparable<? super P>, V> implements PriorityQueue<P, V> {
    private static final int INITIAL_QUEUE_CAPACITY = 1;

    private Triplet<?, ?>[] triplets;
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
            int timeCmp = Long.compare(this.timeStamp, other.timeStamp);
            return timeCmp;
        }
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
    public HeapArrayQueue(){
        this.triplets = new Triplet[INITIAL_QUEUE_CAPACITY];
        this.size = 0;
        this.nextTimeStamp = 0L;
    }

    @Override
    public void add(P priority, V value){
        Triplet<P, V> trip = new Triplet<>(priority, nextTimeStamp, value);
        nextTimeStamp++;
        if (size + 1 == triplets.length) {
            ensureCapacity();
        } size++; triplets[size] = trip; int current = size;
        while (current > 1) { int parent = parentIndex(current);
            Triplet<P, V> currentTrip = (Triplet<P, V>) triplets[current];
            Triplet<P, V> parentTrip = (Triplet<P, V>) triplets[parent];
            if (currentTrip.compareTo(parentTrip) <= 0) {
                break;
            } swap(current, parent);
            current = parent;
        }
    }

    @Override
    public V remove(){
        var E = element();
        swap(1, size());
        triplets[size] = null;
        while(true){
            if(){} //HAZ EL PUTISIMO METODO DE LOS PADRES
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V element(){
        if(size() == 0) throw new NoSuchElementException();
        return (V) triplets[1].value;
    }

    public int size(){
        return size;
    }
    @SuppressWarnings("unchecked")
    private void swap(int i, int j) {
        Triplet<P,V> temporal = (Triplet<P, V>) triplets[i];
        triplets[i] = triplets[j];
        triplets[j] = temporal;
    }
    private void ensureCapacity(){
        Triplet<P, V>[] newArray = new Triplet[triplets.length * 2];
        System.arraycopy(triplets, 0, newArray, 0, triplets.length);
        triplets = newArray;
    }
}

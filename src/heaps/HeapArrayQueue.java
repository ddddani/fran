package heaps;

import java.util.NoSuchElementException;

import static java.util.Collections.swap;

public class HeapArrayQueue<P extends Comparable<? super P>, V> implements PriorityQueue<P, V> {
    private static final int INITIAL_QUEUE_CAPACITY = 1;

    private Triplet<?, ?>[] triplets;
    private int size = 0;
    private long nexTimeStamp = 0L;

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
    public HeapArrayQueue(){
        this.triplets = new Triplet[INITIAL_QUEUE_CAPACITY];
        this.size = 0;
        this.nexTimeStamp = 0L;
    }

    @Override
    public void add(P priority, V value){

    }

    @Override
    public V remove(){
        var E = element();
        swap(1, size());
        triplets[size] = null;
        while(true){
            if(HAZ EL PUTISIMO METODO DE LOS PADRES)
        }
    }




    @Override
    @SuppressWarnings("unchecked")
    public V element(){
        if(size() == 0) throw NoSuchElementException;
        return (V) triplets[1].value;
    }

    public int size(){

    }
    @SuppressWarnings("unchecked")
    private void swap(int i, int j) {
        Triplet<P,V> temporal = (Triplet<P, V>) triplets[i];
        triplets[i] = triplets[j];
        triplets[j] = temporal;
    }

    private static int position(){

    }
}

package ds.graph.valued;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Graph {
    int v;
    AtomicInteger i;
    List<ValuedVertex> vertices;

    private final Lock readLock;
    private final Lock writeLock;

    Graph( int v ) {
        this.v = v;
        this.vertices = new ArrayList<ValuedVertex>();

        final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        readLock = rwLock.readLock();
        writeLock = rwLock.writeLock();
    }

    void addVertices(int... values) {
        writeLock.lock();
        try {
            for(int val : values) {
                this.vertices.add( new ValuedVertex( i.incrementAndGet(), val ) );
            }
        } finally {
            writeLock.unlock();
        }
    }

    void addEdge( int src, int dest ) {
        this.vertices.get(src).neighbours.add(this.vertices.get(dest));
        this.vertices.get(dest).neighbours.add(this.vertices.get(src));
    }

    void removeEdge( int src, int dest ) {
        this.vertices.get(src).neighbours.remove(this.vertices.get(dest));
        this.vertices.get(dest).neighbours.remove(this.vertices.get(src));
    }

    void addVertex(int val) {
        writeLock.lock();
        try {
            this.vertices.add( new ValuedVertex( i.incrementAndGet(), val ) );
        } finally {
            writeLock.unlock();
        }
    }

    void removeVertex( int i ) {
        writeLock.lock();
        try {
            ValuedVertex v = this.vertices.remove(i);
            v.neighbours.forEach(vertex -> vertex.neighbours.remove(v));
        } finally {
            writeLock.unlock();
        }
    }

    void removeVertex( ValuedVertex v ) {
        writeLock.lock();
        try {
            this.vertices.remove(v);
            v.neighbours.forEach(vertex -> vertex.neighbours.remove(v));
        } finally {
            writeLock.unlock();
        }
    }

    class ValuedVertex {
        int idx;
        int val;
        List<ValuedVertex> neighbours;
        PriorityQueue<ValuedVertex> pq;

        ValuedVertex(int idx, int val) {
            this.idx = idx;
            this.val = val;
            this.neighbours = new ArrayList<ValuedVertex>();
        }

        ValuedVertex(int idx, int val, Comparator<ValuedVertex> comparator) {
            this.idx = idx;
            this.val = val;
            this.pq = new PriorityQueue<ValuedVertex>(comparator);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ValuedVertex vertex = (ValuedVertex) o;
            return idx == vertex.idx;
        }

        @Override
        public int hashCode() {
            return Objects.hash(idx);
        }
    }
}

package ds.graph.labeledvalued;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Graph {
    int v;
    AtomicInteger idx;
    List<LabeledValuedVertex> vertices;
    Map<String, Integer> vertexIdxMap;

    private final Lock readLock;
    private final Lock writeLock;

    Graph(int v) {
        this.v = v;
        this.i = new AtomicInteger();
        this.vertices = new ArrayList<LabeledValuedVertex>();
        this.vertexIdxMap = new LinkedHashMap<String, Integer>();

        final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        readLock = rwLock.readLock();
        writeLock = rwLock.writeLock();
    }

    void addVertices(String[] labels, int[] values) {
        writeLock.lock();
        try {
            int n = labels.length;
            for(int i = 0; i < n; i++) {
                this.vertices.add( new LabeledValuedVertex( idx.incrementAndGet(), values[i], labels[i]) );
            }
        } finally {
            writeLock.unlock();
        }
    }

    void addEdge( String src, int val1, String dest, int val2 ) {
        writeLock.lock();
        try {
            Integer s = vertexIdxMap.get(src);
            if(s == null) {
                s = idx.incrementAndGet();
                vertexIdxMap.put(src, s);
                this.vertices.add(s, new LabeledValuedVertex(s, val1, src));
            }
            Integer d = vertexIdxMap.get(dest);
            if(d == null) {
                d = idx.incrementAndGet();
                vertexIdxMap.put(dest, d);
                this.vertices.add(d, new LabeledValuedVertex(d, val2, dest));
            }
            this.vertices.get(s).neighbours.add(this.vertices.get(d));
            this.vertices.get(d).neighbours.add(this.vertices.get(s));
        } finally {
            writeLock.unlock();
        }
    }

    void addEdge( int src, int dest ) {
        this.vertices.get(src).neighbours.add(this.vertices.get(dest));
        this.vertices.get(dest).neighbours.add(this.vertices.get(src));
    }

    void removeEdge( String src, String dest ) {
        writeLock.lock();
        try {
            Integer s = vertexIdxMap.get(src);
            Integer d = vertexIdxMap.get(dest);
            this.vertices.get(s).neighbours.remove(this.vertices.get(d));
            this.vertices.get(d).neighbours.remove(this.vertices.get(s));
            vertexIdxMap.remove(s);
            vertexIdxMap.remove(d);
        } finally {
            writeLock.unlock();
        }
    }

    void removeEdge( int src, int dest ) {
        this.vertices.get(src).neighbours.remove(this.vertices.get(dest));
        this.vertices.get(dest).neighbours.remove(this.vertices.get(src));
    }

    void addVertex( String src, int val ) {
        writeLock.lock();
        try {
            Integer s = idx.incrementAndGet();
            vertexIdxMap.put(src, s);
            this.vertices.add(s, new LabeledValuedVertex(s, val, src));
        } finally {
            writeLock.unlock();
        }
    }

    void removeVertex( int i ) {
        writeLock.lock();
        try {
            LabeledValuedVertex v = this.vertices.remove(i);
            v.neighbours.forEach(vertex -> vertex.neighbours.remove(v));
            vertexIdxMap.remove(v.label);
        } finally {
            writeLock.unlock();
        }
    }

    void removeVertex( LabeledValuedVertex v ) {
        writeLock.lock();
        try {
            this.vertices.remove(v);
            v.neighbours.forEach(vertex -> vertex.neighbours.remove(v));
            vertexIdxMap.remove(v.label);
        } finally {
            writeLock.unlock();
        }
    }

    class LabeledValuedVertex {
        int idx;
        int val;
        String label;
        List<LabeledValuedVertex> neighbours;
        PriorityQueue<LabeledValuedVertex> pq;

        LabeledValuedVertex(int idx, int val, String label) {
            this.idx = idx;
            this.val = val;
            this.label = label;
            this.neighbours = new ArrayList<LabeledValuedVertex>();
        }

        LabeledValuedVertex(int idx, int val, String label, Comparator<LabeledValuedVertex> comparator) {
            this.idx = idx;
            this.val = val;
            this.label = label;
            this.pq = new PriorityQueue<LabeledValuedVertex>(comparator);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LabeledValuedVertex vertex = (LabeledValuedVertex) o;
            return idx == vertex.idx;
        }

        @Override
        public int hashCode() {
            return Objects.hash(idx);
        }
    }
}

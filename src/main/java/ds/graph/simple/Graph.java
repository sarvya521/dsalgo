package ds.graph.simple;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Graph {
    int v;
    List<Vertex> vertices;

    private final Lock readLock;
    private final Lock writeLock;

    Graph( int v ) {
        this.v = v;
        this.vertices = new ArrayList<Vertex>();
        for (int idx = 0; idx < v; idx++) {
            this.vertices.add(new Vertex(idx));
        }

        final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        readLock = rwLock.readLock();
        writeLock = rwLock.writeLock();
    }

    void addEdge( int src, int dest ) {
        this.vertices.get(src).neighbours.add(this.vertices.get(dest));
        this.vertices.get(dest).neighbours.add(this.vertices.get(src));
    }

    void removeEdge( int src, int dest ) {
        this.vertices.get(src).neighbours.remove(this.vertices.get(dest));
        this.vertices.get(dest).neighbours.remove(this.vertices.get(src));
    }

    void addVertex() {
        writeLock.lock();
        try {
            this.vertices.add(new Vertex(this.vertices.size()));
        } finally {
            writeLock.unlock();
        }
    }

    void removeVertex( int i ) {
        writeLock.lock();
        try {
            Vertex v = this.vertices.remove(i);
            v.neighbours.forEach(vertex -> vertex.neighbours.remove(v));
        } finally {
            writeLock.unlock();
        }
    }

    void removeVertex( Vertex v ) {
        writeLock.lock();
        try {
            this.vertices.remove(v);
            v.neighbours.forEach(vertex -> vertex.neighbours.remove(v));
        } finally {
            writeLock.unlock();
        }
    }

    class Vertex {
        int idx;
        List<Vertex> neighbours;

        Vertex( int idx ) {
            this.idx = idx;
            this.neighbours = new ArrayList<Vertex>();
        }

        @Override
        public boolean equals( Object o ) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return idx == vertex.idx;
        }

        @Override
        public int hashCode() {
            return Objects.hash(idx);
        }
    }
}

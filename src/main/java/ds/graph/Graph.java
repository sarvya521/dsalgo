package ds.graph;

import java.util.*;

public class Graph {
    int v;
    int i;
    List<Vertex> vertices;
    Map<Vertex, Integer> vertexIdxMap;

    Graph(int v, int i, int vertices) {
        this.v = v;
        this.i = i;
        this.vertices = new ArrayList<Vertex>();
        for(int idx = 0; idx < v; idx++) {
            this.vertices.add(new Vertex(idx));
        }
    }

    void addEdge( int src, int dest ) {
        this.vertices.get(src).neighbours.add(this.vertices.get(dest));
        this.vertices.get(dest).neighbours.add(this.vertices.get(src));
    }

    class Vertex {
        int idx;
        List<Vertex> neighbours;

        Vertex(int idx) {
            this.idx = idx;
            this.neighbours = new ArrayList<Vertex>();
        }
    }

    class LabeledVertex {
        int idx;
        String label;
        List<Vertex> neighbours;

        LabeledVertex(int idx, String label) {
            this.idx = idx;
            this.label = label;
            this.neighbours = new ArrayList<Vertex>();
        }
    }

    class ValuedVertex {
        int idx;
        int val;
        List<Vertex> neighbours;
        PriorityQueue<Vertex> pq;

        ValuedVertex(int idx, int val) {
            this.idx = idx;
            this.val = val;
            this.neighbours = new ArrayList<Vertex>();
        }

        ValuedVertex(int idx, int val, Comparator<Vertex> comparator) {
            this.idx = idx;
            this.val = val;
            this.pq = new PriorityQueue<Vertex>(comparator);
        }
    }

    class LabledValuedVertex {
        int idx;
        int val;
        String label;
        List<Vertex> neighbours;
        PriorityQueue<Vertex> pq;

        LabledValuedVertex(int val, int idx, String label) {
            this.idx = idx;
            this.val = val;
            this.label = label;
            this.neighbours = new ArrayList<Vertex>();
        }

        LabledValuedVertex(int val, int idx, String label, Comparator<Vertex> comparator) {
            this.idx = idx;
            this.val = val;
            this.label = label;
            this.pq = new PriorityQueue<Vertex>(comparator);
        }
    }
}

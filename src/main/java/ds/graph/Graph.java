package ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    public static void main(String[] args) {
        Graph g = new Graph();
        Graph.Node a = g.new Node("A");
        Graph.Node b = g.new Node("B");

        Graph.Edge e = g.new Edge();
        e.setDestination(b);
        e.setWeight(1.0);

        a.addEdge(e);

        a.getEdges().get(0).getDestination();// returns the destination Node of the first Edge

        a.getEdges().get(0).getWeight();// returns the weight of the first Edge

        List<List<Integer>> list = new ArrayList<List<Integer>>();
    }

    class Node {
        private String label;
        private List<Graph.Edge> edges;

        public Node(String label) {
            this.label = label;
            this.edges = new ArrayList<Graph.Edge>();
        }

        public String getLabel() {
            return label;
        }

        public List<Graph.Edge> getEdges() {
            return edges;
        }

        public void addEdge(Graph.Edge edge) {
            this.edges.add(edge);
        }

    }

    class Edge {
        private Graph.Node destination;
        private double weight;

        public Graph.Node getDestination() {
            return destination;
        }

        public void setDestination(Graph.Node destination) {
            this.destination = destination;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

    }
}


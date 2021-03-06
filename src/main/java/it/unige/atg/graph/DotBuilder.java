package it.unige.atg.graph;

import org.jgrapht.EdgeFactory;
import org.jgrapht.io.Attribute;
import org.jgrapht.io.ComponentUpdater;
import org.jgrapht.io.EdgeProvider;
import org.jgrapht.io.VertexProvider;

import java.util.Map;

public class DotBuilder implements VertexProvider<Vertex>, EdgeProvider<Vertex, Edge>, EdgeFactory<Vertex, Edge>, ComponentUpdater<Vertex> {

    @Override
    public Vertex buildVertex(String id, Map<String, Attribute> attributes) {
        return new Vertex(id, attributes);
    }

    @Override
    public Edge buildEdge(Vertex from, Vertex to, String label, Map<String, Attribute> attributes) {
        return new Edge(from, to, label, attributes);
    }

    @Override
    public Edge createEdge(Vertex sourceVertex, Vertex targetVertex) {
        return new Edge(sourceVertex, targetVertex, "", null);
    }

    @Override
    public void update(Vertex vertex, Map<String, Attribute> map) {
        vertex.getAttributes().putAll(map);
    }
}

package it.unige.atg;

import it.unige.atg.graph.Edge;
import it.unige.atg.graph.Vertex;
import org.jgrapht.Graph;
import org.jgrapht.event.ConnectedComponentTraversalEvent;
import org.jgrapht.event.EdgeTraversalEvent;
import org.jgrapht.event.TraversalListener;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

import java.util.*;

public class BAVisitor implements TraversalListener<Vertex, Edge> {

    HashSet<Literal> literals;
    HashMap<Vertex, List<Path>> paths;
    Graph<Vertex, Edge> graph;

    public BAVisitor(Graph<Vertex, Edge> graph) {
        this.graph = graph;
        literals = new HashSet<>();
        paths = new HashMap<>();

        for(Vertex v :graph.vertexSet())
            paths.put(v, new ArrayList<>());
    }

    public void visit() {
        Optional<Vertex> initV = graph.vertexSet().stream().filter(v -> v.getId().equals("I")).findFirst();

        GraphIterator<Vertex, Edge> iterator =
                new DepthFirstIterator<Vertex, Edge>(graph, initV.get());

        iterator.addTraversalListener(this);

        paths.get(initV.get()).add(new Path());

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public HashMap<Vertex, List<Path>> getPaths() {
        return paths;
    }


    public List<Vertex> findFinalStates() {
        List<Vertex> vertexList = new ArrayList<>();
        for(Vertex v : graph.vertexSet())
            if(v.getAttributes().containsKey("peripheries"))
                vertexList.add(v);
        return vertexList;
    }

    private void addPaths(Edge e, Step s) {
        List<Path> targetPaths = paths.get(e.getTarget());
        List<Path> sourcePaths = paths.get(e.getSource());

        List<Path> newPaths = new ArrayList<>();
        sourcePaths.forEach(p -> newPaths.add(new Path(p)));

        for(Path p : newPaths)
            p.append(s);

        targetPaths.addAll(newPaths);
    }

    @Override
    public void connectedComponentFinished(ConnectedComponentTraversalEvent e) {

    }

    @Override
    public void connectedComponentStarted(ConnectedComponentTraversalEvent e) {

    }

    @Override
    public void edgeTraversed(EdgeTraversalEvent<Edge> e) {
        System.out.println(e.getEdge());
        Literal l = new Literal(e.getEdge().getLabel(), false);
        Set<Literal> literals = new HashSet<>();
        literals.add(l);
        addPaths(e.getEdge(), new Step(e.getEdge(), literals));
    }

    @Override
    public void vertexTraversed(VertexTraversalEvent<Vertex> e) {

    }

    @Override
    public void vertexFinished(VertexTraversalEvent<Vertex> e) {

    }
}

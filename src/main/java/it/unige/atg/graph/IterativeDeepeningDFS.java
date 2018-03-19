package it.unige.atg.graph;

import it.unige.atg.Literal;
import it.unige.atg.Path;
import it.unige.atg.Step;
import org.jgrapht.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IterativeDeepeningDFS {

    List<ArrayList<String>> paths;
    final Graph<Vertex, Edge> graph;
    final int maxIterations;

    public IterativeDeepeningDFS(Graph<Vertex, Edge> graph, int maxIterations) {
        this.paths = new ArrayList<>();
        this.graph = graph;
        this.maxIterations = maxIterations;
    }

    public void iddfs() {
        Vertex[] initStates = graph.vertexSet().stream().filter(v -> v.getId().equals("I")).toArray((n)-> new Vertex[n]);

        for(Vertex v: initStates) {
            System.out.println("Init State: " + v);
            for(Edge e: graph.edgesOf(v))
                System.out.println(e);
        }

        for(int i = 1; i < maxIterations; ++i) {
            System.out.println("Iteration " + i);
            for(Vertex v : initStates) {
                dfs(v, i + 1, new ArrayList<String>());
            }
        }
    }

    private void dfs(Vertex v, int n, ArrayList<String> path) {

        if(n < 0) {
            throw new IllegalArgumentException("n can't be lower then 0");
        }

        if(n == 0) {
            if(v.isAcceptingState()) {
                addPath(path);
            }
            return;
        }

        Set<Edge> edges = graph.outgoingEdgesOf(v);

        for(Edge e: edges) {
            path.add(e.getLabel());
            dfs(e.getTarget(), n - 1, path);
            path.remove(path.size() - 1);
        }

    }

    public Set<Literal> getLiterals(String label) {
        Set<Literal> literals = new HashSet<>();
        literals.add(new Literal(label, false));
        return literals;
    }

    private void addPath(ArrayList<String> path) {
        //paths.add(new ArrayList<>(path));
        //System.out.println(path);
    }

    public List<ArrayList<String>> getPaths() {
        return paths;
    }

}

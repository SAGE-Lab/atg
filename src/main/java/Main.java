import it.unige.atg.BAVisitor;
import it.unige.atg.Path;
import it.unige.atg.graph.DotBuilder;
import it.unige.atg.graph.Edge;
import it.unige.atg.graph.IterativeDeepeningDFS;
import it.unige.atg.graph.Vertex;
import org.jgrapht.Graph;
import org.jgrapht.graph.DirectedPseudograph;
import org.jgrapht.io.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void log(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws FileNotFoundException, ImportException {

        DotBuilder db = new DotBuilder();
        Graph<Vertex, Edge> g = new DirectedPseudograph<Vertex, Edge>(db);

        DOTImporter<Vertex, Edge> importer = new DOTImporter<>(db, db, db);

        importer.importGraph(g, new FileInputStream("car.dot"));

        System.out.println("N of vertex: " + g.vertexSet().size());
        System.out.println("N of edges: " + g.edgeSet().size());

//        BAVisitor visitor = new BAVisitor(g);
//
//        visitor.visit();
//
//
//
//
//        List<Vertex> finalStates = visitor.findFinalStates();
//
//        for(Vertex v : finalStates) {
//            System.out.println(v);
//            List<Path> paths = visitor.getPaths().get(v);
//            for(Path p : paths)
//                System.out.println(p);
//        }

        System.out.println("Accepting States: ");
        for(Vertex v: g.vertexSet())
            if(v.isAcceptingState())
                System.out.println(v);

        IterativeDeepeningDFS pathFinder = new IterativeDeepeningDFS(g, g.vertexSet().size() + 1);

        pathFinder.iddfs();

        for(ArrayList<String> p: pathFinder.getPaths())
            System.out.println(p);

    }
}

package it.unige.atg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Path {

    LinkedList<Step> path;

    public Path() {
        path = new LinkedList<>();
    }

    public Path(Path p) {
        path = new LinkedList<>(p.getSteps());
    }

    public List<Step> getSteps() {
        return path;
    }

    public Path append(Step s) {
        path.add(s);
        return this;
    }

    public Path removeLast() {
        path.removeLast();
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Step s : path) {
            sb.append("[" + s.getEdge() + " " + s.getLiterals().iterator().next() +"]");
            if(path.get(path.size() - 1) != s)
                sb.append(", ");
        }

        return sb.toString();
    }

}

package it.unige.atg;

import it.unige.atg.graph.Edge;

import java.util.Set;

public class Step {

    Edge e;
    Set<Literal> literals;

    public Step(Edge e, Set<Literal> literals) {
        this.e = e;
        this.literals = literals;
    }

    public Edge getEdge() {
        return e;
    }

    public Set<Literal> getLiterals() {
        return literals;
    }


}

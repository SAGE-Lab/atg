package it.unige.atg;

import java.util.Set;

public class Assignment {

    Set<Literal> literalSet;

    public Assignment(Set<Literal> literals) {
        this.literalSet = literals;
    }

    public Set<Literal> getLiterals() {
        return literalSet;
    }
}

package it.unige.atg;

public class Literal {

    String label;
    boolean negate;

    public Literal(String label, boolean negate) {
        this.label = label;
        this.negate = negate;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Literal))
            return false;
        Literal l = (Literal) obj;
        return label.equals(l.label) && negate == l.negate;
    }

    @Override
    public String toString() {
        return label;
    }
}

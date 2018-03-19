package it.unige.atg.graph;

import it.unige.atg.Assignment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Trie implements Iterable<Trie.TrieNode> {

    @Override
    public Iterator<TrieNode> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super TrieNode> consumer) {

    }

    @Override
    public Spliterator<TrieNode> spliterator() {
        return null;
    }

    public class TrieNode {
        private HashMap<String, TrieNode> children;
        private Assignment assignment;
        private boolean isPath;

    }

}

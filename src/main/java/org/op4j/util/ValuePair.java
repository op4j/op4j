package org.op4j.util;

public final class ValuePair<T> {

    private final T left;
    private final T right;


    
    public ValuePair(T left, T right) {
        super();
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return this.left;
    }

    public T getRight() {
        return this.right;
    }
    
}

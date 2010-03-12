package org.op4j.util;

public final class ValuePair<L,R> {

    private final L left;
    private final R right;


    
    public ValuePair(L left, R right) {
        super();
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }
    
}

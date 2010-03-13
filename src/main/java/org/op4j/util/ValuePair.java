package org.op4j.util;

import org.javaruntype.type.Type;
import org.javaruntype.type.TypeParameters;
import org.javaruntype.type.Types;

public final class ValuePair<L,R> {

    @SuppressWarnings("unchecked")
    public static final Type<ValuePair<?,?>> TYPE_VALUE_PAIR_OF_UNKNOWN = 
        (Type<ValuePair<?,?>>) Types.forName(ValuePair.class.getName() + "<?,?>");
    
    public static final <L,R> Type<ValuePair<L,R>> TYPE_VALUE_PAIR_OF(final Type<L> leftType, final Type<R> rightType) { 
        return Types.forClass(ValuePair.class, TypeParameters.forType(leftType), TypeParameters.forType(rightType));
    }
    
    
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

/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
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

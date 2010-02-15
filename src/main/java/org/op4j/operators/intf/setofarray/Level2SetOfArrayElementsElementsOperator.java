/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
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
package org.op4j.operators.intf.setofarray;

import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableArrayElementsOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2SetOfArrayElementsElementsOperator<T>
        extends UniqOperator<Set<T[]>>,
                NavigatingCollectionOperator<T>,
        		ExecutableArrayElementsOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                CastableToTypeOperator<T> {



    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifNull();
    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifNotNull();
    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval);

    
    public Level1SetOfArrayElementsOperator<T> endFor();
    
    public Level2SetOfArrayElementsElementsOperator<T> replaceWith(final T replacement);
    public Level2SetOfArrayElementsElementsOperator<T> replaceIfNullWith(final T replacement);


    public Level2SetOfArrayElementsElementsOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function);
    public Level2SetOfArrayElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function);
    public <X> Level2SetOfArrayElementsElementsOperator<X> execIfNotNull(final Type<X> type, final IFunction<X,? super T> function);
    public <X> Level2SetOfArrayElementsElementsOperator<X> exec(final Type<X> type, final IFunction<X,? super T> function);
    
    public <X> Level2SetOfArrayElementsElementsOperator<X> asType(final Type<X> type);
    public Level2SetOfArrayElementsElementsOperator<?> asUnknown();
        
    }

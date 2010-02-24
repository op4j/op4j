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
package org.op4j.operators.intf.set;

import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
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
public interface Level1SetElementsOperator<T,I>
        extends UniqOperator<Set<T>>,
        		NavigatingCollectionOperator<T>,
        		ExecutableOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                CastableToTypeOperator<T> {



    public Level1SetElementsSelectedOperator<T,I> ifIndex(final int... indexes);
    public Level1SetElementsSelectedOperator<T,I> ifTrue(final IFunction<Boolean, ? super T> eval);
    public Level1SetElementsSelectedOperator<T,I> ifFalse(final IFunction<Boolean, ? super T> eval);
    public Level1SetElementsSelectedOperator<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level1SetElementsSelectedOperator<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level1SetElementsSelectedOperator<T,I> ifNull();
    public Level1SetElementsSelectedOperator<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level1SetElementsSelectedOperator<T,I> ifIndexNot(final int... indexes);
    public Level1SetElementsSelectedOperator<T,I> ifNotNull();
    public Level1SetElementsSelectedOperator<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval);


    
    public Level0SetOperator<T,I> endFor();
    
    public Level1SetElementsOperator<T,I> replaceWith(final T replacement);
    public Level1SetElementsOperator<T,I> replaceIfNullWith(final T replacement);


    public <X> Level1SetElementsOperator<X,I> execIfNotNull(final IFunction<X,? super T> function);

    public <X> Level1SetElementsOperator<X,I> exec(final IFunction<X, ? super T> function);
    
    public <X> Level1SetElementsOperator<X,I> asType(final Type<X> type);
    public Level1SetElementsOperator<?,I> asUnknown();
    
                                    
}

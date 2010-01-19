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
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.CastableToMapOperator;
import org.op4j.operators.qualities.CastableToSetOperator;
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
public interface Level1SetElementsOperator<T>
        extends UniqOperator<Set<T>>,
                CastableToArrayOperator,
                CastableToListOperator,
                CastableToMapOperator,
                CastableToSetOperator,
        		NavigatingCollectionOperator<T>,
        		ExecutableOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                CastableToTypeOperator<T> {



    public Level1SetElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1SetElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetElementsSelectedOperator<T> ifNull();
    public Level1SetElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1SetElementsSelectedOperator<T> ifNotNull();
    public Level1SetElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);


    
    public Level0SetOperator<T> endFor();
    
    public Level1SetElementsOperator<T> replaceBy(final T replacement);
    public Level1SetElementsOperator<T> replaceIfNullBy(final T replacement);


    public <X> Level1SetElementsOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> Level1SetElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public <X> Level1SetElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> Level1SetElementsOperator<X> asType(final Type<X> type);
    public Level1SetElementsOperator<?> asUnknown();
        
    public <X> Level1SetOfArrayElementsOperator<X> asArrayOf(final Type<X> type);
    public <X> Level1SetOfListElementsOperator<X> asListOf(final Type<X> type);
    public <K,V> Level1SetOfMapElementsOperator<K,V> asMapOf(final Type<K> keyType, final Type<V> valueType);
    public <X> Level1SetOfSetElementsOperator<X> asSetOf(final Type<X> type);
    public Level1SetOfArrayElementsOperator<?> asArrayOfUnknown();
    public Level1SetOfListElementsOperator<?> asListOfUnknown();
    public Level1SetOfMapElementsOperator<?,?> asMapOfUnknown();
    public Level1SetOfSetElementsOperator<?> asSetOfUnknown();
    
                                    
}

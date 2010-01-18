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
package org.op4j.operators.intf.list;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.CastableToMapOperator;
import org.op4j.operators.qualities.CastableToSetOperator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1ListElementsOperator<T>
        extends UniqOperator<List<T>>,
                CastableToArrayOperator,
                CastableToListOperator,
                CastableToMapOperator,
                CastableToSetOperator,
                NavigatingCollectionOperator<T>,
        		ExecutableOperator<T>,
                SelectableOperator<T>,
                CastableToTypeOperator<T> {



    public Level1ListElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1ListElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListElementsSelectedOperator<T> ifNull();
    public Level1ListElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1ListElementsSelectedOperator<T> ifNotNull();
    public Level1ListElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);


    
    public Level0ListOperator<T> endFor();
    
    public <X> Level1ListElementsOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> Level1ListElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public <X> Level1ListElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> Level1ListElementsOperator<X> asType(final Type<X> type);
    public Level1ListElementsOperator<?> asUnknown();
        
    public <X> Level1ListOfArrayElementsOperator<X> asArrayOf(final Type<X> type);
    public <X> Level1ListOfListElementsOperator<X> asListOf(final Type<X> type);
    public <K,V> Level1ListOfMapElementsOperator<K,V> asMapOf(final Type<K> keyType, final Type<V> valueType);
    public <X> Level1ListOfSetElementsOperator<X> asSetOf(final Type<X> type);
    public Level1ListOfArrayElementsOperator<?> asArrayOfUnknown();
    public Level1ListOfListElementsOperator<?> asListOfUnknown();
    public Level1ListOfMapElementsOperator<?,?> asMapOfUnknown();
    public Level1ListOfSetElementsOperator<?> asSetOfUnknown();
    
                                    
}

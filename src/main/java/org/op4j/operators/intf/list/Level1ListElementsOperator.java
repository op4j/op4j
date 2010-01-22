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
public interface Level1ListElementsOperator<T,I>
        extends UniqOperator<List<T>,I>,
                CastableToArrayOperator<I>,
                CastableToListOperator<I>,
                CastableToMapOperator<I>,
                CastableToSetOperator<I>,
                NavigatingCollectionOperator<T,I>,
        		ExecutableOperator<T,I>,
                SelectableOperator<T,I>,
                ReplaceableOperator<T,I>,
                ReplaceableIfNullOperator<T,I>,
                CastableToTypeOperator<T,I> {



    public Level1ListElementsSelectedOperator<T,I> ifIndex(final int... indices);
    public Level1ListElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListElementsSelectedOperator<T,I> ifNull();
    public Level1ListElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListElementsSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level1ListElementsSelectedOperator<T,I> ifNotNull();
    public Level1ListElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);


    
    public Level0ListOperator<T,I> endFor();
    
    public Level1ListElementsOperator<T,I> replaceWith(final T replacement);
    public Level1ListElementsOperator<T,I> replaceIfNullWith(final T replacement);


    public <X> Level1ListElementsOperator<X,I> convert(final IConverter<X,? super T> converter);
    
    public <X> Level1ListElementsOperator<X,I> eval(final IEvaluator<X,? super T> eval);

    public <X> Level1ListElementsOperator<X,I> exec(final IFunction<X, ? super T> function);
    
    public <X> Level1ListElementsOperator<X,I> asType(final Type<X> type);
    public Level1ListElementsOperator<?,I> asUnknown();
        
    public <X> Level1ListOfArrayElementsOperator<X,I> asArrayOf(final Type<X> type);
    public <X> Level1ListOfListElementsOperator<X,I> asListOf(final Type<X> type);
    public <K,V> Level1ListOfMapElementsOperator<K,V,I> asMapOf(final Type<K> keyType, final Type<V> valueType);
    public <X> Level1ListOfSetElementsOperator<X,I> asSetOf(final Type<X> type);
    public Level1ListOfArrayElementsOperator<?,I> asArrayOfUnknown();
    public Level1ListOfListElementsOperator<?,I> asListOfUnknown();
    public Level1ListOfMapElementsOperator<?,?,I> asMapOfUnknown();
    public Level1ListOfSetElementsOperator<?,I> asSetOfUnknown();
    
                                    
}

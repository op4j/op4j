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
package org.op4j.operators.intf.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.qualities.CastableToArrayOperator;
import org.op4j.operators.qualities.CastableToListOperator;
import org.op4j.operators.qualities.CastableToMapOperator;
import org.op4j.operators.qualities.CastableToSetOperator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.NavigatingArrayOperator;
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
public interface Level1ArrayElementsOperator<T,I>
        extends UniqOperator<T[],I>,
                CastableToArrayOperator<I>,
                CastableToListOperator<I>,
                CastableToMapOperator<I>,
                CastableToSetOperator<I>,
                NavigatingArrayOperator<T,I>,
                SelectableOperator<T,I>,
                ReplaceableOperator<T,I>,
                ReplaceableIfNullOperator<T,I>,
                ExecutableOperator<T,I>,
                CastableToTypeOperator<T,I> {



    public Level1ArrayElementsSelectedOperator<T,I> ifIndex(final int... indices);
    public Level1ArrayElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T,I> ifNull();
    public Level1ArrayElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level1ArrayElementsSelectedOperator<T,I> ifNotNull();
    public Level1ArrayElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);


		    
    public Level0ArrayOperator<T,I> endFor();
    
    public Level1ArrayElementsOperator<T,I> replaceWith(final T replacement);
    public Level1ArrayElementsOperator<T,I> replaceIfNullWith(final T replacement);


    public <X> Level1ArrayElementsOperator<X,I> convert(final IConverter<X,? super T> converter);
    public <X> Level1ArrayElementsOperator<X,I> eval(final IEvaluator<X,? super T> eval);
    public <X> Level1ArrayElementsOperator<X,I> exec(final IFunction<X,? super T> function);
    
    
    public <X> Level1ArrayElementsOperator<X,I> asType(final Type<X> type);
    public Level1ArrayElementsOperator<?,I> asUnknown();
        
    public <X> Level1ArrayOfArrayElementsOperator<X,I> asArrayOf(final Type<X> type);
    public <X> Level1ArrayOfListElementsOperator<X,I> asListOf(final Type<X> type);
    public <K,V> Level1ArrayOfMapElementsOperator<K,V,I> asMapOf(final Type<K> keyType, final Type<V> valueType);
    public <X> Level1ArrayOfSetElementsOperator<X,I> asSetOf(final Type<X> type);
    public Level1ArrayOfArrayElementsOperator<?,I> asArrayOfUnknown();
    public Level1ArrayOfListElementsOperator<?,I> asListOfUnknown();
    public Level1ArrayOfMapElementsOperator<?,?,I> asMapOfUnknown();
    public Level1ArrayOfSetElementsOperator<?,I> asSetOfUnknown();
	
    
}

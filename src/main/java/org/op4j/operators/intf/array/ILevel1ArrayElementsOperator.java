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
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.operators.qualities.ICastableToArrayOperator;
import org.op4j.operators.qualities.ICastableToListOperator;
import org.op4j.operators.qualities.ICastableToMapOperator;
import org.op4j.operators.qualities.ICastableToSetOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.INavigatingCollectionOperator;
import org.op4j.operators.qualities.ICastableToTypeOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel1ArrayElementsOperator<T> 
		extends IUniqOperator<T[]>,
		        ICastableToArrayOperator,
                ICastableToListOperator,
                ICastableToMapOperator,
                ICastableToSetOperator,
                INavigatingCollectionOperator<T>,
                IConvertibleOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ICastableToTypeOperator<T> {

		    
    public ILevel0ArrayOperator<T> endFor();
    
    public <X> ILevel1ArrayElementsOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> ILevel1ArrayElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public <X> ILevel1ArrayElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel1ArrayElementsOperator<X> asType(final Type<X> type);
    public ILevel1ArrayElementsOperator<?> asUnknown();
        
    public <X> ILevel1ArrayOfArrayElementsOperator<X> asArray(final Type<X> of);
    public <X> ILevel1ArrayOfListElementsOperator<X> asList(final Type<X> of);
    public <K,V> ILevel1ArrayOfMapElementsOperator<K,V> asMap(final Type<K> keyOf, final Type<V> valueOf);
    public <X> ILevel1ArrayOfSetElementsOperator<X> asSet(final Type<X> of);
    public ILevel1ArrayOfArrayElementsOperator<?> asArrayOfUnknown();
    public ILevel1ArrayOfListElementsOperator<?> asListOfUnknown();
    public ILevel1ArrayOfMapElementsOperator<?,?> asMapOfUnknown();
    public ILevel1ArrayOfSetElementsOperator<?> asSetOfUnknown();
	
    
}

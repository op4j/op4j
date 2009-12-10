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
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
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
public interface ILevel1ListElementsOperator<T> 
		extends IUniqOperator<List<T>>,
                ICastableToArrayOperator,
                ICastableToListOperator,
                ICastableToMapOperator,
                ICastableToSetOperator,
                INavigatingCollectionOperator<T>,
                IConvertibleOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ICastableToTypeOperator<T> {

    
    public ILevel0ListOperator<T> endFor();
    
    public <X> ILevel1ListElementsOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> ILevel1ListElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public <X> ILevel1ListElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel1ListElementsOperator<X> asType(final Type<X> type);
    public ILevel1ListElementsOperator<?> asUnknown();
        
    public <X> ILevel1ListOfArrayElementsOperator<X> asArrayOf(final Type<X> type);
    public <X> ILevel1ListOfListElementsOperator<X> asListOf(final Type<X> type);
    public <K,V> ILevel1ListOfMapElementsOperator<K,V> asMapOf(final Type<K> keyType, final Type<V> valueType);
    public <X> ILevel1ListOfSetElementsOperator<X> asSetOf(final Type<X> type);
    public ILevel1ListOfArrayElementsOperator<?> asArrayOfUnknown();
    public ILevel1ListOfListElementsOperator<?> asListOfUnknown();
    public ILevel1ListOfMapElementsOperator<?,?> asMapOfUnknown();
    public ILevel1ListOfSetElementsOperator<?> asSetOfUnknown();
    
                                    
}

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
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.operators.qualities.ICastableToArrayOperator;
import org.op4j.operators.qualities.ICastableToListOperator;
import org.op4j.operators.qualities.ICastableToMapOperator;
import org.op4j.operators.qualities.ICastableToSetOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.INavigatingCollectionOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel1SetElementsOperator<T> 
		extends IUniqOperator<Set<T>>,
                ICastableToArrayOperator,
                ICastableToListOperator,
                ICastableToMapOperator,
                ICastableToSetOperator,
        		INavigatingCollectionOperator<T>,
        		IConvertibleOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {

    
    public ILevel0SetOperator<T> endFor();
    
    public <X> ILevel1SetElementsOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> ILevel1SetElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public <X> ILevel1SetElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel1SetElementsOperator<X> of(final Type<X> of);
        
    public ILevel1SetElementsOperator<?> raw();
    
    
    
    public <X> ILevel1SetOfArrayElementsOperator<X> asArray(final Type<X> of);
    public <X> ILevel1SetOfListElementsOperator<X> asList(final Type<X> of);
    public <K,V> ILevel1SetOfMapElementsOperator<K,V> asMap(final Type<K> keyOf, final Type<V> valueOf);
    public <X> ILevel1SetOfSetElementsOperator<X> asSet(final Type<X> of);
    public ILevel1SetOfArrayElementsOperator<?> asArrayOfUnknown();
    public ILevel1SetOfListElementsOperator<?> asListOfUnknown();
    public ILevel1SetOfMapElementsOperator<?,?> asMapOfUnknown();
    public ILevel1SetOfSetElementsOperator<?> asSetOfUnknown();
    
                                    
}

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
package org.op4j.operators.intf.map;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.mapofarray.ILevel2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.operators.qualities.ICastableToArrayOperator;
import org.op4j.operators.qualities.ICastableToListOperator;
import org.op4j.operators.qualities.ICastableToMapOperator;
import org.op4j.operators.qualities.ICastableToSetOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.INavigatingMapEntryOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel2MapEntriesValueOperator<K,V>
		extends IUniqOperator<Map<K,V>>,
                ICastableToArrayOperator,
                ICastableToListOperator,
                ICastableToMapOperator,
                ICastableToSetOperator,
				INavigatingMapEntryOperator,
                IConvertibleOperator<V>,
        		IEvaluableOperator<V>,
        		IExecutableOperator<V>,
                ITypeParameterizableXOperator<V> {
    
    public ILevel1MapEntriesOperator<K,V> endOn();
    
    public <X> ILevel2MapEntriesValueOperator<K,X> convert(final IConverter<X,? super V> converter);
    
    public <X> ILevel2MapEntriesValueOperator<K,X> eval(final IEvaluator<X,? super V> eval);

    public <X> ILevel2MapEntriesValueOperator<K,X> exec(final IFunction<X, ? super V> function);
    
    public <X> ILevel2MapEntriesValueOperator<K,X> of(final Type<X> of);
    
        
    public ILevel2MapEntriesValueOperator<K,?> raw();
    

    
    
    public <X> ILevel2MapOfArrayEntriesValueOperator<K,X> asArray(final Type<X> of);
    public <X> ILevel2MapOfListEntriesValueOperator<K,X> asList(final Type<X> of);
    public <K2,V2> ILevel2MapOfMapEntriesValueOperator<K,K2,V2> asMap(final Type<K2> keyOf, final Type<V2> valueOf);
    public <X> ILevel2MapOfSetEntriesValueOperator<K,X> asSet(final Type<X> of);
    public ILevel2MapOfArrayEntriesValueOperator<K,?> asArrayOfUnknown();
    public ILevel2MapOfListEntriesValueOperator<K,?> asListOfUnknown();
    public ILevel2MapOfMapEntriesValueOperator<K,?,?> asMapOfUnknown();
    public ILevel2MapOfSetEntriesValueOperator<K,?> asSetOfUnknown();
    

    
}

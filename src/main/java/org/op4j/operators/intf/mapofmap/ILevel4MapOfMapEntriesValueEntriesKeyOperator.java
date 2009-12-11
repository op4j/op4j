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
package org.op4j.operators.intf.mapofmap;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.INavigatingMapEntryOperator;
import org.op4j.operators.qualities.ICastableToTypeOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel4MapOfMapEntriesValueEntriesKeyOperator<K1,K2,V>
		extends IUniqOperator<Map<K1,Map<K2,V>>>,
				INavigatingMapEntryOperator,
                ICastableToTypeOperator<K2>,
                IExecutableOperator<K2>, 
                IEvaluableOperator<K2>, 
                IConvertibleOperator<K2> {
    
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> endOn();
    
    public <X> ILevel4MapOfMapEntriesValueEntriesKeyOperator<K1,X,V> asType(final Type<X> type);
    public ILevel4MapOfMapEntriesValueEntriesKeyOperator<K1,?,V> asUnknown();

    public <X> ILevel4MapOfMapEntriesValueEntriesKeyOperator<K1,X,V> exec(final IFunction<X, ? super K2> function);
    
    public <X> ILevel4MapOfMapEntriesValueEntriesKeyOperator<K1,X,V> eval(final IEvaluator<X,? super K2> eval);
    
    public <X> ILevel4MapOfMapEntriesValueEntriesKeyOperator<K1,X,V> convert(final IConverter<X,? super K2> converter);

        
}

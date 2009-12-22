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
package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesKeyOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;
import org.op4j.util.TargetUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level4MapOfMapEntriesValueEntriesKeyOperatorImpl<K1,K2,V> extends AbstractOperatorImpl
        implements Level4MapOfMapEntriesValueEntriesKeyOperator<K1,K2,V> {

    
    public Level4MapOfMapEntriesValueEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V> endOn() {
        return new Level3MapOfMapEntriesValueEntriesOperatorImpl<K1, K2, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> Level4MapOfMapEntriesValueEntriesKeyOperator<K1, X, V> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        TargetUtils.checkIsMapOfMapOfValueOfKey(type, get());
        return new Level4MapOfMapEntriesValueEntriesKeyOperatorImpl<K1, X, V>(getTarget());
    }

    public Level4MapOfMapEntriesValueEntriesKeyOperator<K1, ?, V> asUnknown() {
        return asType(Types.OBJECT);
    }

    




    public <X> Level4MapOfMapEntriesValueEntriesKeyOperator<K1, X, V> convert(final IConverter<X, ? super K2> converter) {
        return new Level4MapOfMapEntriesValueEntriesKeyOperatorImpl<K1, X, V>(getTarget().execute(converter));
    }


    public <X> Level4MapOfMapEntriesValueEntriesKeyOperator<K1, X, V> eval(final IEvaluator<X, ? super K2> eval) {
        return new Level4MapOfMapEntriesValueEntriesKeyOperatorImpl<K1, X, V>(getTarget().execute(eval));
    }


    public <X> Level4MapOfMapEntriesValueEntriesKeyOperator<K1, X, V> exec(final IFunction<X, ? super K2> function) {
        return new Level4MapOfMapEntriesValueEntriesKeyOperatorImpl<K1, X, V>(getTarget().execute(function));
    }
    
    
    

    public Map<K1, Map<K2, V>> get() {
        return endOn().endFor().endOn().endFor().get();
    }


}

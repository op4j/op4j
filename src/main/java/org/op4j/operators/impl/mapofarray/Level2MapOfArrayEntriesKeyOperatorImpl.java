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
package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesKeyOperator;
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
public class Level2MapOfArrayEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level2MapOfArrayEntriesKeyOperator<K,V> {
    
    private final Type<? super V> arrayOf; 

    
    public Level2MapOfArrayEntriesKeyOperatorImpl(final Type<? super V> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public Level1MapOfArrayEntriesOperator<K, V> endOn() {
        return new Level1MapOfArrayEntriesOperatorImpl<K, V>(this.arrayOf, getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> Level2MapOfArrayEntriesKeyOperator<X, V> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        TargetUtils.checkIsMapOfKey(type, get());
        return new Level2MapOfArrayEntriesKeyOperatorImpl<X, V>(this.arrayOf, getTarget());
    }

    public Level2MapOfArrayEntriesKeyOperator<?, V> asUnknown() {
        return asType(Types.OBJECT);
    }


    public <X> Level2MapOfArrayEntriesKeyOperator<X, V> convert(final IConverter<X, ? super K> converter) {
        return new Level2MapOfArrayEntriesKeyOperatorImpl<X, V>(this.arrayOf, getTarget().execute(converter));
    }


    public <X> Level2MapOfArrayEntriesKeyOperator<X, V> eval(final IEvaluator<X, ? super K> eval) {
        return new Level2MapOfArrayEntriesKeyOperatorImpl<X, V>(this.arrayOf, getTarget().execute(eval));
    }


    public <X> Level2MapOfArrayEntriesKeyOperator<X, V> exec(final IFunction<X, ? super K> function) {
        return new Level2MapOfArrayEntriesKeyOperatorImpl<X, V>(this.arrayOf, getTarget().execute(function));
    }

    

    public Map<K, V[]> get() {
        return endOn().endFor().get();
    }

}

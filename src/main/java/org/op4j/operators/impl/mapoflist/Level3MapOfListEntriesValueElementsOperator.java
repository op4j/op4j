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
package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel3MapOfListEntriesValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level3MapOfListEntriesValueElementsOperator<K,V> extends Operator
        implements ILevel3MapOfListEntriesValueElementsOperator<K,V> {

    
    public Level3MapOfListEntriesValueElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> convert(final IConverter<X, ? super V> converter) {
        return new Level3MapOfListEntriesValueElementsOperator<K, X>(getTarget().execute(converter));
    }



    public ILevel2MapOfListEntriesValueOperator<K, V> endFor() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsOperator<K, X>(getTarget().execute(eval));
    }


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> exec(final IFunction<X, ? super V> function) {
        return new Level3MapOfListEntriesValueElementsOperator<K, X>(getTarget().execute(function));
    }


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> asType(final Type<X> type) {
        return new Level3MapOfListEntriesValueElementsOperator<K, X>(getTarget());
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, ?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K, List<V>> get() {
        return endFor().endOn().endFor().get();
    }

}

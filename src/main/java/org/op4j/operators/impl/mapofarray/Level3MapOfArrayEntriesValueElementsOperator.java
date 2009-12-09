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
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.mapofarray.ILevel2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.ILevel3MapOfArrayEntriesValueElementsOperator;
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
public class Level3MapOfArrayEntriesValueElementsOperator<K,V> extends Operator
        implements ILevel3MapOfArrayEntriesValueElementsOperator<K,V> {
    
    private final Type<? super V> arrayOf; 

    
    public Level3MapOfArrayEntriesValueElementsOperator(final Type<? super V> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> convert(final IConverter<X, ? super V> converter) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(converter.getResultType(), getTarget().execute(converter));
    }



    public ILevel2MapOfArrayEntriesValueOperator<K, V> endFor() {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(eval.getResultType(), getTarget().execute(eval));
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> exec(final IFunction<X, ? super V> function) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(function.getResultType(), getTarget().execute(function));
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        TargetUtils.checkIsMapOfArrayOfValue(type, get());
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(type, getTarget());
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, ?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K, V[]> get() {
        return endFor().endOn().endFor().get();
    }

}

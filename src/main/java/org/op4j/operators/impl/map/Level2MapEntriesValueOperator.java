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
package org.op4j.operators.impl.map;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.TargetCastException;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.impl.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.impl.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.impl.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.intf.map.ILevel1MapEntriesOperator;
import org.op4j.operators.intf.map.ILevel2MapEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.ILevel2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapEntriesValueOperator<K,V> extends Operator
        implements ILevel2MapEntriesValueOperator<K,V> {

    
    public Level2MapEntriesValueOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2MapEntriesValueOperator<K, X> convert(final IConverter<X, ? super V> converter) {
        return new Level2MapEntriesValueOperator<K, X>(getTarget().execute(converter));
    }



    public ILevel1MapEntriesOperator<K, V> endOn() {
        return new Level1MapEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> ILevel2MapEntriesValueOperator<K, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level2MapEntriesValueOperator<K, X>(getTarget().execute(eval));
    }


    public <X> ILevel2MapEntriesValueOperator<K, X> exec(final IFunction<X, ? super V> function) {
        return new Level2MapEntriesValueOperator<K, X>(getTarget().execute(function));
    }


    public <X> ILevel2MapEntriesValueOperator<K, X> of(final Type<X> of) {
        return new Level2MapEntriesValueOperator<K, X>(getTarget());
    }


    public ILevel2MapEntriesValueOperator<K, ?> raw() {
        return new Level2MapEntriesValueOperator<K, V>(getTarget());
    }

    
    
    
    
    
    
    


    public <X> ILevel2MapOfArrayEntriesValueOperator<K,X> asArray(final Type<X> of) {
        Validate.notNull(of, "A type representing the elements must be specified");
        final Map<K,V> targetObject = get();
        for (final V targetElement : targetObject.values()) {
            if (targetElement != null) {
                final Class<?> newTargetClass = Types.arrayOf(of).getRawClass();
                if (!newTargetClass.isAssignableFrom(targetElement.getClass())) {
                    throw new TargetCastException(targetElement.getClass(), "Array");
                }
            }
        }
        return new Level2MapOfArrayEntriesValueOperator<K,X>(of, getTarget());
    }


    public <X> ILevel2MapOfListEntriesValueOperator<K,X> asList(final Type<X> of) {
        Validate.notNull(of, "A type representing the elements must be specified");
        final Map<K,V> targetObject = get();
        for (final V targetElement : targetObject.values()) {
            if (targetElement != null) {
                final Class<?> newTargetClass = List.class;
                if (!newTargetClass.isAssignableFrom(targetElement.getClass())) {
                    throw new TargetCastException(targetElement.getClass(), "List");
                }
            }
        }
        return new Level2MapOfListEntriesValueOperator<K,X>(getTarget());
    }


    public <K2,V2> ILevel2MapOfMapEntriesValueOperator<K,K2,V2> asMap(final Type<K2> keyOf, final Type<V2> valueOf) {
        Validate.notNull(keyOf, "A type representing the keys must be specified");
        Validate.notNull(valueOf, "A type representing the values must be specified");
        final Map<K,V> targetObject = get();
        for (final V targetElement : targetObject.values()) {
            if (targetElement != null) {
                final Class<?> newTargetClass = Map.class;
                if (!newTargetClass.isAssignableFrom(targetElement.getClass())) {
                    throw new TargetCastException(targetElement.getClass(), "Map");
                }
            }
        }
        return new Level2MapOfMapEntriesValueOperator<K,K2,V2>(getTarget());
    }


    public <X> ILevel2MapOfSetEntriesValueOperator<K,X> asSet(final Type<X> of) {
        Validate.notNull(of, "A type representing the elements must be specified");
        final Map<K,V> targetObject = get();
        for (final V targetElement : targetObject.values()) {
            if (targetElement != null) {
                final Class<?> newTargetClass = Set.class;
                if (!newTargetClass.isAssignableFrom(targetElement.getClass())) {
                    throw new TargetCastException(targetElement.getClass(), "Set");
                }
            }
        }
        return new Level2MapOfSetEntriesValueOperator<K,X>(getTarget());
    }

    
    

    public ILevel2MapOfArrayEntriesValueOperator<K, ?> asArrayOfUnknown() {
        return asArray(Types.OBJECT);
    }


    public ILevel2MapOfListEntriesValueOperator<K, ?> asListOfUnknown() {
        return asList(Types.OBJECT);
    }


    public ILevel2MapOfMapEntriesValueOperator<K, ?, ?> asMapOfUnknown() {
        return asMap(Types.OBJECT, Types.OBJECT);
    }


    public ILevel2MapOfSetEntriesValueOperator<K, ?> asSetOfUnknown() {
        return asSet(Types.OBJECT);
    }
    
    
    
    
    
    
    
    
    
    
    
    

    public Map<K, V> get() {
        return endOn().endFor().get();
    }

}

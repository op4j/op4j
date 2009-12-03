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
package org.op4j.operators.impl.set;

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
import org.op4j.operators.impl.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.impl.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.impl.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.impl.setofset.Level1SetOfSetElementsOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.set.ILevel1SetElementsOperator;
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1SetElementsOperator<T> extends Operator
        implements ILevel1SetElementsOperator<T>  {

    
    public Level1SetElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel1SetElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level1SetElementsOperator<X>(getTarget().execute(converter));
    }



    public ILevel0SetOperator<T> endFor() {
        return new Level0SetOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> ILevel1SetElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level1SetElementsOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel1SetElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level1SetElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel1SetElementsOperator<X> of(final Type<X> of) {
        return new Level1SetElementsOperator<X>(getTarget());
    }


    public ILevel1SetElementsOperator<?> raw() {
        return new Level1SetElementsOperator<T>(getTarget());
    }

    
    
    
    
    


    public <X> ILevel1SetOfArrayElementsOperator<X> asArray(final Type<X> of) {
        Validate.notNull(of, "A type representing the elements must be specified");
        final Set<T> targetObject = get();
        for (final T targetElement : targetObject) {
            if (targetElement != null) {
                final Class<?> newTargetClass = Types.arrayOf(of).getRawClass();
                if (!newTargetClass.isAssignableFrom(targetElement.getClass())) {
                    throw new TargetCastException(targetElement.getClass(), "Array");
                }
            }
        }
        return new Level1SetOfArrayElementsOperator<X>(of, getTarget());
    }


    public <X> ILevel1SetOfListElementsOperator<X> asList(final Type<X> of) {
        Validate.notNull(of, "A type representing the elements must be specified");
        final Set<T> targetObject = get();
        for (final T targetElement : targetObject) {
            if (targetElement != null) {
                final Class<?> newTargetClass = List.class;
                if (!newTargetClass.isAssignableFrom(targetElement.getClass())) {
                    throw new TargetCastException(targetElement.getClass(), "List");
                }
            }
        }
        return new Level1SetOfListElementsOperator<X>(getTarget());
    }


    public <K,V> ILevel1SetOfMapElementsOperator<K,V> asMap(final Type<K> keyOf, final Type<V> valueOf) {
        Validate.notNull(keyOf, "A type representing the keys must be specified");
        Validate.notNull(valueOf, "A type representing the values must be specified");
        final Set<T> targetObject = get();
        for (final T targetElement : targetObject) {
            if (targetElement != null) {
                final Class<?> newTargetClass = Map.class;
                if (!newTargetClass.isAssignableFrom(targetElement.getClass())) {
                    throw new TargetCastException(targetElement.getClass(), "Map");
                }
            }
        }
        return new Level1SetOfMapElementsOperator<K,V>(getTarget());
    }


    public <X> ILevel1SetOfSetElementsOperator<X> asSet(final Type<X> of) {
        Validate.notNull(of, "A type representing the elements must be specified");
        final Set<T> targetObject = get();
        for (final T targetElement : targetObject) {
            if (targetElement != null) {
                final Class<?> newTargetClass = Set.class;
                if (!newTargetClass.isAssignableFrom(targetElement.getClass())) {
                    throw new TargetCastException(targetElement.getClass(), "Set");
                }
            }
        }
        return new Level1SetOfSetElementsOperator<X>(getTarget());
    }
    
    
    
    
    
    
    
    

    public Set<T> get() {
        return endFor().get();
    }

}

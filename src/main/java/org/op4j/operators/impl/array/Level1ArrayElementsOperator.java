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
package org.op4j.operators.impl.array;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.TargetCastException;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.impl.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.impl.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.impl.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.array.ILevel1ArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayElementsOperator<T> extends Operator
        implements ILevel1ArrayElementsOperator<T> {
    
    private final Type<? super T> arrayOf; 

    
    public Level1ArrayElementsOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel1ArrayElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level1ArrayElementsOperator<X>(converter.getResultType(), getTarget().execute(converter));
    }



    public ILevel0ArrayOperator<T> endFor() {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> ILevel1ArrayElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level1ArrayElementsOperator<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public ILevel1ArrayElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<BigInteger>(Types.BIG_INTEGER, getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Boolean>(Types.BOOLEAN, getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Object>(Types.OBJECT, getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel1ArrayElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<X>(resultType, getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel1ArrayElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Byte>(Types.BYTE, getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Calendar>(Types.CALENDAR, getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Double>(Types.DOUBLE, getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Float>(Types.FLOAT, getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Integer>(Types.INTEGER, getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Long>(Types.LONG, getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Short>(Types.SHORT, getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<String>(Types.STRING, getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel1ArrayElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Character>(Types.CHARACTER, getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel1ArrayElementsOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Date>(Types.DATE, getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel1ArrayElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level1ArrayElementsOperator<X>(function.getResultType(), getTarget().execute(function));
    }


    public <X> ILevel1ArrayElementsOperator<X> of(final Type<X> of) {
        return new Level1ArrayElementsOperator<X>(of, getTarget());
    }


    public ILevel1ArrayElementsOperator<?> raw() {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget());
    }


    
    


    public <X> ILevel1ArrayOfArrayElementsOperator<X> asArray(final Type<X> of) {
        Validate.notNull(of, "A type representing the elements must be specified");
        final T[] targetObject = get();
        for (final T targetElement : targetObject) {
            if (targetElement != null) {
                final Class<?> newTargetClass = Types.arrayOf(of).getRawClass();
                if (!newTargetClass.isAssignableFrom(targetElement.getClass())) {
                    throw new TargetCastException(targetElement.getClass(), "Array");
                }
            }
        }
        return new Level1ArrayOfArrayElementsOperator<X>(of, getTarget());
    }


    public <X> ILevel1ArrayOfListElementsOperator<X> asList(final Type<X> of) {
        Validate.notNull(of, "A type representing the elements must be specified");
        final T[] targetObject = get();
        for (final T targetElement : targetObject) {
            if (targetElement != null) {
                final Class<?> newTargetClass = List.class;
                if (!newTargetClass.isAssignableFrom(targetElement.getClass())) {
                    throw new TargetCastException(targetElement.getClass(), "List");
                }
            }
        }
        return new Level1ArrayOfListElementsOperator<X>(getTarget());
    }


    public <K,V> ILevel1ArrayOfMapElementsOperator<K,V> asMap(final Type<K> keyOf, final Type<V> valueOf) {
        Validate.notNull(keyOf, "A type representing the keys must be specified");
        Validate.notNull(valueOf, "A type representing the values must be specified");
        final T[] targetObject = get();
        for (final T targetElement : targetObject) {
            if (targetElement != null) {
                final Class<?> newTargetClass = Map.class;
                if (!newTargetClass.isAssignableFrom(targetElement.getClass())) {
                    throw new TargetCastException(targetElement.getClass(), "Map");
                }
            }
        }
        return new Level1ArrayOfMapElementsOperator<K,V>(getTarget());
    }


    public <X> ILevel1ArrayOfSetElementsOperator<X> asSet(final Type<X> of) {
        Validate.notNull(of, "A type representing the elements must be specified");
        final T[] targetObject = get();
        for (final T targetElement : targetObject) {
            if (targetElement != null) {
                final Class<?> newTargetClass = Set.class;
                if (!newTargetClass.isAssignableFrom(targetElement.getClass())) {
                    throw new TargetCastException(targetElement.getClass(), "Set");
                }
            }
        }
        return new Level1ArrayOfSetElementsOperator<X>(getTarget());
    }
    
    
    
    
    public T[] get() {
        return endFor().get();
    }

}

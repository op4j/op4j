/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
package org.op4j.functions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.operators.impl.fn.array.Level0ArrayOperator;
import org.op4j.operators.impl.fn.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.fn.list.Level0ListOperator;
import org.op4j.operators.impl.fn.map.Level0MapOperator;
import org.op4j.operators.impl.fn.set.Level0SetOperator;
import org.op4j.target.ExecutionTarget;
import org.op4j.target.Target.Normalisation;


/**
 * <p>
 * Building class for <b>Function Expressions</b>.
 * </p>
 * <p>
 * This class allows the creation of chained expressions in exactly the same way
 * as {@link org.op4j.Op}, but the results of expressions starting with <tt>Fn</tt>
 * are functions instead of objects.
 * </p>
 * <p>
 * For more info, see the <a href="http://www.op4j.org/basics.html">Basics Page</a>.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
@SuppressWarnings("deprecation")
public final class Fn {
    

    
    
    
    private Fn() {
        super();
    }

    
    
    
    
    
    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of the specified type.
     * </p>
     * <p>
     * Examples: 
     * </p>
     * <ul>
     *   <li><tt>Fn.on(Types.STRING).get()</tt> returns <tt>Function&lt;String,String&gt;</tt>
     *       which does nothing.</li>
     *   <li><tt>Fn.on(Types.STRING).exec(FnString.toInteger()).get()</tt> returns 
     *       <tt>Function&lt;String,Integer&gt;</tt> which receives a String as input,
     *       and outputs an Integer as output (see {@link Function}).</li>
     * </ul>
     * 
     * @param type the type of the object on which the expression should start
     * @return an operator, ready for chaining
     */
    public static <T> Level0GenericUniqOperator<T,T> on(final Type<T> type) {
        return new Level0GenericUniqOperator<T,T>(ExecutionTarget.forFn(Normalisation.NONE));
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Object.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.OBJECT)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0GenericUniqOperator<Object,Object> onObject() {
        return on(Types.OBJECT);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Object[].
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onArrayOf(Types.OBJECT)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ArrayOperator<Object[],Object> onArrayOfObject() {
        return onArrayOf(Types.OBJECT);
    }

   
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;Object&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onListOf(Types.OBJECT)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ListOperator<List<Object>,Object> onListOfObject() {
        return onListOf(Types.OBJECT);
    }


    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;Object&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onSetOf(Types.OBJECT)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0SetOperator<Set<Object>,Object> onSetOfObject() {
        return onSetOf(Types.OBJECT);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type BigInteger.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.BIG_INTEGER)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0GenericUniqOperator<BigInteger,BigInteger> onBigInteger() {
        return on(Types.BIG_INTEGER);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type BigInteger[].
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onArrayOf(Types.BIG_INTEGER)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ArrayOperator<BigInteger[],BigInteger> onArrayOfBigInteger() {
        return onArrayOf(Types.BIG_INTEGER);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;BigInteger&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onListOf(Types.BIG_INTEGER)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ListOperator<List<BigInteger>,BigInteger> onListOfBigInteger() {
        return onListOf(Types.BIG_INTEGER);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;BigInteger&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onSetOf(Types.BIG_INTEGER)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0SetOperator<Set<BigInteger>,BigInteger> onSetOfBigInteger() {
        return onSetOf(Types.BIG_INTEGER);
    }

    
    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type BigDecimal.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.BIG_DECIMAL)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0GenericUniqOperator<BigDecimal,BigDecimal> onBigDecimal() {
        return on(Types.BIG_DECIMAL);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type  BigDecimal[].
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onArrayOf(Types.BIG_DECIMAL)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ArrayOperator<BigDecimal[],BigDecimal> onArrayOfBigDecimal() {
        return onArrayOf(Types.BIG_DECIMAL);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;BigDecimal&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onListOf(Types.BIG_DECIMAL)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ListOperator<List<BigDecimal>,BigDecimal> onListOfBigDecimal() {
        return onListOf(Types.BIG_DECIMAL);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;BigDecimal&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onSetOf(Types.BIG_DECIMAL)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0SetOperator<Set<BigDecimal>,BigDecimal> onSetOfBigDecimal() {
        return onSetOf(Types.BIG_DECIMAL);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Boolean.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.BOOLEAN)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0GenericUniqOperator<Boolean,Boolean> onBoolean() {
        return on(Types.BOOLEAN);
    }


    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Boolean[].
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onArrayOf(Types.BOOLEAN)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ArrayOperator<Boolean[],Boolean> onArrayOfBoolean() {
        return onArrayOf(Types.BOOLEAN);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;Boolean&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onListOf(Types.BOOLEAN)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ListOperator<List<Boolean>,Boolean> onListOfBoolean() {
        return onListOf(Types.BOOLEAN);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;Boolean&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onSetOf(Types.BOOLEAN)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0SetOperator<Set<Boolean>,Boolean> onSetOfBoolean() {
        return onSetOf(Types.BOOLEAN);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Byte.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.BYTE)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0GenericUniqOperator<Byte,Byte> onByte() {
        return on(Types.BYTE);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Byte[].
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onArrayOf(Types.BYTE)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ArrayOperator<Byte[],Byte> onArrayOfByte() {
        return onArrayOf(Types.BYTE);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;Byte&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onListOf(Types.BYTE)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ListOperator<List<Byte>,Byte> onListOfByte() {
        return onListOf(Types.BYTE);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;Byte&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onSetOf(Types.BYTE)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0SetOperator<Set<Byte>,Byte> onSetOfByte() {
        return onSetOf(Types.BYTE);
    }

    

    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Character.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.CHARACTER)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0GenericUniqOperator<Character,Character> onCharacter() {
        return on(Types.CHARACTER);
    }


    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Character[].
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onArrayOf(Types.CHARACTER)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ArrayOperator<Character[],Character> onArrayOfCharacter() {
        return onArrayOf(Types.CHARACTER);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;Character&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onListOf(Types.CHARACTER)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ListOperator<List<Character>,Character> onListOfCharacter() {
        return onListOf(Types.CHARACTER);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;Character&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onSetOf(Types.CHARACTER)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0SetOperator<Set<Character>,Character> onSetOfCharacter() {
        return onSetOf(Types.CHARACTER);
    }

    
    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Calendar.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.CALENDAR)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0GenericUniqOperator<Calendar,Calendar> onCalendar() {
        return on(Types.CALENDAR);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Calendar[].
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onArrayOf(Types.CALENDAR)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ArrayOperator<Calendar[],Calendar> onArrayOfCalendar() {
        return onArrayOf(Types.CALENDAR);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;Calendar&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onListOf(Types.CALENDAR)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ListOperator<List<Calendar>,Calendar> onListOfCalendar() {
        return onListOf(Types.CALENDAR);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;Calendar&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onSetOf(Types.CALENDAR)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0SetOperator<Set<Calendar>,Calendar> onSetOfCalendar() {
        return onSetOf(Types.CALENDAR);
    }

    
    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Date.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.DATE)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0GenericUniqOperator<Date,Date> onDate() {
        return on(Types.DATE);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Date[].
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onArrayOf(Types.DATE)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ArrayOperator<Date[],Date> onArrayOfDate() {
        return onArrayOf(Types.DATE);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;Date&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onListOf(Types.DATE)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ListOperator<List<Date>,Date> onListOfDate() {
        return onListOf(Types.DATE);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;Date&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onSetOf(Types.DATE)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0SetOperator<Set<Date>,Date> onSetOfDate() {
        return onSetOf(Types.DATE);
    }

    
    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Double.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.DOUBLE)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0GenericUniqOperator<Double,Double> onDouble() {
        return on(Types.DOUBLE);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Double[].
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onArrayOf(Types.DOUBLE)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ArrayOperator<Double[],Double> onArrayOfDouble() {
        return onArrayOf(Types.DOUBLE);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;Double&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onListOf(Types.DOUBLE)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ListOperator<List<Double>,Double> onListOfDouble() {
        return onListOf(Types.DOUBLE);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;Double&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onSetOf(Types.DOUBLE)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0SetOperator<Set<Double>,Double> onSetOfDouble() {
        return onSetOf(Types.DOUBLE);
    }


    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Float.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.FLOAT)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0GenericUniqOperator<Float,Float> onFloat() {
        return on(Types.FLOAT);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Float[].
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onArrayOf(Types.FLOAT)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ArrayOperator<Float[],Float> onArrayOfFloat() {
        return onArrayOf(Types.FLOAT);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;Float&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onListOf(Types.FLOAT)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ListOperator<List<Float>,Float> onListOfFloat() {
        return onListOf(Types.FLOAT);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;Float&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onSetOf(Types.FLOAT)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0SetOperator<Set<Float>,Float> onSetOfFloat() {
        return onSetOf(Types.FLOAT);
    }

    
    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Integer.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.INTEGER)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0GenericUniqOperator<Integer,Integer> onInteger() {
        return on(Types.INTEGER);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Integer[].
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onArrayOf(Types.INTEGER)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ArrayOperator<Integer[],Integer> onArrayOfInteger() {
        return onArrayOf(Types.INTEGER);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;Integer&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onListOf(Types.INTEGER)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ListOperator<List<Integer>,Integer> onListOfInteger() {
        return onListOf(Types.INTEGER);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;Integer&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onSetOf(Types.INTEGER)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0SetOperator<Set<Integer>,Integer> onSetOfInteger() {
        return onSetOf(Types.INTEGER);
    }

    

    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Long.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.LONG)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0GenericUniqOperator<Long,Long> onLong() {
        return on(Types.LONG);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Long[].
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onArrayOf(Types.LONG)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ArrayOperator<Long[],Long> onArrayOfLong() {
        return onArrayOf(Types.LONG);
    }


    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;Long&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onListOf(Types.LONG)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ListOperator<List<Long>,Long> onListOfLong() {
        return onListOf(Types.LONG);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;Long&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onSetOf(Types.LONG)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0SetOperator<Set<Long>,Long> onSetOfLong() {
        return onSetOf(Types.LONG);
    }

    
    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Short.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.SHORT)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0GenericUniqOperator<Short,Short> onShort() {
        return on(Types.SHORT);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Short[].
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onArrayOf(Types.SHORT)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ArrayOperator<Short[],Short> onArrayOfShort() {
        return onArrayOf(Types.SHORT);
    }


    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;Short&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onListOf(Types.SHORT)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ListOperator<List<Short>,Short> onListOfShort() {
        return onListOf(Types.SHORT);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;Short&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onSetOf(Types.SHORT)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0SetOperator<Set<Short>,Short> onSetOfShort() {
        return onSetOf(Types.SHORT);
    }

    
    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type String.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.STRING)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0GenericUniqOperator<String,String> onString() {
        return on(Types.STRING);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type String[].
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onArrayOf(Types.STRING)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ArrayOperator<String[],String> onArrayOfString() {
        return onArrayOf(Types.STRING);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;String&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onListOf(Types.STRING)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0ListOperator<List<String>,String> onListOfString() {
        return onListOf(Types.STRING);
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;String&gt;.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.onSetOf(Types.STRING)</tt>
     * </p>
     * 
     * @return an operator, ready for chaining
     */
    public static Level0SetOperator<Set<String>,String> onSetOfString() {
        return onSetOf(Types.STRING);
    }

    
    
    
    
    
    
    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type T[], being <tt>Type&lt;T&gt;</tt> a type specified 
     * as a parameter.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.arrayOf(type))</tt>
     * </p>
     * 
     * @param type the type to be used
     * @return an operator, ready for chaining
     */
    public static <T> Level0ArrayOperator<T[],T> onArrayOf(final Type<T> type) {
        return new Level0ArrayOperator<T[],T>(type, ExecutionTarget.forFn(Normalisation.ARRAY(type.getRawClass())));
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type List&lt;T&gt;, being <tt>Type&lt;T&gt;</tt> a type specified 
     * as a parameter.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.listOf(type))</tt>
     * </p>
     * 
     * @param type the type to be used
     * @return an operator, ready for chaining
     */
    public static <T> Level0ListOperator<List<T>,T> onListOf(final Type<T> type) {
        return new Level0ListOperator<List<T>,T>(ExecutionTarget.forFn(Normalisation.LIST));
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Map&lt;K,V&gt;, being both 
     * <tt>Type&lt;K&gt;</tt> and <tt>Type&lt;V&gt;</tt> type specified 
     * as parameters.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.mapOf(keyType, valueType))</tt>
     * </p>
     * 
     * @param keyType the type to be used for keys
     * @param valueType the type to be used for values
     * @return an operator, ready for chaining
     */
    public static <K,V> Level0MapOperator<Map<K,V>,K,V> onMapOf(final Type<K> keyType, Type<V> valueType) {
        return new Level0MapOperator<Map<K,V>,K,V>(ExecutionTarget.forFn(Normalisation.MAP));
    }

    
    /**
     * <p>
     * Creates a <i>function expression</i> for building a function operating on
     * a target object of type Set&lt;T&gt;, being <tt>Type&lt;T&gt;</tt> a type specified 
     * as a parameter.
     * </p>
     * <p>
     * This is equivalent to <tt>Fn.on(Types.setOf(type))</tt>
     * </p>
     *
     * @param type the type to be used
     * @return an operator, ready for chaining
     */
    public static <T> Level0SetOperator<Set<T>,T> onSetOf(final Type<T> type) {
        return new Level0SetOperator<Set<T>,T>(ExecutionTarget.forFn(Normalisation.SET));
    }
    
 
    
    
    
    
    
    
    
    

}

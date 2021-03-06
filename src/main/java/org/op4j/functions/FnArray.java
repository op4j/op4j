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

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;

/**
 * <p>
 * Function hub class for functions on arrays. As these functions have to be parameterized
 * depending on the type of the array elements, this function hub class does not
 * contain the real functions, but instead provides methods for specifying the type of the
 * array components so that the appropiate functions are offered.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class FnArray {

    
    private static final FnArrayOf<Object> OF_OBJECT = new FnArrayOf<Object>(Types.OBJECT);
    private static final FnArrayOf<BigInteger> OF_BIG_INTEGER = new FnArrayOf<BigInteger>(Types.BIG_INTEGER);
    private static final FnArrayOf<BigDecimal> OF_BIG_DECIMAL = new FnArrayOf<BigDecimal>(Types.BIG_DECIMAL);
    private static final FnArrayOf<Boolean> OF_BOOLEAN = new FnArrayOf<Boolean>(Types.BOOLEAN); 
    private static final FnArrayOf<Byte> OF_BYTE = new FnArrayOf<Byte>(Types.BYTE); 
    private static final FnArrayOf<Character> OF_CHARACTER = new FnArrayOf<Character>(Types.CHARACTER); 
    private static final FnArrayOf<Calendar> OF_CALENDAR = new FnArrayOf<Calendar>(Types.CALENDAR); 
    private static final FnArrayOf<Date> OF_DATE = new FnArrayOf<Date>(Types.DATE); 
    private static final FnArrayOf<Double> OF_DOUBLE = new FnArrayOf<Double>(Types.DOUBLE); 
    private static final FnArrayOf<Float> OF_FLOAT = new FnArrayOf<Float>(Types.FLOAT); 
    private static final FnArrayOf<Integer> OF_INTEGER = new FnArrayOf<Integer>(Types.INTEGER); 
    private static final FnArrayOf<Long> OF_LONG = new FnArrayOf<Long>(Types.LONG); 
    private static final FnArrayOf<Short> OF_SHORT = new FnArrayOf<Short>(Types.SHORT); 
    private static final FnArrayOf<String> OF_STRING = new FnArrayOf<String>(Types.STRING); 
    
    
    
    /**
     * <p>
     * Specifies the type of the array components, so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @param type the type of the array components
     * @return the adequate array function hub
     */
    public static <T> FnArrayOf<T> of(final Type<T> type) {
        return new FnArrayOf<T>(type);
    }
    
    public static <T> FnArrayOfArrayOf<T> ofArrayOf(final Type<T> type) {
        return new FnArrayOfArrayOf<T>(type);
    }
    
    public static <T> FnArrayOfListOf<T> ofListOf(final Type<T> type) {
        return new FnArrayOfListOf<T>(type);
    }
    
    public static <T> FnArrayOfSetOf<T> ofSetOf(final Type<T> type) {
        return new FnArrayOfSetOf<T>(type);
    }

    
    /**
     * <p>
     * Specifies the array as an Object[], so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @return the adequate array function hub
     */
    public static FnArrayOf<Object> ofObject() {
        return OF_OBJECT;
    }
    

    /**
     * <p>
     * Specifies the array as a BigInteger[], so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @return the adequate array function hub
     */
    public static FnArrayOf<BigInteger> ofBigInteger() {
        return OF_BIG_INTEGER;
    }
    

    /**
     * <p>
     * Specifies the array as a BigDecimal[], so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @return the adequate array function hub
     */
    public static FnArrayOf<BigDecimal> ofBigDecimal() {
        return OF_BIG_DECIMAL;
    }

    
    /**
     * <p>
     * Specifies the array as a Boolean[], so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @return the adequate array function hub
     */
    public static FnArrayOf<Boolean> ofBoolean() {
        return OF_BOOLEAN;
    }
    
    
    /**
     * <p>
     * Specifies the array as a Byte[], so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @return the adequate array function hub
     */
    public static FnArrayOf<Byte> ofByte() {
        return OF_BYTE;
    }
    
    
    /**
     * <p>
     * Specifies the array as a Character[], so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @return the adequate array function hub
     */
    public static FnArrayOf<Character> ofCharacter() {
        return OF_CHARACTER;
    }
    
    
    /**
     * <p>
     * Specifies the array as a Calendar[], so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @return the adequate array function hub
     */
    public static FnArrayOf<Calendar> ofCalendar() {
        return OF_CALENDAR;
    }
    

    /**
     * <p>
     * Specifies the array as a Date[], so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @return the adequate array function hub
     */
    public static FnArrayOf<Date> ofDate() {
        return OF_DATE;
    }
    
    
    /**
     * <p>
     * Specifies the array as a Double[], so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @return the adequate array function hub
     */
    public static FnArrayOf<Double> ofDouble() {
        return OF_DOUBLE;
    }
    

    /**
     * <p>
     * Specifies the array as a Float[], so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @return the adequate array function hub
     */
    public static FnArrayOf<Float> ofFloat() {
        return OF_FLOAT;
    }
    
    
    /**
     * <p>
     * Specifies the array as an Integer[], so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @return the adequate array function hub
     */
    public static FnArrayOf<Integer> ofInteger() {
        return OF_INTEGER;
    }
    
    
    /**
     * <p>
     * Specifies the array as a Long[], so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @return the adequate array function hub
     */
    public static FnArrayOf<Long> ofLong() {
        return OF_LONG;
    }
    
    
    /**
     * <p>
     * Specifies the array as a Short[], so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @return the adequate array function hub
     */
    public static FnArrayOf<Short> ofShort() {
        return OF_SHORT;
    }
    
    
    /**
     * <p>
     * Specifies the array as a String[], so that the adequate array functions
     * can be offered.
     * </p>
     * 
     * @return the adequate array function hub
     */
    public static FnArrayOf<String> ofString() {
        return OF_STRING;
    }
    
    
    
    
    private FnArray() {
        super();
    }
    
    
    
    
}

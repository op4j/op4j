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
 * Function hub class for functions on sets. As these functions have to be parameterized
 * depending on the type of the set elements, this function hub class does not
 * contain the real functions, but instead provides methods for specifying the type of the
 * set components so that the appropiate functions are offered.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class FnSet {

    
    private static final FnSetOf<Object> OF_OBJECT = new FnSetOf<Object>(Types.OBJECT);
    private static final FnSetOf<BigInteger> OF_BIG_INTEGER = new FnSetOf<BigInteger>(Types.BIG_INTEGER);
    private static final FnSetOf<BigDecimal> OF_BIG_DECIMAL = new FnSetOf<BigDecimal>(Types.BIG_DECIMAL);
    private static final FnSetOf<Boolean> OF_BOOLEAN = new FnSetOf<Boolean>(Types.BOOLEAN); 
    private static final FnSetOf<Byte> OF_BYTE = new FnSetOf<Byte>(Types.BYTE); 
    private static final FnSetOf<Character> OF_CHARACTER = new FnSetOf<Character>(Types.CHARACTER); 
    private static final FnSetOf<Calendar> OF_CALENDAR = new FnSetOf<Calendar>(Types.CALENDAR); 
    private static final FnSetOf<Date> OF_DATE = new FnSetOf<Date>(Types.DATE); 
    private static final FnSetOf<Double> OF_DOUBLE = new FnSetOf<Double>(Types.DOUBLE); 
    private static final FnSetOf<Float> OF_FLOAT = new FnSetOf<Float>(Types.FLOAT); 
    private static final FnSetOf<Integer> OF_INTEGER = new FnSetOf<Integer>(Types.INTEGER); 
    private static final FnSetOf<Long> OF_LONG = new FnSetOf<Long>(Types.LONG); 
    private static final FnSetOf<Short> OF_SHORT = new FnSetOf<Short>(Types.SHORT); 
    private static final FnSetOf<String> OF_STRING = new FnSetOf<String>(Types.STRING); 
    
    
    
    
    /**
     * <p>
     * Specifies the type of the set components, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @param type the type of the set components
     * @return the adequate set function hub
     */
    public static <T> FnSetOf<T> of(final Type<T> type) {
        return new FnSetOf<T>(type);
    }
    
    public static <T> FnSetOfArrayOf<T> ofArrayOf(final Type<T> type) {
        return new FnSetOfArrayOf<T>(type);
    }
    
    public static <T> FnSetOfListOf<T> ofListOf(final Type<T> type) {
        return new FnSetOfListOf<T>(type);
    }
    
    public static <T> FnSetOfSetOf<T> ofSetOf(final Type<T> type) {
        return new FnSetOfSetOf<T>(type);
    }
    
    
    /**
     * <p>
     * Specifies the set as a Set&lt;Object&gt;, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @return the adequate set function hub
     */
    public static FnSetOf<Object> ofObject() {
        return OF_OBJECT;
    }

    
    /**
     * <p>
     * Specifies the set as a Set&lt;BigInteger&gt;, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @return the adequate set function hub
     */
    public static FnSetOf<BigInteger> ofBigInteger() {
        return OF_BIG_INTEGER;
    }

    
    /**
     * <p>
     * Specifies the set as a Set&lt;BigDecimal&gt;, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @return the adequate set function hub
     */
    public static FnSetOf<BigDecimal> ofBigDecimal() {
        return OF_BIG_DECIMAL;
    }
    

    /**
     * <p>
     * Specifies the set as a Set&lt;Boolean&gt;, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @return the adequate set function hub
     */
    public static FnSetOf<Boolean> ofBoolean() {
        return OF_BOOLEAN;
    }
    

    /**
     * <p>
     * Specifies the set as a Set&lt;Byte&gt;, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @return the adequate set function hub
     */
    public static FnSetOf<Byte> ofByte() {
        return OF_BYTE;
    }
    

    /**
     * <p>
     * Specifies the set as a Set&lt;Character&gt;, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @return the adequate set function hub
     */
    public static FnSetOf<Character> ofCharacter() {
        return OF_CHARACTER;
    }
    

    /**
     * <p>
     * Specifies the set as a Set&lt;Calendar&gt;, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @return the adequate set function hub
     */
    public static FnSetOf<Calendar> ofCalendar() {
        return OF_CALENDAR;
    }
    
    
    /**
     * <p>
     * Specifies the set as a Set&lt;Date&gt;, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @return the adequate set function hub
     */
    public static FnSetOf<Date> ofDate() {
        return OF_DATE;
    }
    

    /**
     * <p>
     * Specifies the set as a Set&lt;Double&gt;, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @return the adequate set function hub
     */
    public static FnSetOf<Double> ofDouble() {
        return OF_DOUBLE;
    }

    
    /**
     * <p>
     * Specifies the set as a Set&lt;Float&gt;, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @return the adequate set function hub
     */
    public static FnSetOf<Float> ofFloat() {
        return OF_FLOAT;
    }
    
    
    /**
     * <p>
     * Specifies the set as a Set&lt;Integer&gt;, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @return the adequate set function hub
     */
    public static FnSetOf<Integer> ofInteger() {
        return OF_INTEGER;
    }
    
    
    /**
     * <p>
     * Specifies the set as a Set&lt;Long&gt;, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @return the adequate set function hub
     */
    public static FnSetOf<Long> ofLong() {
        return OF_LONG;
    }
    
    
    /**
     * <p>
     * Specifies the set as a Set&lt;Short&gt;, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @return the adequate set function hub
     */
    public static FnSetOf<Short> ofShort() {
        return OF_SHORT;
    }

    
    /**
     * <p>
     * Specifies the set as a Set&lt;String&gt;, so that the adequate set functions
     * can be offered.
     * </p>
     * 
     * @return the adequate set function hub
     */
    public static FnSetOf<String> ofString() {
        return OF_STRING;
    }
    
    
    private FnSet() {
        super();
    }

        
    
}

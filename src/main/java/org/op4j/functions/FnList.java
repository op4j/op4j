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
 * Function hub class for functions on lists. As these functions have to be parameterized
 * depending on the type of the list elements, this function hub class does not
 * contain the real functions, but instead provides methods for specifying the type of the
 * list components so that the appropiate functions are offered.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class FnList {

    
    private static final FnListOf<Object> OF_OBJECT = new FnListOf<Object>(Types.OBJECT);
    private static final FnListOf<BigInteger> OF_BIG_INTEGER = new FnListOf<BigInteger>(Types.BIG_INTEGER);
    private static final FnListOf<BigDecimal> OF_BIG_DECIMAL = new FnListOf<BigDecimal>(Types.BIG_DECIMAL);
    private static final FnListOf<Boolean> OF_BOOLEAN = new FnListOf<Boolean>(Types.BOOLEAN); 
    private static final FnListOf<Byte> OF_BYTE = new FnListOf<Byte>(Types.BYTE); 
    private static final FnListOf<Character> OF_CHARACTER = new FnListOf<Character>(Types.CHARACTER); 
    private static final FnListOf<Calendar> OF_CALENDAR = new FnListOf<Calendar>(Types.CALENDAR); 
    private static final FnListOf<Date> OF_DATE = new FnListOf<Date>(Types.DATE); 
    private static final FnListOf<Double> OF_DOUBLE = new FnListOf<Double>(Types.DOUBLE); 
    private static final FnListOf<Float> OF_FLOAT = new FnListOf<Float>(Types.FLOAT); 
    private static final FnListOf<Integer> OF_INTEGER = new FnListOf<Integer>(Types.INTEGER); 
    private static final FnListOf<Long> OF_LONG = new FnListOf<Long>(Types.LONG); 
    private static final FnListOf<Short> OF_SHORT = new FnListOf<Short>(Types.SHORT); 
    private static final FnListOf<String> OF_STRING = new FnListOf<String>(Types.STRING);
    
        
    
    
    /**
     * <p>
     * Specifies the type of the list components, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @param type the type of the list components
     * @return the adequate list function hub
     */
    public static <T> FnListOf<T> of(final Type<T> type) {
        return new FnListOf<T>(type);
    }
    
    public static <T> FnListOfArrayOf<T> ofArrayOf(final Type<T> type) {
        return new FnListOfArrayOf<T>(type);
    }
    
    public static <T> FnListOfListOf<T> ofListOf(final Type<T> type) {
        return new FnListOfListOf<T>(type);
    }
    
    public static <T> FnListOfSetOf<T> ofSetOf(final Type<T> type) {
        return new FnListOfSetOf<T>(type);
    }
    

    /**
     * <p>
     * Specifies the list as a List&lt;Object&gt;, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @return the adequate list function hub
     */
    public static FnListOf<Object> ofObject() {
        return OF_OBJECT;
    }

    
    /**
     * <p>
     * Specifies the list as a List&lt;BigInteger&gt;, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @return the adequate list function hub
     */
    public static FnListOf<BigInteger> ofBigInteger() {
        return OF_BIG_INTEGER;
    }

    
    /**
     * <p>
     * Specifies the list as a List&lt;BigDecimal&gt;, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @return the adequate list function hub
     */
    public static FnListOf<BigDecimal> ofBigDecimal() {
        return OF_BIG_DECIMAL;
    }

    
    /**
     * <p>
     * Specifies the list as a List&lt;Boolean&gt;, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @return the adequate list function hub
     */
    public static FnListOf<Boolean> ofBoolean() {
        return OF_BOOLEAN;
    }
    
    
    /**
     * <p>
     * Specifies the list as a List&lt;Byte&gt;, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @return the adequate list function hub
     */
    public static FnListOf<Byte> ofByte() {
        return OF_BYTE;
    }
    

    /**
     * <p>
     * Specifies the list as a List&lt;Character&gt;, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @return the adequate list function hub
     */
    public static FnListOf<Character> ofCharacter() {
        return OF_CHARACTER;
    }
    

    /**
     * <p>
     * Specifies the list as a List&lt;Calendar&gt;, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @return the adequate list function hub
     */
    public static FnListOf<Calendar> ofCalendar() {
        return OF_CALENDAR;
    }

    
    /**
     * <p>
     * Specifies the list as a List&lt;Date&gt;, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @return the adequate list function hub
     */
    public static FnListOf<Date> ofDate() {
        return OF_DATE;
    }
    
    
    /**
     * <p>
     * Specifies the list as a List&lt;Double&gt;, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @return the adequate list function hub
     */
    public static FnListOf<Double> ofDouble() {
        return OF_DOUBLE;
    }
    

    /**
     * <p>
     * Specifies the list as a List&lt;Float&gt;, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @return the adequate list function hub
     */
    public static FnListOf<Float> ofFloat() {
        return OF_FLOAT;
    }

    
    /**
     * <p>
     * Specifies the list as a List&lt;Integer&gt;, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @return the adequate list function hub
     */
    public static FnListOf<Integer> ofInteger() {
        return OF_INTEGER;
    }
    

    /**
     * <p>
     * Specifies the list as a List&lt;Long&gt;, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @return the adequate list function hub
     */
    public static FnListOf<Long> ofLong() {
        return OF_LONG;
    }
    

    /**
     * <p>
     * Specifies the list as a List&lt;Short&gt;, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @return the adequate list function hub
     */
    public static FnListOf<Short> ofShort() {
        return OF_SHORT;
    }
    

    /**
     * <p>
     * Specifies the list as a List&lt;String&gt;, so that the adequate list functions
     * can be offered.
     * </p>
     * 
     * @return the adequate list function hub
     */
    public static FnListOf<String> ofString() {
        return OF_STRING;
    }

    
    
    
    
    

    private FnList() {
        super();
    }
    
    
    
}

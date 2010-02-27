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

package org.op4j.functions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;

/**
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
    
    public static FnSetOf<Object> ofObject() {
        return OF_OBJECT;
    }
    
    public static FnSetOf<BigInteger> ofBigInteger() {
        return OF_BIG_INTEGER;
    }
    
    public static FnSetOf<BigDecimal> ofBigDecimal() {
        return OF_BIG_DECIMAL;
    }
    
    public static FnSetOf<Boolean> ofBoolean() {
        return OF_BOOLEAN;
    }
    
    public static FnSetOf<Byte> ofByte() {
        return OF_BYTE;
    }
    
    public static FnSetOf<Character> ofCharacter() {
        return OF_CHARACTER;
    }
    
    public static FnSetOf<Calendar> ofCalendar() {
        return OF_CALENDAR;
    }
    
    public static FnSetOf<Date> ofDate() {
        return OF_DATE;
    }
    
    public static FnSetOf<Double> ofDouble() {
        return OF_DOUBLE;
    }
    
    public static FnSetOf<Float> ofFloat() {
        return OF_FLOAT;
    }
    
    public static FnSetOf<Integer> ofInteger() {
        return OF_INTEGER;
    }
    
    public static FnSetOf<Long> ofLong() {
        return OF_LONG;
    }
    
    public static FnSetOf<Short> ofShort() {
        return OF_SHORT;
    }
    
    public static FnSetOf<String> ofString() {
        return OF_STRING;
    }
    


    
    
    private FnSet() {
        super();
    }

    
    
    
    
}

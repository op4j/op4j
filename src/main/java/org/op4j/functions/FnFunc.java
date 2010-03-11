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
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class FnFunc {

    
    private static final FnFuncOf<Object> OF_OBJECT = new FnFuncOf<Object>(Types.OBJECT);
    private static final FnFuncOf<BigInteger> OF_BIG_INTEGER = new FnFuncOf<BigInteger>(Types.BIG_INTEGER);
    private static final FnFuncOf<BigDecimal> OF_BIG_DECIMAL = new FnFuncOf<BigDecimal>(Types.BIG_DECIMAL);
    private static final FnFuncOf<Boolean> OF_BOOLEAN = new FnFuncOf<Boolean>(Types.BOOLEAN); 
    private static final FnFuncOf<Byte> OF_BYTE = new FnFuncOf<Byte>(Types.BYTE); 
    private static final FnFuncOf<Character> OF_CHARACTER = new FnFuncOf<Character>(Types.CHARACTER); 
    private static final FnFuncOf<Calendar> OF_CALENDAR = new FnFuncOf<Calendar>(Types.CALENDAR); 
    private static final FnFuncOf<Date> OF_DATE = new FnFuncOf<Date>(Types.DATE); 
    private static final FnFuncOf<Double> OF_DOUBLE = new FnFuncOf<Double>(Types.DOUBLE); 
    private static final FnFuncOf<Float> OF_FLOAT = new FnFuncOf<Float>(Types.FLOAT); 
    private static final FnFuncOf<Integer> OF_INTEGER = new FnFuncOf<Integer>(Types.INTEGER); 
    private static final FnFuncOf<Long> OF_LONG = new FnFuncOf<Long>(Types.LONG); 
    private static final FnFuncOf<Short> OF_SHORT = new FnFuncOf<Short>(Types.SHORT); 
    private static final FnFuncOf<String> OF_STRING = new FnFuncOf<String>(Types.STRING); 

    
    
    
    
    public static <T> FnFuncOf<T> of(final Type<T> type) {
        return new FnFuncOf<T>(type);
    }
    
    
    public static FnFuncOf<Object> ofObject() {
        return OF_OBJECT;
    }
    
    public static FnFuncOf<BigInteger> ofBigInteger() {
        return OF_BIG_INTEGER;
    }
    
    public static FnFuncOf<BigDecimal> ofBigDecimal() {
        return OF_BIG_DECIMAL;
    }
    
    public static FnFuncOf<Boolean> ofBoolean() {
        return OF_BOOLEAN;
    }
    
    public static FnFuncOf<Byte> ofByte() {
        return OF_BYTE;
    }
    
    public static FnFuncOf<Character> ofCharacter() {
        return OF_CHARACTER;
    }
    
    public static FnFuncOf<Calendar> ofCalendar() {
        return OF_CALENDAR;
    }
    
    public static FnFuncOf<Date> ofDate() {
        return OF_DATE;
    }
    
    public static FnFuncOf<Double> ofDouble() {
        return OF_DOUBLE;
    }
    
    public static FnFuncOf<Float> ofFloat() {
        return OF_FLOAT;
    }
    
    public static FnFuncOf<Integer> ofInteger() {
        return OF_INTEGER;
    }
    
    public static FnFuncOf<Long> ofLong() {
        return OF_LONG;
    }
    
    public static FnFuncOf<Short> ofShort() {
        return OF_SHORT;
    }
    
    public static FnFuncOf<String> ofString() {
        return OF_STRING;
    }
    
    
    
    
    private FnFunc() {
        super();
    }
    
    
    
}

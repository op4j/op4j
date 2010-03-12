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
public final class FnReduce {

    
    private static final FnReduceOf<Object> OF_OBJECT = new FnReduceOf<Object>(Types.OBJECT);
    private static final FnReduceOfBigInteger OF_BIG_INTEGER = new FnReduceOfBigInteger();
    private static final FnReduceOfBigDecimal OF_BIG_DECIMAL = new FnReduceOfBigDecimal();
    private static final FnReduceOfBoolean OF_BOOLEAN = new FnReduceOfBoolean(); 
    private static final FnReduceOfByte OF_BYTE = new FnReduceOfByte(); 
    private static final FnReduceOf<Character> OF_CHARACTER = new FnReduceOf<Character>(Types.CHARACTER); 
    private static final FnReduceOf<Calendar> OF_CALENDAR = new FnReduceOf<Calendar>(Types.CALENDAR); 
    private static final FnReduceOf<Date> OF_DATE = new FnReduceOf<Date>(Types.DATE); 
    private static final FnReduceOfDouble OF_DOUBLE = new FnReduceOfDouble(); 
    private static final FnReduceOfFloat OF_FLOAT = new FnReduceOfFloat(); 
    private static final FnReduceOfInteger OF_INTEGER = new FnReduceOfInteger(); 
    private static final FnReduceOfLong OF_LONG = new FnReduceOfLong(); 
    private static final FnReduceOfShort OF_SHORT = new FnReduceOfShort(); 
    private static final FnReduceOfString OF_STRING = new FnReduceOfString(); 

    
    
    
    
    public static <T> FnReduceOf<T> of(final Type<T> type) {
        return new FnReduceOf<T>(type);
    }
    
    
    public static FnReduceOf<Object> ofObject() {
        return OF_OBJECT;
    }
    
    public static FnReduceOfBigInteger ofBigInteger() {
        return OF_BIG_INTEGER;
    }
    
    public static FnReduceOfBigDecimal ofBigDecimal() {
        return OF_BIG_DECIMAL;
    }
    
    public static FnReduceOfBoolean ofBoolean() {
        return OF_BOOLEAN;
    }
    
    public static FnReduceOfByte ofByte() {
        return OF_BYTE;
    }
    
    public static FnReduceOf<Character> ofCharacter() {
        return OF_CHARACTER;
    }
    
    public static FnReduceOf<Calendar> ofCalendar() {
        return OF_CALENDAR;
    }
    
    public static FnReduceOf<Date> ofDate() {
        return OF_DATE;
    }
    
    public static FnReduceOfDouble ofDouble() {
        return OF_DOUBLE;
    }
    
    public static FnReduceOfFloat ofFloat() {
        return OF_FLOAT;
    }
    
    public static FnReduceOfInteger ofInteger() {
        return OF_INTEGER;
    }
    
    public static FnReduceOfLong ofLong() {
        return OF_LONG;
    }
    
    public static FnReduceOfShort ofShort() {
        return OF_SHORT;
    }
    
    public static FnReduceOfString ofString() {
        return OF_STRING;
    }
    
    
    
    
    private FnReduce() {
        super();
    }
    
    
    
}

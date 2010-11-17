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
 * @deprecated This class will be removed in version 1.2 
 * 
 */
@Deprecated
public final class FnReduce {

    
    private static final FnReduceOn<Object> ON_OBJECT = new FnReduceOn<Object>(Types.OBJECT);
    private static final FnReduceOnBigInteger ON_BIG_INTEGER = new FnReduceOnBigInteger();
    private static final FnReduceOnBigDecimal ON_BIG_DECIMAL = new FnReduceOnBigDecimal();
    private static final FnReduceOnBoolean ON_BOOLEAN = new FnReduceOnBoolean(); 
    private static final FnReduceOnByte ON_BYTE = new FnReduceOnByte(); 
    private static final FnReduceOn<Character> ON_CHARACTER = new FnReduceOn<Character>(Types.CHARACTER); 
    private static final FnReduceOn<Calendar> ON_CALENDAR = new FnReduceOn<Calendar>(Types.CALENDAR); 
    private static final FnReduceOn<Date> ON_DATE = new FnReduceOn<Date>(Types.DATE); 
    private static final FnReduceOnDouble ON_DOUBLE = new FnReduceOnDouble(); 
    private static final FnReduceOnFloat ON_FLOAT = new FnReduceOnFloat(); 
    private static final FnReduceOnInteger ON_INTEGER = new FnReduceOnInteger(); 
    private static final FnReduceOnLong ON_LONG = new FnReduceOnLong(); 
    private static final FnReduceOnShort ON_SHORT = new FnReduceOnShort(); 
    private static final FnReduceOnString ON_STRING = new FnReduceOnString(); 

    
    
    
    
    public static <T> FnReduceOn<T> on(final Type<T> type) {
        return new FnReduceOn<T>(type);
    }
    
    
    public static FnReduceOn<Object> onObject() {
        return ON_OBJECT;
    }
    
    public static FnReduceOnBigInteger onBigInteger() {
        return ON_BIG_INTEGER;
    }
    
    public static FnReduceOnBigDecimal onBigDecimal() {
        return ON_BIG_DECIMAL;
    }
    
    public static FnReduceOnBoolean onBoolean() {
        return ON_BOOLEAN;
    }
    
    public static FnReduceOnByte onByte() {
        return ON_BYTE;
    }
    
    public static FnReduceOn<Character> onCharacter() {
        return ON_CHARACTER;
    }
    
    public static FnReduceOn<Calendar> onCalendar() {
        return ON_CALENDAR;
    }
    
    public static FnReduceOn<Date> onDate() {
        return ON_DATE;
    }
    
    public static FnReduceOnDouble onDouble() {
        return ON_DOUBLE;
    }
    
    public static FnReduceOnFloat onFloat() {
        return ON_FLOAT;
    }
    
    public static FnReduceOnInteger onInteger() {
        return ON_INTEGER;
    }
    
    public static FnReduceOnLong onLong() {
        return ON_LONG;
    }
    
    public static FnReduceOnShort onShort() {
        return ON_SHORT;
    }
    
    public static FnReduceOnString onString() {
        return ON_STRING;
    }
    
    
    
    
    private FnReduce() {
        super();
    }
    
    
    
}

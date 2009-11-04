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

package org.op4j;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Of<T> {


    public static final Of<Boolean> BOOLEAN = Of.clazz(Boolean.class);
    public static final Of<Byte> BYTE = Of.clazz(Byte.class);
    public static final Of<Character> CHARACTER = Of.clazz(Character.class);
	public static final Of<Double> DOUBLE = Of.clazz(Double.class);
	public static final Of<Float> FLOAT = Of.clazz(Float.class);
	public static final Of<Integer> INTEGER = Of.clazz(Integer.class);
	public static final Of<Long> LONG = Of.clazz(Long.class);
    public static final Of<Number> NUMBER = Of.clazz(Number.class);
    public static final Of<Object> OBJECT = Of.clazz(Object.class);
	public static final Of<Short> SHORT = Of.clazz(Short.class);
	public static final Of<String> STRING = Of.clazz(String.class);
    public static final Of<Date> DATE = Of.clazz(Date.class);
    public static final Of<Calendar> CALENDAR = Of.clazz(Calendar.class);
    public static final Of<BigDecimal> BIG_DECIMAL = Of.clazz(BigDecimal.class);
    public static final Of<BigInteger> BIG_INTEGER = Of.clazz(BigInteger.class);
	

	private final Type<T> type;


	
	public static <T> Of<T> type(final Type<T> type) {
	    Validate.notNull(type, "Type cannot be null");
		return new Of<T>(type);
	}
    
    public static <T> Of<T> clazz(final Class<T> clazz) {
        Validate.notNull(clazz, "Class cannot be null");
        return new Of<T>(Types.forClass(clazz));
    }
	
    
    
	
	private Of(final Type<T> type) {
		super();
		this.type = type;
	}



    public Type<T> getType() {
        return this.type;
    }


	public String getTypeName() {
		return this.type.getName();
	}
	
	
	@Override
	public String toString() {
	    return "of " + this.getTypeName();
	}

	
    public Class<? super T> getRawClass() {
        return this.type.getRawClass();
    }

	
}

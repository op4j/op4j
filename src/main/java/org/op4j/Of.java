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
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Of<T> implements IOf<T> {
	
	public static final Of<Object> OBJECT = Of.clazz(Object.class);
	public static final Of<BigInteger> BIG_INTEGER = Of.clazz(BigInteger.class);
	public static final Of<BigDecimal> BIG_DECIMAL = Of.clazz(BigDecimal.class);
	public static final Of<Boolean> BOOLEAN = Of.clazz(Boolean.class);
	public static final Of<Byte> BYTE = Of.clazz(Byte.class);
	public static final Of<Calendar> CALENDAR = Of.clazz(Calendar.class);
	public static final Of<Double> DOUBLE = Of.clazz(Double.class);
	public static final Of<Float> FLOAT = Of.clazz(Float.class);
	public static final Of<Integer> INTEGER = Of.clazz(Integer.class);
	public static final Of<Long> LONG = Of.clazz(Long.class);
	public static final Of<Short> SHORT = Of.clazz(Short.class);
	public static final Of<String> STRING = Of.clazz(String.class);
    
    public static final Of<Object[]> ARRAY = Of.clazz(Object[].class);
    public static final Of<BigInteger[]> ARRAY_OF_BIG_INTEGER = Of.clazz(BigInteger[].class);
    public static final Of<BigDecimal[]> ARRAY_OF_BIG_DECIMAL = Of.clazz(BigDecimal[].class);
    public static final Of<Boolean[]> ARRAY_OF_BOOLEAN = Of.clazz(Boolean[].class);
    public static final Of<Byte[]> ARRAY_OF_BYTE = Of.clazz(Byte[].class);
    public static final Of<Calendar[]> ARRAY_OF_CALENDAR = Of.clazz(Calendar[].class);
    public static final Of<Double[]> ARRAY_OF_DOUBLE = Of.clazz(Double[].class);
    public static final Of<Float[]> ARRAY_OF_FLOAT = Of.clazz(Float[].class);
    public static final Of<Integer[]> ARRAY_OF_INTEGER = Of.clazz(Integer[].class);
    public static final Of<Long[]> ARRAY_OF_LONG = Of.clazz(Long[].class);
    public static final Of<Short[]> ARRAY_OF_SHORT = Of.clazz(Short[].class);
    public static final Of<String[]> ARRAY_OF_STRING = Of.clazz(String[].class);

    public static final Of<List<?>> LIST = Of.clazz(List.class);
    public static final Of<List<BigInteger>> LIST_OF_BIG_INTEGER = Of.clazz(List.class);
    public static final Of<List<BigDecimal>> LIST_OF_BIG_DECIMAL = Of.clazz(List.class);
    public static final Of<List<Boolean>> LIST_OF_BOOLEAN = Of.clazz(List.class);
    public static final Of<List<Byte>> LIST_OF_BYTE = Of.clazz(List.class);
    public static final Of<List<Calendar>> LIST_OF_CALENDAR = Of.clazz(List.class);
    public static final Of<List<Double>> LIST_OF_DOUBLE = Of.clazz(List.class);
    public static final Of<List<Float>> LIST_OF_FLOAT = Of.clazz(List.class);
    public static final Of<List<Integer>> LIST_OF_INTEGER = Of.clazz(List.class);
    public static final Of<List<Long>> LIST_OF_LONG = Of.clazz(List.class);
    public static final Of<List<Short>> LIST_OF_SHORT = Of.clazz(List.class);
    public static final Of<List<String>> LIST_OF_STRING = Of.clazz(List.class);

    public static final Of<Set<?>> SET = Of.clazz(Set.class);
    public static final Of<Set<BigInteger>> SET_OF_BIG_INTEGER = Of.clazz(Set.class);
    public static final Of<Set<BigDecimal>> SET_OF_BIG_DECIMAL = Of.clazz(Set.class);
    public static final Of<Set<Boolean>> SET_OF_BOOLEAN = Of.clazz(Set.class);
    public static final Of<Set<Byte>> SET_OF_BYTE = Of.clazz(Set.class);
    public static final Of<Set<Calendar>> SET_OF_CALENDAR = Of.clazz(Set.class);
    public static final Of<Set<Double>> SET_OF_DOUBLE = Of.clazz(Set.class);
    public static final Of<Set<Float>> SET_OF_FLOAT = Of.clazz(Set.class);
    public static final Of<Set<Integer>> SET_OF_INTEGER = Of.clazz(Set.class);
    public static final Of<Set<Long>> SET_OF_LONG = Of.clazz(Set.class);
    public static final Of<Set<Short>> SET_OF_SHORT = Of.clazz(Set.class);
    public static final Of<Set<String>> SET_OF_STRING = Of.clazz(Set.class);

    public static final Of<Map<?,?>> MAP = Of.clazz(Map.class);
	

	private final Class<? super T> componentClass;

	
	public static <T> Of<T> clazz(final Class<? super T> clazz) {
		return new Of<T>(clazz);
	}
	
	
	private Of(final Class<? super T> componentClass) {
		this.componentClass = componentClass;
	}
	
    public Class<? super T> getComponentClass() {
    	return this.componentClass;
    }
    
}

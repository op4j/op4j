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

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.op4j.exceptions.ExecutionException;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * @author Soraya S&aacute;nchez
 *
 */
public final class FnObject {

    
	private static final Function<Object,String> TO_STRING = new ToString();
    private static final Function<Object,String> TO_STRING_NULL_SAFE = new ToStringNullSafe();
	
    private static final Function<Object,Boolean> IS_NULL = new IsNull();
    private static final Function<Object,Boolean> IS_NOT_NULL = new IsNotNull();
	
	
	
	private FnObject() {
		super();           
	}

	
    
	/**
	 * <p>
	 * Converts the target object to String using the default <tt>toString()</tt> method.
	 * </p>
	 * 
	 * @return the String representation of the target object.
	 */
    public static final Function<Object,String> toStr() {
        return TO_STRING;
    }
    
    
    /**
     * <p>
     * Converts the target object to String using the default <tt>toString()</tt> method,
     * returning null if target is null.
     * </p>
     * 
     * @return the String representation of the target object, or null if target is null.
     */
    public static final Function<Object,String> toStrNullSafe() {
        return TO_STRING_NULL_SAFE;
    }
    

    /**
     * <p>
     * Creates an array of the specified type with only the target object in it.
     * </p>
     * 
     * @param <T> the type of the array elements
     * @param type the type of the array
     * @return the resulting array.
     */
    public static final <T> Function<T,T[]> intoSingletonArrayOf(final Type<T> type) {
        return new IntoSingletonArray<T>(type);
    }
    
    
    /**
     * <p>
     * Creates a list of the specified type with only the target object in it.
     * </p>
     * 
     * @param <T> the type of the list elements
     * @param type the type of the list
     * @return the resulting list.
     */
    public static final <T> Function<T,List<T>> intoSingletonListOf(final Type<T> type) {
        return new IntoSingletonList<T>();
    }

    
    /**
     * <p>
     * Creates a set of the specified type with only the target object in it.
     * </p>
     * 
     * @param <T> the type of the set elements
     * @param type the type of the set
     * @return the resulting set.
     */
    public static final <T> Function<T,Set<T>> intoSingletonSetOf(final Type<T> type) {
        return new IntoSingletonSet<T>();
    }

    
    
    

    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Object,Boolean> eq(final Object object) {
        return new Equals(object);
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Object,Boolean> eq(final float object) {
        return new Equals(Float.valueOf(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Object,Boolean> eq(final double object) {
        return new Equals(Double.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Object,Boolean> eq(final byte object) {
        return new Equals(Byte.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Object,Boolean> eq(final short object) {
        return new Equals(Short.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Object,Boolean> eq(final int object) {
        return new Equals(Integer.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Object,Boolean> eq(final long object) {
        return new Equals(Long.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Object,Boolean> eq(final boolean object) {
        return new Equals(Boolean.valueOf(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Object,Boolean> eqValue(final Object object) {
        return new EqualValue(object);
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Object,Boolean> eqValue(final float object) {
        return new EqualValue(Float.valueOf(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Object,Boolean> eqValue(final double object) {
        return new EqualValue(Double.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Object,Boolean> eqValue(final byte object) {
        return new EqualValue(Byte.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Object,Boolean> eqValue(final short object) {
        return new EqualValue(Short.valueOf(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Object,Boolean> eqValue(final int object) {
        return new EqualValue(Integer.valueOf(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Object,Boolean> eqValue(final long object) {
        return new EqualValue(Long.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Object,Boolean> eqValue(final boolean object) {
        return new EqualValue(Boolean.valueOf(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Object,Boolean> notEq(final Object object) {
        return new NotEquals(object);
    }
        
    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Object,Boolean> notEq(final float object) {
        return new NotEquals(Float.valueOf(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Object,Boolean> notEq(final double object) {
        return new NotEquals(Double.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Object,Boolean> notEq(final byte object) {
        return new NotEquals(Byte.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Object,Boolean> notEq(final short object) {
        return new NotEquals(Short.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Object,Boolean> notEq(final int object) {
        return new NotEquals(Integer.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Object,Boolean> notEq(final long object) {
        return new NotEquals(Long.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Object,Boolean> notEq(final boolean object) {
        return new NotEquals(Boolean.valueOf(object));
    }


    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Object,Boolean> notEqValue(final Object object) {
        return new NotEqualValue(object);
    }
    
    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Object,Boolean> notEqValue(final float object) {
        return new NotEqualValue(Float.valueOf(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Object,Boolean> notEqValue(final double object) {
        return new NotEqualValue(Double.valueOf(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Object,Boolean> notEqValue(final byte object) {
        return new NotEqualValue(Byte.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Object,Boolean> notEqValue(final short object) {
        return new NotEqualValue(Short.valueOf(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Object,Boolean> notEqValue(final int object) {
        return new NotEqualValue(Integer.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Object,Boolean> notEqValue(final long object) {
        return new NotEqualValue(Long.valueOf(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Object,Boolean> notEqValue(final boolean object) {
        return new NotEqualValue(Boolean.valueOf(object));
    }
    
    
    

    
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Object,Boolean> lessThan(final Object object) {
        return new LessThan(object);
    }
        
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Object,Boolean> lessThan(final float object) {
        return new LessThan(Float.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Object,Boolean> lessThan(final double object) {
        return new LessThan(Double.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Object,Boolean> lessThan(final byte object) {
        return new LessThan(Byte.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Object,Boolean> lessThan(final short object) {
        return new LessThan(Short.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Object,Boolean> lessThan(final int object) {
        return new LessThan(Integer.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Object,Boolean> lessThan(final long object) {
        return new LessThan(Long.valueOf(object));
    }

    
    
    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> lessOrEqTo(final Object object) {
        return new LessOrEqualTo(object);
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> lessOrEqTo(final float object) {
        return new LessOrEqualTo(Float.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> lessOrEqTo(final double object) {
        return new LessOrEqualTo(Double.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> lessOrEqTo(final byte object) {
        return new LessOrEqualTo(Byte.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> lessOrEqTo(final short object) {
        return new LessOrEqualTo(Short.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> lessOrEqTo(final int object) {
        return new LessOrEqualTo(Integer.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> lessOrEqTo(final long object) {
        return new LessOrEqualTo(Long.valueOf(object));
    }
    
    

    

    


    
    

    /**
     * <p>
     * Determines whether the target object is greater than the specified object
     * in value, this is, whether <tt>target.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater than the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterThan(final Object object) {    
        return new GreaterThan(object);
    }
    
    

    /**
     * <p>
     * Determines whether the target object is greater than the specified object
     * in value, this is, whether <tt>target.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater than the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterThan(final float object) {    
        return new GreaterThan(Float.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is greater than the specified object
     * in value, this is, whether <tt>target.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater than the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterThan(final double object) {    
        return new GreaterThan(Double.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is greater than the specified object
     * in value, this is, whether <tt>target.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater than the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterThan(final byte object) {    
        return new GreaterThan(Byte.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is greater than the specified object
     * in value, this is, whether <tt>target.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater than the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterThan(final short object) {    
        return new GreaterThan(Short.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is greater than the specified object
     * in value, this is, whether <tt>target.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater than the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterThan(final int object) {    
        return new GreaterThan(Integer.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is greater than the specified object
     * in value, this is, whether <tt>target.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater than the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterThan(final long object) {    
        return new GreaterThan(Long.valueOf(object));
    }

    
    
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterOrEqTo(final Object object) {
        return new GreaterOrEqualTo(object);
    }
    
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterOrEqTo(final float object) {
        return new GreaterOrEqualTo(Float.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterOrEqTo(final double object) {
        return new GreaterOrEqualTo(Double.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterOrEqTo(final byte object) {
        return new GreaterOrEqualTo(Byte.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterOrEqTo(final short object) {
        return new GreaterOrEqualTo(Short.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterOrEqTo(final int object) {
        return new GreaterOrEqualTo(Integer.valueOf(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterOrEqTo(final long object) {
        return new GreaterOrEqualTo(Long.valueOf(object));
    }
    
    
    
    

    
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final Object object) {
        return FnFunc.by(by, eq(object));
    }
        
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final float object) {
        return FnFunc.by(by, eq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final double object) {
        return FnFunc.by(by, eq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final byte object) {
        return FnFunc.by(by, eq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final short object) {
        return FnFunc.by(by, eq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final int object) {
        return FnFunc.by(by, eq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final long object) {
        return FnFunc.by(by, eq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final boolean object) {
        return FnFunc.by(by, eq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final <X> Function<X,Boolean> eqValueBy(final IFunction<X,?> by, final Object object) {
        return FnFunc.by(by, eqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final <X> Function<X,Boolean> eqValueBy(final IFunction<X,?> by, final float object) {
        return FnFunc.by(by, eqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final <X> Function<X,Boolean> eqValueBy(final IFunction<X,?> by, final double object) {
        return FnFunc.by(by, eqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final <X> Function<X,Boolean> eqValueBy(final IFunction<X,?> by, final byte object) {
        return FnFunc.by(by, eqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final <X> Function<X,Boolean> eqValueBy(final IFunction<X,?> by, final short object) {
        return FnFunc.by(by, eqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final <X> Function<X,Boolean> eqValueBy(final IFunction<X,?> by, final int object) {
        return FnFunc.by(by, eqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final <X> Function<X,Boolean> eqValueBy(final IFunction<X,?> by, final long object) {
        return FnFunc.by(by, eqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final <X> Function<X,Boolean> eqValueBy(final IFunction<X,?> by, final boolean object) {
        return FnFunc.by(by, eqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final Object object) {
        return FnFunc.by(by, notEq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final float object) {
        return FnFunc.by(by, notEq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final double object) {
        return FnFunc.by(by, notEq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final byte object) {
        return FnFunc.by(by, notEq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final short object) {
        return FnFunc.by(by, notEq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final int object) {
        return FnFunc.by(by, notEq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final long object) {
        return FnFunc.by(by, notEq(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final boolean object) {
        return FnFunc.by(by, notEq(object));
    }

    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final <X> Function<X,Boolean> notEqValueBy(final IFunction<X,?> by, final Object object) {
        return FnFunc.by(by, notEqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final <X> Function<X,Boolean> notEqValueBy(final IFunction<X,?> by, final float object) {
        return FnFunc.by(by, notEqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final <X> Function<X,Boolean> notEqValueBy(final IFunction<X,?> by, final double object) {
        return FnFunc.by(by, notEqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final <X> Function<X,Boolean> notEqValueBy(final IFunction<X,?> by, final byte object) {
        return FnFunc.by(by, notEqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final <X> Function<X,Boolean> notEqValueBy(final IFunction<X,?> by, final short object) {
        return FnFunc.by(by, notEqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final <X> Function<X,Boolean> notEqValueBy(final IFunction<X,?> by, final int object) {
        return FnFunc.by(by, notEqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final <X> Function<X,Boolean> notEqValueBy(final IFunction<X,?> by, final long object) {
        return FnFunc.by(by, notEqValue(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final <X> Function<X,Boolean> notEqValueBy(final IFunction<X,?> by, final boolean object) {
        return FnFunc.by(by, notEqValue(object));
    }
    
    
    
    

    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final Object object) {
        return FnFunc.by(by, lessThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final float object) {
        return FnFunc.by(by, lessThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final double object) {
        return FnFunc.by(by, lessThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final byte object) {
        return FnFunc.by(by, lessThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final short object) {
        return FnFunc.by(by, lessThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final int object) {
        return FnFunc.by(by, lessThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final long object) {
        return FnFunc.by(by, lessThan(object));
    }

    
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final Object object) {
        return FnFunc.by(by, lessOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final float object) {
        return FnFunc.by(by, lessOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final double object) {
        return FnFunc.by(by, lessOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final byte object) {
        return FnFunc.by(by, lessOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final short object) {
        return FnFunc.by(by, lessOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final int object) {
        return FnFunc.by(by, lessOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final long object) {
        return FnFunc.by(by, lessOrEqTo(object));
    }
    
    

    

    


    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater than the specified object, false if not
     */
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final Object object) {
        return FnFunc.by(by, greaterThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater than the specified object, false if not
     */
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final float object) {
        return FnFunc.by(by, greaterThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater than the specified object, false if not
     */
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final double object) {
        return FnFunc.by(by, greaterThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater than the specified object, false if not
     */
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final byte object) {
        return FnFunc.by(by, greaterThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater than the specified object, false if not
     */
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final short object) {
        return FnFunc.by(by, greaterThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater than the specified object, false if not
     */
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final int object) {
        return FnFunc.by(by, greaterThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater than the specified object, false if not
     */
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final long object) {
        return FnFunc.by(by, greaterThan(object));
    }

    
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     */
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final Object object) {
        return FnFunc.by(by, greaterOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     */
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final float object) {
        return FnFunc.by(by, greaterOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     */
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final double object) {
        return FnFunc.by(by, greaterOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     */
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final byte object) {
        return FnFunc.by(by, greaterOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     */
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final short object) {
        return FnFunc.by(by, greaterOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     */
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final int object) {
        return FnFunc.by(by, greaterOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     */
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final long object) {
        return FnFunc.by(by, greaterOrEqTo(object));
    }
    
    
    

    
    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return true if the target object is null, false if not.
     */
    public static final Function<Object,Boolean> isNull() {
        return IS_NULL;
    }
    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return false if the target object is null, true if not.
     */
    public static final Function<Object,Boolean> isNotNull() {
        return IS_NOT_NULL;
    }
    
    
    
    

    /**
     * <p>
     * Determines whether the result of executing the
     * specified function on the target object is null or not.
     * </p>
     * 
     * @return true if the function result is null, false if not.
     */
    public static final <X> Function<X,Boolean> isNullBy(final IFunction<X,?> by) {
        return FnFunc.by(by, IS_NULL);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the
     * specified function on the target object is null or not.
     * </p>
     * 
     * @return false if the function result is null, true if not.
     */
    public static final <X> Function<X,Boolean> isNotNullBy(final IFunction<X,?> by) {
        return FnFunc.by(by, IS_NOT_NULL);
    }
    
    
    

    
    
    public static final <T> Function<Object,T> replaceWith(final T object) {
        return new ReplaceWith<T>(object);
    }

    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    protected static final Comparable prepareComparable(Comparable comp) {
        if (comp == null) {
            return comp;
        }
        if (!(comp instanceof Number)) {
            return comp;
        }
        if (comp instanceof BigDecimal) {
            return comp;
        }
        if (comp instanceof BigInteger) {
            return new BigDecimal((BigInteger)comp);
        }
        return new BigDecimal(((Number)comp).doubleValue());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	static final class ToString extends Function<Object,String> {

	    ToString() {
			super();			
		}

        public String execute(final Object input, final ExecCtx ctx) throws Exception {
			return input.toString();
		}		
	}
    
	
    static final class ToStringNullSafe extends AbstractNullAsNullFunction<Object,String> {

        ToStringNullSafe() {
            super();            
        }

        @Override
        public String nullAsNullExecute(final Object input, final ExecCtx ctx) throws Exception {
            return input.toString();
        }       
    }   


    
    
    static final class IntoSingletonArray<T> extends Function<T,T[]>  {

        private final Type<T> type;
        
        IntoSingletonArray(final Type<T> type) {
            super();
            Validate.notNull(type, "A type representing the object must be specified");
            this.type = type;
        }

        @SuppressWarnings("unchecked")
        public T[] execute(final T input, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            result.add(input);
            final T[] array = (T[]) Array.newInstance(this.type.getRawClass(), result.size());
            return result.toArray(array);
        }
        
    }
    
    
    
    
    
    static final class IntoSingletonList<T> extends Function<T,List<T>> {

        IntoSingletonList() {
            super();
        }

        public List<T> execute(final T input, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            result.add(input);
            return result;
        }
        
    }
 
    
    
    static final class IntoSingletonSet<T> extends Function<T,Set<T>> {

        IntoSingletonSet() {
            super();
        }

        public Set<T> execute(final T input, final ExecCtx ctx) throws Exception {
            final Set<T> result = new LinkedHashSet<T>();
            result.add(input);
            return result;
        }
        
    }


    
    
    
    static final class Equals extends Function<Object,Boolean> {

        private final Object object;
        
        Equals(final Object object) {
            super();
            this.object = object;
        }

        public Boolean execute(final Object input, final ExecCtx ctx) throws Exception {
            if (input == null) {
                return Boolean.valueOf(this.object == null);
            }                        
            return Boolean.valueOf(input.equals(this.object));
        }
        
    }
    
    
    static final class NotEquals extends Function<Object,Boolean> {

        private final Object object;
        
        NotEquals(final Object object) {
            super();
            this.object = object;
        }

        public Boolean execute(final Object input, final ExecCtx ctx) throws Exception {
            if (input == null) {
                return Boolean.valueOf(this.object != null);
            }
            return Boolean.valueOf(!input.equals(this.object));
        }
        
    }
    
    
    static final class EqualValue extends AbstractNotNullFunction<Object,Boolean> {

        private final Object object;
        
        EqualValue(final Object object) {
            super();
            Validate.notNull(object, "Object can't be null");
            this.object = object;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Boolean notNullExecute(final Object input, final ExecCtx ctx) throws Exception {
            if (!(input instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Target object is not comparable: " + input.getClass());
            }
            Comparable comp1 = prepareComparable((Comparable<?>) input);
            Comparable comp2 = prepareComparable((Comparable) this.object);
            return Boolean.valueOf(comp1.compareTo(comp2) == 0);
        }
        
    }
    
    
    static final class NotEqualValue extends AbstractNotNullFunction<Object,Boolean> {

        private final Object object;
        
        NotEqualValue(final Object object) {
            super();
            Validate.notNull(object, "Object can't be null");
            this.object = object;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Boolean notNullExecute(final Object input, final ExecCtx ctx) throws Exception {
            if (!(input instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Target object is not comparable: " + input.getClass());
            }
            Comparable comp1 = prepareComparable((Comparable<?>) input);
            Comparable comp2 = prepareComparable((Comparable) this.object);
            return Boolean.valueOf(comp1.compareTo(comp2) != 0);
        }
        
    }
    
    
    static final class LessThan extends AbstractNotNullFunction<Object,Boolean> {

        private final Object object;
        
        LessThan(final Object object) {
            super();
            Validate.notNull(object, "Object can't be null");
            this.object = object;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Boolean notNullExecute(final Object input, final ExecCtx ctx) throws Exception {
            if (!(input instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Target object is not comparable: " + input.getClass());
            }
            if (!(this.object instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Compared object is not comparable: " + this.object.getClass());
            }
            Comparable comp1 = prepareComparable((Comparable) input);
            Comparable comp2 = prepareComparable((Comparable) this.object);
            return Boolean.valueOf(comp1.compareTo(comp2) < 0);
        }
        
    }
    
    
    static final class LessOrEqualTo extends AbstractNotNullFunction<Object,Boolean> {

        private final Object object;
        
        LessOrEqualTo(final Object object) {
            super();
            Validate.notNull(object, "Object can't be null");
            this.object = object;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Boolean notNullExecute(final Object input, final ExecCtx ctx) throws Exception {
            if (!(input instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Target object is not comparable: " + input.getClass());
            }
            if (!(this.object instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Compared object is not comparable: " + this.object.getClass());
            }
            Comparable comp1 = prepareComparable((Comparable) input);
            Comparable comp2 = prepareComparable((Comparable) this.object);
            return Boolean.valueOf(comp1.compareTo(comp2) <= 0);
        }
        
    }
    
    
    static final class GreaterThan extends AbstractNotNullFunction<Object,Boolean> {

        private final Object object;
        
        GreaterThan(final Object object) {
            super();
            Validate.notNull(object, "Object can't be null");
            this.object = object;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Boolean notNullExecute(final Object input, final ExecCtx ctx) throws Exception {
            if (!(input instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Target object is not comparable: " + input.getClass());
            }
            if (!(this.object instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Compared object is not comparable: " + this.object.getClass());
            }
            Comparable comp1 = prepareComparable((Comparable) input);
            Comparable comp2 = prepareComparable((Comparable) this.object);
            return Boolean.valueOf(comp1.compareTo(comp2) > 0);
        }
        
    }
    
    
    static final class GreaterOrEqualTo extends AbstractNotNullFunction<Object,Boolean> {

        private final Object object;
        
        GreaterOrEqualTo(final Object object) {
            super();
            Validate.notNull(object, "Object can't be null");
            this.object = object;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Boolean notNullExecute(final Object input, final ExecCtx ctx) throws Exception {
            if (!(input instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Target object is not comparable: " + input.getClass());
            }
            if (!(this.object instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Compared object is not comparable: " + this.object.getClass());
            }
            Comparable comp1 = prepareComparable((Comparable) input);
            Comparable comp2 = prepareComparable((Comparable) this.object);
            return Boolean.valueOf(comp1.compareTo(comp2) >= 0);
        }
        
    }
    
    
    
    

    
    static class IsNull extends Function<Object, Boolean> {

        public IsNull() {
            super();
        }

        public Boolean execute(final Object object, final ExecCtx ctx) throws Exception {
            if (object == null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        
        
    }
    
    
    static class IsNotNull extends Function<Object, Boolean> {

        public IsNotNull() {
            super();
        }

        public Boolean execute(final Object object, final ExecCtx ctx) throws Exception {
            if (object == null) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        
        
    }
    
    
    
    static class ReplaceWith<T> extends Function<Object,T> {
        
        private final T object;

        public ReplaceWith(final T object) {
            super();
            this.object = object;
        }

        public T execute(final Object input, final ExecCtx ctx) throws Exception {
            return this.object;
        }
        
    }
    
    
    
}

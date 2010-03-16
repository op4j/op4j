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
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.op4j.Fn;
import org.op4j.exceptions.ExecutionException;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
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

	
    
    public static final Function<Object,String> toStr() {
        return TO_STRING;
    }
    
    public static final Function<Object,String> toStrNullSafe() {
        return TO_STRING_NULL_SAFE;
    }
    
    
    public static final <T> Function<T,T[]> toSingletonArrayOf(final Type<T> type) {
        return new ToSingletonArray<T>(type);
    }
    
    public static final <T> Function<T,List<T>> toSingletonListOf(final Type<T> type) {
        return new ToSingletonList<T>();
    }
    
    public static final <T> Function<T,Set<T>> toSingletonSetOf(final Type<T> type) {
        return new ToSingletonSet<T>();
    }

    
    
    

    
    
    public static final Function<Object,Boolean> eq(final Object object) {
        return new Equals(object);
    }
    
    public static final Function<Object,Boolean> eq(final float object) {
        return new Equals(Float.valueOf(object));
    }
    
    public static final Function<Object,Boolean> eq(final double object) {
        return new Equals(Double.valueOf(object));
    }
    
    public static final Function<Object,Boolean> eq(final byte object) {
        return new Equals(Byte.valueOf(object));
    }
    
    public static final Function<Object,Boolean> eq(final short object) {
        return new Equals(Short.valueOf(object));
    }
    
    public static final Function<Object,Boolean> eq(final int object) {
        return new Equals(Integer.valueOf(object));
    }
    
    public static final Function<Object,Boolean> eq(final long object) {
        return new Equals(Long.valueOf(object));
    }
    
    public static final Function<Object,Boolean> eq(final boolean object) {
        return new Equals(Boolean.valueOf(object));
    }
    
    
    public static final Function<Object,Boolean> notEq(final Object object) {
        return new NotEquals(object);
    }
    
    public static final Function<Object,Boolean> notEq(final float object) {
        return new NotEquals(Float.valueOf(object));
    }
    
    public static final Function<Object,Boolean> notEq(final double object) {
        return new NotEquals(Double.valueOf(object));
    }
    
    public static final Function<Object,Boolean> notEq(final byte object) {
        return new NotEquals(Byte.valueOf(object));
    }
    
    public static final Function<Object,Boolean> notEq(final short object) {
        return new NotEquals(Short.valueOf(object));
    }
    
    public static final Function<Object,Boolean> notEq(final int object) {
        return new NotEquals(Integer.valueOf(object));
    }
    
    public static final Function<Object,Boolean> notEq(final long object) {
        return new NotEquals(Long.valueOf(object));
    }
    
    public static final Function<Object,Boolean> notEq(final boolean object) {
        return new NotEquals(Boolean.valueOf(object));
    }

    
    
    
    
    
    

    
    public static final Function<Object,Boolean> lessThan(final Object object) {
        return new LessThan(object);
    }
    
    public static final Function<Object,Boolean> lessThan(final float object) {
        return new LessThan(Float.valueOf(object));
    }
    
    public static final Function<Object,Boolean> lessThan(final double object) {
        return new LessThan(Double.valueOf(object));
    }
    
    public static final Function<Object,Boolean> lessThan(final byte object) {
        return new LessThan(Byte.valueOf(object));
    }
    
    public static final Function<Object,Boolean> lessThan(final short object) {
        return new LessThan(Short.valueOf(object));
    }
    
    public static final Function<Object,Boolean> lessThan(final int object) {
        return new LessThan(Integer.valueOf(object));
    }
    
    public static final Function<Object,Boolean> lessThan(final long object) {
        return new LessThan(Long.valueOf(object));
    }

    
    
    public static final Function<Object,Boolean> lessOrEqTo(final Object object) {
        return new LessOrEqualTo(object);
    }
    
    public static final Function<Object,Boolean> lessOrEqTo(final float object) {
        return new LessOrEqualTo(Float.valueOf(object));
    }
    
    public static final Function<Object,Boolean> lessOrEqTo(final double object) {
        return new LessOrEqualTo(Double.valueOf(object));
    }
    
    public static final Function<Object,Boolean> lessOrEqTo(final byte object) {
        return new LessOrEqualTo(Byte.valueOf(object));
    }
    
    public static final Function<Object,Boolean> lessOrEqTo(final short object) {
        return new LessOrEqualTo(Short.valueOf(object));
    }
    
    public static final Function<Object,Boolean> lessOrEqTo(final int object) {
        return new LessOrEqualTo(Integer.valueOf(object));
    }
    
    public static final Function<Object,Boolean> lessOrEqTo(final long object) {
        return new LessOrEqualTo(Long.valueOf(object));
    }
    
    

    

    


    
    public static final Function<Object,Boolean> greaterThan(final Object object) {
        return new GreaterThan(object);
    }
    
    public static final Function<Object,Boolean> greaterThan(final float object) {
        return new GreaterThan(Float.valueOf(object));
    }
    
    public static final Function<Object,Boolean> greaterThan(final double object) {
        return new GreaterThan(Double.valueOf(object));
    }
    
    public static final Function<Object,Boolean> greaterThan(final byte object) {
        return new GreaterThan(Byte.valueOf(object));
    }
    
    public static final Function<Object,Boolean> greaterThan(final short object) {
        return new GreaterThan(Short.valueOf(object));
    }
    
    public static final Function<Object,Boolean> greaterThan(final int object) {
        return new GreaterThan(Integer.valueOf(object));
    }
    
    public static final Function<Object,Boolean> greaterThan(final long object) {
        return new GreaterThan(Long.valueOf(object));
    }

    
    
    public static final Function<Object,Boolean> greaterOrEqTo(final Object object) {
        return new GreaterOrEqualTo(object);
    }
    
    public static final Function<Object,Boolean> greaterOrEqTo(final float object) {
        return new GreaterOrEqualTo(Float.valueOf(object));
    }
    
    public static final Function<Object,Boolean> greaterOrEqTo(final double object) {
        return new GreaterOrEqualTo(Double.valueOf(object));
    }
    
    public static final Function<Object,Boolean> greaterOrEqTo(final byte object) {
        return new GreaterOrEqualTo(Byte.valueOf(object));
    }
    
    public static final Function<Object,Boolean> greaterOrEqTo(final short object) {
        return new GreaterOrEqualTo(Short.valueOf(object));
    }
    
    public static final Function<Object,Boolean> greaterOrEqTo(final int object) {
        return new GreaterOrEqualTo(Integer.valueOf(object));
    }
    
    public static final Function<Object,Boolean> greaterOrEqTo(final long object) {
        return new GreaterOrEqualTo(Long.valueOf(object));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final Object object) {
        return Fn.by(by, eq(object));
    }
    
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final float object) {
        return Fn.by(by, eq(object));
    }
    
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final double object) {
        return Fn.by(by, eq(object));
    }
    
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final byte object) {
        return Fn.by(by, eq(object));
    }
    
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final short object) {
        return Fn.by(by, eq(object));
    }
    
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final int object) {
        return Fn.by(by, eq(object));
    }
    
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final long object) {
        return Fn.by(by, eq(object));
    }
    
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final boolean object) {
        return Fn.by(by, eq(object));
    }
    
    
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final Object object) {
        return Fn.by(by, notEq(object));
    }
    
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final float object) {
        return Fn.by(by, notEq(object));
    }
    
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final double object) {
        return Fn.by(by, notEq(object));
    }
    
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final byte object) {
        return Fn.by(by, notEq(object));
    }
    
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final short object) {
        return Fn.by(by, notEq(object));
    }
    
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final int object) {
        return Fn.by(by, notEq(object));
    }
    
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final long object) {
        return Fn.by(by, notEq(object));
    }
    
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final boolean object) {
        return Fn.by(by, notEq(object));
    }

    
    
    
    
    
    

    
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final Object object) {
        return Fn.by(by, lessThan(object));
    }
    
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final float object) {
        return Fn.by(by, lessThan(object));
    }
    
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final double object) {
        return Fn.by(by, lessThan(object));
    }
    
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final byte object) {
        return Fn.by(by, lessThan(object));
    }
    
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final short object) {
        return Fn.by(by, lessThan(object));
    }
    
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final int object) {
        return Fn.by(by, lessThan(object));
    }
    
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final long object) {
        return Fn.by(by, lessThan(object));
    }

    
    
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final Object object) {
        return Fn.by(by, lessOrEqTo(object));
    }
    
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final float object) {
        return Fn.by(by, lessOrEqTo(object));
    }
    
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final double object) {
        return Fn.by(by, lessOrEqTo(object));
    }
    
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final byte object) {
        return Fn.by(by, lessOrEqTo(object));
    }
    
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final short object) {
        return Fn.by(by, lessOrEqTo(object));
    }
    
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final int object) {
        return Fn.by(by, lessOrEqTo(object));
    }
    
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final long object) {
        return Fn.by(by, lessOrEqTo(object));
    }
    
    

    

    


    
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final Object object) {
        return Fn.by(by, greaterThan(object));
    }
    
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final float object) {
        return Fn.by(by, greaterThan(object));
    }
    
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final double object) {
        return Fn.by(by, greaterThan(object));
    }
    
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final byte object) {
        return Fn.by(by, greaterThan(object));
    }
    
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final short object) {
        return Fn.by(by, greaterThan(object));
    }
    
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final int object) {
        return Fn.by(by, greaterThan(object));
    }
    
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final long object) {
        return Fn.by(by, greaterThan(object));
    }

    
    
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final Object object) {
        return Fn.by(by, greaterOrEqTo(object));
    }
    
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final float object) {
        return Fn.by(by, greaterOrEqTo(object));
    }
    
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final double object) {
        return Fn.by(by, greaterOrEqTo(object));
    }
    
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final byte object) {
        return Fn.by(by, greaterOrEqTo(object));
    }
    
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final short object) {
        return Fn.by(by, greaterOrEqTo(object));
    }
    
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final int object) {
        return Fn.by(by, greaterOrEqTo(object));
    }
    
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final long object) {
        return Fn.by(by, greaterOrEqTo(object));
    }
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    public static final Function<Object,Boolean> isNull() {
        return IS_NULL;
    }
    
    public static final Function<Object,Boolean> isNotNull() {
        return IS_NOT_NULL;
    }
    
    
    
    public static final <X> Function<X,Boolean> isNullBy(final IFunction<X,?> by) {
        return Fn.by(by, IS_NULL);
    }
    
    public static final <X> Function<X,Boolean> isNotNullBy(final IFunction<X,?> by) {
        return Fn.by(by, IS_NOT_NULL);
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


    
    
    static final class ToSingletonArray<T> extends Function<T,T[]>  {

        private final Type<T> type;
        
        ToSingletonArray(final Type<T> type) {
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
    
    
    
    
    
    static final class ToSingletonList<T> extends Function<T,List<T>> {

        ToSingletonList() {
            super();
        }

        public List<T> execute(final T input, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            result.add(input);
            return result;
        }
        
    }
 
    
    
    static final class ToSingletonSet<T> extends Function<T,Set<T>> {

        ToSingletonSet() {
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
                return Boolean.valueOf(this.object == null);
            }
            return Boolean.valueOf(!input.equals(this.object));
        }
        
    }
    
    
    
    
    
    static final class LessThan extends Function<Object,Boolean> {

        private final Object object;
        
        LessThan(final Object object) {
            super();
            this.object = object;
        }

        @SuppressWarnings("unchecked")
        public Boolean execute(final Object input, final ExecCtx ctx) throws Exception {
            if (input == null) {
                return Boolean.valueOf(this.object == null);
            }
            if (!(input instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Target object is not comparable: " + input.getClass());
            }
            if (this.object != null && !(this.object instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Compared object is not comparable: " + this.object.getClass());
            }
            return Boolean.valueOf(((Comparable)input).compareTo(this.object) < 0);
        }
        
    }
    
    
    static final class LessOrEqualTo extends Function<Object,Boolean> {

        private final Object object;
        
        LessOrEqualTo(final Object object) {
            super();
            this.object = object;
        }

        @SuppressWarnings("unchecked")
        public Boolean execute(final Object input, final ExecCtx ctx) throws Exception {
            if (input == null) {
                return Boolean.valueOf(this.object == null);
            }
            if (!(input instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Target object is not comparable: " + input.getClass());
            }
            if (this.object != null && !(this.object instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Compared object is not comparable: " + this.object.getClass());
            }
            return Boolean.valueOf(((Comparable)input).compareTo(this.object) <= 0);
        }
        
    }
    
    
    static final class GreaterThan extends Function<Object,Boolean> {

        private final Object object;
        
        GreaterThan(final Object object) {
            super();
            this.object = object;
        }

        @SuppressWarnings("unchecked")
        public Boolean execute(final Object input, final ExecCtx ctx) throws Exception {
            if (input == null) {
                return Boolean.valueOf(this.object == null);
            }
            if (!(input instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Target object is not comparable: " + input.getClass());
            }
            if (this.object != null && !(this.object instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Compared object is not comparable: " + this.object.getClass());
            }
            return Boolean.valueOf(((Comparable)input).compareTo(this.object) > 0);
        }
        
    }
    
    
    static final class GreaterOrEqualTo extends Function<Object,Boolean> {

        private final Object object;
        
        GreaterOrEqualTo(final Object object) {
            super();
            this.object = object;
        }

        @SuppressWarnings("unchecked")
        public Boolean execute(final Object input, final ExecCtx ctx) throws Exception {
            if (input == null) {
                return Boolean.valueOf(this.object == null);
            }
            if (!(input instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Target object is not comparable: " + input.getClass());
            }
            if (this.object != null && !(this.object instanceof Comparable<?>)) {
                throw new ExecutionException(
                        "Compared object is not comparable: " + this.object.getClass());
            }
            return Boolean.valueOf(((Comparable)input).compareTo(this.object) >= 0);
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
    
    
    
}

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
    
    
    
}

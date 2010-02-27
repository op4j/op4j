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

    
	private static IFunction<Object,String> TO_STRING = new ToString();
    private static IFunction<Object,String> TO_STRING_NULL_SAFE = new ToStringNullSafe();
	
	
	
	
	private FnObject() {
		super();           
	}

	
    
    public static final IFunction<Object,String> toStr() {
        return TO_STRING;
    }
    
    public static final IFunction<Object,String> toStrNullSafe() {
        return TO_STRING_NULL_SAFE;
    }
    
    
    public static final <T> IFunction<T,T[]> toSingletonArrayOf(final Type<T> type) {
        return new ToSingletonArray<T>(type);
    }
    
    public static final <T> IFunction<T,List<T>> toSingletonListOf(final Type<T> type) {
        return new ToSingletonList<T>();
    }
    
    public static final <T> IFunction<T,Set<T>> toSingletonSetOf(final Type<T> type) {
        return new ToSingletonSet<T>();
    }

    
    
    
    
	static final class ToString implements IFunction<Object,String> {

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


    
    
    static final class ToSingletonArray<T> implements IFunction<T,T[]>  {

        private final Type<T> type;
        
        ToSingletonArray(final Type<T> type) {
            super();
            Validate.notNull(type, "A type representing the object must be specified");
            this.type = type;
        }

        @SuppressWarnings("unchecked")
        public T[] execute(final T object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            result.add(object);
            final T[] array = (T[]) Array.newInstance(this.type.getRawClass(), result.size());
            return result.toArray(array);
        }
        
    }
    
    
    
    
    
    static final class ToSingletonList<T> implements IFunction<T,List<T>> {

        ToSingletonList() {
            super();
        }

        public List<T> execute(final T object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            result.add(object);
            return result;
        }
        
    }
 
    
    
    static final class ToSingletonSet<T> implements IFunction<T,Set<T>> {

        ToSingletonSet() {
            super();
        }

        public Set<T> execute(final T object, final ExecCtx ctx) throws Exception {
            final Set<T> result = new LinkedHashSet<T>();
            result.add(object);
            return result;
        }
        
    }
    
    
}

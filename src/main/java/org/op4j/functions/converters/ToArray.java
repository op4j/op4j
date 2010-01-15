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

package org.op4j.functions.converters;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.ExecCtx;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class ToArray {
    
    
    private ToArray() {
        super();
    }
    

    
    
    
    public static final class FromCollection<T> extends AbstractNullAsNullConverter<T[], Collection<T>> {

        private final Type<T> type;
        
        public FromCollection(final Type<T> type) {
            super();
			Validate.notNull(type, "A type representing the collection elements must be specified");
            this.type = type;
        }

        @SuppressWarnings("unchecked")
        public Type<? extends T[]> getResultType(final Type<? extends Collection<T>> targetType) {
            return Types.arrayOf(Types.collectionComponentOf((Type<Collection<T>>)targetType));
        }

        @Override
        @SuppressWarnings("unchecked")
        public T[] nullAsNullExecute(final Collection<T> object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            final T[] array = (T[]) Array.newInstance(this.type.getRawClass(), result.size());
            return result.toArray(array);
        }
        
    }

    
    
    public static final class FromObject<T> implements IConverter<T[], T> {

        private final Type<T> type;
        
        public FromObject(final Type<T> type) {
            super();
			Validate.notNull(type, "A type representing the object must be specified");
            this.type = type;
        }

        @SuppressWarnings("unchecked")
        public Type<? extends T[]> getResultType(final Type<? extends T> targetType) {
            return Types.arrayOf((Type<T>)targetType);
        }

        @SuppressWarnings("unchecked")
        public T[] execute(final T object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            result.add(object);
            final T[] array = (T[]) Array.newInstance(this.type.getRawClass(), result.size());
            return result.toArray(array);
        }
        
    }
    
}

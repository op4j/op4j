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

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.op4j.util.VarArgsUtil;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Type<T> implements Serializable {
	
    private static final long serialVersionUID = 231766527103920722L;
    
    private final Class<?> componentClass;
	private final Class<? super T> rawClass;
	private final List<Type<?>> ofTypes;
	private final int arrayDimensions;
	private final String name;


	
	public static <T> Type<T> forClass(final Class<T> typeClass) {
		return new Type<T>(typeClass, null, 0);
	}
    
    public static <T> Type<T> forClassOf(final Class<? super T> typeClass, final Class<?>... ofClass) {
        return null;
    }
    
    public static <T> Type<T> forClassOf(final Class<? super T> typeClass, final Type<?>... ofType) {
        return new Type<T>(typeClass, VarArgsUtil.asOptionalObjectList(ofType), 0);
    }
    
    public static <T> Type<T[]> forArrayOf(final Class<T> ofClass) {
        return null;
    }
    
    public static <T> Type<T[]> forArray(final Type<T> ofType) {
        return null;
    }
    
    public static <T> Type<List<T>> forListOf(final Class<T> ofClass) {
        return null;
    }
    
    public static <T> Type<List<T>> forListOf(final Type<T> ofType) {
        return null;
    }
    
    public static <T> Type<Set<T>> forSetOf(final Class<T> ofClass) {
        return null;
    }
    
    public static <T> Type<Set<T>> forSetOf(final Type<T> ofType) {
        return null;
    }
    
    public static <K,V> Type<Map<K,V>> forMapOf(final Class<K> keyOfClass, final Class<V> valueOfClass) {
        return null;
    }
    
    public static <K,V> Type<Map<K,V>> forMapOf(final Type<K> keyOfType, final Type<V> valueOfType) {
        return null;
    }
	
    
    
	
	@SuppressWarnings("unchecked")
    private Type(final Class<?> typeClass, final List<Type<?>> ofTypes, final int arrayDimensions) {
		
		super();

		//TODO validations!!

        this.ofTypes = 
            (ofTypes != null? new ArrayList<Type<?>>(ofTypes) : new ArrayList<Type<?>>());
		
		
		/*
		 * Take care of possible arrays in typeClass
		 */
		int newArrayDimensions = arrayDimensions;
		Class<?> newComponentClass = typeClass;
		while (newComponentClass.isArray()) {
		    newArrayDimensions++;
		    newComponentClass = newComponentClass.getComponentType();
		}
		
		this.componentClass = newComponentClass;
		this.arrayDimensions = newArrayDimensions;

		
		/*
		 * Compute raw class
		 */
        if (this.arrayDimensions == 0) {
            this.rawClass = (Class<? super T>) this.componentClass;
        } else {
            final int[] zeroDims = new int[this.arrayDimensions];
            Arrays.fill(zeroDims, 0);
            this.rawClass = (Class<? super T>) Array.newInstance(this.componentClass, zeroDims).getClass();
        }

        
        /*
         * Compute type name
         */
		final StringBuilder nameBuilder = new StringBuilder();
		nameBuilder.append(this.componentClass.getCanonicalName());
		if (this.ofTypes != null && !this.ofTypes.isEmpty()) {
			nameBuilder.append("<");
			for (int i = 0; i < this.ofTypes.size(); i++) {
				if (i > 0) {
					nameBuilder.append(",");
				}
				nameBuilder.append(this.ofTypes.get(i).getTypeName());
			}
			nameBuilder.append(">");
		}
		for (int i = 0; i < this.arrayDimensions; i++) {
			nameBuilder.append("[]");
		}
		this.name = nameBuilder.toString();
		
	}
	
	
    public Class<? super T> getRawClass() {
    	return this.rawClass;
    }
    


	public Class<?> getComponentClass() {
		return this.componentClass;
	}


	public List<Type<?>> getTypeParameters() {
		return this.ofTypes;
	}


	public int getArrayDimensions() {
		return this.arrayDimensions;
	}


	public String getTypeName() {
		return this.name;
	}


	@Override
	public String toString() {
	    return getTypeName();
	}
	
	
	
	public static void main(String[] args) {
	    
	    System.out.println(Type.forClass(String.class));
        System.out.println(Type.forClass(String[].class));
        System.out.println(Type.forClassOf(String.class, Type.forClass(Integer.class)));
	    
	}
	
}

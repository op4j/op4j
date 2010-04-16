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

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;

/**
 * <p>
 * Function hub class for functions on maps. As these functions have to be parameterized
 * depending on the type of the map elements, this function hub class does not
 * contain the real functions, but instead provides methods for specifying the type of the
 * map components so that the appropiate functions are offered.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public final class FnMap {

    
    private static final FnMapOf<Object,Object> OF_OBJECT_OBJECT = new FnMapOf<Object,Object>(Types.OBJECT, Types.OBJECT);
    private static final FnMapOf<String,String> OF_STRING_STRING = new FnMapOf<String,String>(Types.STRING, Types.STRING);
    private static final FnMapOf<Integer,String> OF_INTEGER_STRING = new FnMapOf<Integer,String>(Types.INTEGER, Types.STRING);
    private static final FnMapOf<String,Integer> OF_STRING_INTEGER = new FnMapOf<String,Integer>(Types.STRING, Types.INTEGER);
    
    
    
    
    /**
     * <p>
     * Specifies the type of the map components (key+value), so that the adequate map functions
     * can be offered.
     * </p>
     * 
     * @param keyType the type of the map key components
     * @param valueType the type of the map value components
     * @return the adequate set function hub
     */
    public static <K,V> FnMapOf<K,V> of(final Type<K> keyType, final Type<V> valueType) {
        return new FnMapOf<K,V>(keyType, valueType);
    }
    
    
    /**
     * <p>
     * Specifies the map as a Map&lt;Object,Object&gt;, so that the adequate map functions
     * can be offered.
     * </p>
     * 
     * @return the adequate map function hub
     */
    public static FnMapOf<Object,Object> ofObjectObject() {
        return OF_OBJECT_OBJECT;
    }
    

    /**
     * <p>
     * Specifies the map as a Map&lt;String,String&gt;, so that the adequate map functions
     * can be offered.
     * </p>
     * 
     * @return the adequate map function hub
     */
    public static FnMapOf<String,String> ofStringString() {
        return OF_STRING_STRING;
    }

    
    /**
     * <p>
     * Specifies the map as a Map&lt;Integer,String&gt;, so that the adequate map functions
     * can be offered.
     * </p>
     * 
     * @return the adequate map function hub
     */
    public static FnMapOf<Integer,String> ofIntegerString() {
        return OF_INTEGER_STRING;
    }

    
    /**
     * <p>
     * Specifies the map as a Map&lt;String,Integer&gt;, so that the adequate map functions
     * can be offered.
     * </p>
     * 
     * @return the adequate map function hub
     */
    public static FnMapOf<String,Integer> ofStringInteger() {
        return OF_STRING_INTEGER;
    }
    
    
    
    

    private FnMap() {
        super();
    }
    
    
    
    
}

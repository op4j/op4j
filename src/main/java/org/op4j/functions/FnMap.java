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

package org.op4j.functions;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;

/**
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



    
    
    public static <K,V> FnMapOf<K,V> of(final Type<K> keyType, final Type<V> valueType) {
        return new FnMapOf<K,V>(keyType, valueType);
    }
    
    public static FnMapOf<Object,Object> ofObjectObject() {
        return OF_OBJECT_OBJECT;
    }
    
    public static FnMapOf<String,String> ofStringString() {
        return OF_STRING_STRING;
    }
    
    public static FnMapOf<Integer,String> ofIntegerString() {
        return OF_INTEGER_STRING;
    }
    
    public static FnMapOf<String,Integer> ofStringInteger() {
        return OF_STRING_INTEGER;
    }
    
    
    

    private FnMap() {
        super();
    }
    
    
}

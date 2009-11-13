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
package org.op4j.executables.functions.builtin;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.Function;
import org.op4j.executables.functions.FunctionArguments;
import org.op4j.executables.functions.Functions;
import org.op4j.executables.functions.IFunc;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class MapFunc<X,K,V> implements IFunc<X,Map<K,V>>  {
    
    private final Function<X,Map<K,V>> function;
    private final List<? extends Object> parameters;

    
    
    
    @SuppressWarnings("unchecked")
    public static <K,V> MapFunc<Map<K,V>,K,V> put(final K key, final V value) {
    	final Map<K,V> newEntry = new LinkedHashMap<K,V>();
    	newEntry.put(key, value);
        return new MapFunc<Map<K,V>,K,V>((Function<Map<K,V>, Map<K,V>>) Functions.getFunctionByName(MapModifyFunction.NAME), Arrays.asList(new Object[] {newEntry, "PUT"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,V> MapFunc<Map<K,V>,K,V> insert(final int position, final K key, final V value) {
    	final Map<K,V> newEntry = new LinkedHashMap<K,V>();
    	newEntry.put(key, value);
        return new MapFunc<Map<K,V>,K,V>((Function<Map<K,V>, Map<K,V>>) Functions.getFunctionByName(MapModifyFunction.NAME), Arrays.asList(new Object[] {newEntry, Integer.valueOf(position), "PUT"})); 
    }
    
    @SuppressWarnings("unchecked")
    public static <K,V> MapFunc<Map<K,V>,K,V> putAll(final Map<K,V> map) {
        return new MapFunc<Map<K,V>,K,V>((Function<Map<K,V>, Map<K,V>>) Functions.getFunctionByName(MapModifyFunction.NAME), Arrays.asList(new Object[] {map, "PUT"})); 
    }
    
    @SuppressWarnings("unchecked")
    public static <K,V> MapFunc<Map<K,V>,K,V> insertAll(final int position, final Map<K,V> map) {
        return new MapFunc<Map<K,V>,K,V>((Function<Map<K,V>, Map<K,V>>) Functions.getFunctionByName(MapModifyFunction.NAME), Arrays.asList(new Object[] {map, Integer.valueOf(position), "PUT"})); 
    }


    @SuppressWarnings("unchecked")
    public static <K,V> MapFunc<Map<K,V>,K,V> removeKeys(final K... keys) {
        return new MapFunc<Map<K,V>,K,V>((Function<Map<K,V>, Map<K,V>>) Functions.getFunctionByName(MapModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(keys), "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <K,V> MapFunc<Map<K,V>,K,V> removeMatching(final String expression, final Object... optionalExpParams) {
        return new MapFunc<Map<K,V>,K,V>((Function<Map<K,V>, Map<K,V>>) Functions.getFunctionByName(MapModifyFunction.NAME), Arrays.asList(new Object[] {expression, VarArgsUtil.asOptionalObjectList(optionalExpParams), "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <K,V> MapFunc<Map<K,V>,K,V> removeoSelected(final ISelect<Map.Entry<K,V>> selector) {
        return new MapFunc<Map<K,V>,K,V>((Function<Map<K,V>, Map<K,V>>) Functions.getFunctionByName(MapModifyFunction.NAME), Arrays.asList(new Object[] {selector, "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <K,V> MapFunc<Map<K,V>,K,V> removeAllExceptKeys(final K... keys) {
        return new MapFunc<Map<K,V>,K,V>((Function<Map<K,V>, Map<K,V>>) Functions.getFunctionByName(MapModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(keys), "REMOVE_NOT"})); 
    }
    
    
    
    
    private MapFunc(final Function<X,Map<K,V>> function, final List<? extends Object> parameters) {
        super();
        this.function = function;
        this.parameters = parameters;
    }



    public Type<X> getResultType() {
        return this.function.getResultType();
    }



    public X execute(final Map<K,V> object) {
        return this.function.executeFunction(FunctionArguments.fromObjects(object, this.parameters));
    }

     
        
}

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

package org.op4j.target;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
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
final class ExecutionTargetIterateClosedOperation implements ExecutionTargetOperation {

    private final int internalBlock;
    private final Class<?> arrayComponentClass;

    
    
    public ExecutionTargetIterateClosedOperation(final int internalBlock, final Class<?> arrayComponentClass) {
        super();
        this.internalBlock = internalBlock;
        this.arrayComponentClass = arrayComponentClass;
    }
    

    
    private static int[] addIndex(final int[] indices, int newIndex) {
        final int[] newIndices = new int[indices.length + 1];
        for (int i = 0, z = indices.length; i < z; i++) {
            newIndices[i] = indices[i];
        }
        newIndices[indices.length] = newIndex;
        return newIndices;
    }
    
    
    
    public Object execute(final Object target, final ExecutionTargetOperation[][] operations, final int[] indices) {
        
        if (target == null) {
            
            throw new IllegalStateException("Cannot iterate on null");
            
        } else if (target instanceof Object[]){
            
            final Object[] arrayTarget = (Object[])target;
            final Object[] arrayResult = 
                (Object[]) Array.newInstance(this.arrayComponentClass, arrayTarget.length);
            for (int i = 0, z = arrayTarget.length; i < z; i++) {
                Object result = arrayTarget[i];
                for (int j = 0, y = operations[this.internalBlock].length; j < y; j++) {
                    result = operations[this.internalBlock][j].execute(result, operations, addIndex(indices, i));
                }
                arrayResult[i] = result;
            }
            return arrayResult;
            
        } else if (target instanceof List<?>){
            
            final List<?> listTarget = (List<?>)target;
            final List<Object> listResult = new ArrayList<Object>();
            int i = 0;
            for (final Object element : listTarget) {
                Object result = element;
                for (int j = 0, y = operations[this.internalBlock].length; j < y; j++) {
                    result = operations[this.internalBlock][j].execute(result, operations, addIndex(indices, i));
                }
                listResult.add(result);
                i++;
            }
            return listResult;
            
        } else if (target instanceof Map<?,?>){
            
            final Map<?,?> mapTarget = (Map<?,?>) target;
            int i = 0;
            boolean allMapEntries = true;
            final List<Object> resultList = new ArrayList<Object>();
            for (final Map.Entry<?,?> element : mapTarget.entrySet()) {
                Object result = element;
                for (int j = 0, y = operations[this.internalBlock].length; j < y; j++) {
                    result = operations[this.internalBlock][j].execute(result, operations, addIndex(indices, i));
                }
                if (!(result instanceof Map.Entry<?,?>)) {
                    allMapEntries = false; 
                }
                resultList.add(result);
                i++;
            }
            
            if (allMapEntries) {
                final Map<Object,Object> mapResult = new LinkedHashMap<Object,Object>();
                for (final Object resultElement : resultList) {
                    final Map.Entry<?,?> mapEntryResult = (Map.Entry<?,?>) resultElement;
                    mapResult.put(mapEntryResult.getKey(), mapEntryResult.getValue());
                }
                return mapResult;
            }
            
            return resultList;
            
            
            
        } else if (target instanceof Set<?>){
            
            final Set<?> setTarget = (Set<?>)target;
            final Set<Object> setResult = new LinkedHashSet<Object>();
            int i = 0;
            for (final Object element : setTarget) {
                Object result = element;
                for (int j = 0, y = operations[this.internalBlock].length; j < y; j++) {
                    result = operations[this.internalBlock][j].execute(result, operations, addIndex(indices, i));
                }
                setResult.add(result);
                i++;
            }
            return setResult;
            
        } else {
            throw new IllegalStateException("Cannot iterate: object is not iterable: " + target.getClass().getName());
        }
        
    }
    
}

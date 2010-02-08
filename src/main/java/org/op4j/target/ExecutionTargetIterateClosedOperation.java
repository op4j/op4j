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

import org.op4j.target.Target.Structure;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ExecutionTargetIterateClosedOperation implements ExecutionTargetOperation {

    private final int internalBlock;
    private final Structure structure;
    private final Class<?> arrayComponentClass;
    private final boolean excludeFirstIndex;

    
    
    public ExecutionTargetIterateClosedOperation(final int internalBlock, final Structure structure, final Class<?> arrayComponentClass, final boolean excludeFirstIndex) {
        super();
        this.internalBlock = internalBlock;
        this.structure = structure;
        this.arrayComponentClass = arrayComponentClass;
        this.excludeFirstIndex = excludeFirstIndex;
    }
    

    
    private static int[] addIndex(final int[] indexes, final int newIndex, final boolean excludeFirstIndex) {
        int[] newIndices = null;
        if (excludeFirstIndex) {
            newIndices = new int[indexes.length];
            for (int i = 0, z = indexes.length - 1; i < z; i++) {
                newIndices[i] = indexes[i + 1];
            }
        } else {
            newIndices = new int[indexes.length + 1];
            for (int i = 0, z = indexes.length; i < z; i++) {
                newIndices[i] = indexes[i];
            }
        }
        newIndices[newIndices.length - 1] = newIndex;
        return newIndices;
    }
    
    
    
    public Object execute(final Object target, final ExecutionTargetOperation[][] operations, final int[] indexes) {
        
        if (target == null) {
            
            throw new IllegalStateException("Cannot iterate on null");
            
        }
        
        switch(this.structure) {
        
            case ARRAY:
                
                final Object[] arrayTarget = (Object[])target;
                final Object[] arrayResult = 
                    (Object[]) Array.newInstance(this.arrayComponentClass, arrayTarget.length);
                for (int i = 0, z = arrayTarget.length; i < z; i++) {
                    Object result = arrayTarget[i];
                    for (int j = 0, y = operations[this.internalBlock].length; j < y; j++) {
                        result = operations[this.internalBlock][j].execute(result, operations, addIndex(indexes, i, this.excludeFirstIndex));
                    }
                    arrayResult[i] = result;
                }
                return arrayResult;

            case LIST:
                
                final List<?> listTarget = (List<?>)target;
                final List<Object> listResult = new ArrayList<Object>();
                int iList = 0;
                for (final Object element : listTarget) {
                    Object result = element;
                    for (int j = 0, y = operations[this.internalBlock].length; j < y; j++) {
                        result = operations[this.internalBlock][j].execute(result, operations, addIndex(indexes, iList, this.excludeFirstIndex));
                    }
                    listResult.add(result);
                    iList++;
                }
                return listResult;
                
            case MAP:
                
                final Map<?,?> mapTarget = (Map<?,?>) target;
                int iMap = 0;
                boolean allMapEntries = true;
                final List<Object> resultList = new ArrayList<Object>();
                for (final Map.Entry<?,?> element : mapTarget.entrySet()) {
                    Object result = element;
                    for (int j = 0, y = operations[this.internalBlock].length; j < y; j++) {
                        result = operations[this.internalBlock][j].execute(result, operations, addIndex(indexes, iMap, this.excludeFirstIndex));
                    }
                    if (!(result instanceof Map.Entry<?,?>)) {
                        allMapEntries = false; 
                    }
                    resultList.add(result);
                    iMap++;
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
                
            case SET:
                
                final Set<?> setTarget = (Set<?>)target;
                final Set<Object> setResult = new LinkedHashSet<Object>();
                int iSet = 0;
                for (final Object element : setTarget) {
                    Object result = element;
                    for (int j = 0, y = operations[this.internalBlock].length; j < y; j++) {
                        result = operations[this.internalBlock][j].execute(result, operations, addIndex(indexes, iSet, this.excludeFirstIndex));
                    }
                    setResult.add(result);
                    iSet++;
                }
                return setResult;
                
            default:
                
                throw new IllegalStateException("Unsupported structure: " +  this.structure);
                
        }
        
    }
    
}

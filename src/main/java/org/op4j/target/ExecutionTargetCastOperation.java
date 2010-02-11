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

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.target.Target.CastType;
import org.op4j.util.NormalisationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ExecutionTargetCastOperation implements ExecutionTargetOperation {

    private final CastType targetType;
    private final Type<?>[] types;

    
    
    public ExecutionTargetCastOperation(final CastType targetType, final Type<?>... types) {
        super();
        this.targetType = targetType;
        this.types = types;
    }
    
    
    
    @SuppressWarnings("unchecked")
    public Object execute(final Object target, final ExecutionTargetOperation[][] operations, final int[] indexes) {
        
        Object result = target;
        
        switch (this.targetType) {
        
            case OBJECT: 
                NormalisationUtils.checkIs(this.types[0], result);
                break;
                
            case ARRAY:
                NormalisationUtils.checkIsArray(this.types[0], result);
                result = NormalisationUtils.normaliseArray((Object[])result, this.types[0].getRawClass());
                break;
                
            case LIST:
                NormalisationUtils.checkIsList(this.types[0], result);
                result = NormalisationUtils.normaliseList((List<Object>)result);
                break;
                
            case MAP:
                NormalisationUtils.checkIsMap(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseMap((Map<Object,Object>)result);
                break;
                
            case MAP_KEY:
                NormalisationUtils.checkIsMapOfKey(this.types[0], result);
                result = NormalisationUtils.normaliseMap((Map<Object,Object>)result);
                break;
                
            case MAP_VALUE:
                NormalisationUtils.checkIsMapOfValue(this.types[0], result);
                result = NormalisationUtils.normaliseMap((Map<Object,Object>)result);
                break;
                
            case SET:
                NormalisationUtils.checkIsSet(this.types[0], result);
                result = NormalisationUtils.normaliseSet((Set<Object>)result);
                break;
                
            case ARRAY_OF_ARRAY:
                NormalisationUtils.checkIsArrayOfArray(this.types[0], result);
                result = NormalisationUtils.normaliseArrayOfArray((Object[][])result, this.types[0].getRawClass());
                break;
                
            case ARRAY_OF_LIST:
                NormalisationUtils.checkIsArrayOfList(this.types[0], result);
                result = NormalisationUtils.normaliseArrayOfList((List<Object>[])result);
                break;
                
            case ARRAY_OF_MAP:
                NormalisationUtils.checkIsArrayOfMap(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseArrayOfMap((Map<Object,Object>[])result);
                break;
                
            case ARRAY_OF_MAP_KEY:
                NormalisationUtils.checkIsArrayOfMapOfKey(this.types[0], result);
                result = NormalisationUtils.normaliseArrayOfMap((Map<Object,Object>[])result);
                break;
                
            case ARRAY_OF_MAP_VALUE:
                NormalisationUtils.checkIsArrayOfMapOfValue(this.types[0], result);
                result = NormalisationUtils.normaliseArrayOfMap((Map<Object,Object>[])result);
                break;
                
            case ARRAY_OF_SET:
                NormalisationUtils.checkIsArrayOfSet(this.types[0], result);
                result = NormalisationUtils.normaliseArrayOfSet((Set<Object>[])result);
                break;
                
            case LIST_OF_ARRAY:
                NormalisationUtils.checkIsListOfArray(this.types[0], result);
                result = NormalisationUtils.normaliseListOfArray((List<Object[]>)result, this.types[0].getRawClass());
                break;
                
            case LIST_OF_LIST:
                NormalisationUtils.checkIsListOfList(this.types[0], result);
                result = NormalisationUtils.normaliseListOfList((List<List<Object>>)result);
                break;
                
            case LIST_OF_MAP:
                NormalisationUtils.checkIsListOfMap(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseListOfMap((List<Map<Object,Object>>)result);
                break;
                
            case LIST_OF_MAP_KEY:
                NormalisationUtils.checkIsListOfMapOfKey(this.types[0], result);
                result = NormalisationUtils.normaliseListOfMap((List<Map<Object,Object>>)result);
                break;
                
            case LIST_OF_MAP_VALUE:
                NormalisationUtils.checkIsListOfMapOfValue(this.types[0], result);
                result = NormalisationUtils.normaliseListOfMap((List<Map<Object,Object>>)result);
                break;
                
            case LIST_OF_SET:
                NormalisationUtils.checkIsListOfSet(this.types[0], result);
                result = NormalisationUtils.normaliseListOfSet((List<Set<Object>>)result);
                break;
                
            case MAP_OF_ARRAY:
                NormalisationUtils.checkIsMapOfArray(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseMapOfArray((Map<Object,Object[]>)result, this.types[0].getRawClass());
                break;
                
            case MAP_OF_ARRAY_VALUE:
                NormalisationUtils.checkIsMapOfArrayOfValue(this.types[0], result);
                result = NormalisationUtils.normaliseMapOfArray((Map<Object,Object[]>)result, this.types[0].getRawClass());
                break;
                
            case MAP_OF_LIST:
                NormalisationUtils.checkIsMapOfList(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseMapOfList((Map<Object,List<Object>>)result);
                break;
                
            case MAP_OF_LIST_VALUE:
                NormalisationUtils.checkIsMapOfListOfValue(this.types[0], result);
                result = NormalisationUtils.normaliseMapOfList((Map<Object,List<Object>>)result);
                break;
                
            case MAP_OF_MAP:
                NormalisationUtils.checkIsMapOfMap(this.types[0], this.types[1], this.types[2], result);
                result = NormalisationUtils.normaliseMapOfMap((Map<Object,Map<Object,Object>>)result);
                break;
                
            case MAP_OF_MAP_VALUE:
                NormalisationUtils.checkIsMapOfMapOfValue(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseMapOfMap((Map<Object,Map<Object,Object>>)result);
                break;
                
            case MAP_OF_MAP_VALUE_KEY:
                NormalisationUtils.checkIsMapOfMapOfValueOfKey(this.types[0], result);
                result = NormalisationUtils.normaliseMapOfMap((Map<Object,Map<Object,Object>>)result);
                break;
                
            case MAP_OF_MAP_VALUE_VALUE:
                NormalisationUtils.checkIsMapOfMapOfValueOfValue(this.types[0], result);
                result = NormalisationUtils.normaliseMapOfMap((Map<Object,Map<Object,Object>>)result);
                break;
                
            case MAP_OF_SET:
                NormalisationUtils.checkIsMapOfSet(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseMapOfSet((Map<Object,Set<Object>>)result);
                break;
                
            case MAP_OF_SET_VALUE:
                NormalisationUtils.checkIsMapOfSetOfValue(this.types[0], result);
                result = NormalisationUtils.normaliseMapOfSet((Map<Object,Set<Object>>)result);
                break;
                
            case SET_OF_ARRAY:
                NormalisationUtils.checkIsSetOfArray(this.types[0], result);
                result = NormalisationUtils.normaliseSetOfArray((Set<Object[]>)result, this.types[0].getRawClass());
                break;
                
            case SET_OF_LIST:
                NormalisationUtils.checkIsSetOfList(this.types[0], result);
                result = NormalisationUtils.normaliseSetOfList((Set<List<Object>>)result);
                break;
                
            case SET_OF_MAP:
                NormalisationUtils.checkIsSetOfMap(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseSetOfMap((Set<Map<Object,Object>>)result);
                break;
                
            case SET_OF_MAP_KEY:
                NormalisationUtils.checkIsSetOfMapOfKey(this.types[0], result);
                result = NormalisationUtils.normaliseSetOfMap((Set<Map<Object,Object>>)result);
                break;
                
            case SET_OF_MAP_VALUE:
                NormalisationUtils.checkIsSetOfMapOfValue(this.types[0], result);
                result = NormalisationUtils.normaliseSetOfMap((Set<Map<Object,Object>>)result);
                break;
                
            case SET_OF_SET:
                NormalisationUtils.checkIsSetOfSet(this.types[0], result);
                result = NormalisationUtils.normaliseSetOfSet((Set<Set<Object>>)result);
                break;
                
        }

        return result;
        
    }
    
}
